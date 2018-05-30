package com.example.jamal.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class ReadPreferences extends AppCompatActivity {
        Intent i;
        TextView readDefaultPreference,readMyPreference;
        SharedPreferences defaultPreference ,myPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_preferences);
        readDefaultPreference = (TextView) findViewById(R.id.readDefault);
        readMyPreference = (TextView) findViewById(R.id.readActivityPreference);
        defaultPreference = PreferenceManager.getDefaultSharedPreferences(this);
        myPreference = getSharedPreferences("com.example.jamal.sharedpreferences_preferences",MODE_PRIVATE);
        readDefaultPreference.setText(defaultPreference.getString("branche",""));
        readMyPreference.setText("vous estes :  "+myPreference.getString("nom","")+" "+myPreference.getString("prenom",
                ""+ (myPreference.getBoolean("redoublant",false) ? "redoublant " : "nouveau"))
        +" "+myPreference.getString("group",""));
    }
    public void process(View view){
           i=new Intent();
           i.putExtra("action","vous avez lu les données partagées ");
           setResult(RESULT_OK,i);
           finish();
    }
}
