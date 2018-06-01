package com.example.tanvi.atharva2k18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class EventParticipants extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbHackathon,dbGne,dbBridge,dbFaceIt,dbAutoSpark,dbAcco;
    private ListView listView;
    private ArrayList<String> sUser =new ArrayList<>();
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_participants);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent rcv = getIntent();
        String Employee = rcv.getStringExtra("keySong");
        dbHackathon = FirebaseDatabase.getInstance().getReference("Hackathon");
        dbGne = FirebaseDatabase.getInstance().getReference("Gne Pitchers");
        dbBridge = FirebaseDatabase.getInstance().getReference("Bridge Modelling");
        dbFaceIt = FirebaseDatabase.getInstance().getReference("Face It");
        dbAutoSpark = FirebaseDatabase.getInstance().getReference("AutoSpark");
        dbAcco = FirebaseDatabase.getInstance().getReference("Accomodation");
        firebaseDatabase= FirebaseDatabase.getInstance();
        listView=(ListView)findViewById(R.id.listPaticipants);


        final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sUser);
        listView.setAdapter(mAdapter);
        // listView.setOnClickListener((View.OnClickListener) this);
        if (Employee.equals("Hackathon")) {
            dbHackathon.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name=dataSnapshot.child("name");
                    user=name.getValue().toString().trim();
                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("Hackathon");

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        } else if (Employee.equals("Autospark")) {
            dbAutoSpark.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name=dataSnapshot.child("name");
                    user=name.getValue().toString().trim();

                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("AutoSpark");


                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        } else if (Employee.equals("Bridge Modelling")) {
            dbBridge.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name=dataSnapshot.child("name");
                    user=name.getValue().toString().trim();

                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("Bridge Modelling");

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        } else if (Employee.equals("Gne Pitchers")) {
            dbGne.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name=dataSnapshot.child("name");
                    user=name.getValue().toString().trim();

                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("Gne Pitchers");

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        } else if (Employee.equals("Accomodation")) {
            dbAcco.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name = dataSnapshot.child("name");
                    user = name.getValue().toString().trim();
                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("Face It");


                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if (Employee.equals("Face It")) {
            dbFaceIt.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name=dataSnapshot.child("name");
                    user=name.getValue().toString().trim();

                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("Face It");


                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,101,0,"Sign Out");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case 101:
                Intent intent = new Intent(EventParticipants.this,MainActivity.class);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                return true;
            // break;
        }
        return super.onOptionsItemSelected(item) ;
    }
}
