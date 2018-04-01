package com.example.vinogorova.musicappstructure;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class LoadActivity extends Activity{

    ArrayList<Song> songs = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        LinearLayout layout = (LinearLayout)findViewById(R.id.main_layout);
        layout.setBackgroundResource(R.drawable.bg_new);

        //Find Button with the ID browse
        Button browse = (Button)findViewById(R.id.browse);
        //Set OnClickListener to this Button
        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareListForAdapter(getContentFromDevice());
                SongListAdapter adapter = new SongListAdapter(LoadActivity.this, songs);
                ListView list = (ListView)findViewById(R.id.list);
                list.setAdapter(adapter);
            }
        });
    }

    /**
     * This method creates ContentResolver to get external data from ContentProvider
     * And returns ArrayList of this data
     * @return s
     */
    protected ArrayList<String> getContentFromDevice() {

        //Create ArrayList for keeping data of received songs
        ArrayList<String> s = new ArrayList<>();

        //Check if the permission to the external storage is granted
        //and create ContentResolver
        if (isStoragePermissionGranted()){
            ContentResolver cr = this.getContentResolver();
            String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

            //Create projection of data we want to get
            String[] projection = {
                    MediaStore.Audio.Media._ID,
                    MediaStore.Audio.Media.ARTIST,
                    MediaStore.Audio.Media.TITLE,
            };

            //Create Cursor for reading table with song's information
            Cursor cursor = this.managedQuery(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    projection,
                    selection,
                    null,
                    null);

            //Read data and add in ArrayList s
            while(cursor.moveToNext()){
                s.add(cursor.getString(1) + "/" +
                        cursor.getString(2));
            }
        }
        return s;
    }

    /**
     * This method turns ArrayList of Strings to ArrayList of Songs
     * @param listOfSongs
     */
    private void prepareListForAdapter(ArrayList<String> listOfSongs){
        for (int i = 0; i < listOfSongs.size(); i++){
            String[] s = listOfSongs.get(i).split("/");
            songs.add(new Song(s[0], s[1], null));
        }
    }

    /**
     * This method checks if the access to the external storage is allowed
     * @return
     */
    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission is granted");
                return true;
            } else {

                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission is granted");
            return true;
        }
    }
}
