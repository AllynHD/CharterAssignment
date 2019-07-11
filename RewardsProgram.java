package com.company;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class RewardsProgram {

    static ArrayList<Transaction> transactionList = new ArrayList<>();
    static ArrayList<Customer> customerList = new ArrayList<>();


    static Transaction getTransactionById(int transactionId) {
        for (Transaction transaction : transactionList) {
            if (transactionId == transaction.getTransactionId()) {
                return transaction;
            }
        }
        System.out.println("Could not find transaction by ID " + transactionId);
        return null;
    }

    static Customer getOrCreateCustomerById(int customerId) {
        for (Customer customer : customerList) {
            if (customerId == customer.getCustomerId()) {
                return customer;
            }
        }
        Customer newCustomer = new Customer(customerId);
        return newCustomer;
    }

    static void printAllCustomersTotalRewards() {
        for (Customer customer : customerList) {
            int customerId = customer.getCustomerId();
            printRewardsForSingleCustomer(customerId);        }
    }

    static void printRewardsForSingleCustomer(int customerId) {
        System.out.println("Total rewards for customer " + customerId + " = " + getOrCreateCustomerById(12345).getRewardBalance());
    }

    static int getMonthlyCustomerRewards (Customer customer, Month month) {
        int balance = 0;
        for (Transaction transaction : transactionList) {
            if (transaction.customer.equals(customer) && transaction.getMonth(transaction.getDate()).equals(month)) {
             balance += transaction.getRewardPoints();
            }
        }
        return balance;
    }

    static void selectCustomerAndMonthForMonthlyRewards(int customerId, Month month) {
        Customer customer = getOrCreateCustomerById(customerId);
        int monthlyRewardsForCustomer = getMonthlyCustomerRewards(customer, month);
        // If you'd like to put in an expected value for easier testing checks, you can.
        System.out.println("Customer " + customer.getCustomerId() + "'s " + month + " rewards should be <expected value> and are " + monthlyRewardsForCustomer);
    }


    public static void main(String[] args) {
        try {
            Transaction t1 = new Transaction(12345, 150.00, LocalDate.of(2019, 7, 10));     // 150 points, JULY - Can process level 2 whole numbers accurately
            Transaction t2 = new Transaction(12345, 150.00, LocalDate.of(2019, 8, 10));     // 150 points, AUGUST - Can process month separation accurately
            Transaction t3 = new Transaction(12345, 75, LocalDate.of(2019, 8, 10));         // 25 points, AUGUST - Can process level 1 whole numbers accurately
            Transaction t4 = new Transaction(10101, 219.75, LocalDate.of(2019, 7, 10));     // 288 points, JULY - Can process new customer, decimal amount accurately
            Transaction t5 = new Transaction(10101, 49.99, LocalDate.of(2019, 8, 10));      // 0 points, AUGUST - Can process zero points accurately
            Transaction t6 = new Transaction(10101, 98.63, LocalDate.of(2019, 7, 10));      // 48 points, JULY - Can process cents accurately, not giving additional points for rounding/accumulation
            Transaction t7 = new Transaction(10101, 75, LocalDate.of(2019, 9, 30));         // 25 points, SEPTEMBER - Can process third month, bad date accurately
            Transaction t8 = new Transaction(10101, 150.00, LocalDate.of(2019, 8, 10));     // 150 points, AUGUST - Can process months out of order for same customer
            Transaction t9 = new Transaction(8675309, 999.99, LocalDate.of(2019, 8, 10));   // 1848 points, AUGUST - Can process third customer
        } catch (DateTimeException e) {
            System.out.println("DateTime Error! Message = " + e.getMessage() + " AND NOTHING AFTER THIS DATE PROCESSED. Fix error and run again.");
        }


        // To print total rewards for every customer, uncomment following line
//        printAllCustomersTotalRewards();

        // To print a single customer's total rewards, uncomment following line and define customer by changing customerId argument (placeholder value = 12345).
//        printRewardsForSingleCustomer(12345);

        // To print a particular monthly reward total for a particular customer, uncomment following line and fill in arguments (month should be in format Month.MONTHNAME)
//        selectCustomerAndMonthForMonthlyRewards(12345, Month.AUGUST);
    }
}