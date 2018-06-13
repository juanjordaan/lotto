## TS Lottery API
#ts-lottery-api

### Requirements
Java 8
Gradle 3 or 4

#### Compile and Test ( with a Test Profile )
gradle test -i

The test will run src/test/java/org/ts/lotto/test/LotteryTest.java


Alternatively:
#### Dev Profile
create application-dev.properties by copying application-test.properties, change database settings and run
gradle bootRun


#### Compile and Package
gradle clean bootRepackage



Patterns
Dao Pattern
Dto Pattern?
