package lesson3;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    //Задание 1
    public static void main(String[] args) {
        numGame();
        int exitOrNo;

        do {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            exitOrNo = sc.nextInt();
            if (exitOrNo == 1) {
                numGame();
            } else if (exitOrNo == 0) {
                return;
            }
        } while (exitOrNo == 1);
    }

    public static void numGame() {

        int answer = rand.nextInt(10);
        int userAnswer;
        int tryCount = 0;
        System.out.println("Загадано число от 0 до 9. У Вас есть попытки 3 его отгадать.");

        do {
            userAnswer = sc.nextInt();
            if (userAnswer == answer) {
                System.out.println("Отгадано верно! Игра окончена.");
            } else if (userAnswer > answer) {
                System.out.println("Число слишком большое");
            } else if (userAnswer < answer) {
                System.out.println("Число слишком маленькое");
            }

            tryCount++;
            if (tryCount == 3 & userAnswer != answer)
                System.out.println("Вы использовали 3 попытки. Игра окончена.");

        } while (answer != userAnswer & tryCount < 3);
    }



}



