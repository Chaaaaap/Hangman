package com.example.mikkel.hangman;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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
    String something;
    ListView listView;
    ImageView image;
    ArrayList<String> usedLetters = new ArrayList<String>();
    SharedPreferences score;
    SharedPreferences.Editor edit;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        logic = new Logic();





        score = getSharedPreferences("score", Context.MODE_PRIVATE);
        edit = score.edit();
        new GetWordsAsyncTask().execute();



        gameText = (TextView) findViewById(R.id.word);
        image = (ImageView) findViewById(R.id.galge);
    }

//    private void initScore() {
//        if (score.getInt("score", 0) == 0) {
//            score.edit().putInt("wins", score.getInt("wins", 0)+1);
//
//        }
//    }
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

    private String chooseWord() {
        if(DifficultyFragment.difficulty.equals("multi")) {
            listView = (ListView) findViewById(R.id.listView);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, logic.getMuligeOrd());
            listView.setAdapter(adapter);
            listView.setVisibility(View.VISIBLE);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String word = listView.getItemAtPosition(i).toString();
                    logic.setOrdet(word);
                    listView.setVisibility(View.GONE);
                    System.out.println(logic.getOrdet());
                    initButtons();
                    gameText.setText(logic.getSynligtOrd());
                    logic.opdaterSynligtOrd();
                }
            });
        } else {
            listView.setVisibility(View.GONE);
        }
        return logic.getOrdet();
    }

    @Override
    public void onClick(View v) {
        String letter;
        letter =  ((Button)v).getText().toString();
        letter = letter.toLowerCase();
        v.setVisibility(View.INVISIBLE);

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
            edit.putInt("losses", score.getInt("losses", 0)+1);
            edit.commit();
            AlertDialog.Builder dialog = new AlertDialog.Builder(Game.this);
            dialog.setTitle("Defeat!");
            String txt = "You lose!\nYou have now lost "+score.getInt("losses", 0)+" times.";
            CharSequence positive = "Sad panda :(";
            dialog.setMessage(txt).setPositiveButton(positive, this);
            dialog.show();

        } else if(logic.erSpilletVundet()) {
            Context ctx = getApplicationContext();
            edit.putInt("wins", score.getInt("wins", 0)+1);
            edit.commit();
            AlertDialog.Builder dialog = new AlertDialog.Builder(Game.this);
            dialog.setTitle("Victory!");
            CharSequence positive = "Cool!";
            dialog.setMessage("Congratulations! You won!\nYou have now won "+score.getInt("wins", 0)+" times.").setPositiveButton(positive, this);
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
            if(DifficultyFragment.difficulty.equals("multi")) {
                chooseWord();
            }

        }
    }
}
