package com.techreturner.marsrover;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import static java.util.stream.Collectors.*;


public class Mars {

    private final String MOVEMENTSTRING = "LRM";
    private int upperRightCornerCol;
    private int upperRightCornerRoW;
    private ArrayList<ArrayList<String>> planetGrid = new ArrayList<ArrayList<String>>();
    private boolean gameOver = false;
    private final int RECESS = 1;
    private int nextId = 1;


    public int getUpperRightCornerCol(){return upperRightCornerCol;}
    public int getUpperRightCornerRoW(){return upperRightCornerRoW;}
    public ArrayList<ArrayList<String>> getGrid(){return planetGrid;}
    public ArrayList<ThingsOnMars> everything = new ArrayList<>();
    public boolean isGameOver(){return gameOver;};

    public Mars(String gridSize){
        this.setGrid(gridSize);
    }

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

    public void playGame(){
        createObjectsOnMars();
        Movable movable;
        int roundNo = 1;
        while (!gameOver) {
            System.out.println("Round : " + roundNo++);
            for (ThingsOnMars obj : everything) {
                if (obj.isMovable) {
                    movable = (Movable) obj;
                    movable.moveOnMars('S');
                }
            }
            findEvent();

            printGrid();
            try {
                TimeUnit.SECONDS.sleep(RECESS);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    private void findEvent(){
        ArrayList<String> a = new ArrayList<>();
        Map<String, List<ThingsOnMars>> map = everything.stream().collect(groupingBy(ThingsOnMars::getCoord));
        if (map.size() < everything.size())
            for (Map.Entry<String, List<ThingsOnMars>> entry: map.entrySet())
                if (entry.getValue().size() > 1)
                    broadcastEvent("CLASH", new ArrayList<ThingsOnMars>(entry.getValue()));
    }

    private void broadcastEvent(String event, ArrayList<ThingsOnMars> thingsOnMars){
        for(ThingsOnMars thing: thingsOnMars)
            thing.eventListener(event, thingsOnMars);
    }

    public void endThisGame(){
        gameOver = true;
    }

    private void createObjectsOnMars(){
        Rock rock = new Rock(this, getRandomInt(1, 3), "R", nextId++);
        rock.setPosition(getRandomInt(0, upperRightCornerCol) + " " + getRandomInt(0, upperRightCornerRoW) );
        System.out.println("Rock position : " + rock.getCurrentCol() + " " + rock.getCurrentRow());
        everything.add(rock);
        Rover roverA = new Rover(this, "A", nextId++);
        roverA.setPosition(getRandomInt(0, upperRightCornerCol) + " " + getRandomInt(0, upperRightCornerRoW) + " N");
        System.out.println("Rover A position :" + roverA.getPositionDirection());
        everything.add(roverA);
        Rover roverB = new Rover(this, "B", nextId++);
        roverB.setPosition(getRandomInt(0, upperRightCornerCol) + " " + getRandomInt(0, upperRightCornerRoW) + " N");
        System.out.println("Rover B position :" + roverB.getPositionDirection());
        everything.add(roverB);
        Martian friend = new Martian(this, "M");
        friend.setPosition(getRandomInt(0, upperRightCornerCol) + " " + getRandomInt(0, upperRightCornerRoW) + " S");
        System.out.println("Martian position :" + friend.getPositionDirection());
        everything.add(friend);
        printGrid();
    }



    protected void updateGridPosition(int col, int row, String name){
        planetGrid.get(row).set(col, name);
    }

    public void printGrid(){

        for (int i=0; i<= upperRightCornerRoW; i++)
            for (int j = 0; j <= upperRightCornerCol; j++)
                planetGrid.get(i).set(j, " ");
        everything.forEach(thing->
                planetGrid.get(thing.getCurrentRow()).set(thing.getCurrentCol(), thing.getName()));

        String gridLine = "+";
        for (int i=0; i<= upperRightCornerCol; i++)
            gridLine += "-+";
        String grid = gridLine + "\n";

        for (int i=upperRightCornerRoW; i >= 0 ; i--){
            grid += i+"|";
            for (int j=0; j <= upperRightCornerCol; j++)
                grid += planetGrid.get(i).get(j) + "|";
            grid += "\n" + gridLine + "\n";
        }
        grid += " |";
        for (int i =0; i <= upperRightCornerCol; i++)
            grid += i + "|";
                grid += "\n\n--------------------------------\n";
        System.out.println(grid);
    }

    public int getRandomInt(int min, int max) {
        return  ThreadLocalRandom.current().nextInt(min, max + 1);
    }


    public static void main(String[] args) {
        Mars mars = new Mars("10 10");
        mars.playGame();
    }
}