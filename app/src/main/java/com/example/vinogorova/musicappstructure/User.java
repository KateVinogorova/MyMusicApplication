package com.example.vinogorova.musicappstructure;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<User> friends;
    private ArrayList<Song> favouriteSongs;

    public User (String name){
        this.name = name;
    }

    /**
     * This method adds favourite song to User's class
     * @param song
     */
    public void addFavouriteSong(Song song) {
        if (favouriteSongs == null){
            favouriteSongs = new ArrayList<Song>();
        }
        favouriteSongs.add(song);
    }

    /**
     * This method returns current User's name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns an ArrayList of current User's favourite songs
     */
    public ArrayList<Song> getFavouriteSongs() {
        return favouriteSongs;
    }

    /**
     * This method adds User object to current User's friends list
     * @param user
     */
    public void addFriend(User user) {
        if (friends == null){
            friends = new ArrayList<User>();
        }
        friends.add(user);
    }

    /**
     * This method returns the list of current User's friends
     * @return
     */
    public ArrayList<User> getFriends () {
        return friends;
    }

}
