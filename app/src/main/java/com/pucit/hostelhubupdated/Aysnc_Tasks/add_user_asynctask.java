package com.pucit.hostelhubupdated.Aysnc_Tasks;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.pucit.hostelhubupdated.AddHostel;
import com.pucit.hostelhubupdated.Database.Database;
import com.pucit.hostelhubupdated.SessionManager.SessionManager;
import com.pucit.hostelhubupdated.Models.UserModel;

public class add_user_asynctask extends AsyncTask<UserModel,Void,Query> {

    private UserModel obj;

    @Override
    protected Query doInBackground(UserModel... userModels) {
        obj = userModels[0];
        return Database.isAlreadyAUser(obj.cnic);
    }

    @Override
    protected void onPostExecute(Query q) {

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    Toast.makeText(obj.context, "Already a User!", Toast.LENGTH_SHORT).show();
                }
                else {

                    Database.insertUser(obj);
                    Toast.makeText(obj.context, "User has been added successfully!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(obj.context, AddHostel.class);
                    i.putExtra("cnic", obj.cnic);
                    i.putExtra("role", obj.role);

                    SessionManager sm = new SessionManager();
                    sm.setUser(obj.context,obj.cnic,obj.role);

                    obj.context.startActivity(i);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
