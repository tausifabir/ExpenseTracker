package com.example.expensetracker.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class ExpenseDataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Expense Database";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_INCOME = "tbl_income_income";
    public static final String INCOME_COL_ID = "tbl_income_id";
    public static final String INCOME_COL_CATEGORY = "tbl_income_category";
    public static final String INCOME_COL_AMOUNT = "tbl_income_amount";
    public static final String INCOME_COL_DATE = "tbl_income_date";
    public static final String INCOME_COL_BALANCE = "tbl_income_balance";

    public static final String CREATE_TABLE_INCOME =
            "CREATE TABLE "+TABLE_INCOME+"("+
                    INCOME_COL_ID+" INTEGER PRIMARY KEY, "+
                    INCOME_COL_CATEGORY+" TEXT,"+
                    INCOME_COL_AMOUNT+" TEXT,"+
                    INCOME_COL_DATE+" TEXT,"+
                    INCOME_COL_BALANCE+" TEXT);";

    public static final String TABLE_EXPENSE = "tbl_expense_expense";
    public static final String EXPENSE_COL_ID = "tbl_expense_id";
    public static final String EXPENSE_COL_CATEGORY = "tbl_expense_category";
    public static final String EXPENSE_COL_AMOUNT = "tbl_expense_amount";
    public static final String EXPENSE_COL_DATE = "tbl_expense_date";
    public static final String EXPENSE_COL_BALANCE = "tbl_expense_balance";

    public static final String CREATE_TABLE_EXPENSE =
            "CREATE TABLE "+TABLE_EXPENSE+"("+
                    EXPENSE_COL_ID+" INTEGER PRIMARY KEY, "+
                    EXPENSE_COL_CATEGORY+" TEXT, "+
                    EXPENSE_COL_AMOUNT+" TEXT, "+
                    EXPENSE_COL_DATE+" TEXT, "+
                    EXPENSE_COL_BALANCE+" TEXT);";




    public ExpenseDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE_INCOME);
            sqLiteDatabase.execSQL(CREATE_TABLE_EXPENSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
