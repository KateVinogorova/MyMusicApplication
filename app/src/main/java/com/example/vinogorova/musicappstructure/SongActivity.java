package com.example.vinogorova.musicappstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        LinearLayout layout = (LinearLayout) findViewById(R.id.main_layout);
        layout.setBackgroundResource(R.drawable.bg_new);

        //Find the TextView with the ID song_name and set to it text from Intent
        TextView songName = (TextView)findViewById(R.id.song_name);
        songName.setText("Track\n" + getIntent().getStringExtra("songName").toUpperCase());

        //Find the TextView with the ID author and set to it text from Intent
        TextView author = (TextView)findViewById(R.id.author);
        author.setText("Artist\n" + getIntent().getStringExtra("authorName").toUpperCase());

        //Find the TextView with the ID genre and set to it text from Intent
        TextView genre = (TextView)findViewById(R.id.genre);
        genre.setText("Genre\n" + getIntent().getStringExtra("genre").toUpperCase());

        //Find the TextView with the ID rate and set to it text from Intent
        TextView rate = (TextView)findViewById(R.id.rating);
        rate.setText("Rate:\n" + getIntent().getStringExtra("rate").toUpperCase());

    }
}
