# SNotes: Basic JUnit Assertions

**Mental Model:** Testing my code manually by running `main()` methods and looking at the console is exhausting. JUnit automates this. I can write "assertions" which are basically strict rules saying "If I add 2 and 3, the result MUST be 5. If it's not, throw a massive error and fail the test."

* **Assertions Practiced:** * `assertEquals()`: Checks if two values match perfectly.
    * `assertTrue()` / `assertFalse()`: Great for testing boolean logic or conditions.
    * `assertNull()` / `assertNotNull()`: Crucial for making sure objects were successfully created or properly destroyed in memory.