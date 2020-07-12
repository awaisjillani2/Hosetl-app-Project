package com.pucit.hostelhubupdated;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.pucit.hostelhubupdated.Aysnc_Tasks.add_user_asynctask;
import com.pucit.hostelhubupdated.Models.UserModel;

public class OTPConfirm extends AppCompatActivity {

    private Button btn;
    private EditText et_input;
    private UserModel obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpconfirm);

        btn = (Button) findViewById(R.id.btn_confrim_confrimotp);
        et_input = (EditText) findViewById(R.id.et_mobilecode_otpconfirm);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String code = b.getString("code");
                obj = (UserModel) b.getSerializable("user");

                String temp = et_input.getText().toString();

                // Add condition temp!=code
                if (temp.equals("") == true) {
                    et_input.setError("Invalid Code");
                } else {

                    obj.context = getApplicationContext();
                    new add_user_asynctask().execute(obj);

                }
            }
        });

    }


}
