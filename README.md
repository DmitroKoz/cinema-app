![](images/header.png)
# Cinema app

This application was created to simulate simple cinema ticket flow. 

It's written with high-level technologies such as hibernate and Spring and is based on SOLID adn REST architectural principles.

### Implementation details
*Multiple endpoints with different access rights*

#### Endpoints before authentication:
* POST: /register - register new user
* POST: /login - login user

#### Endpoints after authentication:
For ADMIN role only:
* GET /users/by-email - find user by email
* POST /cinema-halls - add new cinema hall
* POST /movies - add new movie
* POST movie-sessions - add new movie session
* PUT /movie-sessions/{id} - update a movie session by id
* DELETE /movie-sessions/{id} - delete a movie session by id

For both USER and ADMIN roles:
* GET /cinema-halls - get all cinema halls
* GET /movies - get all movies
* GET /movie-sessions/available - get movie sessions on selected date

For USER role only:
* GET /shopping-carts/by-user - get shopping cart
* GET /orders - get order history
* POST /orders/complete - move tickets from cart to new order
* PUT shopping-carts/movie-sessions - add movie session to shopping cart

All data is stored in the MySQL database. Relations between tables are described in the image below:
![](images/join-db-diagram.png)

### Technologies used
* Java
* Apache Tomcat
* Hibernate
* MySQL
* Spring: Spring Core, Spring Web, Spring Security

### Setup
* Install IntellijIDEA Ultimate version [from here](https://www.jetbrains.com/idea/download/)
* Configure Apache Tomcat [version 9.0.56](https://tomcat.apache.org/download-90.cgi)
* For Windows, check if you have [Microsoft Visual C++ Redistributable Latest Version](https://docs.microsoft.com/en-us/cpp/windows/latest-supported-vc-redist?view=msvc-170)
* Install MySQL and MySQL Workbench [from here](https://dev.mysql.com/downloads/) (you can use prepared installers)
* Create new database and prepare connection
* Customize your connection here: ```src/main/resources/db.properties```
* Check if you have [Lombok plugin](https://projectlombok.org/setup/intellij) installed and configured
* Configure Apache Tomcat
* Run the application. You will see login page if sucsessfull

### Testing
* Register at [Postman](https://www.postman.com/)
* Download collection from [here](https://ufile.io/f6l8bxic)
* Import collection to the postman (feel free to change the domain from localhost:8080 to your own)
* Run collection with "save responses" option
* Check that the first 5 responses return 401 Unauthorized code
* Check that the last 5 responses are 403 Forbidden responses
* Check that all other responses return 200 OK code
* Remember that you will have 2 more 500 responses if you will run tests more than once
* Feel free to look at response bodies to ensure you got what expected

### Enjoying
Just enjoy using the application :)
