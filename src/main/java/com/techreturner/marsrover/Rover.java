package com.techreturner.marsrover;

import java.util.ArrayList;
import java.util.Formatter;

public class Rover extends Movable{


    public Rover(Mars planet, String name, int id){
        this.planet = planet;
        this.type = "ROVER";
        this.name = name;
        this.ID = id;
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
    public void eventListener(String event, ArrayList<ThingsOnMars> involved) {
            if (event.equals("CLASH") ) {
                for (ThingsOnMars theOtherParty : involved)
                    if (theOtherParty.getID() != ID)
                        switch (theOtherParty.getType()) {
                            case "ROVER" -> {
                                System.out.println("Rover " + name + " crashed. Mission Failed.");
                                name = "X";
                                break;
                            }
                            case "ROCK" -> {
                                System.out.println("Rover " + name + " has found a rock. Mission Accomplished.");
                                name = "@";
                                break;
                            }
                        }
                planet.endThisGame();
            }

    }
}
