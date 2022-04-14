package com.techreturner.marsrover;


import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class RoversTest {

    private Rover roverA = new Rover(new Mars());

/*
    @Ignore
    @Test
    public void checkPostionStringTest(){
        assertTrue(roverA.positionIsValidFormat("1 1 W"));
        assertFalse(roverA.positionIsValidFormat("1 1 Q"));
        assertFalse(roverA.positionIsValidFormat("1 7 S"));
    }
*/
    @Test
    public void checkCurrentPostion(){
        roverA.setPosition("5 3 E");
        assertEquals("5 3 E", roverA.getPositionDirection());
        roverA.setPosition("1 4 S");
        assertEquals("1 4 S", roverA.getPositionDirection());
        roverA.setPosition("2 2 W");
        assertEquals("2 2 W", roverA.getPositionDirection());
    }
/*
    @Ignore
    @Test
    public void checkMovementStringFormat(){
        assertTrue(roverA.movementIsValidFormat("LRRRRRMMMMMM"));
        assertTrue(roverA.movementIsValidFormat("MRL"));
        assertFalse(roverA.movementIsValidFormat("12 MRL"));
        assertFalse(roverA.movementIsValidFormat("3 3 N MRL"));
    }

    @Ignore
    @Test
    public void checkUpperRightcoordStringFormat(){
        assertTrue(roverA.UpperRightCoordIsValid("3 4"));
        assertTrue(roverA.UpperRightCoordIsValid("5 5"));
        assertFalse(roverA.UpperRightCoordIsValid("5 7"));
        assertFalse(roverA.UpperRightCoordIsValid("a 5"));
    }

    @Ignore
    @Test
    public void checkSetUpperRightcoordinate(){
        roverA.setUpperRightCoord("3 3");
        assertEquals("3 3", roverA.getUpperRightcoord());
        roverA.setUpperRightCoord("4 3");
        assertEquals("4 3", roverA.getUpperRightcoord());
        roverA.setUpperRightCoord("2 2");
        assertEquals("2 2", roverA.getUpperRightcoord());
        roverA.setUpperRightCoord("5 5");
        assertEquals("5 5", roverA.getUpperRightcoord());
    }
*/
    @Test
    public void checkMovementTest(){
        roverA.setPosition("3 3 N");
        roverA.moveOnMars('L');
        roverA.moveOnMars('L');
        assertEquals(2, roverA.getHeading());
        roverA.moveOnMars('R');
        roverA.moveOnMars('R');
        roverA.moveOnMars('R');
        assertEquals(1, roverA.getHeading());
        roverA.moveOnMars('M');
        roverA.moveOnMars('M');
        roverA.moveOnMars('M');
        assertEquals(0, roverA.getCurrentCol());
        roverA.moveOnMars('R');
        roverA.moveOnMars('M');
        roverA.moveOnMars('M');
        roverA.moveOnMars('M');
        roverA.moveOnMars('M');
        assertEquals(5, roverA.getCurrentRow());
        Rover roverB = new Rover(new Mars());
        roverB.setPosition("1 2 N");
        roverB.moveOnMars('L');
        roverB.moveOnMars('M');
        roverB.moveOnMars('L');
        roverB.moveOnMars('M');
        roverB.moveOnMars('L');
        roverB.moveOnMars('M');
        roverB.moveOnMars('L');
        roverB.moveOnMars('M');
        roverB.moveOnMars('M');
        assertEquals("1 3 N", roverB.getPositionDirection());
        Rover roverC = new Rover(new Mars());
        roverC.setPosition("3 3 E");
        roverC.moveOnMars('M');
        roverC.moveOnMars('M');
        roverC.moveOnMars('R');
        roverC.moveOnMars('M');
        roverC.moveOnMars('M');
        roverC.moveOnMars('R');
        roverC.moveOnMars('M');
        roverC.moveOnMars('R');
        roverC.moveOnMars('R');
        roverC.moveOnMars('M');
        assertEquals("5 1 E", roverC.getPositionDirection());
    }




}
