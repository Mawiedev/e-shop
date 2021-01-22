# Watch e-shop API

The purpose of this project is to build an e-shop features. The store has a REST service for uploading products to the e-shop warehouse.

## Structure

    ├── src
        ├── main
        ├── test
            ├── java
                ├── ...
                    ├── config          
                    ├── controller       
                    ├── exception       
                    ├── model           
                    ├── repositories    
                    ├── service         
    ├── pom.xml
    ├── LICENSE
    ├── README.md      
    
## Install project

- Download the zip and unzip it
- Open with your IDE: pom.xml
- Run it 

default port is 8080

## API

Default format is JSON but XML is also accepted.

A data's example is already stored: 

```
{"title": "Prim",
"price": "250000" //int,
"description": "A watch with a water fountain picture",
"fountain":"R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs="
 // Base64 picture}
```

A graphic doc for API is available at this url:
- http://localhost:8080/ui-api.html

And a json format at this url:
- http://localhost:8080/api-docs

### POST

`http://localhost:8080/addwatch`

### GET

#### Retrieve all watches

`http://localhost:8080/watches` 

#### Retrieve a specific watch

`http://localhost:8080/watch/{id}`
