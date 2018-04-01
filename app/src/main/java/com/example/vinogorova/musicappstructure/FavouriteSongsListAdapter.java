package com.example.vinogorova.musicappstructure;

import android.app.Activity;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

/**
 * Created by Vinogorova on 10.03.2018.
 */

public class FavouriteSongsListAdapter extends ArrayAdapter{

    public FavouriteSongsListAdapter(Activity context, ArrayList<Song> songList) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songList);
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the Song object located at this position in the list
        final Song currentSong = (Song) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name
        TextView songName = (TextView) listItemView.findViewById(R.id.name);

        // Get the song name from the current Song object and
        // set this text on the name TextView
        songName.setText(currentSong.getName());

        // Find the TextView in the list_item.xml layout with the ID author
        TextView authorName = (TextView) listItemView.findViewById(R.id.author);
        // Get the author name from the current Song object and
        // set this text on the author TextView
        authorName.setText(currentSong.getAuthor());

        final ImageButton likeButton = (ImageButton)listItemView.findViewById(R.id.like_button);
        likeButton.setImageResource(R.drawable.green_like);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavouriteActivity.removeFromLikedSongs(currentSong);
                likeButton.setImageResource(R.drawable.disabled_like);
            }
        });

        // Return the whole list item layout (containing 2 TextViews and 2 ImageButtons)
        // so that it can be shown in the ListView
        return listItemView;
    }
}