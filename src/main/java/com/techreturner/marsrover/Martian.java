package com.techreturner.marsrover;

import java.util.ArrayList;

public class Martian extends Movable{

    public Martian(Mars planet, String name){
        this.name = name;
        this.planet = planet;
        this.type = "MARTIAN";
    }

    @Override
    public String moveOnMars(char action) {
        //Martian moves diagonally and randomly
        int moves = 2;
        for (int i =0; i < moves; i++){
            if (getRandomInt(0,1) == 0)
                this.action('L');
            else
                this.action('R');
            this.action('M');
        }
//        planet.updateGridPosition(getCurrentCol(), getCurrentRow(), NAME);
        return getPositionDirection();
    }

    @Override
    public void eventListener(String event, ArrayList<ThingsOnMars> involved) {
        String message;
        if (!planet.isGameOver())
            if (event.equals("CLASH") ) {
                for (ThingsOnMars theOtherParty : involved)
                    if (theOtherParty.getID() != ID)
                        switch (theOtherParty.getType()) {
                            case "ROVER" -> {
                                message = "Martian dodged the rover " + theOtherParty.getName() + ".  Move from \" " + currentCol + " " + currentRow +
                                        "\" to \"" ;
                                moveOnMars('M');
                                message +=  currentCol + " " + currentRow + "\"";
                                System.out.println(message);
                                break;
                            }
                            case "ROCK" -> {
                                System.out.println("Martian kick away a rock. ");
                                break;
                            }
                            default -> {}
                        }
            }
    }

    public static void main(String[] args) {
        Mars a = new Mars("9 9");
//       testing move randomly
        Martian x = new Martian(a, "M");
        x.setPosition("1 1 N");
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
    }

}


