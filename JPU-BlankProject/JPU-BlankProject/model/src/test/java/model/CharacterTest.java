package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Image;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private Character character;

    @BeforeEach
    void setUp() {
        character = new Character(GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE * 2, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
    }

    @Test
    void testConstructor() {
        assertEquals(GameConstants.PIXEL_SIZE, character.getX());
        assertEquals(GameConstants.PIXEL_SIZE * 2, character.getY());
        assertEquals(GameConstants.PIXEL_SIZE, character.getWidth());
        assertEquals(GameConstants.PIXEL_SIZE, character.getHeight());
        assertFalse(character.isDead(), "Character should not be dead initially");
    }

    @Test
    void testGetImgChar() {
        Image img = character.getImgChar();
        assertNotNull(img, "Character image should not be null");
    }

    @Test
    void testMovement() {
        character.setX(GameConstants.PIXEL_SIZE * 3);
        character.setY(GameConstants.PIXEL_SIZE * 4);
        assertEquals(GameConstants.PIXEL_SIZE * 3, character.getX());
        assertEquals(GameConstants.PIXEL_SIZE * 4, character.getY());
    }

    @Test
    void testDeathState() {
        character.setDead(true);
        assertTrue(character.isDead(), "Character should be marked as dead");
    }

    @Test
    void testCollisionDetection() {
        Objet objLeft = new Objet(0, GameConstants.PIXEL_SIZE * 2, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
        Objet objRight = new Objet(GameConstants.PIXEL_SIZE * 2, GameConstants.PIXEL_SIZE * 2, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
        Objet objUp = new Objet(GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
        Objet objDown = new Objet(GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE * 3, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);

        assertTrue(character.leftContact(objLeft), "Character should detect object to the left");
        assertTrue(character.rightContact(objRight), "Character should detect object to the right");
        assertTrue(character.upContact(objUp), "Character should detect object above");
        assertTrue(character.downContact(objDown), "Character should detect object below");
    }
}
