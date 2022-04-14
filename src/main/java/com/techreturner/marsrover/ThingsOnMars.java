package com.techreturner.marsrover;

import java.util.ArrayList;

public abstract class ThingsOnMars {
    protected int ID;
    protected String type;
    protected int currentRow;
    protected int currentCol;
    protected Mars planet;
    protected boolean isMovable = false;

    public int getCurrentRow(){return currentRow;}
    public int getCurrentCol(){return currentCol;}
    public String getType(){return type;}
    public int getID(){return ID;}
    public boolean isMovable (){return isMovable;}
    public void setPosition(String position){
        String[] positionDirection = position.split(" ");
        currentCol = Integer.valueOf(positionDirection[0]);
        currentRow = Integer.valueOf(positionDirection[1]);
    }

    public abstract void eventListener(String event, ArrayList<Integer> involved);

}
