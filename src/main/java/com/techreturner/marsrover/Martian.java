package com.techreturner.marsrover;

import java.util.ArrayList;

public class Martian extends Movable{

    public Martian(Mars planet, String name){
        this.name = name;
        this.planet = planet;
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
        System.out.println("Martian has heard an event.");
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
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
        x.moveOnMars('a');
        System.out.println(x.getPositionDirection());
    }

}


