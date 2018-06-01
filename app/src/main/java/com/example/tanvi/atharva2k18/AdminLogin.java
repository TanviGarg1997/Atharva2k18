package com.example.tanvi.atharva2k18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        user=(EditText)findViewById(R.id.editTextAdminUser);
        pass=(EditText)findViewById(R.id.editTextAdminPass);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Admin Login");
    }
    public void Login(View view){
        String userAdmin=user.getText().toString().trim();
        String passAdmin=pass.getText().toString().trim();
        if(userAdmin.equals("Atharva")&&passAdmin.equals("Atharva")){
            Intent intent=new Intent(this,AdminEventName.class);
            startActivity(intent);
            }
            else{
            Toast.makeText(this,"Check Username or Password",Toast.LENGTH_LONG).show();
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case 101:
                Intent intent = new Intent(AdminLogin.this,MainActivity.class);
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
