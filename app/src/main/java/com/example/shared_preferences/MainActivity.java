package com.example.shared_preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences.Editor editor = getSharedPreferences("Gourav",MODE_PRIVATE).edit();

        editor.putBoolean("IsFirestTimeUser",true);
        editor.commit();
        //editor.apply() can also be used but the difference is that comit writes to persistent storage immediately

        boolean IsFirstTimeUser = (boolean) getSharedPreferences("Gourav",MODE_PRIVATE).getBoolean("IsFirstTimeUser",true);

        if(IsFirstTimeUser) {
            Intent intent = new Intent(MainActivity.this,MyApplication.class);
            startActivity(intent);
        }
        else {
            Log.d(TAG, "user has not opened the app first time ");
        }


    }
}
