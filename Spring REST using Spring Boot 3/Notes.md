# Notes: Spring Web & XML Context Loading

**Mental Model:** Spring Boot 3 normally relies heavily on annotations (`@Component`, `@Service`, etc.) to build its Inversion of Control (IoC) container. However, older Spring applications used XML files to define these objects (Beans). This exercise taught me how to bridge the two by manually loading an old-school XML configuration file into a modern Spring Boot application.

* **Project Setup (Hands-on 1):** I initialized a new Spring Boot 3 web project. The `@SpringBootApplication` annotation acts as the central control room, wrapping `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` into one command to boot up the server.
* **XML Bean Lifecycle (Hands-on 4):** * I created `country.xml` and defined a `<bean>` with an `id` and a `class`.
    * I used `<property>` tags to inject values into that bean.
    * *The magic happens here:* When `new ClassPathXmlApplicationContext("country.xml")` is called, Spring parses the XML. It immediately triggers the `Country` class's empty constructor, and then automatically fires the `setCode()` and `setName()` methods to inject the data. I verified this sequence by placing `LOGGER.debug()` statements inside the constructor and setters.

**Mental Model:** Instead of just printing data to a local console, I am now building an API that other computers (like a React frontend) can talk to over the internet.
* `@RestController` tells Spring: "When someone visits these URLs, intercept the request."
* **Auto-Serialization:** The coolest part is that I don't have to write code to convert my `Country` Java objects into JSON strings. Spring Boot's underlying Jackson library intercepts my returned `Country` object and automatically converts it to `{"code": "IN", "name": "India"}` for the browser!
* **HTTP Headers:** I tested these endpoints in Postman and inspected the `Headers` tab. I observed headers like `Content-Type: application/json` which tells the receiving client exactly what kind of data format is being returned.

**Mental Model:** Passwords shouldn't be sent back and forth on every single request. Instead, a user logs in once using Basic Authentication (Base64 encoded `user:pwd`). The server verifies it and issues a temporary "VIP Pass" called a JSON Web Token (JWT). The user then uses this token for all future requests.

* **Security Config:** I learned that adding `spring-boot-starter-security` automatically locks down the entire API. I had to create a `SecurityFilterChain` bean to explicitly allow public access to `/authenticate`.
* **Header Decoding:** I wrote logic in the Controller to extract the `Authorization` header, strip out the "Basic " prefix, and use `java.util.Base64` to decode the remaining string to retrieve the raw `user:pwd`.
* **Token Generation:** I used the `jjwt` library to build a token. I assigned the `username` as the subject, set an expiration time of 10 hours, and digitally signed it using a secure HMAC key so it cannot be forged.