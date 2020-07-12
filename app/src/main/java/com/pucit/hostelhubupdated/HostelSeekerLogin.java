package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HostelSeekerLogin extends AppCompatActivity {

    private Button loginBtn;
    private Button signUpBtn;
    private TextView forgotPassword;

    private EditText textinputusername,textinputpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_seeker_login);

        textinputusername=findViewById(R.id.et_username_hostel_seeker_login);
        textinputpassword=findViewById(R.id.et_password_hostel_seeker_login);

        signUpBtn = (Button) findViewById(R.id.btn_signup_ll_login_activity);
        loginBtn  = (Button) findViewById(R.id.btn_login_login_activity);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = textinputusername.getText().toString();
                final String pass = textinputpassword.getText().toString();
                if (isValidusername(username) && isValidPassword(pass)) {
                    Intent i = new Intent(getApplicationContext(), HostelSeekerHome.class);
                    startActivity(i);
                } else {
                    if (!isValidusername(username)) {
                        textinputusername.setError("Invalid username");
                    }


                    if (!isValidPassword(pass)) {
                        textinputpassword.setError("Invalid Password");
                    }
                }

            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HostelSeekerLogin.this , SignUp.class);
                intent.putExtra("TypeOfUser","seeker");
                startActivity(intent);
            }
        });

        forgotPassword=findViewById(R.id.tv_forgot_password_hostel_seeker_login);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HostelSeekerLogin.this, Forget.class);
                startActivity(i);
            }
        });




    }

    private boolean isValidusername(String user) {
        if (! user.equals("")) {
            return true;
        }
        return false;
    }
    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }

}
