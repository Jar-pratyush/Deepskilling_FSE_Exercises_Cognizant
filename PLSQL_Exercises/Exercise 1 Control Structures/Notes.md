# Notes: Database Control Structures

**Mental Model:** Normally, SQL acts on everything all at once (like updating every row in a table simultaneously). But sometimes, I need the database to act more like a Java program—checking rows one by one, making decisions based on age or balance, and doing different things. To do this, I use "Cursors" to loop through the data row by row, and "IF/THEN" control structures to apply specific logic to each individual customer.

* **Scenario 1 (Discount):** I need to loop through customers, check if `Age > 60`, and apply a 1% discount to their loan.
* **Scenario 2 (VIP Status):** I check if `Balance > 10000` and set the `IsVIP` flag to TRUE.
* **Scenario 3 (Reminders):** I need to find loans due in the next 30 days. Since MySQL doesn't have a direct "print" console like Java, I use a `SELECT` statement with a formatted string to output the reminder messages.