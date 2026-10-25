# Core Java Business Management Engine

A Java 17 Maven project demonstrating OOP, records, generic collections, Streams/Lambdas, custom exceptions, and JUnit 5 tests.

## Requirements
- JDK 17 or newer
- Maven 3.8+ (or VS Code Java/Maven extensions)

## Run
From the folder containing `pom.xml`:

```bash
mvn test
mvn -q -DskipTests package
java -cp target/classes com.business.Main
```

## Features
- Abstract `Person` base class and `Employee` / `Manager` inheritance
- Immutable `EmployeeDetails` record
- `List`, `Set`, and `Map` collections
- Stream-based salary sorting, department filtering, salary totals
- Checked `BusinessRuleException` and unchecked `EmployeeNotFoundException`
- JUnit 5 tests for key business rules
