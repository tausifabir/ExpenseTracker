package com.example.expensetracker;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private boolean isloggedin = false;
    private EditText nameET,emailET,passET;
    private Button signbtn,registerbtn;
    private String email = "@";
    private String pass = "1";
    private UserPreference userPreference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET = findViewById(R.id.input_emailET);
        passET = findViewById(R.id.input_passET);
        signbtn = findViewById(R.id.signbtn);
        registerbtn = findViewById(R.id.registerbtn);
        userPreference = new UserPreference(this);

        if(userPreference.getLoginStatus()){
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        }
        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailTV = emailET.getText().toString();
                String passTV = passET.getText().toString();
                if(emailTV.isEmpty()){
                    Toast.makeText(MainActivity.this, "Field must be Filled", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(passTV.isEmpty()){
                    Toast.makeText(MainActivity.this, "Field must be Filled", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(emailTV.equals(email)&& passTV.equals(pass)){
                    //isloggedin = true;

                    startActivity(new Intent(MainActivity.this,HomeActivity.class));

                    userPreference.setLoginStatus(true);

                }else {
                    Toast.makeText(MainActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                }



            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });


    }



}
