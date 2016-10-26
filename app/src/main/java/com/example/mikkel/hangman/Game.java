package com.example.mikkel.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Game extends AppCompatActivity implements View.OnClickListener{

    Logic logic;
    Button btn_guess;
    TextView gameText;
    EditText guessText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        logic = new Logic();
        gameText = (TextView) findViewById(R.id.gameText);
        guessText = (EditText) findViewById(R.id.guess);
        btn_guess = (Button) findViewById(R.id.btn_guess);
        gameText.setText(logic.getSynligtOrd());
    }

    @Override
    public void onClick(View v) {
        if(v == btn_guess) {
            String guess = guessText.getText().toString();
            if(guess.length() == 1) {
                logic.gætBogstav(guess);
                gameText.setText(logic.getSynligtOrd());
            } else {

            }
        }
    }
}
