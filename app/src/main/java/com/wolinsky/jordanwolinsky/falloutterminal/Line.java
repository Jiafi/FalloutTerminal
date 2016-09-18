package com.wolinsky.jordanwolinsky.falloutterminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Lines contains 12 characters total
 * Created by jordanwolinsky on 10/22/15.
 */
public class Line {
    private String word;
    private final int MAX_CHARACTERS = 12;
    private static final String characters = "!@#$%^&*(){}[]<>,.|-_=+//";
    private String randomLineLabelChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private ArrayList<String> words;
    public String getRandomLineChars() {
        return randomLineChars;
    }

    public void setRandomLineChars(String randomLineChars) {
        this.randomLineChars = randomLineChars;
    }

    private String randomLineChars;
    private int lineNumber;
    private String lineLabel;
    private Random generator = new Random();
    public Line (boolean cont, ArrayList<String> words) {
        this.words=words;
        lineLabel = "0x";
        setLineLabel();
        if(cont){
            setWord();
        }
        else
        {
            this.word="";
        }
        setLineNumber();
        randomLineChars = generateString();
    }
    public void setWord(String word)
    {
        this.word=word;
    }
    public void setWord(){
        //int rand = generator.nextInt(words.size());
        int rand = generator.nextInt(17);
        //this.word=words.get(rand);
        switch (rand) {
            case 0:
                this.word="VIRAL";
                break;
            case 1:
                this.word="DARED";
                break;
            case 2:
                this.word="WIRES";
                break;
            case 3:
                this.word="LINES";
                break;
            case 4:
                this.word="LIVES";
                break;
            case 5:
                this.word="SORTS";
                break;
            case 6:
                this.word="AGREE";
                break;
            case 7:
                this.word="MINES";
                break;
            case 8:
                this.word="LIKES";
                break;
            case 9:
                this.word="PARTS";
                break;
            case 10:
                this.word="HAREM";
                break;
            case 11:
                this.word="LINED";
                break;
            case 12:
                this.word="WARNS";
                break;
            case 13:
                this.word="THREW";
                break;
            case 14:
                this.word="FARMS";
                break;
            case 15:
                this.word="SIDES";
                break;
            case 16:
                this.word="TIRES";
                break;
            default:
                this.word="";
                break;

        }

    }

    public void setLineNumber()
    {
        lineNumber = generator.nextInt(34);
    }
    public String getWord()
    {
        return word;
    }
    public int getLineNumber()
    {
        return lineNumber;
    }
    public String generateString()
    {
        String text="";
        int spot = generator.nextInt(MAX_CHARACTERS-word.length());
        for (int i = 0; i < MAX_CHARACTERS-word.length(); i++)
        {
            if(i==spot)
            {
                text+=word + " ";
            }
            else {
                text += characters.charAt(generator.nextInt(characters.length())) + " ";
            }
        }
        if(text.charAt(text.length()-1) == ' ')
        {
            text = text.substring(0,text.length()-1);
        }
        return text;
    }
    public void setLineLabel()
    {
        lineLabel="0x";
        for(int i = 0; i < 4; i++) {
            lineLabel += randomLineLabelChars.charAt(generator.nextInt(4));
        }
    }
    public String getLineLabel()
    {
        return lineLabel;
    }

}
