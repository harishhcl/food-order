package com.hcl.foodorder.search.service;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

import com.hcl.foodorder.search.model.MenuItem;


@Service
public class MenuItemsServiceImpl implements MenuItemsService{

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Value("${elasticsearch.index.name}")
    private String indexName;

    @Value("${elasticsearch.items.type}")
    private String itemTypeName;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public String save(MenuItem menuItem) {
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(menuItem.getId().toString())
                .withObject(menuItem)
                .build();
        return elasticsearchOperations.index(indexQuery,IndexCoordinates.of(indexName));
    }


    public List<MenuItem> searchMultiField(String name, int qty) {
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("name", name))
                .must(QueryBuilders.matchQuery("quantity", qty));
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
        SearchHits<MenuItem> items = elasticsearchOperations.search(nativeSearchQuery, MenuItem.class, IndexCoordinates.of(indexName));
        return items.stream().map(s -> s.getContent()).collect(Collectors.toList());
    }

    public List<MenuItem> getMenuNameSearchData(String name) {
        String search = ".*" + name + ".*";
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withFilter(QueryBuilders.regexpQuery("name", search)).build();
        SearchHits<MenuItem> items = elasticsearchOperations.search(nativeSearchQuery, MenuItem.class, IndexCoordinates.of(indexName));
        return items.stream().map(s -> s.getContent()).collect(Collectors.toList());
    }

    public List<MenuItem> multiMatchQuery(Long id) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(id)
                .field("restaurantId").field("id").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
        SearchHits<MenuItem> items = elasticsearchOperations.search(nativeSearchQuery, MenuItem.class, IndexCoordinates.of(indexName));
        return items.stream().map(s -> s.getContent()).collect(Collectors.toList());
    }


    public List<MenuItem> getMenuItemsByPriceRange(final Double itemPriceMin, final Double itemPriceMax) {
        Criteria criteria = new Criteria("price")
                .greaterThan(itemPriceMin)
                .lessThan(itemPriceMax);

        Query searchQuery = new CriteriaQuery(criteria);

        SearchHits<MenuItem> items = elasticsearchOperations.search(searchQuery, MenuItem.class, IndexCoordinates.of(indexName));
        return items.stream().map(s -> s.getContent()).collect(Collectors.toList());
    }


    public List<MenuItem> getMenuItemsByDescriptions(final String description) {
        Query searchQuery = new StringQuery(
                "{\"match\":{\"description\":{\"query\":\""+ description + "\"}}}\"");

        SearchHits<MenuItem> items = elasticsearchOperations.search(searchQuery, MenuItem.class, IndexCoordinates.of(indexName));
        return items.stream().map(s -> s.getContent()).collect(Collectors.toList());
    }

}
