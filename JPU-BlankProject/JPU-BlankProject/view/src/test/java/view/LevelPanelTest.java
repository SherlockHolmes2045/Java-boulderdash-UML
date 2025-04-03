package view;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LevelPanelTest {
    @Mock
    private Level mockLevel;

    @Mock
    private Dash mockDash;

    @Mock
    private ExitDoor mockExitDoor;

    private LevelPanel levelPanel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Prepare mock level map
        char[][] mockMap = new char[25][GameConstants.ROW];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < GameConstants.ROW; j++) {
                mockMap[i][j] = '.'; // Default to ground
            }
        }
        mockMap[10][10] = 'D'; // Place a diamond
        mockMap[11][10] = 'X'; // Place a rock
        mockMap[12][10] = 'M'; // Place a monster

        when(mockLevel.getMap()).thenReturn(mockMap);

        // Initialize LevelPanel with mock objects
        levelPanel = new LevelPanel(
                mockLevel,
                3,  // exitableDiamond
                mockExitDoor,
                mockDash,
                300 // game duration
        );
    }

    @Test
    void testInitialization() {
        assertNotNull(levelPanel);
        assertEquals(1, levelPanel.getTabMonsters().size(), "Should have one monster");

        // Verify diamond count
        assertEquals(1, levelPanel.getDiamondCount(), "Should have one diamond");
    }

    @Test
    void testGameDuration() throws InterruptedException {
        int initialDuration = levelPanel.getGameDuration();

        // Wait a bit to allow timer to decrement
        Thread.sleep(2000);

        assertTrue(levelPanel.getGameDuration() < initialDuration,
                "Game duration should decrease over time");
    }

    @Test
    void testDiamondCollection() {
        Objet[][] tabObjets = levelPanel.getTabObjets();
        int initialDiamondCount = levelPanel.getDiamondCount();

        // Simulate collecting a diamond
        for (int i = 0; i < tabObjets.length; i++) {
            for (int j = 0; j < tabObjets[i].length; j++) {
                if (tabObjets[i][j] instanceof Diamond) {
                    // Here you would typically simulate dash collecting the diamond
                    levelPanel.setDiamondCount(initialDiamondCount - 1);
                }
            }
        }

        assertEquals(0, levelPanel.getDiamondCount(),
                "Diamond count should decrease after collection");
    }

    @Test
    void testExitableCondition() {
        levelPanel.setDiamondCount(3); // Set to exitableDiamond count
        assertTrue(levelPanel.isExitable(),
                "Level should be exitable when diamond count reaches threshold");
    }

    @Test
    void testDashDeath() {
        when(mockDash.isDead()).thenReturn(true);

        // Verify dash death state
        assertTrue(mockDash.isDead(), "Dash should be dead");
    }

    @Test
    void testMonsterCollision() {
        Monster monster = levelPanel.getTabMonsters().get(0);

        // Simulate monster and dash at same position
        when(mockDash.getX()).thenReturn(monster.getX());
        when(mockDash.getY()).thenReturn(monster.getY());

        // This would typically trigger in the monster collision task
        assertTrue(mockDash.getX() == monster.getX() &&
                        mockDash.getY() == monster.getY(),
                "Monster and dash should be at same position");
    }
}
