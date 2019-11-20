package com.example.expensetracker.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.expensetracker.Expense;

import java.util.ArrayList;

public class ExpenseDataSource {

    private ExpenseDataBaseHelper expenseDataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Expense expense;

    public ExpenseDataSource(Context context) {
        expenseDataBaseHelper = new ExpenseDataBaseHelper(context);
    }

    public  void open(){
        sqLiteDatabase = expenseDataBaseHelper.getWritableDatabase();
    }

    public  void close(){
        sqLiteDatabase.close();
    }

    public  boolean newInsertExpense(Expense expense){
        this.open();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(ExpenseDataBaseHelper.EXPENSE_COL_AMOUNT,expense.getAmount());
        contentValues.put(ExpenseDataBaseHelper.EXPENSE_COL_DATE,expense.getDate());
        long id = sqLiteDatabase.insert(ExpenseDataBaseHelper.TABLE_EXPENSE,null,contentValues);

        if(id > 0){
            return  true;
        }else {
            return  false;
        }

    }

    public ArrayList<Expense> getAllExpense(){
        ArrayList<Expense> expenses = new ArrayList<>();
        this.open();

        Cursor cursor = sqLiteDatabase.query(ExpenseDataBaseHelper.TABLE_EXPENSE,null,null,
                null, null,null,null );
        cursor.moveToFirst();
        if(cursor != null && cursor.getCount() > 0){

            for(int i = 0; i < cursor.getCount();i++){

                int id = cursor.getInt(cursor.getColumnIndex(ExpenseDataBaseHelper.EXPENSE_COL_ID));
                String amount = cursor.getString(cursor.getColumnIndex(ExpenseDataBaseHelper.EXPENSE_COL_AMOUNT));
                String date = cursor.getString(cursor.getColumnIndex(ExpenseDataBaseHelper.EXPENSE_COL_DATE));
                expense = new Expense(id,amount,date);
                expenses.add(expense);
                cursor.moveToNext();

            }

        }


        cursor.close();
        this.close();
        return expenses;
    }
}
