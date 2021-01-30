# MyRetail
This is an application for demonstrating RESTful services using mongoDB and Java's Spring Boot framework.

### Requirements
- [ ] Spring Web tools
- [ ] IDE such as Eclipse or IntelliJ
- [ ] Postman
- [ ] MongoDB

### MongoDB settings
- Install mongodb and set the path environmental variable.
- Open the mongo shell
        show db;
        use admin;

        
        db.createUser(
        {
            user: "admin",
            pwd:  "admin",     roles: [
            { role: "userAdminAnyDatabase", db: "admin" }, "readWriteAnyDatabase"
         ]
        }
        )
        


### Execution
- After cloning the project, open it in the IDE.
- Using the spring web tools, you can start the application.
- Open a terminal and enter >mongod. This will start the mongoDB process.
- Now we can call the API requests from the Postman

## Summary
The product has two parts: data and description
### Product Data:
```json
{
    "productID": 18978,
    "currentPrice": {
        "value": 12.23,
        "currencyCode": "USD"
    }
}
```

### Product Description:
```json
{
    "productID": 18978,
    "currentPrice": {
        "productDescription": "Table"
    }
}
```

In this project, 
- There are microservices to create these individually.
- Retrieve all the data
- Retrieve the data using their product ID
- Edit and delete the product data
- Retrieve the complete detail (data+description) based on the productID

***

## All these request require authorization.  Authorization: Basic Auth (username, password)

1. Get all the products data.\
    REQUEST: GET.\
    End point: "/product/data".\

![Screenshot](https://github.com/DrOctopusCodes/MyRetail/blob/main/screenshots/GetAllProductData.PNG)



2. Get the product data by its ID.\
REQUEST: GET.\
End point: "/product/data/{productID}".\
![Screenshot](https://github.com/DrOctopusCodes/MyRetail/blob/main/screenshots/GetProductDataByID.PNG)



3. Post a product data.\
REQUEST: POST.\
End point: "/product/data".\
![Screenshot](https://github.com/DrOctopusCodes/MyRetail/blob/main/screenshots/PostProductData.PNG)



4. Delete a product data.\
REQUEST: DELETE.\
End point: "/product/data/{productID}".\
![Screenshot](https://github.com/DrOctopusCodes/MyRetail/blob/main/screenshots/DeleteProductData.PNG)



5. Update a product data - price.\
REQUEST: PUT.\
End point: "/product/data/{productID}".\
![Screenshot](https://github.com/DrOctopusCodes/MyRetail/blob/main/screenshots/PutUpdateProductData.PNG)



6. Get product descroption.\
REQUEST: GET.\
End point: "/product/description/{productID}".\
![Screenshot](https://github.com/DrOctopusCodes/MyRetail/blob/main/screenshots/GetProductDescription.PNG)



7. Combined response - product detail.\
REQUEST: GET.\
End point: "/product/detail/{productID}".\
![Screenshot](https://github.com/DrOctopusCodes/MyRetail/blob/main/screenshots/CombinedResponse.PNG)



