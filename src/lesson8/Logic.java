package lesson8;

import java.util.Random;

import javax.swing.*;

public class Logic {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static int DIFFICULTY = 0;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '.';
    public static char[][] map;

    public static Random rand = new Random();

    public static boolean gameFinish = false;
    public static String winnerName;

    public static final int EASY = 0;
    public static final int MEDIUM = 1;
    public static final int HARD = 2;


    public static void go() {

        gameFinish = true;

        if (checkWinLines(DOT_X)) {
            JOptionPane.showMessageDialog(Notification.winLabel, "Вы победили!", "Игра окончена", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (isFull()) {
            JOptionPane.showMessageDialog(Notification.winLabel, "Ничья", "Игра окончена", JOptionPane.WARNING_MESSAGE);
            return;
        }

        aiTurn();
        if (checkWinLines(DOT_O)) {
            JOptionPane.showMessageDialog(Notification.winLabel, "Компьютер победил!", "Игра окончена", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (isFull()) {
            JOptionPane.showMessageDialog(Notification.winLabel, "Ничья", "Игра окончена", JOptionPane.WARNING_MESSAGE);
            return;
        }

        gameFinish = false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void setHumanXY(int x, int y) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            go();
        }
    }

    public static void aiTurn() {
        int x, y;

        if (DIFFICULTY == 0) {
            do {
                y = rand.nextInt(SIZE);
                x = rand.nextInt(SIZE);
            } while (!isCellValid(y, x));
            map[y][x] = DOT_O;

        } else if (DIFFICULTY == 1) {

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i, j)) {
                        map[i][j] = DOT_X;
                        if (checkWinLines(DOT_X)) {
                            map[i][j] = DOT_O;
                            return;
                        }
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
            do {
                y = rand.nextInt(SIZE);
                x = rand.nextInt(SIZE);
            } while (!isCellValid(y, x));
            map[y][x] = DOT_O;

        } else if (DIFFICULTY == 2) {

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i, j)) {
                        map[i][j] = DOT_O;
                        if (checkWinLines(DOT_O)) {
                            return;
                        }
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i, j)) {
                        map[i][j] = DOT_X;
                        if (checkWinLines(DOT_X)) {
                            map[i][j] = DOT_O;
                            return;
                        }
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
            do {
                y = rand.nextInt(SIZE);
                x = rand.nextInt(SIZE);
            } while (!isCellValid(y, x));
            map[y][x] = DOT_O;
        }
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static boolean isFull() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkLine(int cy, int cx, int vy, int vx, char dot) {
        if (cx + vx * DOTS_TO_WIN - 1 > SIZE - 1 || cy + vy * DOTS_TO_WIN - 1 > SIZE - 1 ||
                cy + vy * (DOTS_TO_WIN - 1) < 0) {
            return false;
        }

        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWinLines(char dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot) || checkLine(i, j, 1, 0, dot) ||
                        checkLine(i, j, 1, 1, dot) || checkLine(i, j, -1, 1, dot)) {
                    return true;
                }
            }
        }
        return false;
    }

}

