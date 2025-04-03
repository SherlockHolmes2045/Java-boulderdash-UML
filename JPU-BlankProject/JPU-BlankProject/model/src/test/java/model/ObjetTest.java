package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ObjetTest {
    int x = 64, y = 64;
    int width = 32, height = 32;
    Objet instance;
    Dash dash;

    @Before
    public void setUp() {
        this.instance = new Objet(x, y, width, height);
        this.dash = new Dash(32, 32);
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

}
