package com.vald.priot;

import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MediaPlaybackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_playback);
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

    public void playMusic(View view) throws IOException {
        Uri MyUri = Uri.parse("storage/emulated/0/Samsung/Music/Over_the_horizon.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDataSource(getApplicationContext(), MyUri);
        mediaPlayer.prepare();
        mediaPlayer.start();


//        String data = MediaStore.Audio.Media._ID;
//        TextView textView = (TextView) findViewById(R.id.music_data);
//        textView.setText(data);

        /////////////////////////////////////////////////////

//        ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
//        String[] STAR = {"*"};
//
//        Cursor cursor;
//        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
//        cursor = managedQuery(uri, STAR, selection, null, null);
//
//        if (cursor != null) {
//            if (cursor.moveToFirst()) {
//                do {
//                    String songName = cursor
//                            .getString(cursor
//                                    .getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
//                    String path = cursor.getString(cursor
//                            .getColumnIndex(MediaStore.Audio.Media.DATA));
//                    String albumName = cursor.getString(cursor
//                            .getColumnIndex(MediaStore.Audio.Media.ALBUM));
//                    int albumId = cursor
//                            .getInt(cursor
//                                    .getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
//                    HashMap<String, String> song = new HashMap<String, String>();
//                    song.put("songTitle", albumName + " " + songName + "___" + albumId);
//                    song.put("songPath", path);
//                    songsList.add(song);
//                } while (cursor.moveToNext());
//            }
//        }
//
//        //String data = MediaStore.Audio.Media._ID;
//        TextView textView = (TextView) findViewById(R.id.music_data);
//        textView.setText(songsList.toString());
    }

}
