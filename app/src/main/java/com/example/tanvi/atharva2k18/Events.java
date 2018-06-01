package com.example.tanvi.atharva2k18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.wenchao.cardstack.CardStack;

public class Events extends AppCompatActivity implements CardStack.CardEventListener {
    private CardStack cardStack;
    private CardAdapter cardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toast.makeText(this,"Slide the images to see more",Toast.LENGTH_LONG).show();
        initImages();
        cardStack=(CardStack)findViewById(R.id.card_stack);
        cardStack.setContentResource(R.layout.card_layout);
        cardStack.setStackMargin(20);
        cardStack.setAdapter(cardAdapter);
        cardStack.setListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Events");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case 101:
                Intent intent = new Intent(Events.this,MainActivity.class);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                return true;
            // break;
        }
        return super.onOptionsItemSelected(item) ;
    }


    private void initImages(){
        cardAdapter=new CardAdapter(getApplicationContext(),0);
        cardAdapter.add(R.drawable.hack);
        cardAdapter.add(R.drawable.gne);
        cardAdapter.add(R.drawable.bridge);
        cardAdapter.add(R.drawable.auto1);
    }

    @Override
    public boolean swipeEnd(int i, float v) {
        return (v>300)?true:false;
    }

    @Override
    public boolean swipeStart(int i, float v) {
        return false;
    }

    @Override
    public boolean swipeContinue(int i, float v, float v1) {
        return false;
    }

    @Override
    public void discarded(int i, int i1) {

    }

    @Override
    public void topCardTapped() {

    }
    public void onPress(View view){
        Intent intent=new Intent(Events.this,Registration.class);
        startActivity(intent);
    }
}
