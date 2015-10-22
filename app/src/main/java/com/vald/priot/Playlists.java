package com.vald.priot;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.net.Inet4Address;

public class Playlists extends AppCompatActivity {

    public void openFrameActivity (View view){
        Intent intent = new Intent (this, FrameActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void process(View view) {

        Intent intent;
        Intent chooser;

        if (view.getId() == R.id.launchMap) {
            intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.8777"));
            startActivity(intent);
        }

        if (view.getId() == R.id.launchMarket) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=dolphin.developers.com"));
            startActivity(intent);
        }

        if (view.getId() == R.id.sendEmail) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"valdemaras.vaitekenas@gmailc.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Yo!");
            intent.putExtra(Intent.EXTRA_TEXT, "Yo, yo, yo!");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Send EeEmail");
            startActivity(chooser);
        }

        if(view.getId() == R.id.openAdapterActivity){
            intent = new Intent(this, AdapterActivity.class);
            startActivity(intent);
        }

        if(view.getId() == R.id.openFragmentActivity){
            intent = new Intent(this, FragmentActivity.class);
            startActivity(intent);
        }

        if(view.getId()==R.id.openRecyclerActivity){
            intent = new Intent(this, RecyclerActivity.class);
            startActivity(intent);
        }
    }

    public void showToast(View view){
        Toast toast = Toast.makeText(this, "Hello, this is toast", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

}
