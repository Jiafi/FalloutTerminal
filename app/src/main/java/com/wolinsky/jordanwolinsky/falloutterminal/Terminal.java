package com.wolinsky.jordanwolinsky.falloutterminal;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jordanwolinsky on 10/19/15.
 * 34 Lines in total
 */
public class Terminal {
    private ArrayList<Line> lines = new ArrayList<Line>();
    private Line password;
    private int guesses = 4;
    private int xPosition;
    private int currentLine;
    private ArrayList<String> wordsUsed;
    private ArrayList<String> lineLabelsUsed;
    private ArrayList<Integer> lineNumbersUsed;
    private ArrayList<String> words;
    public Terminal(){
        xPosition=0;
        currentLine=0;
        password = new Line(true, words);
        password.setRandomLineChars(password.generateString());
        lines.add(password);
        wordsUsed = new ArrayList<String>();
        wordsUsed.add(password.getWord());
        lineLabelsUsed = new ArrayList<String>();
        lineLabelsUsed.add(password.getLineLabel());
        lineNumbersUsed = new ArrayList<Integer>();
        lineNumbersUsed.add(password.getLineNumber());

        for(int i = 1; i < 34; i++)
        {
            Line line;
            if(i<17)
            {
                line = new Line(true, words);
            }
            else {
                line = new Line(false, words);
            }
            while(wordsUsed.contains(line.getWord()) &&  i<17)
            {
                line.setWord();
                line.setRandomLineChars(line.generateString());
            }

            wordsUsed.add(line.getWord());
            while(lineLabelsUsed.contains(line.getLineLabel()))
            {
                line.setLineLabel();
            }
            lineLabelsUsed.add(line.getLineLabel());
            while(lineNumbersUsed.contains(line.getLineNumber()))
            {
                line.setLineNumber();
            }
            lineNumbersUsed.add(line.getLineNumber());
            lines.add(line);
        }
        lines=sortLines(lines);
    }
    /*public Terminal(String difficulty) {
        Scanner scan = null;
        File file = new File("Easy Terminal Word List");
        try{
            scan = new Scanner(file);
        }
        catch(FileNotFoundException e){

        }
        while(scan.hasNextLine())
        {
            words.add(scan.nextLine());
        }
        xPosition=0;
        currentLine=0;
        password = new Line(true, words);
        password.setRandomLineChars(password.generateString());
        lines.add(password);
        wordsUsed = new ArrayList<String>();
        wordsUsed.add(password.getWord());
        lineLabelsUsed = new ArrayList<String>();
        lineLabelsUsed.add(password.getLineLabel());
        lineNumbersUsed = new ArrayList<Integer>();
        lineNumbersUsed.add(password.getLineNumber());

        for(int i = 1; i < 34; i++)
        {
            Line line;
            if(i<17)
            {
                line = new Line(true, words);
            }
            else {
                line = new Line(false, words);
            }
            while(wordsUsed.contains(line.getWord()) &&  i<17)
            {
                line.setWord();
                line.setRandomLineChars(line.generateString());
            }

            wordsUsed.add(line.getWord());
            while(lineLabelsUsed.contains(line.getLineLabel()))
            {
                line.setLineLabel();
            }
            lineLabelsUsed.add(line.getLineLabel());
            while(lineNumbersUsed.contains(line.getLineNumber()))
            {
                line.setLineNumber();
            }
            lineNumbersUsed.add(line.getLineNumber());
            lines.add(line);
        }
        lines=sortLines(lines);
    }*/
    public Line getPassword() {
        return password;
    }
    public int getGuesses() {
        return guesses;
    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }
    public int getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(int currentLine) {
        this.currentLine = currentLine;
    }
    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    private ArrayList<Line> sortLines(ArrayList<Line> lines)
    {
        Collections.sort(lines, new Comparator<Line>() {
            @Override
            public int compare(Line t1, Line t2) {
                if (t1.getLineNumber() == t2.getLineNumber()) {
                    return 0;
                } else if (t1.getLineNumber() < t2.getLineNumber()) {
                    return -1;
                }
                return 1;
            }
        });
        return lines;
    }

}