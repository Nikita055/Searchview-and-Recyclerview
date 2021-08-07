package com.nikitamandaliya.listviewwithsearchview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter2 extends BaseAdapter {
    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    public ListViewAdapter2(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    //inner  class
    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ListViewAdapter2.ViewHolder holder;
        if (view == null){
            holder = new ListViewAdapter2.ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDescription);
            holder.mIconIv = view.findViewById(R.id.mainicon);

            view.setTag(holder);
        }
        else{
            holder = (ListViewAdapter2.ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(position).getTitle());
        holder.mDescTv.setText(modellist.get(position).getDesc());
        //set the result into textview
        holder.mIconIv.setImageResource(modellist.get(position).getIcon());

        //listview item click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "click", Toast.LENGTH_SHORT).show();
                if (modellist.get(position).getTitle().equals("Battery")){
                    //start NewActivity with title for actionbar and text for textview
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(mContext, NewActivity2.class);
                    intent.putExtra("actionBarTitle","Battery");
                    intent.putExtra("contentTv","This is Battety details");
                    bundle.putInt("image",R.drawable.babyclothing);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getTitle().equals("Cpu")){
                    //start NewActivity with title for actionbar and text for textview
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(mContext, NewActivity2.class);
                    intent.putExtra("actionBarTitle","Cpu");
                    intent.putExtra("contentTv","This is Cpu details");
                    bundle.putInt("image",R.drawable.camera);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getTitle().equals("Display")){
                    //start NewActivity with title for actionbar and text for textview
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(mContext, NewActivity2.class);
                    intent.putExtra("actionBarTitle","Display");
                    intent.putExtra("contentTv","This is Display details");
                    bundle.putInt("image",R.drawable.dress);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getTitle().equals("Memory")){
                    //start NewActivity with title for actionbar and text for textview
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(mContext, NewActivity2.class);
                    intent.putExtra("actionBarTitle","Memory");
                    intent.putExtra("contentTv","This is Memory details");
                    bundle.putInt("image",R.drawable.camera);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getTitle().equals("Sensor")){
                    //start NewActivity with title for actionbar and text for textview
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(mContext, NewActivity2.class);
                    intent.putExtra("actionBarTitle","sensor");
                    intent.putExtra("contentTv","This is sensor details");
                    bundle.putInt("image",R.drawable.camera);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }

            }
        });
        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length() == 0){
            modellist.addAll(arrayList);
        }
        else{
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault()).contains(charText)){
                    modellist.add(model);
                }
            }
        }

        notifyDataSetChanged();
    }
}

