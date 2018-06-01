package com.example.tanvi.atharva2k18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Accomodation extends AppCompatActivity {
Spinner spin;
EditText eName;
EditText eMobile;
EditText eEmail;
EditText eCollege;
EditText eDate;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbAcco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accomodation);
        eName=(EditText)findViewById(R.id.editTextName);
        eMobile=(EditText)findViewById(R.id.editTextMobile);
        eEmail=(EditText)findViewById(R.id.editTextEmail);
        eCollege=(EditText)findViewById(R.id.editTextCollege);
        eDate=(EditText)findViewById(R.id.editTextDates);
        firebaseDatabase=FirebaseDatabase.getInstance();
        dbAcco = FirebaseDatabase.getInstance().getReference("Accomodation");
        ArrayAdapter<String> adapter;
        List<String> list1;
        spin=(Spinner)findViewById(R.id.spinnerGender);
        list1 = new ArrayList<String>();
        list1.add("--Gender--");
        list1.add("Male");
        list1.add("Female");

        adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_layout, list1);
        adapter.setDropDownViewResource( R.layout.spinner_layout);
        spin.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Accomodations");
    }
    public void Next(View view){
        String name=eName.getText().toString().trim();
        String college=eCollege.getText().toString().trim();
        String mobile=eMobile.getText().toString().trim();
        String date=eDate.getText().toString().trim();
        String email=eEmail.getText().toString().trim();
        String id;
        id=dbAcco.push().getKey();
                DetailsAcco details =new DetailsAcco(id,name,college,mobile,email,date);
                dbAcco.child(id).setValue(details);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

            }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case 101:
                Intent intent = new Intent(Accomodation.this,MainActivity.class);
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
