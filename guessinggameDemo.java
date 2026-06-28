package com.assignment2;
import com.assignment2.GuessingGameV2;

import java.util.Scanner;

public class guessinggameDemo {
    public static void main(String[] args) {
        GuessingGameV2 newgame = new GuessingGameV2();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the highest number you'd like to try to guess: ");
        int newUpperLimit = input.nextInt();
        newgame.setUpperLimit(newUpperLimit);
        newgame.changeUpperLimit(newgame.getUpperLimit());

        System.out.printf("upperLimit is %d, myRand is %d%n", newgame.getUpperLimit(), newgame.getMyRand());
        newgame.playGame();
    }
}
