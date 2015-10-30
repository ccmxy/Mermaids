package com.example.colleenminor.theadventure.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.colleenminor.theadventure.R;
import com.example.colleenminor.theadventure.models.Item;

import java.util.ArrayList;
import java.util.List;

public class GiveActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private ArrayList<Item> mItems;
    private ArrayList<String> mItemsString;
    private ListView lv;
    // private ItemAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        mPreferences = getApplicationContext().getSharedPreferences("TheAdventure", Context.MODE_PRIVATE);
        String username = mPreferences.getString("username", null);
        mItems = (ArrayList) Item.all();

        lv = (ListView) findViewById(R.id.list);

        List<String> itemStringList = new ArrayList<String>();
        for(int i = 0; i < mItems.size(); i++){
            Item item = mItems.get(i);
            String itemName = item.getItem();
                itemStringList.add(item.getItem());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                itemStringList);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String theItem = (String) arg0.getItemAtPosition(position);
                if(!(theItem.equals("water"))){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "No, no the " + (String) arg0.getItemAtPosition(position) + "!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if(theItem.equals("water")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ah, that's better! Thanks for the " + (String) arg0.getItemAtPosition(position) + "!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }


        });
    }


}
