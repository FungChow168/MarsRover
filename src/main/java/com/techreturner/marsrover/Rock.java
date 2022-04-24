package com.techreturner.marsrover;

import java.util.ArrayList;

public class Rock extends ThingsOnMars{

    private int size;

    public Rock(Mars planet, int size, String name, int id){
        this.type = "ROCK";
        this.planet = planet;
        this.size = size;
        this.name = name;
        this.ID = id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void eventListener(String event, ArrayList<ThingsOnMars> involved) {
        if (!planet.isGameOver())
            if (event.equals("CLASH") ) {
                for (ThingsOnMars theOtherParty : involved)
                    if (theOtherParty.getID() != ID)
                        switch (theOtherParty.getType()) {
                            case "MARTIAN" -> {
                                setPosition(planet.getRandomInt(0, planet.getUpperRightCornerCol()) + " " + planet.getRandomInt(0, planet.getUpperRightCornerRoW()) );
                                break;
                            }
                            default -> {}
                        }
            }
    }
}
