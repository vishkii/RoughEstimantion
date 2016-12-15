package com.example.krupal.roughestimantion;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.ViewDragHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Krupal on 12/3/2016.
 */

public class ShowRoughAdapter extends BaseAdapter {

    List<RoughModal> listrough;
    Activity a;
    public ShowRoughAdapter(Activity a, List<RoughModal> listrough){
        this.a = a;
        this.listrough = listrough;
    }
    @Override
    public int getCount() {
        return listrough.size();
    }
    @Override
    public Object getItem(int i) {
        return String.valueOf(listrough.get(i));
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    public static class ViewHolder {
        public TextView txtName,txtclarity,txtsize,txtflorosence,txtcut,txtcarat,txtrate,txtamount;
    }
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder view;
        LayoutInflater inflater = a.getLayoutInflater();
        if(convertView == null){
            view = new ViewHolder();
            convertView = inflater.inflate(R.layout.rough_listview, null);
            view.txtName = (TextView) convertView.findViewById(R.id.roughlist_Textview);
            view.txtclarity = (TextView) convertView.findViewById(R.id.roughclarity_Textview);
            view.txtsize = (TextView) convertView.findViewById(R.id.sizelist_Textview);
            view.txtflorosence = (TextView) convertView.findViewById(R.id.florosancelist_Textview);
            view.txtcut = (TextView) convertView.findViewById(R.id.cutlist_Textview);
            view.txtcarat = (TextView) convertView.findViewById(R.id.caratlist_Textview);
            view.txtrate = (TextView) convertView.findViewById(R.id.ratelist_Textview);
            view.txtamount = (TextView) convertView.findViewById(R.id.amountlist_Textview);
            convertView.setTag(view);
        }else {
                view = (ViewHolder) convertView.getTag();
        }
        view.txtName.setText("Rough : "+listrough.get(i).getNAME());
        view.txtclarity.setText("Clarity : "+listrough.get(i).getCLARITY());
        view.txtsize.setText("Size : "+listrough.get(i).getSIZE());
        view.txtflorosence.setText("Florosence : "+ listrough.get(i).getFLOROSENCE());
        view.txtcut.setText("Cut : "+listrough.get(i).getCUT());
        view.txtcarat.setText("Carat : "+listrough.get(i).getCARATS());
        view.txtrate.setText("Rate : "+listrough.get(i).getRATE());
        view.txtamount.setText("Amount : "+listrough.get(i).getAMOUNT());
        return convertView;
    }
}

