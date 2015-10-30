package com.vald.priot;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FragmentCommunicationActivity extends AppCompatActivity implements Communicator{

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);
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

        CommunicationFragment_1 fragment_1 = new CommunicationFragment_1();
        CommunicationFragment_2 fragment_2 = new CommunicationFragment_2();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_communication_xml, fragment_1, "fragment_1");
        fragmentTransaction.add(R.id.fragment_communication_xml, fragment_2, "fragment_2");
        fragmentTransaction.commit();

    }

    @Override
    public void respond(String data) {
        CommunicationFragment_2 fragment_2 = (CommunicationFragment_2) fragmentManager.findFragmentByTag("fragment_2");
        fragment_2.changeText(data);
    }
}
