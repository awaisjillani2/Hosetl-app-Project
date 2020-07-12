package com.pucit.hostelhubupdated;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pucit.hostelhubupdated.Database.Database;

public class EditManagerProfileActivity extends AppCompatActivity {

    public EditText username,cnic,contact,newPassword,confirmNewPassword;
    public Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_manager_profile);

        Database.updateUserInfo("3110128238333");

        username=findViewById(R.id.et_username_edit_profile);
        cnic=findViewById(R.id.et_CNIC_edit_profile);
        cnic.setEnabled(false);
        contact=findViewById(R.id.et_contact_edit_profile);
        newPassword=findViewById(R.id.et_new_password_edit_profile);
        confirmNewPassword=findViewById(R.id.et_confirm_new_password_edit_profile);
        cnic.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(cnic.getText().toString().length()!=13 || !cnic.getText().toString().startsWith("36") ){
                    cnic.setError("CNIC no. should be as per format 3xxxxxxxxxxxx");
                }
                else
                {
                    cnic.setError(null);
                }
            }
        });

        contact.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(contact.getText().toString().length()!=11 || !contact.getText().toString().startsWith("03")){

                    contact.setError("Contact No. should be as per format 03xxxxxxxxx");

                }
                else
                {
                    contact.setError(null);
                }
            }
        });



        confirmNewPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String newPasswordValue=newPassword.getText().toString();
                String confirmNewPasswordValue=confirmNewPassword.getText().toString();
                if(newPasswordValue.equals(confirmNewPasswordValue)){
                    newPassword.setError(null);
                    confirmNewPassword.setError(null);
                }
                else
                {
                    confirmNewPassword.setError("Passwords should match");

                }
            }
        });

        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditManagerProfileActivity.this, "Changes Saved", Toast.LENGTH_SHORT).show();
            }

        });



    }
}
