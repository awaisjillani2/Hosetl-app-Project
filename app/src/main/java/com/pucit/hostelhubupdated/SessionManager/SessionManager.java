package com.pucit.hostelhubupdated.SessionManager;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager extends Activity {

    private SharedPreferences sp;

    public SharedPreferences getMySharedPreferences(Context context){
        if (sp == null)
            sp = context.getSharedPreferences("UserInfo", MODE_PRIVATE);
        return sp;
    }

    public boolean setUser(Context context, String cnic, String role){

        SharedPreferences.Editor editor = getMySharedPreferences(context).edit();
        editor.putString("cnic",cnic);
        editor.putString("role",role);
        if (editor.commit() == true)
            return true;
        else
            return false;
    }


    public boolean destroyUser(Context context){

        SharedPreferences.Editor editor = getMySharedPreferences(context).edit();
        editor.clear();
        return true;
    }


    public String getUser(Context context){
        return getMySharedPreferences(context).getString("cnic","");
    }

}
