package com.example.krupal.roughestimantion;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpenceActivity extends AppCompatActivity {

    TextView avgtotal, finalest;
    EditText adattext, traveltext, extratext;
    String totalexpence = "0";
    String avg_amt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expence);


        adattext = (EditText) findViewById(R.id.adat_txt);
        traveltext = (EditText) findViewById(R.id.travel_txt);
        extratext = (EditText) findViewById(R.id.extra_txt);
        avgtotal = (TextView) findViewById(R.id.totalavg_textView);
        finalest = (TextView) findViewById(R.id.final_est);
        Intent intent = getIntent();
        avg_amt = intent.getStringExtra("totalavg");
        avgtotal.setText("total avearage  :   " + avg_amt);


        adattext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                totalexpence = String.valueOf((Float.parseFloat(avg_amt)* Float.parseFloat(adattext.getText().toString())/100) + (Float.parseFloat(avg_amt)) ) ;
                finalest.setText(totalexpence);
            }
        });
        traveltext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                float aFloat=Float.parseFloat(adattext.getText().toString())+ Float.parseFloat(traveltext.getText().toString());
                totalexpence = String.valueOf((Float.parseFloat(avg_amt)* aFloat/100) + (Float.parseFloat(avg_amt)) ) ;
                finalest.setText(totalexpence);
            }
        });
        extratext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                float aFloat=Float.parseFloat(extratext.getText().toString())+ Float.parseFloat(traveltext.getText().toString())+ Float.parseFloat(adattext.getText().toString());
                Log.i("float",String.valueOf(aFloat) );
                totalexpence = String.valueOf(Float.parseFloat(avg_amt)* aFloat/100 + (Float.parseFloat(avg_amt))) ;
                finalest.setText(totalexpence);
            }
        });

    }
}
