package com.wolinsky.jordanwolinsky.falloutterminal;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Terminal game;
    ArrayList<TextView> lineLabels;
    ArrayList<TextView> lineContents;
    TextView selectedContent;
    TextView amountCorrect;
    TextView triesLeft;
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstGame();
    }
    @TargetApi(Build.VERSION_CODES.BASE)
    /*public void easyButtonPress(View v)
    {
        newGame(v, "Easy Terminal Word List.txt");
    }*/
    /*public void mediumButtonPress(View v)
    {
        newGame(v, "Medium Terminal Word List.txt");
    }*/
    public void firstGame(){
        game = new Terminal();
        lineLabels = new ArrayList<TextView>();
        lineContents = new ArrayList<TextView>();
        amountCorrect = (TextView) findViewById(R.id.amountCorrect);
        amountCorrect.setText("");
        selectedContent = (TextView) findViewById(R.id.selectedText);
        triesLeft = (TextView) findViewById(R.id.amountOfTries);
        ArrayList<Line> lines = game.getLines();
        lineLabels.add((TextView) findViewById(R.id.lineLabel1));
        lineLabels.add((TextView) findViewById(R.id.lineLabel2));
        lineLabels.add((TextView) findViewById(R.id.lineLabel3));
        lineLabels.add((TextView) findViewById(R.id.lineLabel4));
        lineLabels.add((TextView) findViewById(R.id.lineLabel5));
        lineLabels.add((TextView) findViewById(R.id.lineLabel6));
        lineLabels.add((TextView) findViewById(R.id.lineLabel7));
        lineLabels.add((TextView) findViewById(R.id.lineLabel8));
        lineLabels.add((TextView) findViewById(R.id.lineLabel9));
        lineLabels.add((TextView) findViewById(R.id.lineLabel10));
        lineLabels.add((TextView) findViewById(R.id.lineLabel11));
        lineLabels.add((TextView) findViewById(R.id.lineLabel12));
        lineLabels.add((TextView) findViewById(R.id.lineLabel13));
        lineLabels.add((TextView) findViewById(R.id.lineLabel14));
        lineLabels.add((TextView) findViewById(R.id.lineLabel15));
        lineLabels.add((TextView) findViewById(R.id.lineLabel16));
        lineLabels.add((TextView) findViewById(R.id.lineLabel17));
        lineLabels.add((TextView) findViewById(R.id.lineLabel18));
        lineLabels.add((TextView) findViewById(R.id.lineLabel19));
        lineLabels.add((TextView) findViewById(R.id.lineLabel20));
        lineLabels.add((TextView) findViewById(R.id.lineLabel21));
        lineLabels.add((TextView) findViewById(R.id.lineLabel22));
        lineLabels.add((TextView) findViewById(R.id.lineLabel23));
        lineLabels.add((TextView) findViewById(R.id.lineLabel24));
        lineLabels.add((TextView) findViewById(R.id.lineLabel25));
        lineLabels.add((TextView) findViewById(R.id.lineLabel26));
        lineLabels.add((TextView) findViewById(R.id.lineLabel27));
        lineLabels.add((TextView) findViewById(R.id.lineLabel28));
        lineLabels.add((TextView) findViewById(R.id.lineLabel29));
        lineLabels.add((TextView) findViewById(R.id.lineLabel30));
        lineLabels.add((TextView) findViewById(R.id.lineLabel31));
        lineLabels.add((TextView) findViewById(R.id.lineLabel32));
        lineLabels.add((TextView) findViewById(R.id.lineLabel33));
        lineLabels.add((TextView) findViewById(R.id.lineLabel34));
        for(int i = 0; i < lineLabels.size(); i++)
        {
            lineLabels.get(i).setText(lines.get(i).getLineLabel());
        }
        lineContents.add((TextView) findViewById(R.id.lineContent1));
        lineContents.add((TextView) findViewById(R.id.lineContent2));
        lineContents.add((TextView) findViewById(R.id.lineContent3));
        lineContents.add((TextView) findViewById(R.id.lineContent4));
        lineContents.add((TextView) findViewById(R.id.lineContent5));
        lineContents.add((TextView) findViewById(R.id.lineContent6));
        lineContents.add((TextView) findViewById(R.id.lineContent7));
        lineContents.add((TextView) findViewById(R.id.lineContent8));
        lineContents.add((TextView) findViewById(R.id.lineContent9));
        lineContents.add((TextView) findViewById(R.id.lineContent10));
        lineContents.add((TextView) findViewById(R.id.lineContent11));
        lineContents.add((TextView) findViewById(R.id.lineContent12));
        lineContents.add((TextView) findViewById(R.id.lineContent13));
        lineContents.add((TextView) findViewById(R.id.lineContent14));
        lineContents.add((TextView) findViewById(R.id.lineContent15));
        lineContents.add((TextView) findViewById(R.id.lineContent16));
        lineContents.add((TextView) findViewById(R.id.lineContent17));
        lineContents.add((TextView) findViewById(R.id.lineContent18));
        lineContents.add((TextView) findViewById(R.id.lineContent19));
        lineContents.add((TextView) findViewById(R.id.lineContent20));
        lineContents.add((TextView) findViewById(R.id.lineContent21));
        lineContents.add((TextView) findViewById(R.id.lineContent22));
        lineContents.add((TextView) findViewById(R.id.lineContent23));
        lineContents.add((TextView) findViewById(R.id.lineContent24));
        lineContents.add((TextView) findViewById(R.id.lineContent25));
        lineContents.add((TextView) findViewById(R.id.lineContent26));
        lineContents.add((TextView) findViewById(R.id.lineContent27));
        lineContents.add((TextView) findViewById(R.id.lineContent28));
        lineContents.add((TextView) findViewById(R.id.lineContent29));
        lineContents.add((TextView) findViewById(R.id.lineContent30));
        lineContents.add((TextView) findViewById(R.id.lineContent31));
        lineContents.add((TextView) findViewById(R.id.lineContent32));
        lineContents.add((TextView) findViewById(R.id.lineContent33));
        lineContents.add((TextView) findViewById(R.id.lineContent34));
        for(int i = 0; i<lineContents.size(); i++) {
            lineContents.get(i).setText(lines.get(i).getRandomLineChars());
        }
        selectedContent.setText(""+game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(game.getxPosition()));
        lineLabels.get(game.getCurrentLine()).setTextColor(Color.YELLOW);
        if(Character.isLetter(selectedContent.getText().charAt(0))){
            if(!game.getLines().get(game.getCurrentLine()).getWord().equals("")) {
                if (selectedContent.getText().charAt(0) == game.getLines().get(game.getCurrentLine()).getWord().charAt(0)) {
                    selectedContent.setText("" + game.getLines().get(game.getCurrentLine()).getWord());
                }
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.BASE)
    public void newGame(View v){
        setContentView(R.layout.activity_main);
        //game = new Terminal(difficulty);
        game = new Terminal();
        lineLabels = new ArrayList<TextView>();
        lineContents = new ArrayList<TextView>();
        amountCorrect = (TextView) findViewById(R.id.amountCorrect);
        amountCorrect.setText("");
        selectedContent = (TextView) findViewById(R.id.selectedText);
        triesLeft = (TextView) findViewById(R.id.amountOfTries);
        ArrayList<Line> lines = game.getLines();
        lineLabels.add((TextView) findViewById(R.id.lineLabel1));
        lineLabels.add((TextView) findViewById(R.id.lineLabel2));
        lineLabels.add((TextView) findViewById(R.id.lineLabel3));
        lineLabels.add((TextView) findViewById(R.id.lineLabel4));
        lineLabels.add((TextView) findViewById(R.id.lineLabel5));
        lineLabels.add((TextView) findViewById(R.id.lineLabel6));
        lineLabels.add((TextView) findViewById(R.id.lineLabel7));
        lineLabels.add((TextView) findViewById(R.id.lineLabel8));
        lineLabels.add((TextView) findViewById(R.id.lineLabel9));
        lineLabels.add((TextView) findViewById(R.id.lineLabel10));
        lineLabels.add((TextView) findViewById(R.id.lineLabel11));
        lineLabels.add((TextView) findViewById(R.id.lineLabel12));
        lineLabels.add((TextView) findViewById(R.id.lineLabel13));
        lineLabels.add((TextView) findViewById(R.id.lineLabel14));
        lineLabels.add((TextView) findViewById(R.id.lineLabel15));
        lineLabels.add((TextView) findViewById(R.id.lineLabel16));
        lineLabels.add((TextView) findViewById(R.id.lineLabel17));
        lineLabels.add((TextView) findViewById(R.id.lineLabel18));
        lineLabels.add((TextView) findViewById(R.id.lineLabel19));
        lineLabels.add((TextView) findViewById(R.id.lineLabel20));
        lineLabels.add((TextView) findViewById(R.id.lineLabel21));
        lineLabels.add((TextView) findViewById(R.id.lineLabel22));
        lineLabels.add((TextView) findViewById(R.id.lineLabel23));
        lineLabels.add((TextView) findViewById(R.id.lineLabel24));
        lineLabels.add((TextView) findViewById(R.id.lineLabel25));
        lineLabels.add((TextView) findViewById(R.id.lineLabel26));
        lineLabels.add((TextView) findViewById(R.id.lineLabel27));
        lineLabels.add((TextView) findViewById(R.id.lineLabel28));
        lineLabels.add((TextView) findViewById(R.id.lineLabel29));
        lineLabels.add((TextView) findViewById(R.id.lineLabel30));
        lineLabels.add((TextView) findViewById(R.id.lineLabel31));
        lineLabels.add((TextView) findViewById(R.id.lineLabel32));
        lineLabels.add((TextView) findViewById(R.id.lineLabel33));
        lineLabels.add((TextView) findViewById(R.id.lineLabel34));
        for(int i = 0; i < lineLabels.size(); i++)
        {
            lineLabels.get(i).setText(lines.get(i).getLineLabel());
        }
        lineContents.add((TextView) findViewById(R.id.lineContent1));
        lineContents.add((TextView) findViewById(R.id.lineContent2));
        lineContents.add((TextView) findViewById(R.id.lineContent3));
        lineContents.add((TextView) findViewById(R.id.lineContent4));
        lineContents.add((TextView) findViewById(R.id.lineContent5));
        lineContents.add((TextView) findViewById(R.id.lineContent6));
        lineContents.add((TextView) findViewById(R.id.lineContent7));
        lineContents.add((TextView) findViewById(R.id.lineContent8));
        lineContents.add((TextView) findViewById(R.id.lineContent9));
        lineContents.add((TextView) findViewById(R.id.lineContent10));
        lineContents.add((TextView) findViewById(R.id.lineContent11));
        lineContents.add((TextView) findViewById(R.id.lineContent12));
        lineContents.add((TextView) findViewById(R.id.lineContent13));
        lineContents.add((TextView) findViewById(R.id.lineContent14));
        lineContents.add((TextView) findViewById(R.id.lineContent15));
        lineContents.add((TextView) findViewById(R.id.lineContent16));
        lineContents.add((TextView) findViewById(R.id.lineContent17));
        lineContents.add((TextView) findViewById(R.id.lineContent18));
        lineContents.add((TextView) findViewById(R.id.lineContent19));
        lineContents.add((TextView) findViewById(R.id.lineContent20));
        lineContents.add((TextView) findViewById(R.id.lineContent21));
        lineContents.add((TextView) findViewById(R.id.lineContent22));
        lineContents.add((TextView) findViewById(R.id.lineContent23));
        lineContents.add((TextView) findViewById(R.id.lineContent24));
        lineContents.add((TextView) findViewById(R.id.lineContent25));
        lineContents.add((TextView) findViewById(R.id.lineContent26));
        lineContents.add((TextView) findViewById(R.id.lineContent27));
        lineContents.add((TextView) findViewById(R.id.lineContent28));
        lineContents.add((TextView) findViewById(R.id.lineContent29));
        lineContents.add((TextView) findViewById(R.id.lineContent30));
        lineContents.add((TextView) findViewById(R.id.lineContent31));
        lineContents.add((TextView) findViewById(R.id.lineContent32));
        lineContents.add((TextView) findViewById(R.id.lineContent33));
        lineContents.add((TextView) findViewById(R.id.lineContent34));
        for(int i = 0; i<lineContents.size(); i++) {
            lineContents.get(i).setText(lines.get(i).getRandomLineChars());
        }
        selectedContent.setText(""+game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(game.getxPosition()));
        lineLabels.get(game.getCurrentLine()).setTextColor(Color.YELLOW);
        if(Character.isLetter(selectedContent.getText().charAt(0))){
            if(!game.getLines().get(game.getCurrentLine()).getWord().equals("")) {
                if (selectedContent.getText().charAt(0) == game.getLines().get(game.getCurrentLine()).getWord().charAt(0)) {
                    selectedContent.setText("" + game.getLines().get(game.getCurrentLine()).getWord());
                }
            }
        }
    }
    @TargetApi(Build.VERSION_CODES.BASE)
    public void onUpButton(View v)
    {
        int tempLine = game.getCurrentLine();
        if(game.getCurrentLine()>0)
        {
            if(game.getxPosition() == game.getLines().get(game.getCurrentLine()).getRandomLineChars().length()-1)
            {
                game.setxPosition(game.getLines().get(game.getCurrentLine()-1).getRandomLineChars().length()-1);
            }
            game.setCurrentLine(game.getCurrentLine()-1);
            if(game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(game.getxPosition()) == ' ')
            {
                if(game.getLines().get(game.getCurrentLine()).getRandomLineChars().length()-1 > game.getxPosition())
                {
                    game.setxPosition(game.getxPosition()+1);
                }
                else{
                    game.setxPosition(game.getxPosition()-1);
                }
            }
        }
        TextView selectedContent = (TextView) findViewById(R.id.selectedText);
        selectedContent.setText("" + game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(game.getxPosition()));
        lineLabels.get(game.getCurrentLine()).setTextColor(Color.YELLOW);
        if(tempLine!=game.getCurrentLine()) {
            lineLabels.get(tempLine).setTextColor(Color.parseColor("#29e18c"));
        }
        if(Character.isLetter(selectedContent.getText().charAt(0))){
            if(!game.getLines().get(game.getCurrentLine()).getWord().equals("")) {
                if (selectedContent.getText().charAt(0) == game.getLines().get(game.getCurrentLine()).getWord().charAt(0)) {
                    selectedContent.setText("" + game.getLines().get(game.getCurrentLine()).getWord());
                }
            }
        }
    }
    @TargetApi(Build.VERSION_CODES.BASE)
    public void onDownButton(View v)
    {
        int tempLine = game.getCurrentLine();

        if(game.getCurrentLine()<33)
        {
            if(game.getxPosition() == game.getLines().get(game.getCurrentLine()).getRandomLineChars().length()-1)
            {
                game.setxPosition(game.getLines().get(game.getCurrentLine()+1).getRandomLineChars().length()-1);
            }

            game.setCurrentLine(game.getCurrentLine()+1);
            if(game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(game.getxPosition()) == ' ')
            {
                if(game.getLines().get(game.getCurrentLine()).getRandomLineChars().length()-1 > game.getxPosition())
                {
                    game.setxPosition(game.getxPosition()+1);
                }
                else{
                    game.setxPosition(game.getxPosition()-1);
                }
            }
        }
        TextView selectedContent = (TextView) findViewById(R.id.selectedText);
        selectedContent.setText("" + game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(game.getxPosition()));
        lineLabels.get(game.getCurrentLine()).setTextColor(Color.YELLOW);
        if(tempLine!=game.getCurrentLine()) {
            lineLabels.get(tempLine).setTextColor(Color.parseColor("#29e18c"));
        }
        if(Character.isLetter(selectedContent.getText().charAt(0))){
            if(!game.getLines().get(game.getCurrentLine()).getWord().equals("")) {
                if (selectedContent.getText().charAt(0) == game.getLines().get(game.getCurrentLine()).getWord().charAt(0)) {
                    selectedContent.setText("" + game.getLines().get(game.getCurrentLine()).getWord());
                }
            }
        }
    }
    @TargetApi(Build.VERSION_CODES.BASE)
    public void onLeftButton(View v) {
        ArrayList<Line> lines = game.getLines();
        int tempLine = game.getCurrentLine();
        int tempXPosition = game.getxPosition()-1;
        if(tempXPosition<0)
            tempXPosition=0;
        while(game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(tempXPosition) == ' ')
        {
            tempXPosition--;
            if(tempXPosition<0)
                tempXPosition=0;
        }
        if(game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(tempXPosition) != ' ') {
            if (game.getxPosition() == 0 && lines.get(game.getCurrentLine()).getLineNumber() >= 17) {
                game.setCurrentLine(game.getCurrentLine() - 17);
                game.setxPosition(game.getLines().get(game.getCurrentLine()).getRandomLineChars().length() - 1);
            }
            else if(game.getxPosition()<game.getLines().get(game.getCurrentLine()).getRandomLineChars().length())
            {
                game.setxPosition(tempXPosition);
            }
            else if (game.getxPosition() > 0) {
                game.setxPosition(game.getxPosition() - 1);
            }
        }
        TextView selectedContent = (TextView) findViewById(R.id.selectedText);
        selectedContent.setText("" + game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(game.getxPosition()));
        lineLabels.get(game.getCurrentLine()).setTextColor(Color.YELLOW);
        if(tempLine!=game.getCurrentLine()) {
            lineLabels.get(tempLine).setTextColor(Color.parseColor("#29e18c"));
        }
        if(Character.isLetter(selectedContent.getText().charAt(0))){
            if(!game.getLines().get(game.getCurrentLine()).getWord().equals("")) {
                if (selectedContent.getText().charAt(0) == game.getLines().get(game.getCurrentLine()).getWord().charAt(0)) {
                    selectedContent.setText("" + game.getLines().get(game.getCurrentLine()).getWord());
                }
            }
        }
    }
    @TargetApi(Build.VERSION_CODES.BASE)
    public void onRightButton(View v)
    {
        int tempLine = game.getCurrentLine();
        int tempXPosition = game.getxPosition()+1;
        if(tempXPosition >game.getLines().get(game.getCurrentLine()).getRandomLineChars().length()-1)
            tempXPosition = game.getLines().get(game.getCurrentLine()).getRandomLineChars().length()-1;
        while(game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(tempXPosition) == ' ')
        {
            tempXPosition++;
            if(tempXPosition > game.getLines().get(game.getCurrentLine()).getRandomLineChars().length()-1)
                tempXPosition = game.getLines().get(game.getCurrentLine()).getRandomLineChars().length()-1;
        }
        if(game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(tempXPosition) != ' ')
        {
            if (game.getxPosition() == game.getLines().get(game.getCurrentLine()).getRandomLineChars().length()-1
                    && game.getCurrentLine() <= 16) {
                game.setCurrentLine(game.getCurrentLine()+17);
                game.setxPosition(0);
            }
            else if(game.getxPosition()<game.getLines().get(game.getCurrentLine()).getRandomLineChars().length())
            {
                game.setxPosition(tempXPosition);
            }
            else if(game.getxPosition() == game.getLines().get(game.getCurrentLine()).getRandomLineChars().length() && game.getCurrentLine()==33)
            {
                return;
            }
        }

        TextView selectedContent = (TextView) findViewById(R.id.selectedText);
        selectedContent.setText(""+game.getLines().get(game.getCurrentLine()).getRandomLineChars().charAt(game.getxPosition()));
        lineLabels.get(game.getCurrentLine()).setTextColor(Color.YELLOW);
        if(tempLine!=game.getCurrentLine()) {
            lineLabels.get(tempLine).setTextColor(Color.parseColor("#29e18c"));
        }
        if(Character.isLetter(selectedContent.getText().charAt(0))){
            if(!game.getLines().get(game.getCurrentLine()).getWord().equals("")) {
                if (selectedContent.getText().charAt(0) == game.getLines().get(game.getCurrentLine()).getWord().charAt(0)) {
                    selectedContent.setText("" + game.getLines().get(game.getCurrentLine()).getWord());
                }
            }
        }
    }
    @TargetApi(Build.VERSION_CODES.BASE)
    public void onSelectItem(View v){
        int correctLetters = 0;
        if(Character.isLetter(selectedContent.getText().charAt(0)))
        {
            if(game.getPassword().getWord().equals(game.getLines().get(game.getCurrentLine()).getWord()))
            {
                    setContentView(R.layout.winning_screen);
                    TextView winningText = (TextView) findViewById(R.id.winningText);
                    winningText.setText(winningText.getText() + " the word was " + game.getPassword().getWord());
            }
            else{

                for(int i = 0; i<game.getLines().get(game.getCurrentLine()).getWord().length(); i++)
                {
                    if(game.getLines().get(game.getCurrentLine()).getWord().charAt(i) == game.getPassword().getWord().charAt(i))
                    {
                        correctLetters++;
                    }
                }
                amountCorrect.setText(correctLetters+ " out of "+ game.getPassword().getWord().length()+" correct");
                game.setGuesses(game.getGuesses()-1);
                if(game.getGuesses()==0)
                    setContentView(R.layout.losing_screen);
                triesLeft.setText(game.getGuesses()+"/4");
            }
        }
    }

}