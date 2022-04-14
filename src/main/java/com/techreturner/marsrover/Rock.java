package com.techreturner.marsrover;

import java.util.ArrayList;

public class Rock extends ThingsOnMars{

    private int size;

    public Rock(Mars planet, int size){
        this.planet = planet;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void eventListener(String event, ArrayList<Integer> involved) {

    }
}
