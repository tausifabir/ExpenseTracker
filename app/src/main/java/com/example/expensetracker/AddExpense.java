package com.example.expensetracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.expensetracker.Database.ExpenseDataSource;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddExpense extends AppCompatActivity {

    View.OnClickListener listener1 = null;
    View.OnClickListener listener2 = null;



    private RadioGroup radioGroup;
    private RadioButton incomerb,expenserb;
    private String RadioText;
    private Spinner categoryincomesp, categoryexpensp;
    private EditText expense_amount;
    private Button savebtn,Datepicker;
    private ExpenseDataSource expenseDataSource;

    boolean isDateChanged = false;

    private Expense expense;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_expense);
        radioGroup = findViewById(R.id.selectRadiogroud);
        expense_amount = findViewById(R.id.amoutnET);
        savebtn = findViewById(R.id.addsavebtn);
        Datepicker = findViewById(R.id.datePicker);

        expenseDataSource = new ExpenseDataSource(this);



        incomerb = findViewById(R.id.incomrbtn);
        incomerb.setOnClickListener(listener1);

        expenserb = findViewById(R.id.expenrbtn);
        expenserb.setOnClickListener(listener2);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                RadioText = rb.getText().toString();


            }
        });


        listener1 = new View.OnClickListener() {
            public void onClick(View v) {
                setTitle("Income");
                categoryexpensp.setVisibility(View.GONE);
                categoryincomesp.setVisibility(View.VISIBLE);
            }
        };

        listener2 = new View.OnClickListener() {
            public void onClick(View v) {
                setTitle("Expense");
                categoryincomesp.setVisibility(View.GONE);
                categoryexpensp.setVisibility(View.VISIBLE);
            }
        };





        categoryincomesp = findViewById(R.id.Income_Spinner);
        categoryexpensp = findViewById(R.id.Expense_Spinner);
        String[] incomcate = getResources().getStringArray(R.array.Income_Category);
        String[] expencate = getResources().getStringArray(R.array.Expense_Category);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,incomcate);
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,expencate);

        categoryincomesp.setAdapter(adapter);
        categoryexpensp.setAdapter(adapter1);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String ex_amount = expense_amount.getText().toString();
                String ex_date = Datepicker.getText().toString();



                if(ex_amount.isEmpty()){
                    expense_amount.setError("Amount must be filled");
                }else if (ex_date.isEmpty()){
                    Toast.makeText(AddExpense.this, "Date must be filled", Toast.LENGTH_SHORT).show();

                }else{

                    expense = new Expense(RadioText,ex_amount,ex_date);
                    boolean status = expenseDataSource.newInsertExpense(expense);
                    if(status){
                        Toast.makeText(AddExpense.this, ""+expense.getInputType(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddExpense.this,HomeActivity.class));
                    }else{
                        Toast.makeText(AddExpense.this, "Failed", Toast.LENGTH_SHORT).show();

                    }


                }

            }


        });

    }


    public void selectdate(View view) {

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(this, listner, year, month, day);
        //datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());// disable to take previous dates
        datePickerDialog.show();
    }


    private DatePickerDialog.OnDateSetListener listner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            final  Calendar calendar1 = Calendar.getInstance();
            calendar1.set(dayOfMonth,month,year);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yy");
            String selecteddate = simpleDateFormat.format(calendar1.getTime());

            Datepicker.setText(dayOfMonth+"/"+(month+1)+"/"+year);


        }
    };


    public DatePicker.OnDateChangedListener dateSetListener = new DatePicker.OnDateChangedListener() {
        public void onDateChanged(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
            isDateChanged = true;
        }
    };



}
