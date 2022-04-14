package com.techreturner.marsrover;

import java.util.ArrayList;

public class Martian extends Movable{


    public Martian(Mars planet){
        this.planet = planet;
    }

    public int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }


    @Override
    public String moveOnMars(char action) {
        //Martian moves diagonally and randomly
        int moves = 2;
        for (int i =0; i < moves; i++){
            if (getRandomInt(0,1) == 0)
                action('L');
            else
                action('R');
            action('M');
        }
        return getPositionDirection();
    }

    @Override
    public void eventListener(String event, ArrayList<Integer> involved) {
        System.out.println("Martian has heard an event.");
    }
}


