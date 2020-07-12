package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Forget extends AppCompatActivity {

    private Button btn_send;
    private EditText et_forget_Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        btn_send = (Button)findViewById(R.id.btn_send_forgotpassword);
        et_forget_Pass = (EditText) findViewById(R.id.et_forgotpassword_forgotpassword);


        btn_send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                final String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-z]+";
                String temp = et_forget_Pass.getText().toString().trim();
                if (temp.length() != 0 && temp.matches(emailPattern)){
                    Intent intent= new Intent(getApplicationContext(), verifyCode.class);
                    startActivity(intent);
                }
                else
                    et_forget_Pass.setError("Invalid format");

            }
        });

    }



}
