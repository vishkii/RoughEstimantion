package com.example.krupal.roughestimantion;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krupal on 12/3/2016.
 */

public class ShowRoughAdapter extends ArrayAdapter<String> {


    List<String> listrough = null;
    Activity a;
    Context context;


    public ShowRoughAdapter(Context context, int resource, List<String> objects) {

        super(context, resource, objects);

        this.context = context;
        this.listrough = objects;
    }

    /*public ShowRoughAdapter(Activity a, int rough_listview, List<String> listrough){
        this.a = a;
        this.listrough = listrough;
    }*/
    @Override
    public int getCount() {
        return listrough.size();
    }
  /*  @Override
    public Object getItem(int i) {
        return String.valueOf(listrough.get(i));
    }*/

    @Nullable
    @Override
    public String getItem(int position) {
        return listrough.get(position);
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
      /*  view.txtName.setText("Rough : "+listrough.get(i).getNAME());
        view.txtclarity.setText("Clarity : "+listrough.get(i).getCLARITY());
        view.txtsize.setText("Size : "+listrough.get(i).getSIZE());
        view.txtflorosence.setText("Florosence : "+ listrough.get(i).getFLOROSENCE());
        view.txtcut.setText("Cut : "+listrough.get(i).getCUT());
        view.txtcarat.setText("Carat : "+listrough.get(i).getCARATS());
        view.txtrate.setText("Rate : "+listrough.get(i).getRATE());
        view.txtamount.setText("Amount : "+listrough.get(i).getAMOUNT());*/
         view.txtName.setText("Rough : "+listrough.get(0));
        view.txtclarity.setText("Clarity : "+listrough.get(1));
        view.txtsize.setText("Size : "+listrough.get(2));
        view.txtflorosence.setText("Florosence : "+ listrough.get(3));
        view.txtcut.setText("Cut : "+listrough.get(4));
        view.txtcarat.setText("Carat : "+listrough.get(5));
        view.txtrate.setText("Rate : "+listrough.get(6));
        view.txtamount.setText("Amount : "+listrough.get(7));

        return convertView;
    }
}

