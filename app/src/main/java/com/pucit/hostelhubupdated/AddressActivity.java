package com.pucit.hostelhubupdated;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pucit.hostelhubupdated.Models.UserModel;

import java.util.Random;

public class AddressActivity extends AppCompatActivity {

    private EditText house,street,code,locality,city;
    private Button btn;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    private String phoneNo,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        house = (EditText) findViewById(R.id.et_houseNo_address_activity);
        street = (EditText) findViewById(R.id.et_streetNo_address_activity);
        code = (EditText) findViewById(R.id.et_postalCode_address_activity);
        locality = (EditText) findViewById(R.id.et_locality_address_activity);
        city = (EditText) findViewById(R.id.et_city_address_activity);
        btn = (Button) findViewById(R.id.btn_create_account_address_activity);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int h = -1;
                int s = -1;
                int c = -1;

                if (house.getText().toString().equals("")){
                    house.setError("Please enter valid Number");
                }
                else{
                    h = Integer.parseInt(house.getText().toString());
                }

                if (street.getText().toString().equals("")){
                    street.setError("Please enter valid Number");
                }
                else{
                    s = Integer.parseInt(street.getText().toString());
                }

                if (code.getText().toString().equals("")){
                    code.setError("Please enter valid Number");
                }
                else{
                    c = Integer.parseInt(code.getText().toString());
                }

                String l = locality.getText().toString();
                String cty = city.getText().toString();

                if (isValidString(l) && isValidString(cty)){

                    Bundle b = getIntent().getExtras();
                    UserModel obj = new UserModel();

                    obj.role = b.getString("role");
                    obj.username = b.getString("name");
                    obj.login = b.getString("login");
                    obj.password = b.getString("pass");
                    obj.cnic = b.getString("cnic");
                    obj.phone = b.getString("cell");
                    obj.email = b.getString("email");

                    obj.streetNo = s;
                    obj.houseNo = h;
                    obj.postalCode = c;
                    obj.locality = l;
                    obj.city = cty;

                    Random random = new Random();
                    String rand = String.format("%04d",random.nextInt(10000));

                    Intent i = new Intent(AddressActivity.this,OTPConfirm.class);
                    i.putExtra("user",obj);
                    i.putExtra("code",rand);

                    phoneNo = obj.phone;
                    message = rand.toString();

                    //sendSMSMessage();

                    startActivity(i);


                }
                else if (isValidString(l) == false)
                    locality.setError("Please enter valid name!");
                else if (isValidString(cty) == false)
                    city.setError("Please enter valid name!");


            }
        });

    }


    private boolean isValidString(String str) {
        if (str.equals("")) {
            return false;
        }
        return true;
    }

    private boolean isValidNum(int num) {
        if (num <= 0 || num>= 1000) {
            return false;
        }
        return true;
    }


    protected void sendSMSMessage() {
        SmsManager sms = SmsManager.getDefault();
        PendingIntent sentPI;
        String SENT = "SMS_SENT";
        sentPI = PendingIntent.getBroadcast(AddressActivity.this, 0,new Intent(SENT), 0);
        sms.sendTextMessage(phoneNo, null, message, sentPI, null);

        Toast.makeText(getApplicationContext(),"Sent", Toast.LENGTH_LONG).show();
    }



}
