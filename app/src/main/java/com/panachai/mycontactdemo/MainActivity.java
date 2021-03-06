package com.panachai.mycontactdemo;

import android.content.Intent;
import android.icu.text.DisplayContext;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        //เป็นการเขียน Event OnClick อีกแบบนึง
        //ใส่ Event เมื่อผู้ใช้เลือกรายชื่อผู้ติดต่อใน listview
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //ส่งค่าผู้ติดต่อที่เลือกไปยังอีก Activity นึง
                Bundle bundle = new Bundle();
                bundle.putInt("id",i+1); //เพื่อให้ index ของ ItemList ตรงกับ listview
                Intent intent = new Intent(getApplicationContext(), DisplayContact.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //-----------------------------
    }
}
