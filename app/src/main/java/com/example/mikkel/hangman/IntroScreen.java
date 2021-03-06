package com.example.mikkel.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntroScreen extends AppCompatActivity implements View.OnClickListener{

    Button btn_play;
    Button btn_guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        btn_guide = (Button) findViewById(R.id.btn_guide);
        btn_play = (Button) findViewById(R.id.btn_play);

        btn_play.setOnClickListener(this);
        btn_guide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_play) {
            DifficultyFragment.difficulty = "";
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new DifficultyFragment());
            ft.commit();
//            Intent i = new Intent(IntroScreen.this, Game.class);
//            startActivity(i);
        } else if (v == btn_guide) {
            Intent i = new Intent(IntroScreen.this, Guide.class);
            startActivity(i);
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().findFragmentById(R.id.fragment_container).isVisible()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        ft.commit();
    } else {
            finish();
        }
    }
}
