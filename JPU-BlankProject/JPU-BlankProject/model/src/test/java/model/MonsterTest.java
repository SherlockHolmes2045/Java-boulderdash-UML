package model;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for Monster class
 */
public class MonsterTest {

    private Monster monster;

    @Mock
    private Back mockBack;

    @Mock
    private Wall mockWall;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize mock objects with specific positions
        when(mockBack.getX()).thenReturn(GameConstants.PIXEL_SIZE);
        when(mockBack.getY()).thenReturn(GameConstants.PIXEL_SIZE);

        when(mockWall.getX()).thenReturn(GameConstants.PIXEL_SIZE);
        when(mockWall.getY()).thenReturn(0);

        // Create a monster at position (0,0)
        monster = new Monster(0, 0);
    }

    @Test
    void testInitialization() {
        assertEquals(0, monster.getX(), "Monster X position should be initialized correctly");
        assertEquals(0, monster.getY(), "Monster Y position should be initialized correctly");
        assertEquals(32, monster.getWidth(), "Monster width should be 32");
        assertEquals(32, monster.getHeight(), "Monster height should be 32");
        assertFalse(monster.getWalks(), "Monster should not be walking initially");
        assertFalse(monster.isGoesDown(), "Monster should not be going down initially");
        assertFalse(monster.isGoesRight(), "Monster should not be going right initially");
        assertFalse(monster.isGoesLeft(), "Monster should not be going left initially");
        assertFalse(monster.isGoesUp(), "Monster should not be going up initially");
    }

    @Test
    void testMove_Right() {
        // Set monster to walk right
        monster.setWalks(true);
        monster.setGoesRight(true);

        // Execute move
        monster.move();

        // Check new position
        assertEquals(GameConstants.PIXEL_SIZE, monster.getX(), "Monster should move right by PIXEL_SIZE");
        assertEquals(0, monster.getY(), "Monster Y position should not change");
    }

    @Test
    void testMove_Left() {
        // Place monster at a position where it can move left
        monster = new Monster(GameConstants.PIXEL_SIZE, 0);

        // Set monster to walk left
        monster.setWalks(true);
        monster.setGoesLeft(true);

        // Execute move
        monster.move();

        // Check new position
        assertEquals(0, monster.getX(), "Monster should move left by PIXEL_SIZE");
        assertEquals(0, monster.getY(), "Monster Y position should not change");
    }

    @Test
    void testMove_Up() {
        // Place monster at a position where it can move up
        monster = new Monster(0, GameConstants.PIXEL_SIZE);

        // Set monster to walk up
        monster.setWalks(true);
        monster.setGoesUp(true);

        // Execute move
        monster.move();

        // Check new position
        assertEquals(0, monster.getX(), "Monster X position should not change");
        assertEquals(0, monster.getY(), "Monster should move up by PIXEL_SIZE");
    }

    @Test
    void testMove_Down() {
        // Set monster to walk down
        monster.setWalks(true);
        monster.setGoesDown(true);

        // Execute move
        monster.move();

        // Check new position
        assertEquals(0, monster.getX(), "Monster X position should not change");
        assertEquals(GameConstants.PIXEL_SIZE, monster.getY(), "Monster should move down by PIXEL_SIZE");
    }

    @Test
    void testMove_NotWalking() {
        // Set monster to not walk but with a direction
        monster.setWalks(false);
        monster.setGoesRight(true);

        // Initial position
        int initialX = monster.getX();
        int initialY = monster.getY();

        // Execute move
        monster.move();

        // Position should not change
        assertEquals(initialX, monster.getX(), "Monster X position should not change when not walking");
        assertEquals(initialY, monster.getY(), "Monster Y position should not change when not walking");
    }

    @Test
    void testCanMoveRight() {
        // Position Back object one space to the right of monster
        when(mockBack.getX()).thenReturn(GameConstants.PIXEL_SIZE);
        when(mockBack.getY()).thenReturn(0);

        assertTrue(monster.canMoveRight(mockBack), "Monster should be able to move right into Back object");

        // Test with Wall object
        assertFalse(monster.canMoveRight(mockWall), "Monster should not be able to move right into Wall object");

        // Test with null object
        assertFalse(monster.canMoveRight(null), "Monster should not be able to move right into null object");
    }

    @Test
    void testCanMoveLeft() {
        // Create monster at position that can move left
        monster = new Monster(GameConstants.PIXEL_SIZE, 0);

        // Position Back object one space to the left of monster
        when(mockBack.getX()).thenReturn(0);
        when(mockBack.getY()).thenReturn(0);

        assertTrue(monster.canMoveLeft(mockBack), "Monster should be able to move left into Back object");

        // Test with Wall object
        when(mockWall.getX()).thenReturn(0);
        assertFalse(monster.canMoveLeft(mockWall), "Monster should not be able to move left into Wall object");
    }

    @Test
    void testCanMoveUp() {
        // Create monster at position that can move up
        monster = new Monster(0, GameConstants.PIXEL_SIZE);

        // Position Back object one space above monster
        when(mockBack.getX()).thenReturn(0);
        when(mockBack.getY()).thenReturn(0);

        assertTrue(monster.canMoveUp(mockBack), "Monster should be able to move up into Back object");

        // Test with Wall object
        when(mockWall.getX()).thenReturn(0);
        when(mockWall.getY()).thenReturn(0);
        assertFalse(monster.canMoveUp(mockWall), "Monster should not be able to move up into Wall object");
    }

    @Test
    void testCanMoveDown() {
        // Position Back object one space below monster
        when(mockBack.getX()).thenReturn(0);
        when(mockBack.getY()).thenReturn(GameConstants.PIXEL_SIZE);

        assertTrue(monster.canMoveDown(mockBack), "Monster should be able to move down into Back object");

        // Test with Wall object
        when(mockWall.getX()).thenReturn(0);
        when(mockWall.getY()).thenReturn(GameConstants.PIXEL_SIZE);
        assertFalse(monster.canMoveDown(mockWall), "Monster should not be able to move down into Wall object");
    }

    @Test
    void testDoesNotMoveRight() {
        // Position Wall object one space to the right of monster
        when(mockWall.getX()).thenReturn(GameConstants.PIXEL_SIZE);
        when(mockWall.getY()).thenReturn(0);

        assertTrue(monster.doesNotMoveRight(mockWall), "Monster should not move right when Wall is present");

        // Test with Back object
        assertFalse(monster.doesNotMoveRight(mockBack), "Monster should be able to move right when Back is present");
    }

    @Test
    void testDoesNotMoveLeft() {
        // Create monster at position that can test left movement
        monster = new Monster(GameConstants.PIXEL_SIZE, 0);

        // Position Wall object one space to the left of monster
        when(mockWall.getX()).thenReturn(0);
        when(mockWall.getY()).thenReturn(0);

        assertTrue(monster.doesNotMoveLeft(mockWall), "Monster should not move left when Wall is present");

        // Test with Back object
        when(mockBack.getX()).thenReturn(0);
        when(mockBack.getY()).thenReturn(0);
        assertFalse(monster.doesNotMoveLeft(mockBack), "Monster should be able to move left when Back is present");
    }

    @Test
    void testDoesNotMoveUp() {
        // Create monster at position that can test up movement
        monster = new Monster(0, GameConstants.PIXEL_SIZE);

        // Position Wall object one space above monster
        when(mockWall.getX()).thenReturn(0);
        when(mockWall.getY()).thenReturn(0);

        assertTrue(monster.doesNotMoveUp(mockWall), "Monster should not move up when Wall is present");

        // Test with Back object
        when(mockBack.getX()).thenReturn(0);
        when(mockBack.getY()).thenReturn(0);
        assertFalse(monster.doesNotMoveUp(mockBack), "Monster should be able to move up when Back is present");
    }

    @Test
    void testDoesNotMoveDown() {
        // Position Wall object one space below monster
        when(mockWall.getX()).thenReturn(0);
        when(mockWall.getY()).thenReturn(GameConstants.PIXEL_SIZE);

        assertTrue(monster.doesNotMoveDown(mockWall), "Monster should not move down when Wall is present");

        // Test with Back object
        when(mockBack.getX()).thenReturn(0);
        when(mockBack.getY()).thenReturn(GameConstants.PIXEL_SIZE);
        assertFalse(monster.doesNotMoveDown(mockBack), "Monster should be able to move down when Back is present");
    }

    @Test
    void testDirectionSetters() {
        // Test all direction setters
        monster.setGoesRight(true);
        assertTrue(monster.isGoesRight(), "Monster should be going right after setter");

        monster.setGoesLeft(true);
        assertTrue(monster.isGoesLeft(), "Monster should be going left after setter");

        monster.setGoesUp(true);
        assertTrue(monster.isGoesUp(), "Monster should be going up after setter");

        monster.setGoesDown(true);
        assertTrue(monster.isGoesDown(), "Monster should be going down after setter");
    }
}
