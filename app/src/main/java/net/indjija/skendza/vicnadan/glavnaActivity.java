package net.indjija.skendza.vicnadan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class glavnaActivity extends ActionBarActivity {

    TextView vicTextview;
    Button dugme;
    int brojKlikova = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavna);

        ArrayList<Vic> nekiVicevi = zbirkaViceva.JSONZbirkaViceva();
        final vicBot Botinjo = new vicBot(nekiVicevi);

        vicTextview = (TextView) findViewById(R.id.vicView);

        dugme = (Button) findViewById(R.id.dugme);
        dugme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (brojKlikova % 2 != 0)
                {
                    Botinjo.izaberiVic();
                    vicTextview.setText(Botinjo.pitanje);
                }else
                {
                    vicTextview.setText(Botinjo.odgovor);

                }

                brojKlikova++;
            }
        });


    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_glavna, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
