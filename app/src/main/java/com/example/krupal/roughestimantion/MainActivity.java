package com.example.krupal.roughestimantion;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    EditText carats_edit, rate_edit, amount_edit, rough_edit, florosence_edit, size_edit;
    Button submit_btn, viewrecord_btn, addexpences;
    Spinner clarity_edit, cut_edit;


    Intent intent, intent2;
    String total_amt = "0", avg_amt, total_carat = "0";
    String carat_edt1, rate_adt1, amount_edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> arr = new ArrayList<>();


        submit_btn = (Button) findViewById(R.id.submit_button);
        addexpences = (Button) findViewById(R.id.expences);
        carats_edit = (EditText) findViewById(R.id.carats_editText);
        rate_edit = (EditText) findViewById(R.id.rate_editText);
        clarity_edit = (Spinner) findViewById(R.id.clarity_list);
        cut_edit = (Spinner) findViewById(R.id.cut_list);
        rough_edit = (EditText) findViewById(R.id.rough_editText);
        florosence_edit = (EditText) findViewById(R.id.florosenceeditText);
        amount_edit = (EditText) findViewById(R.id.amount_editText);
        size_edit = (EditText) findViewById(R.id.size_editText);
        viewrecord_btn = (Button) findViewById(R.id.viewrecord_burron);


        viewrecord_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        rate_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                carat_edt1 = carats_edit.getText().toString();
                rate_adt1 = rate_edit.getText().toString();
                amount_edt1 = String.valueOf(Float.parseFloat(carat_edt1) * Float.parseFloat(rate_adt1));
                Log.d("price", "Final Price:-" + amount_edt1);
                amount_edit.setText(amount_edt1.toString());
            }
        });
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rough_edit.length() == 0) {
                    rough_edit.setError("FIELD CANNOT BE EMPTY");
                } else if (size_edit.length() == 0) {
                    size_edit.setError("FIELD CANNOT BE EMPTY");
                } else if (florosence_edit.length() == 0) {

                    florosence_edit.setError("FIELD CANNOT BE EMPTY");
                } else if (carats_edit.length() == 0) {
                    carats_edit.setError("FIELD CANNOT BE EMPTY");
                } else if (rate_edit.length() == 0) {
                    rate_edit.setError("FIELD CANNOT BE EMPTY");
                } else {
                    total_carat = String.valueOf(Float.parseFloat(total_carat) + Float.parseFloat(carats_edit.getText().toString()));
                    total_amt = String.valueOf(Float.parseFloat(total_amt) + Float.parseFloat(amount_edit.getText().toString()));
                    avg_amt = String.valueOf(Float.parseFloat(total_amt) / Float.parseFloat(total_carat));
                    Toast.makeText(getApplicationContext(), " total amount " + total_amt + " total carat " + total_carat + " avearage " + avg_amt, Toast.LENGTH_LONG).show();


                    arr.add(0,rough_edit.getText().toString());
                    arr.add(1,clarity_edit.getSelectedItem().toString());
                    arr.add(2,size_edit.getText().toString());
                    arr.add(3,florosence_edit.getText().toString());
                    arr.add(4,cut_edit.getSelectedItem().toString());
                    arr.add(5,carats_edit.getText().toString());
                    arr.add(6,rate_edit.getText().toString());
                    arr.add(7,amount_edit.getText().toString());

                 /*   roughModal.setNAME(rough_edit.getText().toString());
                    roughModal.setCLARITY(clarity_edit.getSelectedItem().toString());
                    roughModal.setSIZE(size_edit.getText().toString());
                    roughModal.setFLOROSENCE(florosence_edit.getText().toString());
                    roughModal.setCUT(cut_edit.getSelectedItem().toString());
                    roughModal.setCARATS(carats_edit.getText().toString());
                    roughModal.setRATE(rate_edit.getText().toString());
                    roughModal.setAMOUNT(amount_edit.getText().toString());
                    arr.add(roughModal);*/


                    intent = new Intent(MainActivity.this, DisplayRoughList.class);
                  //  intent.putStringArrayListExtra("arrayList", (ArrayList) arr);
                    intent.putExtra("total amount", total_amt);
                    intent.putExtra("total carat", total_carat);
                    intent.putExtra("totalavg", avg_amt);


                    intent2 = new Intent(MainActivity.this, ExpenceActivity.class);
                    intent2.putExtra("totalavg", avg_amt);

                    clear();

                    viewrecord_btn.setVisibility(view.VISIBLE);
                    addexpences.setVisibility(view.VISIBLE);
                }
            }

        });
        addexpences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intent2, 1);
            }
        });
    }

    void clear() {
        carats_edit.setText("0");
        rate_edit.setText("0");
        amount_edit.setText("");
        rough_edit.setText("");
        florosence_edit.setText("");
        size_edit.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            String res = data.getStringExtra("Result");
            Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
            intent.putExtra("avegrage", res);
        }
    }
}










