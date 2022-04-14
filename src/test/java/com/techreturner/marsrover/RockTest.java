package com.techreturner.marsrover;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class RockTest {

    private Rock rock = new Rock(new Mars(), 3);

    @Test
    public void checkSizeTest(){
        assertEquals(3, rock.getSize());
    }
}
