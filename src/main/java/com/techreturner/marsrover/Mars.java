package com.techreturner.marsrover;


import java.util.ArrayList;
import java.util.Arrays;

public class Mars {

    private final int MINCOLUMNNO = 0;
    private final int MAXCOLUMNNO = 0;
    private final String MOVEMENTSTRING = "LRM";
    private int upperRightCornerCol = 5;
    private int upperRightCornerRoW = 5;
    private ArrayList<ArrayList<String>> planetGrid = new ArrayList<ArrayList<String>>();

    private void promptUserInput() {}

    public int getMINCOLUMNNO(){return MINCOLUMNNO;};
    public int getMAXCOLUMNNO(){return MAXCOLUMNNO;};
    public int getUpperRightCornerCol(){return upperRightCornerCol;}
    public int getUpperRightCornerRoW(){return upperRightCornerRoW;}
    public ArrayList<ArrayList<String>> getGrid(){return planetGrid;};
    public void setGrid(String grid){
        String[] gridArray = grid.split(" ");
        upperRightCornerRoW = Integer.valueOf(gridArray[0]);
        upperRightCornerCol = Integer.valueOf(gridArray[1]);
        for (int i=0; i<= upperRightCornerRoW; i++) {
            planetGrid.add(new ArrayList<>());
            for (int j = 0; j <= upperRightCornerCol; j++)
                planetGrid.get(planetGrid.size() - 1).add(" ");
        }
    }

    public String printGrid(){


        String gridLine = "+";
        for (int i=0; i<= upperRightCornerCol; i++)
            gridLine += "-+";
        String grid = gridLine + "\n";

        for (int i=0; i <= upperRightCornerRoW; i++){
            grid += "|";
            for (int j=0; j <= upperRightCornerCol; j++)
                grid += planetGrid.get(i).get(j) + "|";
            grid += "\n" + gridLine + "\n";
        }
        System.out.println(grid);

        return "hello world"; //grid;
    }

    public static void main(String[] args) {
        Mars a = new Mars();
        a.setGrid("55 35");
        System.out.println("row size : " + a.getGrid().size());
        System.out.println("col size : " + a.getGrid().get(1).size());
        a.printGrid();
    }

}
