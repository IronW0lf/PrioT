package com.vald.priot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String currentLocation = "Home";
    private RecyclerView recyclerView;
    Button newActivityButton;

    public void openNewActivity(View view){
        Intent intent = new Intent(this, Playlists.class);
        startActivity(intent);
    }

    public void openMap(View view) {
        TextView currentLocationTextView = (TextView) findViewById(R.id.currentLocation_text_view);
        switch (currentLocationTextView.getText().toString()) {
            case "Home":
                currentLocation = "Work";
                break;
            case "Work":
                currentLocation = "Home";
                break;
            default:
                currentLocation = "Home";
                break;
        }
        currentLocationTextView.setText(currentLocation);

//        TextView test = new TextView(this);
//        test.setText("WTF is going on!?");
//        setContentView(test);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        Set Location
        TextView currentLocationTextView = (TextView) findViewById(R.id.currentLocation_text_view);
        currentLocationTextView.setText(currentLocation);

//        Song List Array
        String[] songsArray = {"song1", "song2", "song3", "song4", "song5"};

        ArrayAdapter mSongListAdapter = new ArrayAdapter<>(this,R.layout.list_item_song,songsArray);

        ListView songsList = (ListView) findViewById(R.id.listview_songs);
        songsList.setAdapter(mSongListAdapter);


        newActivityButton = (Button) findViewById(R.id.new_activity_button);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
