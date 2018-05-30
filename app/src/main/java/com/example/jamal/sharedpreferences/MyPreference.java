package com.example.jamal.sharedpreferences;

import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyPreference extends PreferenceActivity {
    Intent  i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.sharedpreferences);
    }

    public void process(View view){
        i=new Intent();
        i.putExtra("action","vous avez lu les données partagées ");
        setResult(RESULT_OK,i);
        finish();
    }
}
