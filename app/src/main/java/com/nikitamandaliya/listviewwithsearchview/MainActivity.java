package com.nikitamandaliya.listviewwithsearchview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

//https://devofandroid.blogspot.com/2018/03/custom-listview-with-searchview-on.html
//http://eazyprogramming.blogspot.com/2013/01/passing-image-between-activities.html
public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    //listvw2
    ListView listView2;
    ListViewAdapter2 adapter2;
    String[] title2;
    String[] description2;
    int[] icon2;
    ArrayList<Model> arrayList2 = new ArrayList<Model>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Item List");

        title = new String[]{"Battery","Cpu","Display"};
        description = new String[]{"Battery Details....","Cpu Details....","Display Details...."};
        icon = new int[]{R.drawable.babyclothing,R.drawable.camera,R.drawable.dress};

        title2 = new String[]{"Battery2","Cpu2"};
        description2 = new String[]{"2Battery Details....","2Cpu Details...."};
        icon2 = new int[]{R.drawable.babyclothing,R.drawable.camera};


        listView = findViewById(R.id.listView);
        listView2 = findViewById(R.id.listView2);

        for (int i=0; i<title.length; i++){
            Model model = new Model(title[i], description[i],icon[i]);
                //bind all the string in array
                arrayList.add(model);
            }

        for (int i=0; i<title2.length; i++){
            Model model = new Model(title2[i], description2[i],icon2[i]);
            //bind all the string in array
            arrayList2.add(model);
        }

        //pass results into listview Adapter class
        adapter = new ListViewAdapter(this,arrayList);

        adapter2 = new ListViewAdapter2(this,arrayList2);

        //bind the adapter to the listview
        listView.setAdapter(adapter);

        listView2.setAdapter(adapter2);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    adapter2.filter("");
                    listView.clearTextFilter();
                    listView2.clearTextFilter();
                }
                else{
                    adapter.filter(s);
                    adapter2.filter(s);
                }
                return true;
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.action_settings){
            // do your functionality here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
