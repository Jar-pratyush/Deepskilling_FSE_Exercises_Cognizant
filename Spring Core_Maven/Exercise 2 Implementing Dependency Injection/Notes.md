# Notes: Implementing Dependency Injection

## Mental Model

**Dependency Injection (DI)** takes **Inversion of Control (IoC)** a step further. Instead of my `BookService` creating a `BookRepository` object using the `new` keyword, I simply provide a setter method in the service class. In the XML configuration file, I instruct Spring to "wire" the two beans together. Spring creates both objects and automatically injects the `BookRepository` into the `BookService`, eliminating the need for manual object creation.

## Setter Injection

- Added a `setBookRepository()` setter method to the `BookService` class.
- This method allows Spring to inject the required `BookRepository` dependency.

## XML Wiring

- Updated the `applicationContext.xml` file.
- Added a `<property>` tag inside the `bookService` bean definition.
- Set the `ref` attribute of the `<property>` tag to the `bookRepository` bean ID, enabling Spring to connect the two beans.

## Testing

- Retrieved the `BookService` bean from the Spring IoC container.
- Called a method on the service.
- Verified that the service successfully used the injected `BookRepository` without requiring `new BookRepository()` anywhere in the code.