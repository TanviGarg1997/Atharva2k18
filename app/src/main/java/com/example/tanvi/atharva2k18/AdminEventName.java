package com.example.tanvi.atharva2k18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AdminEventName extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_event_name);
        getSupportActionBar().setTitle("Event Names ");
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(this,"Select a particular event",Toast.LENGTH_LONG).show();
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adapter.add("Hackathon"); //0
        adapter.add("Gne Pitchers");
        adapter.add("Face It");
        adapter.add("Bridge Modelling");
        adapter.add("Auto Spark"); //n-1
        adapter.add("Accomodation");
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String Employee = adapter.getItem(i);
        Intent intent1 = new Intent(AdminEventName.this,EventParticipants.class);
        intent1.putExtra("keySong",Employee);
        startActivity(intent1);
    }
}
