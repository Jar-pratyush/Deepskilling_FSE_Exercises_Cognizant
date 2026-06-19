# Notes: Search Algorithms & Asymptotic Notation

**Mental Model:** Big O notation is basically a way to measure how badly an algorithm will slow down as we throw more data at it. Linear search is the brute-force way—checking every single item on the shelf until I find what I need. Binary search is the "guess a number between 1 and 100" strategy, where I keep cutting the sorted list in half. It's way smarter, but the catch is the data *must* be sorted first.

* **Big O Notation:** It helps analyze how an algorithm's runtime grows as the data size increases.
* **Linear Search:** Checks each item one by one.
    * **Best Case:** `O(1)` (Found on the first try).
    * **Worst/Average Case:** `O(n)` (Item is at the end or doesn't exist).
* **Binary Search:** Repeatedly divides a *sorted* array in half.
    * **Best Case:** `O(1)` (Found right in the middle).
    * **Worst/Average Case:** `O(log n)` (Massively faster for large datasets).
* **Conclusion:** Binary search is much better for my e-commerce platform because searching through thousands of products will be lightning-fast, provided the product list is kept sorted by ID!