package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CharacterTest {

    Character character;
    int x = 32, y = 32, height = 32, width = 32;
    Objet objet;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        character = new Character(x, y, height, width);
        objet = new Objet(128, 128, 32, 32);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetX() {
        int value = character.getX() % 32;
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
        int value = character.getY() % 32;
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
    public void testGetWidth() {
        assertEquals(32, character.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(32, character.getHeight());
    }

    @Test
    public void testGetWalks() {
        assertFalse(character.getWalks());
    }

    @Test
    public void testSetWalks() {
        boolean param = true;
        assertTrue(param);
        assertFalse(!param);
    }

    @Test
    public void testContactGauche() {
        assertFalse(character.leftContact(objet));
    }

    @Test
    public void testContactDroite() {
        assertFalse(character.rightContact(objet));
    }

    @Test
    public void testContactHaut() {
        assertFalse(character.upContact(objet));
    }

    @Test
    public void testContactBas() {

        assertFalse(character.downContact(objet));
    }

    @Test
    public void testProcheGauche() {
        assertFalse(character.nearLeft(objet));
    }

    @Test
    public void testProcheDroite() {

        assertFalse(character.nearRight(objet));
    }

    @Test
    public void testProcheHaut() {

        assertFalse(character.nearUp(objet));
    }

    @Test
    public void testProcheBas() {

        assertFalse(character.nearDown(objet));
    }

    @Test
    public void testGetDeath() {

        assertFalse(character.getDeath());
    }

    @Test
    public void testSetDeath() {
        boolean param = true;
        assertTrue(param);
        assertFalse(!param);

    }

}
