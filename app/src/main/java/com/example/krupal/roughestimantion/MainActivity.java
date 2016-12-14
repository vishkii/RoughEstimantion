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

public class MainActivity extends AppCompatActivity {


    EditText carats_edit, rate_edit, amount_edit, rough_edit, florosence_edit, size_edit;
    Button submit_btn, viewrecord_btn;
    Spinner clarity_edit, cut_edit;
    DbHelper SQLITEDATABASE;
    Intent intent,intent2;
    String total_amt = "0", avg_amt, total_carat = "0";
    String carat_edt1, rate_adt1, amount_edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SQLITEDATABASE = new DbHelper(this);
        submit_btn = (Button) findViewById(R.id.submit_button);
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
                amount_edt1 = String.valueOf(Integer.parseInt(carat_edt1) * Integer.parseInt(rate_adt1));
                Log.d("price", "Final Price:-" + amount_edt1);
                amount_edit.setText(amount_edt1.toString());
            }
        });
    submit_btn.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View view){
        boolean isInserted = SQLITEDATABASE.insertData(
                rough_edit.getText().toString(),
                clarity_edit.getSelectedItem().toString(),
                size_edit.getText().toString(),
                florosence_edit.getText().toString(),
                cut_edit.getSelectedItem().toString(),
                carats_edit.getText().toString(),
                rate_edit.getText().toString(),
                amount_edit.getText().toString());
        if (isInserted == true)
            Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();

        total_carat = String.valueOf(Integer.parseInt(total_carat) + Integer.parseInt(carats_edit.getText().toString()));
        total_amt = String.valueOf(Integer.parseInt(total_amt) + Integer.parseInt(amount_edit.getText().toString()));
        avg_amt = String.valueOf(Integer.parseInt(total_amt) / Integer.parseInt(total_carat));
        Toast.makeText(getApplicationContext(), " total amount " + total_amt + " total carat " + total_carat + " avearage " + avg_amt, Toast.LENGTH_LONG).show();
            intent = new Intent(MainActivity.this, DisplayRoughList.class);
            intent.putExtra("total carat", total_carat);
            intent.putExtra("total amount", total_amt);
            intent.putExtra("avearage", avg_amt);


            intent2 = new Intent(MainActivity.this, ExpenceActivity.class);
            intent2.putExtra("totalavg",avg_amt);
            startActivity(intent2);
            clear();
            viewrecord_btn.setVisibility(view.VISIBLE);

    }

    }

    );

}
    void clear() {
        carats_edit.setText("0");
        rate_edit.setText("0");
        amount_edit.setText("");
        rough_edit.setText("");
        florosence_edit.setText("");
        size_edit.setText("");
    }
}








