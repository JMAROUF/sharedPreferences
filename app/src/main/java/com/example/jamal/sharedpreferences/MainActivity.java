package com.example.jamal.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int myRequestCode= 1;
    Intent i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view){
        switch(view.getId()){
            case R.id.activityPreference : i=new Intent("com.example.jamal.sharedpreferences.ActivityPreference");
                                        startActivityForResult(i,myRequestCode);
                                        break;
            case R.id.defaultPreference :
                                             SharedPreferences defaultPreference = PreferenceManager.getDefaultSharedPreferences(this);
                                             SharedPreferences.Editor editeur = defaultPreference.edit();
                                             editeur.putString("branche","TDI");
                                             editeur.commit();
                break;

            case R.id.readActivity : i=new Intent("com.example.jamal.sharedpreferences.ReadtPreference");
                                        startActivityForResult(i,myRequestCode);
                                     break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==myRequestCode){
            if(resultCode==RESULT_OK){
                Toast.makeText(this,data.getStringExtra("action"),Toast.LENGTH_LONG).show();
            }
        }
    }
}

