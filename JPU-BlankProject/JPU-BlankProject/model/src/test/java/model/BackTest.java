package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.Image;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

public class BackTest {
    private Back back;
    private static final Logger logger = Logger.getLogger(BackTest.class.getName());

    @BeforeEach
    void setUp() {
        back = new Back(GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE * 2);
    }

    @Test
    void testConstructor() {
        assertEquals(GameConstants.PIXEL_SIZE, back.getX());
        assertEquals(GameConstants.PIXEL_SIZE * 2, back.getY());
    }

    @Test
    void testGetImgObj() {
        Image img = back.getImgObj();
        assertNotNull(img, "Image should not be null");
    }

    @Test
    void testToString() {
        String expected = "Back{x=" + GameConstants.PIXEL_SIZE + ", y=" + GameConstants.PIXEL_SIZE * 2 + ", width=" + GameConstants.PIXEL_SIZE + ", height=" + GameConstants.PIXEL_SIZE + "}";
        assertEquals(expected, back.toString());
    }

    @Test
    void testImageLoadingFailure() {
        Back faultyBack = new Back(10, 20) {
            @Override
            public Image getImgObj() {
                try {
                    this.icoObj = new ImageIcon(Objects.requireNonNull(getClass().getResource("invalid_path.png")));
                    this.imgObj = this.icoObj.getImage();
                } catch (NullPointerException e) {
                    logger.log(Level.SEVERE, "Resource not found: invalid_path.png", e);
                    this.imgObj = null;
                }
                return this.imgObj;
            }
        };

        assertNull(faultyBack.getImgObj(), "Image should be null for invalid path");
    }


    @Test
    void testDownContact() {
        Objet obj = new Objet(back.getX(), back.getY() + GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
        assertTrue(back.downContact(obj), "Back should detect object below it");
    }

    @Test
    void testLeftContact() {
        Objet obj = new Back(0, back.getY());
        assertTrue(back.leftContact(obj), "Back should detect object to the left");
    }

    @Test
    void testRightContact() {
        Objet obj = new Back(back.getX() + GameConstants.PIXEL_SIZE, back.getY());
        assertTrue(back.rightContact(obj), "Back should detect object to the right");
    }
}
