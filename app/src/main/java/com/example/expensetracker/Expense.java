package com.example.expensetracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Expense implements Serializable {


    public static final List<Expense> expenseList = new ArrayList<>();

    private int expense_id;
    private String InputType;
    private String categroy;
    private String amount;
    private String date;

    public Expense(int expense_id, String InputType, String categroy, String amount, String date) {
        this.expense_id = expense_id;
        this.InputType = InputType;
        this.categroy = categroy;
        this.amount = amount;
        this.date = date;
    }


    public Expense(String InputType, String categroy, String amount, String date) {
        this.InputType = InputType;
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


    public Expense(int expense_id, String inputType, String amount, String date) {
        this.expense_id = expense_id;
        InputType = inputType;
        this.amount = amount;
        this.date = date;
    }


    public Expense(String inputType, String amount, String date) {
        InputType = inputType;
        this.amount = amount;
        this.date = date;
    }

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public String getInputType() {
        return InputType;
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
