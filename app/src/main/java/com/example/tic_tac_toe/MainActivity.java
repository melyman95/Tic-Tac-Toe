package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean clicked = false;
    private static boolean isPlayerOnesTurn = true;
    private static boolean isPlayerTwosTurn = false;
    public static int player1TotalScore;
    public static int player2TotalScore;

    public TextView turnText;
    public EditText P1Score;
    public EditText P2Score;

    private Button[][] gameButtons = new Button[3][3];
    private int turnCount;

    private static final String player1wins = "Player X wins!";
    private static final String player2wins = "Player O wins!";
    private static final String tieText = "It's a tie!";

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

        turnText = findViewById(R.id.turnText);
        P1Score = findViewById(R.id.player1score);
        P2Score = findViewById(R.id.player2score);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (isPlayerOnesTurn) {
            turnText.setText("Player 1's turn");
            ((Button) v).setText("X");
            if (noOpenSquares() == true) {
                disableButtons();
                View toast_view = LayoutInflater.from(this).inflate(Integer.parseInt(player1wins), null);
                Toast tieMessage = Toast.makeText(getApplicationContext(),
                        player1wins, Toast.LENGTH_LONG);
                tieMessage.show();
            }
            if (checkWinner() == true) {
                if (isPlayerOnesTurn) {
                    String text = "Player X wins!";
                    disableButtons();
                    int duration = Toast.LENGTH_LONG;
                    Toast winMessage = Toast.makeText(this, player1wins, duration);
                    winMessage.setMargin(30, 30);
                    winMessage.show();
                    player1TotalScore++;
                    P1Score.setText(Integer.toString(player1TotalScore));
                    return;
                }
                if (isPlayerTwosTurn) {
                    String text = "Player O wins!";
                    disableButtons();
                    int duration = Toast.LENGTH_LONG;
                    Toast winMessage = Toast.makeText(this, player2wins, duration);
                    winMessage.setGravity(Gravity.CENTER, 0, 50);
                    winMessage.show();
                    player2TotalScore++;
                    P2Score.setText(Integer.toString(player2TotalScore));
                    return;
                }
            }
            switchTurns();
        } else {
            turnText.setText("Player 2's turn");
            ((Button) v).setText("O");
            if (noOpenSquares() == true) {
                disableButtons();
                Toast tieMessage = Toast.makeText(this,
                        tieText, Toast.LENGTH_SHORT);
                tieMessage.show();
            }
            if (checkWinner() == true) {
                if (isPlayerOnesTurn) {
                    String text = "Player X wins!";
                    disableButtons();
                    int duration = Toast.LENGTH_LONG;
                    Toast winMessage = Toast.makeText(this, player1wins, duration);
                    winMessage.setGravity(Gravity.CENTER, 0, 50);
                    winMessage.show();
                    player1TotalScore++;
                    P1Score.setText(Integer.toString(player1TotalScore));
                    return;
                }
                if (isPlayerTwosTurn) {
                    String text = "Player O wins!";
                    disableButtons();
                    int duration = Toast.LENGTH_LONG;
                    Toast winMessage = Toast.makeText(this, player2wins, duration);
                    winMessage.setGravity(Gravity.CENTER, 0, 50);
                    winMessage.show();
                    player2TotalScore++;
                    P2Score.setText(Integer.toString(player2TotalScore));
                    return;
                }
            }
            switchTurns();
        }

        turnCount++;
    }

    private void switchTurns() {
        if (isPlayerOnesTurn == true) {
            isPlayerOnesTurn = false;
            isPlayerTwosTurn = true;
            turnText.setText("Player 2's turn");
        } else if (isPlayerTwosTurn == true) {
            isPlayerTwosTurn = false;
            isPlayerOnesTurn = true;
            turnText.setText("Player 1's turn");
        }
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameButtons[i][j].setEnabled(true);
                gameButtons[i][j].setText("");
            }
        }
        turnText.setText("Player 1's turn");
    }

    private boolean checkWinner() {

        for (int i = 0; i < 3; i++) {
            if (gameButtons[i][0].getText().equals(gameButtons[i][1].getText())
                    && gameButtons[i][0].getText().equals(gameButtons[i][2].getText())
            && !gameButtons[i][0].getText().equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (gameButtons[0][i].getText().equals(gameButtons[1][i].getText())
                    && gameButtons[0][i].getText().equals(gameButtons[2][i].getText())
                    && !gameButtons[0][i].getText().equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (gameButtons[0][0].getText().equals(gameButtons[1][1].getText())
                    && gameButtons[0][0].getText().equals(gameButtons[2][2].getText())
                    && !gameButtons[0][0].getText().equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (gameButtons[0][2].getText().equals(gameButtons[1][1].getText())
                    && gameButtons[0][2].getText().equals(gameButtons[2][0].getText())
                    && !gameButtons[0][2].getText().equals("")) {
                return true;
            }
        }
        return false;
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameButtons[i][j].setEnabled(false);
            }
        }
    }

    private boolean noOpenSquares() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!gameButtons[0][0].getText().equals("") &&
                        !gameButtons[1][1].getText().equals("") &&
                        !gameButtons[2][2].getText().equals("") &&
                        !gameButtons[0][1].getText().equals("") &&
                        !gameButtons[0][2].getText().equals("") &&
                        !gameButtons[2][0].getText().equals("") &&
                        !gameButtons[2][1].getText().equals("") &&
                        !gameButtons[2][2].getText().equals("") &&
                        !gameButtons[1][0].getText().equals("") &&
                        !gameButtons[1][2].getText().equals("")){

                    return true;
                }
            }
        }
        return false;
    }
}