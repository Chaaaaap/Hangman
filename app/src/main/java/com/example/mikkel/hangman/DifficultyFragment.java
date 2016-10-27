package com.example.mikkel.hangman;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class DifficultyFragment extends Fragment implements View.OnClickListener {

    private Button btn_easy, btn_med, btn_hard;
    public static String difficulty;

    public DifficultyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_difficulty, container, false);
        return v;
    }

    public void onViewCreated(View v, Bundle savedInstanceState) {
        btn_easy = (Button) v.findViewById(R.id.btn_easy);
        btn_med = (Button) v.findViewById(R.id.btn_medium);
        btn_hard = (Button) v.findViewById(R.id.btn_hard);

        btn_easy.setOnClickListener(this);
        btn_med.setOnClickListener(this);
        btn_hard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_easy) {
            difficulty = "easy";
        } else if(v == btn_med) {
            difficulty = "medium";
        } else if(v == btn_hard) {
            difficulty = "hard";
        }

        Intent i = new Intent(getActivity(), Game.class);
        startActivity(i);
    }
}
