package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class verifyCode extends AppCompatActivity {

    private Button btn_verify;
    private EditText et_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);

        btn_verify = (Button)findViewById(R.id.btn_confirm_verify_code_activity);
        et_input = (EditText) findViewById(R.id.et_verificationCode_verificationcode);

        btn_verify.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String temp = et_input.getText().toString().trim();

                if (temp.length() == 4){
                    Intent intent= new Intent(getApplicationContext(), newPassword.class);
                    startActivity(intent);
                }
                else
                    et_input.setError("Enter 4-digit code");


            }
        });

    }
}
