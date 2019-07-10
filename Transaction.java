package com.company;

import java.time.LocalDate;
import java.time.Month;

public class Transaction {

    // class fields
    private static int counter = 1;
    private int transactionId;
    private double amount;
    private int firstLevelMarker = 50;      // Coding level markers this way so they're easier to change if tweaks are made to rewards program rules.
    private int secondLevelMarker = 100;
    private LocalDate date;         // If this were a live app, I'd probably use a drop-down ENUM list for validating days and months (maybe years), so not taking the time to validate date input.
    private int rewardPoints;
    Customer customer;



    // Constructor and getters/setter
    public Transaction(int customerId, double amount, LocalDate date) {
        this.transactionId = setTransactionId();
        System.out.println("transactionId = " + this.transactionId);
        this.amount = amount;
        this.date = date;
        this.rewardPoints = calculateRewards(amount);
        System.out.println("Reward Points amount = " + rewardPoints);
        this.customer = RewardsProgram.getOrCreateCustomerById(customerId);
        System.out.println("Customer ID = " + customerId);
        System.out.println("Customer " + customerId + " previous reward balance = " + customer.getRewardBalance());
        addRewardPoints(this.customer);
        System.out.println("Customer " + customerId + " new reward balance = " + customer.getRewardBalance());
        System.out.println("Transaction List size before adding = " + RewardsProgram.transactionList.size());
        RewardsProgram.transactionList.add(this);
        System.out.println("Transaction List size after adding = " + RewardsProgram.transactionList.size());

    }

    private void addRewardPoints(Customer customer) {
        customer.addRewardPoints(rewardPoints);
    }

    int getTransactionId() {
        return transactionId;
    }

    private static int setTransactionId() {
        int transactionId = counter;
        counter += 1;
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public LocalDate getDate() {
        return date;
    }

    public Month getMonth(LocalDate date) {
        return date.getMonth();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", date=" + date +
                ", rewardPoints=" + rewardPoints +
                ", customerId=" + customer.getCustomerId() +
                '}';
    }

    // Reading assignment literally, that there are two points for a full dollar, not 1 point for each 50 cents. No partial points given.
    int calculateRewards(double amount) {
        int rewardsEarned = 0;
        if (amount > secondLevelMarker) {
            rewardsEarned += Math.floor(amount - firstLevelMarker);
            rewardsEarned += Math.floor(amount - secondLevelMarker);
        } else if (amount > firstLevelMarker) {
            rewardsEarned += Math.floor(amount - firstLevelMarker);
        }
        return rewardsEarned;
    }

}
