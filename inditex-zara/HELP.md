### swagger info 
http://localhost:8080/swagger-ui.html#/Price_API


### Endpoint Test


-     Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
       Endpoint type Post :http://localhost:8080/price
       Request:
        Body:  {
        "productId": 35455,
        "brandId": 1,
        "appDate": "2020-06-14T10:00:00"
        }
-     Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        Endpoint type Post :http://localhost:8080/price
       Request:
        Body:  {
        "productId": 35455,
        "brandId": 1,
        "appDate": "2020-06-14T16:00:00"
        }
-     Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
       Endpoint type Post :http://localhost:8080/price
       Request:
        Body:  {
        "productId": 35455,
        "brandId": 1,
        "appDate": "2020-06-14T21:00:00"
        }
-      Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
       Endpoint type Post :http://localhost:8080/price
       Request:
        Body:  {
        "productId": 35455,
        "brandId": 1,
        "appDate": "2020-06-15T10:00:00"
        }
-      Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
       Endpoint type Post :http://localhost:8080/price
       Request:
        Body:  {
        "productId": 35455,
        "brandId": 1,
        "appDate": "2020-06-16T21:00:00"
        }
