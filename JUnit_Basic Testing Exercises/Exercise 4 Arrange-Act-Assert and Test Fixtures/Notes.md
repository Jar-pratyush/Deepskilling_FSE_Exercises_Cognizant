# Notes: AAA Pattern & Test Fixtures

**Mental Model:** Writing tests can get messy if they aren't organized. The AAA pattern (Arrange, Act, Assert) keeps every test structured like a neat little story: Setup the data, do the action, check the result. Also, tests shouldn't interfere with each other, so I use "Fixtures" to clean the slate every time.

* **AAA Pattern:** It makes my test code highly readable for other developers.
* **@Before / @After:** These annotations act as setup and teardown hooks. They automatically reset my test variables (like the `testString`) before and after *every single test* runs, ensuring a fresh environment and preventing weird data bleeding between tests.