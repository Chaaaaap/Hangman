package com.example.mikkel.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Guide extends AppCompatActivity implements View.OnClickListener{

    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
