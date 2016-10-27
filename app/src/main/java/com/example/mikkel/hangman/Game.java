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
    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,y,x,z,æ,ø,å;
    TextView gameText;
    EditText guessText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        logic = new Logic();
        gameText = (TextView) findViewById(R.id.word);
        gameText.setText(logic.getSynligtOrd());
        initButtons();
    }

    private void initButtons() {
        a = (Button) findViewById(R.id.A);
        b = (Button) findViewById(R.id.B);
        c = (Button) findViewById(R.id.C);
        d = (Button) findViewById(R.id.D);
        e = (Button) findViewById(R.id.E);
        f = (Button) findViewById(R.id.F);
        g = (Button) findViewById(R.id.G);
        h = (Button) findViewById(R.id.H);
        j = (Button) findViewById(R.id.J);
        k = (Button) findViewById(R.id.K);
        l = (Button) findViewById(R.id.L);
        m = (Button) findViewById(R.id.M);
        n = (Button) findViewById(R.id.N);
        o = (Button) findViewById(R.id.O);
        p = (Button) findViewById(R.id.P);
        q = (Button) findViewById(R.id.Q);
        r = (Button) findViewById(R.id.R_letter);
        s = (Button) findViewById(R.id.S);
        t = (Button) findViewById(R.id.T);
        u = (Button) findViewById(R.id.U);
        v = (Button) findViewById(R.id.V);
        w = (Button) findViewById(R.id.W);
        y = (Button) findViewById(R.id.Y);
        x = (Button) findViewById(R.id.X);
        z = (Button) findViewById(R.id.Z);
        æ = (Button) findViewById(R.id.Æ);
        ø = (Button) findViewById(R.id.Ø);
        å = (Button) findViewById(R.id.Å);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        q.setOnClickListener(this);
        r.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        v.setOnClickListener(this);
        w.setOnClickListener(this);
        y.setOnClickListener(this);
        x.setOnClickListener(this);
        z.setOnClickListener(this);
        æ.setOnClickListener(this);
        ø.setOnClickListener(this);
        å.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String letter = null;
        if(v == a) {
            letter = "a";
        } else if(v == b) {
            letter = "b";
        } else if(v == c) {
            letter = "c";
        } else if(v == d) {
            letter = "d";
        } else if(v == e) {
            letter = "e";
        } else if(v == f) {
            letter = "f";
        } else if(v == g) {
            letter = "g";
        } else if(v == h) {
            letter = "h";
        } else if(v == i) {
            letter = "i";
        } else if(v == j) {
            letter = "j";
        } else if(v == k) {
            letter = "k";
        } else if(v == l) {
            letter = "l";
        } else if(v == m) {
            letter = "m";
        } else if(v == n) {
            letter = "n";
        } else if(v == o) {
            letter = "o";
        } else if(v == p) {
            letter = "p";
        } else if(v == q) {
            letter = "q";
        } else if(v == r) {
            letter = "r";
        } else if(v == s) {
            letter = "s";
        } else if(v == t) {
            letter = "t";
        } else if(v == u) {
            letter = "u";
        } else if(v == v) {
            letter = "v";
        } else if(v == w) {
            letter = "w";
        } else if(v == y) {
            letter = "y";
        } else if(v == x) {
            letter = "x";
        } else if(v == z) {
            letter = "z";
        } else if(v == æ) {
            letter = "æ";
        } else if(v == ø) {
            letter = "ø";
        } else if(v == å) {
            letter = "å";
        }
        logic.gætBogstav(letter);
        gameText.setText(logic.getSynligtOrd());
    }
}
