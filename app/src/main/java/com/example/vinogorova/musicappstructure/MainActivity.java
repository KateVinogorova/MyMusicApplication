package com.example.vinogorova.musicappstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = (LinearLayout)findViewById(R.id.main_layout);
        layout.setBackgroundResource(R.drawable.bg_new);

    /*
    Set background for New releases block and set OnClickListener for it
     */
        ImageView newReleases = (ImageView) findViewById(R.id.new_releases);
        newReleases.setBackgroundResource(R.drawable.new_releases);
        newReleases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewReleasesActivity.class);
                startActivity(intent);
            }
        });
    /*
    Set background for Last liked block and set OnClickListener for it
     */
        ImageView lastLiked = (ImageView) findViewById(R.id.last_liked);
        lastLiked.setBackgroundResource(R.drawable.last_liked);
        lastLiked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavouriteActivity.class);
                startActivity(intent);
            }
        });

    /*
    Set background for Load from device block and set OnClickListener for it
     */
        ImageView loadFromDevice = (ImageView) findViewById(R.id.load_from_device);
        loadFromDevice.setBackgroundResource(R.drawable.load);
        loadFromDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoadActivity.class);
                startActivity(intent);
            }
        });
    /*
    Set background for Friend's music block and set OnClickListener for it
     */
        ImageView friendsMusic = (ImageView) findViewById(R.id.friends_music);
        friendsMusic.setBackgroundResource(R.drawable.friends);
        friendsMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FriendsMusicActivity.class);
                startActivity(intent);
            }
        });

    }
}
