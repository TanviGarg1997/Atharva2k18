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

public class Registration extends AppCompatActivity {
Spinner spin,spin1;
    EditText eName;
    EditText eMobile;
    EditText eEmail;
    EditText eUser;
    EditText eCollege;
   // EditText eDate;
    EditText ePass;
    EditText eRePass;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbHackathon,dbGne,dbBridge,dbFaceIt,dbAutoSpark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        eName=(EditText)findViewById(R.id.editTextName);
        eMobile=(EditText)findViewById(R.id.editTextMobile);
        eEmail=(EditText)findViewById(R.id.editTextEmail);
        eCollege=(EditText)findViewById(R.id.editTextCollege);
     //   eDate=(EditText)findViewById(R.id.editTextDates);
        eUser=(EditText)findViewById(R.id.editTextUser);
        ePass=(EditText)findViewById(R.id.editTextPass);
        eRePass=(EditText)findViewById(R.id.editTextRePass);
        dbHackathon = FirebaseDatabase.getInstance().getReference("Hackathon");
        dbGne = FirebaseDatabase.getInstance().getReference("Gne Pitchers");
        dbBridge = FirebaseDatabase.getInstance().getReference("Bridge Modelling");
        dbFaceIt = FirebaseDatabase.getInstance().getReference("Face It");
        dbAutoSpark = FirebaseDatabase.getInstance().getReference("AutoSpark");
        firebaseDatabase= FirebaseDatabase.getInstance();
        ArrayAdapter<String> adapter,adapter1;
        List<String> list1,list2;
        spin=(Spinner)findViewById(R.id.spinnerGender);
        spin1=(Spinner)findViewById(R.id.spinnerEvent);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();
        list1.add("--Gender--");
        list1.add("Male");
        list1.add("Female");

        list2.add("--Choose Event--");
        list2.add("Hackathon");
        list2.add("Gne Pitchers");
        list2.add("Autospark");
        list2.add("Bridge Modelling");
        list2.add("Face It");
        adapter1 = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_layout, list1);
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_layout, list2);
        adapter.setDropDownViewResource( R.layout.spinner_layout);
        adapter1.setDropDownViewResource( R.layout.spinner_layout);
        spin.setAdapter(adapter1);
        spin1.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Registrations");
    }
    public void Submit(View view){
        String name=eName.getText().toString().trim();
        String college=eCollege.getText().toString().trim();
        String mobile=eMobile.getText().toString().trim();
     //   String date=eDate.getText().toString().trim();
        String email=eEmail.getText().toString().trim();
        String user=eUser.getText().toString().trim();
        String pass=ePass.getText().toString().trim();
        String rePass=eRePass.getText().toString().trim();
        String meet= spin1.getSelectedItem().toString().trim();
        String id;
        if((TextUtils.isEmpty(name))&&(TextUtils.isEmpty(pass))&&(TextUtils.isEmpty(email))){
            Toast.makeText(this,"Enter all the data",Toast.LENGTH_LONG).show();
        }
       else if((TextUtils.isEmpty(name))&&(TextUtils.isEmpty(pass))&&(TextUtils.isEmpty(email))&&(mobile.length()!=10)){
            Toast.makeText(this,"Enter valid credentials",Toast.LENGTH_LONG).show();
        }
        else if(pass.equals(rePass) && (mobile.length()==10) &&(!TextUtils.isEmpty(name)) && (!TextUtils.isEmpty(pass))) {
            if(meet.equals("Gne Pitchers")){
                id=dbGne.push().getKey();
                DetailsRegister details =new DetailsRegister(id, name,email,user,pass,college, mobile);
                dbGne.child(id).setValue(details);
                Toast.makeText(this, "Thank you for Registration", Toast.LENGTH_LONG).show();

            }
            else if(meet.equals("Hackathon")){
                id=dbHackathon.push().getKey();
                DetailsRegister details =new DetailsRegister(id, name,email,user,pass,college, mobile);
                dbHackathon.child(id).setValue(details);
                Toast.makeText(this, "Thank you for Registration", Toast.LENGTH_LONG).show();

            }
            else if(meet.equals("Face It")){
                id=dbFaceIt.push().getKey();
                DetailsRegister details =new DetailsRegister(id, name,email,user,pass,college, mobile);
                dbFaceIt.child(id).setValue(details);
                Toast.makeText(this, "Thank you for Registration", Toast.LENGTH_LONG).show();
            }
            else if(meet.equals("Autospark")){
                id=dbAutoSpark.push().getKey();
                DetailsRegister details =new DetailsRegister(id, name,email,user,pass,college, mobile);
                dbAutoSpark.child(id).setValue(details);
                Toast.makeText(this, "Thank you for Registration", Toast.LENGTH_LONG).show();
            }
            else if(meet.equals("Bridge Modelling")){
                id=dbBridge.push().getKey();
                DetailsRegister details =new DetailsRegister(id, name,email,user,pass,college, mobile);
                dbBridge.child(id).setValue(details);
                Toast.makeText(this, "Thank you for Registration", Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Some fields are missing", Toast.LENGTH_LONG).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case 101:
                Intent intent = new Intent(Registration.this,MainActivity.class);
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
