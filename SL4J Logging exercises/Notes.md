# Notes: SLF4J Logging

**Mental Model:** Using `System.out.println()` is terrible practice for real-world applications because it's hard to search, hard to format, and impossible to turn off easily. SLF4J (with Logback) acts like a professional control board for application outputs.

* **Implementation:** I added the `slf4j-api` and `logback-classic` dependencies to Maven.
* **Logging Levels:** I created a `LoggerFactory` and logged distinct `.error()` and `.warn()` messages. In a real production server, I could tweak the Logback configuration file to only save ERRORs to a permanent text file while completely ignoring DEBUG or INFO messages, saving massive amounts of disk space.