package com.example.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView registername,registeremail,registerpass;
    private Button signupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registername = findViewById(R.id.input_registernameET);
        registeremail = findViewById(R.id.input_emailET);
        registerpass = findViewById(R.id.input_registerpassET);
        signupbtn = findViewById(R.id.signupbtn);


        Intent intent =  getIntent();

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });
    }
}
