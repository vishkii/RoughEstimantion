package com.example.krupal.roughestimantion;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayRoughList extends AppCompatActivity {


    private Cursor cursor;
    private final String db_name = "rough.db";
    private final String table_name = "rough_count";
    TextView totalamount, totalavg, totalcarats;
    ListView listView;
    ArrayList<RoughModal> r = new ArrayList<RoughModal>();
      SQLiteDatabase sample = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rough_list);
        totalamount = (TextView) findViewById(R.id.amount_textView);
        totalavg = (TextView) findViewById(R.id.avg_textView);
        totalcarats = (TextView) findViewById(R.id.carat_textView);
        listView = (ListView) findViewById(R.id.display_listview);
        try {
            sample = this.openOrCreateDatabase(db_name, MODE_PRIVATE, null);
            cursor = sample.rawQuery("SELECT * FROM rough_count", null);
            Log.d("cursor", "query" + cursor);
            if (cursor != null) {
                if (cursor.moveToFirst())
                    do {
                        RoughModal rm = new RoughModal();
                        rm.setNAME(cursor.getString(1));
                        rm.setCLARITY(cursor.getString(2));
                        rm.setSIZE(cursor.getString(3));
                        rm.setFLOROSENCE(cursor.getString(4));
                        rm.setCUT(cursor.getString(5));
                        rm.setCARATS(cursor.getString(6));
                        rm.setRATE(cursor.getString(7));
                        rm.setAMOUNT(cursor.getString(8));
                        r.add(rm);
                    } while (cursor.moveToNext());
            }
            Log.e("Database", "Total Records:" + cursor.getCount());
            ShowRoughAdapter adapter = new ShowRoughAdapter(this, r);
            listView.setAdapter(adapter);
        } catch (SQLiteException s) {
        }
        Intent intent = getIntent();
        String total_carat = intent.getStringExtra("total carat");
        String total_amt = intent.getStringExtra("total amount");
        String avg_amt = intent.getStringExtra("avearage");
        totalamount.setText(total_amt);
        totalcarats.setText(total_carat);
        totalavg.setText(avg_amt);
        Log.d("total_carat", total_carat);
        Log.i("total_amt", total_amt);
        Log.i("total_avg", avg_amt);
    }
}
