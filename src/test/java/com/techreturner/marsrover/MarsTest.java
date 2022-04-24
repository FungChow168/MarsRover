package com.techreturner.marsrover;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MarsTest {

    private Mars planet = new Mars("5 5");

    @Test
    public void checkMarsGridTest (){
//        planet.setGrid("5 5");
        assertEquals(6, planet.getGrid().size());
        assertEquals(6, planet.getGrid().get(0).size());
        assertEquals(6, planet.getGrid().get(1).size());
        assertEquals(6, planet.getGrid().get(2).size());
        assertEquals(6, planet.getGrid().get(3).size());
        assertEquals(6, planet.getGrid().get(4).size());
        assertEquals(6, planet.getGrid().get(5).size());
    }


}
