package com.example.lenovo.hotelmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AssignRoomActivity extends AppCompatActivity {
    int mobileArray[] ={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_room);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        final ArrayList<Integer> list = getIntent().getIntegerArrayListExtra("test");
        ArrayList<String> roomlist = getIntent().getStringArrayListExtra("room");
//        mobileArray = list.toArray();
//
//        ArrayAdapter adapter = new ArrayAdapter(this,
//                R.layout.listiewactivity, mobileArray);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.listiewactivity,roomlist);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getApplicationContext(),RoomBookActivity.class);
                it.putExtra("key",list.get(position));
                startActivity(it);
            }
        });
    }
}
