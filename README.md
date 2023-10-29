This project has been created for a system to be able to save and get the prices, 
dates, priority, etc. of the items in a store with a h2 in-memory DataBase and a 
SpringBoot controller for REST methods.

The data stores in the DB is:
 - BRAND_ID: foreign key for the brand
 - START_DATE: date when the price is enabled
 - END_DATE: date when the price expires
 - PRICE_LIST: Price ID
 - PRODUCT_ID: Product ID
 - PRIORITY: Priority (get the highest one)
 - PRICE: Product price
 - CURR: Currency

//INSTALLATION
mvn clean install

//REQUIREMENTS
 - Java
 - Maven

API methods via "/api/offer" (POST to store an offer, GET to get an offer)
Dates format: "yyyy-MM-dd'T'HH:mm:ss" -> (EXAMPLE) 2020-06-19T14:00:00
 - POST need JSON in Body:
(EXAMPLE)
{
    "brandId": 1,
    "startDate": "2020-06-15T16:00:00",
    "endDate": "2020-12-31T23:59:59",
    "priceList": 1,
    "productId": 35455,
    "priority": 3,
    "price": 38.95,
    "currency": "EUR"
}

 - GET need to have 3 args (productId, brandId, date):
(EXAMPLE)
/api/offers/35455/1/2020-06-19T14:00:00


