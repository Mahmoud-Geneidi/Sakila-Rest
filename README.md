


# Sakila Web Services
This project provides Restful web services for the Sakila schema. Services can be used to retrieve, create, update, and delete data from the Sakila database.

## API Documentation
You can find the **API documentation** for this project here ("https://documenter.getpostman.com/view/26734747/2s93XyUNhu"). The documentation provides detailed information on how to use the web services and what parameters they accept.

## Getting Started
To use this project, you will need to have access to a **Sakila schema**.

* Clone the repository to your local machine: git clone https://github.com/Mahmoud-Geneidi/Sakila-Rest.git

* Navigate to the project directory: cd sakila-web-services

* Configure **pom.xml** and **persistence.xml** and **hibernate.properties** to your tomcat server configurations.

* Deploy the application on tomcat server using command **"mvn clean install tomcat7:deploy"**

The web services will now be available at http://localhost:9090/SakilaRest/sakila. You can use a tool like Postman to interact with the services.

## Sakila Database Information
Sakila is a sample database that provides a schema for a DVD rental store. The database includes tables for customers, inventory, rentals, payments, staff, and stores. Here's a brief description of some of the tables: brief overview of each table:

* actor - stores actor information such as first name and last name
* address - stores address information for customers and staff
* category - stores movie category information
* city - stores city information for customers and staff
* country - stores country information for customers and staff
* customer - stores customer information such as name and contact details
* film - stores movie information such as title, description, and length
* film_actor - stores information about the actors who played in each film
* film_category - stores information about which category each film belongs to
* inventory - stores information about each DVD that the rental store has in stock
* language - stores information about the languages available for films
* payment - stores information about customer payments
* rental - stores information about movie rentals, including the date and return date
* staff - stores staff information, such as name and contact details
* store - stores information about the stores, including location and manager
* film_text - stores the full text of the movie descriptions for searching purposes
