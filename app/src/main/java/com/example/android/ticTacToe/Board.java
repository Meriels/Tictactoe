package com.example.android.ticTacToe;

import java.util.Random;

/**
 * Created by DELL 7520 on 4/11/2018.
 */

public class Board {
    private static final Random RANDOM = new Random();
    private char[] gamer;
    private char currentPlayer;
    private boolean ended;

    public Board() {
        gamer = new char[9];
        newGame();
    }

    public boolean isEnded() {
        return ended;
    }

    public char play(int x, int y) {
        if (!ended  &&  gamer[3 * y + x] == ' ') {
            gamer[3 * y + x] = currentPlayer;
            changePlayer();
        }

        return checkEnd();
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
    }

    public char getElt(int x, int y) {
        return gamer[3 * y + x];
    }

    public void newGame() {
        for (int i = 0; i  < gamer.length; i++) {
            gamer[i] = ' ';
        }

        currentPlayer = 'X';
        ended = false;
    }

    public char checkEnd() {
        for (int i = 0; i < 3; i++) {
            if (getElt(i, 0) != ' ' &&
                    getElt(i, 0) == getElt(i, 1)  &&
                    getElt(i, 1) == getElt(i, 2)) {
                ended = true;
                return getElt(i, 0);
            }

            if (getElt(0, i) != ' ' &&
                    getElt(0, i) == getElt(1, i)  &&
                    getElt(1, i) == getElt(2, i)) {
                ended = true;
                return getElt(0, i);
            }
        }

        if (getElt(0, 0) != ' '  &&
                getElt(0, 0) == getElt(1, 1)  &&
                getElt(1, 1) == getElt(2, 2)) {
            ended = true;
            return getElt(0, 0);
        }

        if (getElt(2, 0) != ' '  &&
                getElt(2, 0) == getElt(1, 1)  &&
                getElt(1, 1) == getElt(0, 2)) {
            ended = true;
            return getElt(2, 0);
        }

        for (int i = 0; i < 9; i++) {
            if (gamer[i] == ' ')
                return ' ';
        }

        return 'T';
    }

    public char computer() {
        if (!ended) {
            int position = -1;

            do {
                position = RANDOM.nextInt(9);
            } while (gamer[position] != ' ');

            gamer[position] = currentPlayer;
            changePlayer();
        }

        return checkEnd();
    }

}


