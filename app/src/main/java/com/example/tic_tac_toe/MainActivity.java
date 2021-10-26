package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean clicked = false;
    private boolean isPlayerOnesTurn = true;
    private boolean isPlayerTwosTurn = false;

    TextView turnText;

    private Button[][] gameButtons = new Button[3][3];
    private int turnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonId = "button" + i + j;
                int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
                gameButtons[i][j] = findViewById(resId);
                gameButtons[i][j].setOnClickListener(this::onClick);
            }
        }

        Button resetButton = findViewById(R.id.newGameButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                resetBoard();
                turnCount = 0;
            }
        });
    }
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        if (!((Button)v).getText().toString().equals("")) {
            return;
        }

        if (isPlayerOnesTurn) {
            ((Button)v).setText("X");
            switchTurns();
        }
        else {
            ((Button)v).setText("O");
            switchTurns();
        }

        turnCount++;
    }

    private void switchTurns() {
        if (isPlayerOnesTurn == true) {
            isPlayerOnesTurn = false;
            isPlayerTwosTurn = true;
        }

        else if (isPlayerTwosTurn == true) {
            isPlayerTwosTurn = false;
            isPlayerOnesTurn = true;
        }
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameButtons[i][j].setText("");
            }
        }
    }
}