package com.example.robert.scriptureref;

/**
 * Created by Robert on 10/15/2015.
 */
public class Scripture {
    // Constructor
    Scripture(String book, int chapter, int verse){
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
    }
    // Getter
    public String getScripture(){
        return book + " " + chapter + ":" + verse;
    }

    private String book;
    private int chapter;
    private int verse;
}
