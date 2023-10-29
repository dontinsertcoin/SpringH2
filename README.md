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

The API methods will be able via "/api/offer" (POST to store an offer, GET to get an offer)

//INSTALLATION
mvn clean install

//REQUIREMENTS
 - Java
 - Maven


