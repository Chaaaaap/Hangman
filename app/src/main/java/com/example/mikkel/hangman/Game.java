package com.example.mikkel.hangman;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Game extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    Logic logic;
    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u, V,w,y,x,z,æ,ø,å;
    TextView gameText;
    EditText guessText;
    String something;
    ImageView image;
    ArrayList<String> usedLetters = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        new GetWordsAsyncTask().execute();
//        logic = new Logic();
        gameText = (TextView) findViewById(R.id.word);
//        gameText.setText(logic.getSynligtOrd());
        image = (ImageView) findViewById(R.id.galge);
//        initButtons();
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
        i = (Button) findViewById(R.id.I);
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
        V = (Button) findViewById(R.id.V);
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
        V.setOnClickListener(this);
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
            a.setVisibility(View.INVISIBLE);
        } else if(v == b) {
            letter = "b";
            b.setVisibility(View.INVISIBLE);
        } else if(v == c) {
            letter = "c";
            c.setVisibility(View.INVISIBLE);
        } else if(v == d) {
            letter = "d";
            d.setVisibility(View.INVISIBLE);
        } else if(v == e) {
            letter = "e";
            e.setVisibility(View.INVISIBLE);
        } else if(v == f) {
            letter = "f";
            f.setVisibility(View.INVISIBLE);
        } else if(v == g) {
            letter = "g";
            g.setVisibility(View.INVISIBLE);
        } else if(v == h) {
            letter = "h";
            h.setVisibility(View.INVISIBLE);
        } else if(v == i) {
            letter = "i";
            i.setVisibility(View.INVISIBLE);
        } else if(v == j) {
            letter = "j";
            j.setVisibility(View.INVISIBLE);
        } else if(v == k) {
            letter = "k";
            k.setVisibility(View.INVISIBLE);
        } else if(v == l) {
            letter = "l";
            l.setVisibility(View.INVISIBLE);
        } else if(v == m) {
            letter = "m";
            m.setVisibility(View.INVISIBLE);
        } else if(v == n) {
            letter = "n";
            n.setVisibility(View.INVISIBLE);
        } else if(v == o) {
            letter = "o";
            o.setVisibility(View.INVISIBLE);
        } else if(v == p) {
            letter = "p";
            p.setVisibility(View.INVISIBLE);
        } else if(v == q) {
            letter = "q";
            q.setVisibility(View.INVISIBLE);
        } else if(v == r) {
            letter = "r";
            r.setVisibility(View.INVISIBLE);
        } else if(v == s) {
            letter = "s";
            s.setVisibility(View.INVISIBLE);
        } else if(v == t) {
            letter = "t";
            t.setVisibility(View.INVISIBLE);
        } else if(v == u) {
            letter = "u";
            u.setVisibility(View.INVISIBLE);
        } else if(v == V) {
            letter = "v";
            v.setVisibility(View.INVISIBLE);
        } else if(v == w) {
            letter = "w";
            w.setVisibility(View.INVISIBLE);
        } else if(v == y) {
            letter = "y";
            y.setVisibility(View.INVISIBLE);
        } else if(v == x) {
            letter = "x";
            x.setVisibility(View.INVISIBLE);
        } else if(v == z) {
            letter = "z";
            z.setVisibility(View.INVISIBLE);
        } else if(v == æ) {
            letter = "æ";
            æ.setVisibility(View.INVISIBLE);
        } else if(v == ø) {
            letter = "ø";
            ø.setVisibility(View.INVISIBLE);
        } else if(v == å) {
            letter = "å";
            å.setVisibility(View.INVISIBLE);
        }
        logic.gætBogstav(letter);
        if(logic.erSidsteBogstavKorrekt() != true) {
            Context ctx = getApplicationContext();
            CharSequence txt = "You guessed wrong!";
            int dur = Toast.LENGTH_SHORT;
            Toast msg = Toast.makeText(ctx,txt,dur);
            msg.show();
        }
        usedLetters = logic.getBrugteBogstaver();
        something = "Guess the word: " + logic.getSynligtOrd()+"\nUsed letters: ";
        for(String stuff : usedLetters) {
            something += " "+stuff+", ";
        }
        gameText.setText(something);

        if(logic.getAntalForkerteBogstaver() >= 6) {
            Context ctx = getApplicationContext();
            AlertDialog.Builder dialog = new AlertDialog.Builder(Game.this);
            dialog.setTitle("Defeat!");
            String txt = "You lose!";
            CharSequence positive = "Sad panda :(";
            dialog.setMessage(txt).setPositiveButton(positive, this);
            dialog.show();
        } else if(logic.erSpilletVundet()) {
            Context ctx = getApplicationContext();
            AlertDialog.Builder dialog = new AlertDialog.Builder(Game.this);
            dialog.setTitle("Victory!");
            CharSequence positive = "Cool!";
            dialog.setMessage("Congratulations, you win!").setPositiveButton(positive, this);
            dialog.show();
        }

        if(logic.getAntalForkerteBogstaver() == 1) {
            image.setImageResource(R.drawable.forkert1);
        } else if(logic.getAntalForkerteBogstaver() == 2) {
            image.setImageResource(R.drawable.forkert2);
        } else if(logic.getAntalForkerteBogstaver() == 3) {
            image.setImageResource(R.drawable.forkert3);
        } else if(logic.getAntalForkerteBogstaver() == 4) {
            image.setImageResource(R.drawable.forkert4);
        } else if(logic.getAntalForkerteBogstaver() == 5) {
            image.setImageResource(R.drawable.forkert5);
        } else if(logic.getAntalForkerteBogstaver() == 6) {
            image.setImageResource(R.drawable.forkert6);
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        finish();
    }

    private class GetWordsAsyncTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... params) {

            logic = new Logic();
            ArrayList<String> list = new ArrayList<>();
            try {
                String data = logic.hentUrl("http://dr.dk");
                data = data.replaceAll("<.+?>", " ").toLowerCase().replaceAll("[^a-zæøå]", " ");


                list.addAll(new HashSet<String>(Arrays.asList(data.split(" "))));
            } catch(IOException e) {
                e.printStackTrace();
            }
            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<String> list) {
            System.out.println(list);
            logic.setMuligeOrd(list);
            logic.nulstil();
            System.out.println(logic.getOrdet());
            initButtons();
            gameText.setText(logic.getSynligtOrd());
        }
    }
}
