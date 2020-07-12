package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class newPassword extends AppCompatActivity {

    private Button btn_reset;
    private EditText et_newPass,et_confirmPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        btn_reset = (Button) findViewById(R.id.btn_reset_newpassword_activity);
        et_newPass = (EditText) findViewById(R.id.et_newPassword_newPassword_activity);
        et_confirmPass = (EditText) findViewById(R.id.et_confirmNewPass_newPassword_activity);


        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp1 = et_newPass.getText().toString();
                String temp2 = et_confirmPass.getText().toString();

                if (temp1.equals(temp2) && temp1.length() > 6 )
                {
                    Intent i = new Intent(getApplicationContext(),HostelManagerLogin.class);
                    startActivity(i);
                }
                else
                {
                    et_newPass.setError("Invalid Format");
                }
            }
        });

    }
}
