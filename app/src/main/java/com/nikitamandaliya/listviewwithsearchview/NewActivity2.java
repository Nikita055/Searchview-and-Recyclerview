package com.nikitamandaliya.listviewwithsearchview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);

        ActionBar actionBar = getSupportActionBar();
        TextView mDetailTv = findViewById(R.id.textView2);
        ImageView img = findViewById(R.id.img);

        //get data from previous activity when item of listview is clicked using intent
        Intent intent = getIntent();
        String mActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mContent = intent.getStringExtra("contentTv");
        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");

        //set actionbar title
        actionBar.setTitle(mActionBarTitle);
        //set text in textview
        mDetailTv.setText(mContent);
        img.setImageResource(pic);

    }
}