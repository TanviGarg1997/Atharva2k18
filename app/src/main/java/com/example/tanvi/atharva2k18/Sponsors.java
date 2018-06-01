package com.example.tanvi.atharva2k18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Sponsors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sponsors);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sponsors");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case 101:
                Intent intent = new Intent(Sponsors.this,MainActivity.class);
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

