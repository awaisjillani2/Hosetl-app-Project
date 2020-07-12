package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MoreOptions extends AppCompatActivity {


    public Button termsAndConditions,help,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_options);

        termsAndConditions=findViewById(R.id.btn_termsAndConditions_moreOptions);
        help=findViewById(R.id.btn_Help_moreOptions);
        logout=findViewById(R.id.btn_logout_moreOptions);


        termsAndConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MoreOptions.this, TermsAndConditions.class);
                startActivity(i);

            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MoreOptions.this, Help.class);
                startActivity(i);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MoreOptions.this, HostelSeekerLogin.class);
                startActivity(i);

            }
        });


    }
}
