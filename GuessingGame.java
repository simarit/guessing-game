package com.assignment2;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    protected Random myRand = new Random();
    protected int myNum = myRand.nextInt(1,1000);
    private int numGuesses = 0;
    private int done = 0;
    private final int TOTAL_GUESSES = 1000;
    private int[] actual_guesses = new int[TOTAL_GUESSES];

    public GuessingGame() {

    }

    public GuessingGame(int num){
        myNum = num;
    }

    public void playGame(){
        System.out.println(myNum);

        System.out.println("Guess my number! How many will it take?");
        while(done == 0){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter you guess: ");
            int userGuess = input.nextInt();

            System.out.println(userGuess);

            actual_guesses[numGuesses] = userGuess;
            numGuesses++;

            int value = compareGuess(userGuess, myNum);

            if(value == 0){
                System.out.println("Well done! You got it in " + numGuesses + " guesses!");
                listGuess(actual_guesses,numGuesses);
                done = 1;
            } else if (value == 1){
                System.out.println("Your guess was too high. Try again!\nYou've made " + numGuesses + " guesses.");
            } else if (value == -1){
                System.out.println("Your guess was too low. Try again!\nYou've made " + numGuesses + " guesses.");
            }

        }
    }

    protected int compareGuess(int guess, int answer) {
        int compare = 1;

        if(guess == answer) {
            compare = 0;
        }

        if (guess > answer) {
            compare = 1;
        }

        if (guess < answer) {
            compare = -1;
        }

        return compare;
    }

    private static void listGuess(int [] actualGuesses, int numGuesses) {
        for(int i = 0; i < numGuesses; i++){
            System.out.println(actualGuesses[i]);
        }
    }

    public int getMyRand(){
        return myNum;
    }
}
