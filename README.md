# CharterAssignment
Assignment for Charter Application
<Assignment instructions>
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total. 
·         Make up a data set to best demonstrate your solution
·         Check solution into GitHub
</Assignment Instructions>


Three classes in the program - 
  RewardsProgram is the controller/logic/main class, 
  Customer represents rewards customers, 
  Transaction represents rewards transactions
  
There are three lines in RewardsProgram that require user work.
Line 79 - Uncomment line to print out all customers and their updated total rewards balances.
Line 82 - Uncomment line and (potentially) change customerId argument to print the reward balance for a           particular customer.
Line 85 - Uncomment line and enter a customerID and Month (prepopulated with ID=12345, Month = AUGUST) 
          to print an individual customer's earned rewards for that month. 

Assumptions: 
No partial points are given. Cents offer no rewards credit, and there are no point increases at the 50-           cent mark in transactions over $100.
This is set up for a small dataset, since I'm hand-coding it. For a larger set, I'd changeArrayLists to           HashTables in order to speed up read and write times. I'd change ID fields from primitive ints           to wrapper Integers to use as table-keys in HashTables. The respective Objects would be the             table-values.
Date formats will be clear to those who'd enter them via hard-coding into the program. The only                   validation is a try-catch block to confirm the date is valid (no September 31, February 30,             etc.). I didn't think a formatter method was necessary here.
To create a transaction date in a live app, I'd use something pre-populated like drop-down lists 
Customer IDs are hand-generated. If this were a more wide-spread app, I'd include an auto-generator at             registration. 
