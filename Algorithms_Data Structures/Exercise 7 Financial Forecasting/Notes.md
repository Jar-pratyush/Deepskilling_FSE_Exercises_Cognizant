# Notes: Financial Forecasting & Recursion

**Mental Model:** Recursion is when a method calls itself to solve a smaller piece of the same problem, kind of like Russian nesting dolls, until it hits a "base case" where it finally stops. It makes code look really clean for things like compounding interest. But I have to be careful, because if it goes too deep, it eats up all the computer's memory (Stack Overflow).

* **Recursion:** It simplifies problems by having a method call itself to solve smaller pieces of the problem until it hits a base case to stop.
* **Time Complexity:** My recursive algorithm runs in `O(n)` time, where `n` is the number of periods (years), because it makes one method call per year.
* **Optimization:** Recursion can cause "StackOverflow" errors or excessive computation if the tree gets too big. To optimize it, we can use **Memoization** (storing previously calculated values in a data structure so we don't recalculate them) or simply convert it to an iterative loop / pure math formula for `O(1)` time complexity.