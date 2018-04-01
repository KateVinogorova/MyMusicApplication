package com.example.vinogorova.musicappstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NewReleasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity);

        ListView  view = (ListView)findViewById(R.id.list);
        view.setBackgroundResource(R.drawable.bg_new);

        //Create ArrayList of songs to display them with ListAdapter
        ArrayList<Song> newReleasesList = new ArrayList<Song>();
        newReleasesList.add(new Song("David Byrne", "American Utopia", "Pop/Rock"));
        newReleasesList.add(new Song("Of Montreal", "White Is Relic/Irrealis Mood", "Pop/Rock"));
        newReleasesList.add(new Song("Young Fathers", "Cocoa Sugar", "Rap"));
        newReleasesList.add(new Song("Tracey Thorn", "Record", "Pop/Rock"));
        newReleasesList.add(new Song("John Newman", "Fire In Me", "Soul"));
        newReleasesList.add(new Song("Phonte", "To the Rescue", "Rap"));
        newReleasesList.add(new Song("Hieroglyphic Being", "The Melody Lingers", "Soul Jazz"));
        newReleasesList.add(new Song("Three Days Grace ", "Outsider", "Rock"));
        newReleasesList.add(new Song("George FitzGerald", "All That Must Be", "Electronic"));
        newReleasesList.add(new Song("Editors", "Violence ", "Alternative/Indie Rock"));
        newReleasesList.add(new Song("Erasure  ", "Oh What A World", "Pop"));
        newReleasesList.add(new Song("David Byrne", "Gasoline And Dirty Sheets", "Alternative/Indie Rock"));


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
        //Set ListAdapter to ListView with ID list
        SongListAdapter adapter = new SongListAdapter(this, newReleasesList);
        view.setAdapter(adapter);
    }

}
