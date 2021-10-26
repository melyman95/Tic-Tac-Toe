package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean clicked = false;
    boolean isPlayerOnesTurn;
    boolean isPlayerTwosTurn;

    Button button1 = new Button(this);
    Button button2 = new Button(this);
    Button button3 = new Button(this);
    Button button4 = new Button(this);
    Button button5 = new Button(this);
    Button button6 = new Button(this);
    Button button7 = new Button(this);
    Button button8 = new Button(this);
    Button button9 = new Button(this);

    Button[] buttons = new Button[8];

    TextView gameButton1 = findViewById(R.id.button1);
    TextView gameButton2 = findViewById(R.id.button2);
    TextView gameButton3 = findViewById(R.id.button3);
    TextView gameButton4 = findViewById(R.id.button4);
    TextView gameButton5 = findViewById(R.id.button5);
    TextView gameButton6 = findViewById(R.id.button6);
    TextView gameButton7 = findViewById(R.id.button7);
    TextView gameButton8 = findViewById(R.id.button8);
    TextView gameButton9 = findViewById(R.id.button9);

    TextView[] buttonTexts = new TextView[8];

    EditText turnText;
    Button newGame;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;
        buttons[3] = button4;
        buttons[4] = button5;
        buttons[5] = button6;
        buttons[6] = button7;
        buttons[7] = button8;
        buttons[8] = button9;

        buttonTexts[0] = gameButton1;
        buttonTexts[1] = gameButton2;
        buttonTexts[2] = gameButton3;
        buttonTexts[3] = gameButton4;
        buttonTexts[4] = gameButton5;
        buttonTexts[5] = gameButton6;
        buttonTexts[6] = gameButton7;
        buttonTexts[7] = gameButton8;
        buttonTexts[8] = gameButton9;

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
        for (int i = 0; i < 9; i++) {
            if (buttons[i].isPressed()) {
                buttonTexts[i].setText("X");
            }
        }
    }
}