package com.techreturner.marsrover;

import java.util.ArrayList;
import java.util.Formatter;

public class Rover extends Movable{

    public Rover(Mars planet){
        this.planet = planet;
    }

    @Override
    public String moveOnMars(char action) {
        if (action == 'S')
            this.action(moveRandomly());
        else
            this.action(action);
        return getPositionDirection();
    }

    @Override
    public void eventListener(String event, ArrayList<Integer> involved) {
        System.out.println(new Formatter().format("Rover %s has noticed there is an event.", getID()));
    }
}
