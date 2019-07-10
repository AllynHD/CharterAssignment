package com.company;


import java.util.ArrayList;

public class Customer {

    // class fields
    private int customerId;
    private int rewardBalance;


    // Constructor and getters/setter
    public Customer(int customerId) {
        this.customerId = customerId;
        RewardsProgram.customerList.add(this);
    }


    public int getCustomerId() {
        return customerId;
    }

    public int getRewardBalance() {
        return rewardBalance;
    }

    public void addRewardPoints(int rewardPoints) {
        this.rewardBalance += rewardPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", rewardBalance=" + rewardBalance +
                '}';
    }
}
