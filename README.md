# Hibernate E-Commerce Application

## Project Overview

This project is a Hibernate ORM based Java application for managing an e-commerce system.

The application manages the following entities:

- Category
- Product
- Users
- Orders
- OrderDetails

Hibernate ORM is used to map Java entities to MySQL database tables and perform database operations.

## Technologies Used

- Java 17
- Maven
- Hibernate ORM 6.6.5.Final
- MySQL 8.0
- Jakarta Persistence API
- BCrypt for password hashing
- SLF4J

## Database Configuration

Database name:

ecommerce_db

MySQL connection:

jdbc:mysql://localhost:3306/ecommerce_db

The Hibernate configuration is stored in:

src/main/resources/hibernate.cfg.xml

## Entity Relationships

### Category → Product
One Category can have many Products.

### Product → Category
Each Product belongs to one Category.

### Users → Orders
One User can have many Orders.

### Orders → Users
Each Order belongs to one User.

### Orders → OrderDetails
One Order can contain multiple OrderDetails.

### OrderDetails → Product
Each OrderDetail refers to one Product.

## Main Features

- Hibernate SessionFactory configuration
- Entity mapping using JPA annotations
- MySQL database persistence
- Category and Product management
- User management
- Order creation
- Multiple OrderDetails per Order
- CRUD operations
- Entity relationship testing

## Project Structure

```text
src/main/java
└── com.demo.entity
    ├── Category.java
    ├── Product.java
    ├── Users.java
    ├── Orders.java
    ├── OrderDetails.java
    └── Role.java

└── com.demo.test
    ├── CrudTest.java
    └── HibernateTest.java

└── com.demo.util
    └── HibernateUtil.java

src/main/resources
├── hibernate.cfg.xml
└── schema.sql

pom.xml
README.md