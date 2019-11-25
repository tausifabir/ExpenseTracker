package com.example.expensetracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expensetracker.Database.ExpenseDataBaseHelper;
import com.example.expensetracker.Database.ExpenseDataSource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

public class HomeActivity extends AppCompatActivity {

    private TextView total_incomeTV;
    private TextView total_expenseTV;
    private TextView total_balanceTV;
    private TextView TodayDateTV;
    private TextView dateshowTV;
    private TextView row_date;
    private TextView row_amount;
    private TextView row_type;
    private FloatingActionButton addbtn;
    RecyclerView recyclerView;
    public static List<Expense>expenselist = new ArrayList<>();
    private ExpenseDataSource expenseDataSource;
    private ExpenseAdapter expenseAdapter;
    private ListView expenselistView;
    private Expense expense;

    private ExpenseDataBaseHelper expenseDataBaseHelper;



    private boolean isloggedin = true;
    String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
    private UserPreference userPreference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        total_incomeTV=findViewById(R.id.total_incomeTV);
        total_expenseTV=findViewById(R.id.total_expenseTV);
        total_balanceTV=findViewById(R.id.total_balanceTV);
        TodayDateTV = findViewById(R.id.today_DateTV);
        dateshowTV=findViewById(R.id.currentDatePicker_home);
        row_date = findViewById(R.id.RowDate);
        row_type = findViewById(R.id.RowType);
        row_amount = findViewById(R.id.RowAmount);
        expenselistView = findViewById(R.id.exlistView);
        addbtn= findViewById(R.id.addbtn);
        dateshowTV.setText(date_n);
        userPreference = new UserPreference(this);
        userPreference.setLoginStatus(true);


        expenseDataSource = new ExpenseDataSource(this);

        expenselist = expenseDataSource.getAllExpense();
        expenseAdapter = new ExpenseAdapter(this,expenselist);
        expenselistView.setAdapter(expenseAdapter);




        Intent intent =  getIntent();


        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,AddExpense.class));
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem islogout = menu.findItem(R.id.logout);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.SrRandomMonth:
                Toast.makeText(this, "Search By Month", Toast.LENGTH_SHORT).show();
                break;

            case R.id.SrRandomYear:
                Toast.makeText(this, "Search By Year", Toast.LENGTH_SHORT).show();
                break;

            case R.id.SrCurrentMonth:
                Toast.makeText(this, "Search By Current Month", Toast.LENGTH_SHORT).show();
                break;

            case R.id.SrCurrentYear:
                Toast.makeText(this, "Search By Current Year", Toast.LENGTH_SHORT).show();
                break;
            case R.id.totalReport:
                Toast.makeText(this, "Search By Total Report", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                //isloggedin = false;
                userPreference.setLoginStatus(false);
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                break;
        }
        return true;
    }


}
