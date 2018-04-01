package com.example.vinogorova.musicappstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    private static ArrayList<Song> likedSongs = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        ListView  view = (ListView)findViewById(R.id.list);
        LinearLayout layout = (LinearLayout) findViewById(R.id.lastliked_layout);
        layout.setBackgroundResource(R.drawable.bg_new);

        //Set OnItemClickListener to the ListView with ID list for displaying details of clicked song via Intent
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("ITEM CLICK","CLICKED ITEM POSITION: "+position);
                Song s = (Song)parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), SongActivity.class);
                intent.putExtra("songName", s.getName());
                intent.putExtra("authorName", s.getAuthor());
                intent.putExtra("genre", s.getGenre());
                intent.putExtra("rate", "" + s.getRate());
                startActivity(intent);
            }
        });

        if (likedSongs.size() == 0){
            TextView text = (TextView)findViewById(R.id.alt_text);
            text.setText("You have not added anything");
            text.setGravity(Gravity.CENTER);
        }else{
            FavouriteSongsListAdapter adapter = new FavouriteSongsListAdapter(this, likedSongs);
            view.setAdapter(adapter);
        }
    }

    /**
     * This method adds input parameter of Song object to ArrayList likedSongs
     * @param song
     */
    public static void addLikedSong (Song song) {
        int counter = 0;
        for (Song s : likedSongs){
            if (s.getName().equals(song.getName()) && s.getAuthor().equals(song.getAuthor())){
                counter++;
            }
        }
        if (counter == 0){
            likedSongs.add(song);
        }
    }

    /**
     * This method removes input parameter of Song object from ArrayList likedSongs
     * @param song
     */
    public static void removeFromLikedSongs (Song song) {
        likedSongs.remove(song);
    }

}
