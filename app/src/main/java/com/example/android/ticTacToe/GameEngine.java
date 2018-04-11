package com.example.android.ticTacToe;

import java.util.Random;

/**
 * Created by DELL 7520 on 4/11/2018.
 */

public class GameEngine {

    private static final Random RANDON = new Random();
    private char[] elts;
    static String[] board;
    private char currentPlayer;
    private boolean ended = true;

    public GameEngine() {
        elts = new char[9];
        newGame();
    }

    public boolean isEnded() {
        return ended;
    }

    public char play(int x, int y) {
        if (!ended && elts[3 * x + y] == ' ') {
            elts[3 * x + y] = currentPlayer;
            changePlayer();

        }

        return currentPlayer;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
    }

    public char elt(int x, int y) {
        return elts[3 * x + y];
    }


    public void newGame() {
        for (int i = 0; i < elts.length; i++) {
            elts[i] = ' ';
        }

        currentPlayer = 'X';
        ended = false;

    }
    public String checkEnd() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        return checkEnd();
    }




    public String computer() {
        if (!ended) {
            int position ;
            do {
                position = RANDON.nextInt();
            } while (elts[position] != ' ');

        }

        return checkEnd();

    }
}




