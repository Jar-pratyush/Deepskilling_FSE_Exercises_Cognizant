# Notes: Mocking and Stubbing

**Mental Model:** Sometimes my code relies on external things, like a third-party API or a database. If I'm writing a unit test, I don't want to actually hit the real API—it's slow, requires the internet, and could cost money. Mockito lets me create a "fake" version (a Mock) of that external dependency.

* **Mocking:** I used `Mockito.mock()` to create a dummy version of the `ExternalApi` interface.
* **Stubbing:** I used the `when().thenReturn()` syntax to tell my fake object exactly how to behave. "When your `getData()` method is called, don't go to the internet; just instantly return the string 'Mock Data'." This allows me to isolate and test *only* my `MyService` class logic.