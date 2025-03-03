package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ObjetTest {
    int x = 64, y = 64;
    int width = 32, height = 32;
    Objet instance;
    Dash dash;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.instance = new Objet(x, y, width, height);
        this.dash = new Dash(32, 32);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetVelocity() {

        int expResult = 0;
        assertEquals(expResult, instance.getVelocity());
    }

    @Test
    public void testSetVelocity() {
        int param = 5;
        int expResult = param / 1;
        assertEquals(expResult, param);
    }

    @Test
    public void testContactBas() {

        assertFalse(instance.downContact(instance));
        assertFalse(instance.downContact(instance));
    }

    @Test
    public void testContactGauche() {

        assertFalse(instance.leftContact(instance));
        assertFalse(instance.leftContact(instance));

    }

    @Test
    public void testContactDroite() {
        assertFalse(instance.rightContact(instance));
        assertFalse(instance.rightContact(instance));
    }

    @Test
    public void testContactBasDash() {
        assertFalse(instance.downContactDash(dash));
        assertFalse(instance.downContactDash(dash));
    }

    @Test
    public void testProcheBas() {
        assertFalse(instance.nearDown(instance));
        assertFalse(instance.nearDown(instance));

    }

    @Test
    public void testGetX() {
        int value = instance.getX() % 32;
        int expected = 0;
        assertEquals(expected, value);
    }

    @Test
    public void testSetX() {
        int param = 64;
        int expected = param % 32;
        assertEquals(expected, param % 32);
    }

    @Test
    public void testGetY() {
        int value = instance.getY() % 32;
        int expected = 0;
        assertEquals(expected, value);
    }

    @Test
    public void testSetY() {

        int param = 64;
        int expected = param % 32;
        assertEquals(expected, param % 32);

    }

    @Test
    public void testGetFalling() {
        assertTrue(!instance.getFalling());
        assertFalse(instance.getFalling());

    }

    @Test
    public void testSetFalling() {
        boolean param = true;
        assertTrue(param);
        assertFalse(!param);
    }

    @Test
    public void testGetPushableLeft() {

        boolean param = true;
        assertTrue(param);
        assertFalse(!param);

    }

    @Test
    public void testSetPushableLeft() {

        boolean param = true;
        assertTrue(param);
        assertFalse(!param);

    }

    @Test
    public void testGetPushableRight() {
        boolean param = true;
        assertTrue(param);
        assertFalse(!param);
    }

    @Test
    public void testSetPushableRight() {
        boolean param = true;
        assertTrue(param);
        assertFalse(!param);
    }

}
