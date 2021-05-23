## food-order

## Create Restaurant 
http://localhost:8081/restaurants/v1/create

#Request:
    {
        "id": 90002,
        "name":"Hyderabad Baryani",
        "description":"Baryani Point Bangalore",
        "address":{
        "id":123,
        "type":"RESTAURANT",
        "street":"Silkboard",
        "city":"Bangalore",
        "state":"Karnataka",
        "pincode":123455
        }
    }

## Get Restaurant

http://localhost:8082/restaurants/v1/get/90002

#Response:

    {
        "id": 90002,
        "name": "Hyderabad Baryani",
        "description": "Baryani Point Bangalore",
        "address": {
            "id": 123,
            "type": "RESTAURANT",
            "street": "Silkboard",
            "city": "Bangalore",
            "state": "Karnataka",
            "pincode": "123455"
        }
    }

## Create Menu

http://localhost:8082/restaurants/v1/create/90001/menu

#Request:

    [
        {
        "id":5001,
        "name":"Chicken Biryani",
        "description":"Non-veg Chicken Biryani",
        "price":300.00,
        "quantity":1
    }
    ]

#Response:

    [
        {
            "id": 5001,
            "restaurantId": 90001,
            "name": "Chicken Biryani",
            "description": "Non-veg Chicken Biryani",
            "price": 300.0,
            "quantity": 1
        }
    ]

#Get Restaurant Menu
http://localhost:8082/restaurants/v1/get/90001/menu

#Response:
    [
        {
            "id": 5001,
            "restaurantId": 90001,
            "name": "Chicken Biryani",
            "description": "Non-veg Chicken Biryani",
            "price": 300.0,
            "quantity": 1
        }
    ]
