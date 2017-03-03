package com.panachai.mycontactdemo;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    ListView lvContact;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHelper(this);
        lvContact = (ListView) findViewById(R.id.listView1);

        mydb.insertContact("panachai","pan@gmail.com","0905607225");
        mydb.insertContact("niyom","ss@gmail.com","0905607200");
        //สร้าง ArrayList
        ArrayList arrayList = mydb.getAllContact();
        ArrayAdapter arrayAdapter = new
                ArrayAdapter(this,
                android.R.layout.simple_list_item_1,arrayList);
        lvContact.setAdapter(arrayAdapter);
        //-----------------------------
    }
}
