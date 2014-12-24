package net.indjija.skendza.vicnadan;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GlavnaActivity extends ActionBarActivity {

    static private final String TAG = "net.indjija.skendza.vicnadan.GlavnaActivity";

    TextView vicTextview;

    Button dugme;

    private VicServis vicServis;

    private boolean povezan;

    private Ticker ticker;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            VicServis.LocalBinder binder = (VicServis.LocalBinder) service;
            vicServis = binder.getService();
            ticker = new VicTicker(vicServis.getVicevi());
            povezan = true;
            Log.i(TAG, "Uspesno povezan na vic servis.");
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            povezan = false;
            Log.i(TAG, "Diskonektovan sa vic servisa.");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavna);

        vicTextview = (TextView) findViewById(R.id.vicView);

        dugme = (Button) findViewById(R.id.dugme);
        dugme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(ticker != null)
                    vicTextview.setText(ticker.tick());
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Intent intent = new Intent(this, VicServis.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        if(povezan)
        {
            unbindService(serviceConnection);
            povezan = false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_glavna, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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
