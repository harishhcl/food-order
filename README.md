## food-order

## create request uri
http://localhost:8085/v1/orders/create

## Create input request
    
    {
    "id":1,
    "orderNumber":50002,
    "itemList":[
        {
            "id":2001,
            "name":"Non Veg Biryani",
            "description":"Hyderabad Chicken Biryani",
            "price":300.00
        },
        {
            "id":2002,
            "name":"Veg Biryani",
            "description":" Veg Biryani",
            "price":200.00
        }
    ],
    "status":"CREATED",
    "total":325.00,
    "taxPercentage":5.00,
    "totalTaxAmount":25.00,
    "restaurantId":1001,
    "customerId":3001,
    "driverId":4001
    }


## Get response
http://localhost:8085/v1/orders/get/restaurants/1001

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
