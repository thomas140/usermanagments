package com.example.usermanagment;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference
{
        private SharedPreferences sharedPreferences;
        private Context context;
        private static final String pref="com.user_management";
        private static final String prefStatus="com.user_management";
        public SharedPreference (Context context)
        {
            this.context=context;
            sharedPreferences= context.getSharedPreferences(pref, Context.MODE_PRIVATE);

        }
        public void writeLogInStatus(boolean bool)
        {
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putBoolean(prefStatus, bool);
            editor.commit();
        }
        public boolean readLogInStatus()
        {
            return sharedPreferences.getBoolean(prefStatus,false);
        }
}
