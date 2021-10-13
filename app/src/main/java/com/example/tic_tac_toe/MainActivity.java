package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText turnText;
    Button newGame;
    boolean playerOnesTurn;
    Random rand = new Random();
    Button[] buttons = new Button[8];

    // game buttons
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void clearButtons(){

    }

    private void firstTurn(){

    }

    private void startNewGame(){

    }

    public void onClickNewGame(View view){

    }

    public void gameBoxClicked(View view){

    }
}