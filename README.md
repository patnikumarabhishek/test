Installation
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

Database configuration
Create a MySQL database with the name springbootdb and add the credentials to /resources/application.properties.
The default ones are :

spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update

At the run time data will load into database tables from parent.json and child.json

Usage
Run the project through the IDE and head out to http://localhost:8080/test/swagger-ui.html

or

run this command in the command line:

mvn spring-boot:run

and run on : http://localhost:8080/test