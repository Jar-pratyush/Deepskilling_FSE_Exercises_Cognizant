# Notes: Verifying Interactions

**Mental Model:** Stubbing is great for providing fake data, but sometimes a method doesn't return data; it just *does* something (like sending an email or saving a file). How do I test that? I use Mockito to "spy" on the fake object and verify that my main code actually communicated with it correctly.

* **Verification:** I used Mockito's `verify()` method to ask, "Did `MyService` actually call the `getData()` method on the API exactly one time?" This proves that the underlying behavior and control flow of my service is working exactly as designed, even without returning any variables.