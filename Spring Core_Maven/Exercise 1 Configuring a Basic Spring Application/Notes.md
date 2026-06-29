# Notes: Configuring a Basic Spring Application

## Mental Model

Normally, I have to create objects manually using the `new` keyword. Spring introduces an **Inversion of Control (IoC) Container**, which acts like a factory. Instead of creating objects myself, I write an XML configuration file (`applicationContext.xml`) that tells Spring about my classes. Spring then creates and manages those objects (called **Beans**) automatically in the background.

## Setup

- Created a Maven project.
- Added the **Spring Core** and **Spring Context** dependencies to `pom.xml`.

## Configuration

- Created an `applicationContext.xml` file.
- Defined the following beans:
    - `BookService`
    - `BookRepository`

## Execution

- Used `ClassPathXmlApplicationContext` to load the `applicationContext.xml` file.
- Retrieved the required objects directly from the Spring IoC container instead of creating them using the `new` keyword.