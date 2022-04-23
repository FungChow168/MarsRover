package com.techreturner.marsrover;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.regex.*;
import java.lang.IllegalArgumentException;

public abstract class Movable extends ThingsOnMars{

    private int heading = 0;
//    private ArrayList <Integer> directionIndex = new ArrayList<>(Arrays.asList(0,1,2,3));
//    private ArrayList<String> directionValue = new ArrayList<>(Arrays.asList("N","E","S","W"));
    private String[] directionArray = {"N","E","S","W"};
    private final int TOTALDIRECTIONS = 3;
    private final int ONESTEP = 1;

    public Movable(){
        this.isMovable = true;
    }

    public void setPosition(String position){
        String[] positionDirection = position.split(" ");
        currentCol = Integer.valueOf(positionDirection[0]);
        currentRow = Integer.valueOf(positionDirection[1]);
        heading = convertDirectionToInt(positionDirection[2]);
    }

    private int convertDirectionToInt(String direction){
//        return directionIndex.get(directionValue.indexOf(direction));
        int result = 0;
        for (int i= 0; i < directionArray.length; i++)
            if (directionArray[i].equalsIgnoreCase(direction)) result = i;
        return result;
    }

    private String convertIntToDirection(int index){
//        return directionValue.get(directionIndex.indexOf(Integer.valueOf(index)));
        return directionArray[index];
    }

    public String getPositionDirection(){
        return currentCol + " " + currentRow + " " + convertIntToDirection(heading);
    }

    public int getHeading(){
        return heading;
    }

    protected void action(char action){
        switch (action) {
            case 'L' -> {heading -= ONESTEP;
                if (heading <0 ) heading = TOTALDIRECTIONS;}
            case 'R' -> {heading += ONESTEP;
                if (heading > TOTALDIRECTIONS) heading = 0 ;}
            case 'M'-> moveOneStep();
            default -> throw new IllegalArgumentException();
        }
    }

    private void moveOneStep(){
        switch (heading){
            case 0-> {currentRow += ONESTEP;
                if(currentRow> planet.getUpperRightCornerRoW()) currentRow = 0;}
            case 1-> {currentCol += ONESTEP;
                if(currentCol> planet.getUpperRightCornerCol()) currentCol = 0;}
            case 2-> {currentRow -= ONESTEP;
                if(currentRow < 0) currentRow = planet.getUpperRightCornerRoW();}
            case 3-> {currentCol -= ONESTEP;
                if(currentCol < 0) currentCol = planet.getUpperRightCornerCol();}
            default -> throw new IllegalArgumentException();
        }
    }

    public int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    protected char moveRandomly(){
        final char [] options= {'L','R','M','M'};
        return options[getRandomInt(0, options.length)];
    }

    public abstract String moveOnMars(char action);
    //after the move, this method has to return a Sting of its new location which is in this format "x y"
}
