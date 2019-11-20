package com.example.expensetracker;

import java.io.Serializable;

public class Income implements Serializable {

    private int income_id;
    private String income;
    private String categroy;
    private String amount;
    private String Date;

    public Income(int income_id, String income, String categroy, String amount, String date) {
        this.income_id = income_id;
        this.income = income;
        this.categroy = categroy;
        this.amount = amount;
        Date = date;
    }

    public Income(String income, String categroy, String amount, String date) {
        this.income = income;
        this.categroy = categroy;
        this.amount = amount;
        Date = date;
    }

    public Income(String amount, String date) {
        this.amount = amount;
        Date = date;
    }

    public int getIncome_id() {
        return income_id;
    }

    public void setIncome_id(int income_id) {
        this.income_id = income_id;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getCategroy() {
        return categroy;
    }

    public void setCategroy(String categroy) {
        this.categroy = categroy;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
