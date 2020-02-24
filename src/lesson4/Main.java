package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '.';
    public static char[][] map;

    public static int movesCount = 0;

    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        initMap();
        printMap();
        System.out.println();

        while (true) {
            humanTurn();
            printMap();
            System.out.println();
            movesCount++;
            if (checkWin(DOT_X)) {
                System.out.println("Игрок победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ходы закончились. Ничья!");
                break;
            }


            aiTurn();
            printMap();
            System.out.println();
            movesCount++;
            if (checkWin(DOT_O)) {
                System.out.println("Искусственный интеллект победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ходы закончились. Ничья!");
                break;
            }
        }

    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y; //на самом деле координаты наоборот х - идёт вниз, y - идёт вправо
        do {
            System.out.println("Введите уоординаты в формате X пробел Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static boolean isFull() {
        return movesCount == SIZE * SIZE;
    }

    public static boolean checkWin(char symb) {

        int symbCountRows;
        for (int y = 0; y < SIZE; y++) {
            symbCountRows = 0;
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] == symb) {
                    symbCountRows++;
                    if (symbCountRows == DOTS_TO_WIN) {
                        return true;
                    }
                } else symbCountRows = 0;
            }
        }

        int symbCountColumns;
        for (int x = 0; x < SIZE; x++) {
            symbCountColumns = 0;
            for (int y = 0; y < SIZE; y++) {
                if (map[y][x] == symb) {
                    symbCountColumns++;
                    if (symbCountColumns == DOTS_TO_WIN) {
                        return true;
                    }
                } else symbCountColumns = 0;
            }
        }

        int symbCountDiag = 0;
        for (int y = 0; y < SIZE; y++) {
            if (map[y][y] == symb) {
                symbCountDiag++;
                if (symbCountDiag == DOTS_TO_WIN) {
                    return true;
                }
            } else symbCountDiag = 0;
        }

        int symbCountRevDiag = 0;
        for (int y = 0; y < SIZE; y++) {
            if (map[y][SIZE - 1 - y] == symb) {
                symbCountRevDiag++;
                if (symbCountRevDiag == DOTS_TO_WIN) {
                    return true;
                }
            } else symbCountRevDiag = 0;
        }

        return false;
    }

}

