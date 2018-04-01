package com.example.vinogorova.musicappstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendsMusicActivity extends AppCompatActivity {

    ArrayList<User> friends;
    ArrayList<Song> friendsMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity);

        ListView  view = (ListView)findViewById(R.id.list);
        view.setBackgroundResource(R.drawable.bg_new);

        //Create ArrayList for storing friends of current User
        friends = new ArrayList<>();

        //Create Users and add them to friends
        //Add favourite songs to created Users
        User user1 = new User("John");
        user1.addFavouriteSong(new Song("David Byrne", "American Utopia", "Pop/Rock"));
        user1.addFavouriteSong(new Song("Green Day", "Holiday", "Punk"));
        friends.add(user1);

        User user2 = new User("Anna");
        user2.addFavouriteSong(new Song("Fall Out Boy", "Hold Me Tight or Don't", "Alternative"));
        user2.addFavouriteSong(new Song("Tracey Thorn", "Record", "Pop/Rock"));
        user2.addFavouriteSong(new Song("John Newman", "Fire In Me", "Soul"));
        friends.add(user2);

        User user3 = new User("Peter");
        user3.addFavouriteSong(new Song("Phonte", "To the Rescue", "Rap"));
        user3.addFavouriteSong(new Song("Hieroglyphic Being", "The Melody Lingers", "Soul Jazz"));
        user3.addFavouriteSong(new Song("Three Days Grace ", "Outsider", "Rock"));
        friends.add(user3);

        //create an object of ArrayList friendsMusic
        //add friend's favourite music to friendsMusic
        friendsMusic = new ArrayList<Song>();

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).getFavouriteSongs().size(); j++) {
                friendsMusic.add(friends.get(i).getFavouriteSongs().get(j));
            }
        }

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
        SongListAdapter adapter = new SongListAdapter(this, friendsMusic);
        view.setAdapter(adapter);
    }
}
