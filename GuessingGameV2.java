package com.assignment2;

import java.util.Random;

public class GuessingGameV2 extends GuessingGame{
    protected int upperLimit;

    public void setUpperLimit(int initialLimit){
        upperLimit = initialLimit;
        super.myNum = myRand.nextInt(1,upperLimit+1);
    }

    public int getUpperLimit(){
        return upperLimit;
    }

    public void changeUpperLimit(int x){
        super.myNum = myRand.nextInt(1,x);
    }

    @Override
    protected int compareGuess(int guess, int answer) {
        int compare = -1;

        if(guess == answer) {
            compare = 0;
        } else if (guess > answer) {
            compare = 1;
        } else if (guess < answer) { //if guess is less than answer then pick new number
            changeUpperLimit(guess);
            System.out.println("New rand: " + super.myNum);
        }

        return compare;
    }

}
