package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class DashTest {

    private Dash dash;

    @BeforeEach
    void setUp() {
        dash = new Dash(5, 5);
    }

    @Test
    void testInitialState() {
        assertNotNull(dash);
        assertEquals(5, dash.getX());
        assertEquals(5, dash.getY());
        assertEquals(0, dash.getScore());
    }

    @Test
    void testSetAndGetScore() {
        dash.setScore(100);
        assertEquals(100, dash.getScore());
    }

    @Test
    void testWalkRight() {
        dash.setWalksright(true);
        assertTrue(dash.imageWalk(1) != null);
    }

    @Test
    void testWalkLeft() {
        dash.setWalksleft(true);
        assertTrue(dash.imageWalk(1) != null);
    }

    @Test
    void testRestState() {
        dash.setRest(true);
        assertTrue(dash.isRest());
    }
}
