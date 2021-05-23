## food-order

## create request uri
http://localhost:8085/orders/v1/create

##Via Gateway API
http://localhost:8081/orders/v1/create

## Create input request
    {
    "id":2,
    "orderNumber":50003,
    "itemList":[
        {
            "id":2001,
            "name":"Non Veg Biryani",
            "description":"Hyderabad Chicken Biryani",
            "price":300.00
        },
        {
            "id":2003,
            "name":"Veg Starter",
            "description":"Spicy veg starter ",
            "price":100.00
        },
        {
            "id":2002,
            "name":"Veg Biryani",
            "description":" Veg Biryani",
            "price":200.00
        }
    ],
    "status":"CREATED",
    "total":630.00,
    "taxPercentage":5.00,
    "totalTaxAmount":30.00,
    "restaurantId":1003,
    "customerId":3003,
    "driverId":4003
    }

## Get response
http://localhost:8085/orders/v1/get/restaurants/1001

http://localhost:8081/orders/v1/get/restaurants/1003

## Get Response
   
    [
        {
            "id": 1,
            "orderNumber": "50002",
            "createdDate": "2021-05-22T18:59:24.017",
            "lastUpdatedDate": "2021-05-22T18:59:24.017",
            "itemList": [
                {
                    "id": 2002,
                    "name": "Veg Biryani",
                    "description": " Veg Biryani",
                    "price": 200.0
                },
                {
                    "id": 2001,
                    "name": "Non Veg Biryani",
                    "description": "Hyderabad Chicken Biryani",
                    "price": 300.0
                }
            ],
            "status": "CREATED",
            "total": 325.0,
            "taxPercentage": 5.0,
            "totalTaxAmount": 25.0,
            "restaurantId": 1001,
            "customerId": 3001,
            "driverId": 4001
        }
    ]
