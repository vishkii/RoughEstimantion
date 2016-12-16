package com.example.krupal.roughestimantion;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayRoughList extends AppCompatActivity {

    private ArrayList<String> m_parts = new ArrayList<>();

    TextView totalamount, totalavg, totalcarats,finalavg;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rough_list);
        totalamount = (TextView) findViewById(R.id.amount_textView);
        totalavg = (TextView) findViewById(R.id.avg_textView);
        totalcarats = (TextView) findViewById(R.id.carat_textView);
        listView = (ListView) findViewById(R.id.display_listview);
        finalavg = (TextView)findViewById(R.id.finalavg_textview);



        //ArrayList ar1=getIntent().getExtras().getStringArrayList("arrayList");
        ShowRoughAdapter arrayAdapter =
                new ShowRoughAdapter(this,R.layout.rough_listview, m_parts);
        listView.setAdapter(arrayAdapter);

        Intent intent = getIntent();
        String total_amt = intent.getStringExtra("total amount");
        String total_carat = intent.getStringExtra("total carat");
        String avg_amt = intent.getStringExtra("totalavg");


        totalamount.setText(total_amt);
        totalcarats.setText(total_carat);
        totalavg.setText(avg_amt);


        Intent intent1 = getIntent();
        String avg1 = intent1.getStringExtra("avegrage");
        finalavg.setText(avg1);



    }
}
