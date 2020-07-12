package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    private Button btncreateaccount;
    //private Bundle sentValues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       /*
        sentValues = getIntent().getExtras();
        String user_type = sentValues.getString("type");
        */

        final EditText textinputusername = (EditText) findViewById(R.id.manager_signup_username);
        final EditText textinputpassword = (EditText) findViewById(R.id.manager_signup_password);
        final EditText textinputCNIC = (EditText) findViewById(R.id.manager_signup_cnic);
        final EditText textinputcontact = (EditText) findViewById(R.id.manager_signup_contact);
        final EditText textinputLoginName = (EditText) findViewById(R.id.manager_signup_login_name);
        final EditText textinputEmail = (EditText) findViewById(R.id.manager_signup_email);

        btncreateaccount = (Button) findViewById(R.id.btn_next_signup_activity);
        btncreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = textinputusername.getText().toString();
                final String pass = textinputpassword.getText().toString();
                final String CNIC = textinputCNIC.getText().toString();
                final String Cell = textinputcontact.getText().toString();
                final String loginName = textinputLoginName.getText().toString();
                final String email = textinputEmail.getText().toString();

                if (isValidusername(email) && isValidusername(loginName) && isValidusername(username) && isValidPassword(pass) && isValidCNIC(CNIC) && isValidcontact(Cell) ) {

                    Bundle b = getIntent().getExtras();
                    String role = b.getString("Role");

                    Intent i = new Intent(SignUp.this, AddressActivity.class);
                    i.putExtra("role",role);
                    i.putExtra("login",loginName);
                    i.putExtra("name",username);
                    i.putExtra("pass",pass);
                    i.putExtra("cnic",CNIC);
                    i.putExtra("cell",Cell);
                    i.putExtra("email",email);

                    startActivity(i);

                } else {

                    if (!isValidusername(email)){
                        textinputEmail.setError("Invalid Email");
                    }

                    if (!isValidusername(username)) {
                        textinputusername.setError("Invalid Username");
                    }


                    if (!isValidPassword(pass)) {
                        textinputpassword.setError("Invalid Password");
                    }

                    if (!isValidCNIC(CNIC)) {
                        textinputCNIC.setError("Invalid CNIC");
                    }

                    if (!isValidcontact(Cell)) {
                        textinputcontact.setError("Invalid Contact");
                    }

                    if (!isValidusername(loginName)){
                        textinputLoginName.setError("Invalid Login Name");
                    }

                }
            }
        });

    }
    private boolean isValidusername(String username) {
        if (!username.equals("")) {
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

    // validating CNIC with retype password
    private boolean isValidCNIC(String cnic) {
        if (cnic != null && cnic.length() == 13) {
            return true;
        }
        return false;
    }

    // validating Contact with retype password
    private boolean isValidcontact(String contact) {
        if (contact != null && contact.length() == 11 && contact.startsWith("03")) {
            return true;
        }
        return false;
    }






}
