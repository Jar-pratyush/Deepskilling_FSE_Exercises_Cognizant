# Notes: Setting Up JUnit

**Mental Model:** Before I can write automated tests to check my code, I need to bring the testing tools into my project. Using Maven makes this incredibly easy. Instead of downloading JAR files manually, I just tell the `pom.xml` file what I need, and it handles the rest.

* **Configuration:** I added the JUnit 4 dependency to my `pom.xml` file.
* **Scope:** I set the `<scope>` tag to `test`. This is a best practice because it tells Maven that the JUnit library is only needed for testing and shouldn't be bundled with the final production application.
* **Verification:** I created a simple `JUnitSetupTest` class with an `@Test` annotation to verify the IDE recognizes the library and can execute a test successfully.