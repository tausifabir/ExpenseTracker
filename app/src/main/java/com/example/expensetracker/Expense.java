package com.example.expensetracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Expense implements Serializable {


    public static final List<Expense> expenseList = new ArrayList<>();

    private int expense_id;
    private String expense;
    private String categroy;
    private String amount;
    private String date;

    public Expense(int expense_id, String expense, String categroy, String amount, String date) {
        this.expense_id = expense_id;
        this.expense = expense;
        this.categroy = categroy;
        this.amount = amount;
        this.date = date;
    }



    public Expense(String expense, String categroy, String amount, String date) {
        this.expense = expense;
        this.categroy = categroy;
        this.amount = amount;
        this.date = date;
    }

    public Expense(String amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public Expense(int expense_id, String amount, String date) {
        this.expense_id = expense_id;
        this.amount = amount;
        this.date = date;
    }

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public String getExpense() {
        return expense;
    }

    public String getCategroy() {
        return categroy;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
