package com.vald.priot;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
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

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerAdapter = new RecyclerAdapter(this, getData());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public static List<RecyclerItem> getData(){
        List<RecyclerItem> data = new ArrayList<>();
        int[] icons={R.drawable.tiger,R.drawable.img1,R.drawable.img2,R.drawable.tiger,R.drawable.img1};
        String[] titles = {"How", "Difficult", "Can", "This", "Be"};
        for(int i=0;i<100;i++){
            RecyclerItem current = new RecyclerItem();
            current.iconId=icons[i%icons.length];
            current.title=titles[i%titles.length];
            data.add(current);
        }
        return data;
    }

}
