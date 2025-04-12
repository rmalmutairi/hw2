# hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

## Compile

To compile the code from terminal, use the following command:
```
cd src
javac ExpenseTrackerApp.java
java ExpenseTracker
```

You should be able to view the GUI of the project upon successful compilation. 

## Java Version
This code is compiled with ```openjdk 17.0.7 2023-04-18```. Please update your JDK accordingly if you face any incompatibility issue.


## Homework 2 Additions
- **Immutable Transaction**: Removed setters, made fields private final.
- **Encapsulated Model**: `ExpenseTrackerModel` now returns an unmodifiable list of transactions.
- **Strategy Filters**: Implemented `TransactionFilter`, `AmountFilter`, `CategoryFilter`.
- **New Tests**: Added four JUnit tests (`AddTransactionTest`, `InvalidInputTest`, `FilterAmountTest`, `FilterCategoryTest`) on top of the two starter tests.
- **Undo Design**: Proposed an undo stack in `undo.txt`.