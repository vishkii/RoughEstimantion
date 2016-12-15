package com.example.krupal.roughestimantion;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

import static android.os.FileObserver.DELETE;
import static com.example.krupal.roughestimantion.DbHelper.TABLE_NAME;


public class MainActivity extends AppCompatActivity {


    EditText carats_edit, rate_edit, amount_edit, rough_edit, florosence_edit, size_edit;
    Button submit_btn, viewrecord_btn,delete;
    Spinner clarity_edit, cut_edit;
    DbHelper SQLITEDATABASE;
    SQLiteDatabase db;
    Intent intent,intent2;
    String total_amt = "0", avg_amt, total_carat = "0";
    String carat_edt1, rate_adt1, amount_edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SQLITEDATABASE = new DbHelper(this);
        submit_btn = (Button) findViewById(R.id.submit_button);
        delete = (Button) findViewById(R.id.delete);
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
    submit_btn.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View view){

            if(rough_edit.length()==0)
            {
                rough_edit.setError("FIELD CANNOT BE EMPTY");
            }
            else if(size_edit.length()==0)
            {
                size_edit.setError("FIELD CANNOT BE EMPTY");
            }
            else if(florosence_edit.length()==0)
            {

                florosence_edit.setError("FIELD CANNOT BE EMPTY");
            }
            else if(carats_edit.length()==0)
            {
                carats_edit.setError("FIELD CANNOT BE EMPTY");
            }
            else if(rate_edit.length()==0)
            {
                rate_edit.setError("FIELD CANNOT BE EMPTY");
            }
            else{

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

                total_carat = String.valueOf(Float.parseFloat(total_carat) + Float.parseFloat(carats_edit.getText().toString()));
                total_amt = String.valueOf(Float.parseFloat(total_amt) + Float.parseFloat(amount_edit.getText().toString()));
                avg_amt = String.valueOf(Float.parseFloat(total_amt) / Float.parseFloat(total_carat));
                Toast.makeText(getApplicationContext(), " total amount " + total_amt + " total carat " + total_carat + " avearage " + avg_amt, Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this, DisplayRoughList.class);
                intent.putExtra("total carat", total_carat);
                intent.putExtra("total amount", total_amt);
                intent.putExtra("avearage", avg_amt);


                intent2 = new Intent(MainActivity.this, ExpenceActivity.class);
                intent2.putExtra("totalavg",avg_amt);
                //startActivity(intent2);
                clear();
                viewrecord_btn.setVisibility(view.VISIBLE);
                delete.setVisibility(view.VISIBLE);
            }

    }

    }

    );
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);

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


//    @Override
//    public void onBackPressed() {
//        AlertDialog alert_back = new AlertDialog.Builder(this).create();
//        alert_back.setTitle("Quit?");
//        alert_back.setMessage("Are you sure want to Quit?");
//
////        alert_back.setButton("No", new DialogInterface.OnClickListener() {
////
////            @Override
////            public void onClick(DialogInterface dialog, int which) {
////                dialog.dismiss();
////            }
////        });
//
//       alert_back.setButton2("Yes", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//               db.execSQL("DELETE FROM rough_count WHERE ID = 1 ");
//                //Log.d("Dtop table","TABLE"+TABLE_NAME);
//                MainActivity.this.finish();
//            }
//        });
//        alert_back.show();
//    }

}








