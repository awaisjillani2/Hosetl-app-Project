package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class HostelSeekerHome extends AppCompatActivity {

    private Button btn_request_res;
    private Button btn_communicate;
    private Button btn_give_rating;
    private Button btn_give_feedback;
    private Button btn_delete_account;
    private Button btn_edit_profile;
    private Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_seeker_home);

        findViews();


        btn_request_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Request has been sent",Toast.LENGTH_SHORT).show();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HostelSeekerLogin.class);
                startActivity(i);
            }
        });

        btn_communicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HostelSeekerHome.this, MainActivity.class);
                startActivity(i);
            }
        });

        btn_give_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inflate the layout of the popup window
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.activity_pop_up_rating, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(findViewById(R.id.ll_main_hostel_seeker_home_activity), Gravity.CENTER, 0, 0);

                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });


                //Setting Input Validation on Ratings Popup
                Button submit = (Button) popupView.findViewById(R.id.btn_submit_popup_rating_activity);
                final EditText editText = (EditText) popupView.findViewById(R.id.et_rating_popup_rating_activity);

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Pattern.matches("[1-5]",editText.getText().toString().trim()) == true){
                            Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_SHORT).show();
                        }
                        else
                            editText.setError("Invalid Input");
                    }
                });



            }
        });

        btn_give_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inflate the layout of the popup window
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.activity_pop_up_feedback, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(findViewById(R.id.ll_main_hostel_seeker_home_activity), Gravity.CENTER, 0, 0);

                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });


                //Setting Input Validation on Feedback Popup
                Button submit = (Button) popupView.findViewById(R.id.btn_submit_popup_feedback_activity);
                final EditText editText = (EditText) popupView.findViewById(R.id.et_feedback_popup_feedback_activity);

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editText.getText().toString().trim().length() > 0){
                            Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_SHORT).show();
                        }
                        else
                            editText.setError("Invalid Input");
                    }
                });



            }
        });

        btn_delete_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HostelSeekerLogin.class);
                startActivity(i);
            }
        });

        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HostelSeekerHome.this, EditManagerProfileActivity.class);
                startActivity(i);
            }
        });

    }


    public void findViews(){

        btn_request_res = (Button) findViewById(R.id.btn_request_reg_hostel_seeker_home_activity);
        btn_communicate = (Button) findViewById(R.id.btn_communicate_hostel_seeker_home_activity);
        btn_give_rating = (Button) findViewById(R.id.btn_give_rating_hostel_seeker_home_activity);
        btn_give_feedback = (Button) findViewById(R.id.btn_give_feedback_hostel_seeker_home_activity);
        btn_delete_account = (Button) findViewById(R.id.btn_delete_profile_hostel_seeker_home_activity);
        btn_edit_profile  = (Button) findViewById(R.id.btn_edit_profile_hostel_seeker_home_activity);
        btn_logout = (Button) findViewById(R.id.btn_logout_hostel_seeker_home_activity);

    }

}
