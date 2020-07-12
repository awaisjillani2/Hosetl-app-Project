package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class OTPVerification extends AppCompatActivity {

    Button btn;
    EditText et_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        btn=(Button) findViewById(R.id.btn_send_otpverification);
        et_input = (EditText) findViewById(R.id.et_otpverification_otpverifaction);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = et_input.getText().toString();

                if (temp.length() != 11 || !temp.startsWith("03")) {
                    et_input.setError("Invalid Format");
                } else {
                    Intent intent = new Intent(getApplicationContext(), OTPConfirm.class);
                    startActivity(intent);

                }

            }
        });
    }
}
