# Notes: Spring Data JPA vs Hibernate

**Mental Model:** Writing raw SQL queries and connecting to databases manually using JDBC is exhausting.
* **JPA (Java Persistence API)** is basically a rulebook (JSR 338). It defines *how* Java objects should be mapped to database tables, but it doesn't actually do any of the work itself.
* **Hibernate** is an ORM (Object-Relational Mapping) tool that actually implements the JPA rulebook. It writes the SQL queries for me behind the scenes.
* **Spring Data JPA** is another level of abstraction on top of Hibernate. It dramatically reduces boilerplate code.

### The Code Comparison (Employee Snippets)

**If I use pure Hibernate:**
To save an employee, I have to write a ton of manual boilerplate code:
1. Open a `Session` using a factory.
2. Manually begin a `Transaction`.
3. Call `session.save(employee)`.
4. Manually call `tx.commit()`.
5. Wrap it all in a `try-catch` block so I can call `tx.rollback()` if something fails.
6. Manually close the session in a `finally` block.

**If I use Spring Data JPA:**
To save an employee, I just do this:
1. Create an interface that extends `JpaRepository`.
2. Autowire that repository into my service class.
3. Annotate my method with `@Transactional` and simply call `employeeRepository.save(employee)`.

Spring Data JPA completely eliminates the need for me to write manual try-catch transaction rollbacks and session management!

**Implementation Notes:**
I configured the `orm-learn` project to use Spring Data JPA. I created a `Country` entity mapping to my MySQL table, and successfully fetched the database records via the `OrmLearnApplication` main method. I also included the `Employee` entity, repository, and service classes to demonstrate the streamlined Spring Data JPA syntax.