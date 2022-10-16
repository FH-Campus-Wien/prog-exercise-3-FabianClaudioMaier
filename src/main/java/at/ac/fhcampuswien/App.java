package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class App {

    // Implement all methods as public static
    public static int checkDigit(int[] code) {
        int magicNumber = 0;

        for (int i = 0; i < code.length; i++) {
            code[i] *= i + 2;
            magicNumber += code[i];
        }

        magicNumber = 11 - magicNumber % 11;

        if (magicNumber == 10) return 0;
        if (magicNumber == 11) return 5;
        return magicNumber;
    }

    public static boolean swapArrays(int[] arrayOne, int[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) return false;

        for (int i = 0; i < arrayOne.length; i++) {
            int save = arrayOne[i];
            arrayOne[i] = arrayTwo[i];
            arrayTwo[i] = save;
        }
        return true;
    }


    public static void oneMonthCalendar(int numberOfDays, int firstDay) {
        String output = "";
        int currentday;

        for (int i = 1; i < firstDay; i++) {
            output += "   ";
        }
        for (int i = 1; i <= 8 - firstDay; i++) {
            output += " " + i + " ";
        }
        System.out.println(output);
        currentday = (8 - firstDay) + 1;

        for (int i = 0; i < numberOfDays / 7; i++) {
            output = "";
            for (int j = 1; j < 8; j++) {
                if (currentday <= numberOfDays) {
                    if (currentday < 10) output += " " + currentday + " ";
                    else output += currentday + " ";
                }
                currentday++;
            }
            System.out.println(output);
        }
    }

    public static long[] lcg(long X0) {
        long modul = 2147483648L;
        long factor = 1103515245L;
        int increment = 12345;

        long[] X = new long[10];
        X[0] = (X0* factor + increment)%modul;

        for (int i = 1; i < 10; i++) {
            X[i] = (factor * X[i - 1] + increment) % modul;
        }
        return X;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scan = new Scanner(System.in);
        int guess;
        int count = 1;
        while (true) {
            System.out.printf("Guess number %d: ", count);
            guess = scan.nextInt();
            if (guess == numberToGuess) {
                System.out.println("You won wisenheimer!");
                return;
            } else if (count >= 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            } else if (guess < numberToGuess) System.out.println("The number AI picked is higher than your guess.");
            else System.out.println("The number AI picked is lower than your guess.");
            count++;
        }

    }

    public static int randomNumberBetweenOneAndHundred() {
        //How to use java.util.Random.nextInt: url: https://www.baeldung.com/java-generating-random-numbers-in-range last accessed: 07.10.22 19:43

        Random random = new Random();
        return random.nextInt(100 - 1) + 1;
    }

    public static String camelCase(String input) {
        char[] charArray = input.toCharArray();

        StringBuilder output = new StringBuilder();
        boolean camel = true;
        for (char c : charArray) {
            if (c == ' ') {
                camel = true;
            }
            if (camel) {
                if (c >= 'A' && c <= 'Z') {
                    output.append(c);
                    camel = false;
                } else if (c >= 'a' && c <= 'z') {
                    output.append((char) (c - 32));
                    camel = false;
                }
            } else {
                if (c >= 'A' && c <= 'Z') output.append((char) (c + 32));
                else if (c >= 'a' && c <= 'z') output.append(c);
            }
        }
        return output.toString();
    }


    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        oneMonthCalendar(28, 1);


        long[] X = lcg(11223344);
        for (long x : X) {
            System.out.println(x);
        }

        guessingGame(randomNumberBetweenOneAndHundred());

        System.out.println(camelCase("my name isn't Alice"));
        System.out.println(checkDigit(new int[]{3, 9, 1, 5, 8}));
        System.out.println(swapArrays(new int[]{3, 8, 1, 5, 8}, new int[]{4, 0, 1, 9, 2}));
    }
}