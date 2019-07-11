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
    private LocalDate date;
    private int rewardPoints;
    Customer customer;

    
    // Constructor and getters/setter/adder
    public Transaction(int customerId, double amount, LocalDate date) {
        this.transactionId = setTransactionId();
        this.amount = amount;
        this.date = date;
        this.rewardPoints = calculateRewards(amount);
        this.customer = RewardsProgram.getOrCreateCustomerById(customerId);
        addRewardPoints(this.customer);
        RewardsProgram.transactionList.add(this);
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
