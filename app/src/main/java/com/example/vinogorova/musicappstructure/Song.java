package com.example.vinogorova.musicappstructure;


/**
 * Created by Vinogorova on 10.03.2018.
 */

public class Song {

    private String author;
    private String name;
    private String genre;
    protected int rate;
    public boolean isLiked;

    public Song (String author, String name, String genre){
        this.author = author;
        this.name = name;
        this.genre = genre;
        if (genre == null){
            this.genre = "undefined";
        }
    }

    /**
     * This method returns value of the author variable
     * @return author's name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method sets value to the author variable
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method returns value of the name variable
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets value to the name variable
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns value of the genre variable
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * This method sets value to the genre variable
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * This method increments value of the rate variable
     */
    public void incrementRate() {
        rate++;
    }

    /**
     * This method decrements value of the rate variable
     */
    public void decrementRate (){
        rate--;
    }

    /**
     * This method returns value of the rate variable
     * @return rate
     */
    public int getRate() {
        return rate;
    }
}
