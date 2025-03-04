
package model;

import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class BackTest {

    private static final Logger logger = Logger.getLogger(BackTest.class.getName());

    // Constructor initializes Back object with correct x,y coordinates and default dimensions
    @Test
    public void test_back_constructor_initialization() {
        int x = 100;
        int y = 200;
        Back back = new Back(x, y);

        assertEquals(x, back.getX());
        assertEquals(y, back.getY());
        assertEquals(32, back.width);
        assertEquals(32, back.height);
    }

    // Handle missing or invalid image resource path
    @Test
    public void test_back_missing_image_resource() throws IllegalAccessException, NoSuchFieldException {
        Back back = new Back(0, 0);
        Field imagePathField = Back.class.getDeclaredField("IMAGE_PATH");
        imagePathField.setAccessible(true);
        imagePathField.set(back, "/invalid/path.png");

        Image result = back.getImgObj();

        assertNull(result);
        //verify(logger).log(Level.SEVERE, "Resource not found: /invalid/path.png", NullPointerException.class);
    }

    // toString returns correctly formatted string with object properties
    @Test
    public void test_to_string_format() {
        int x = 10;
        int y = 20;
        Back back = new Back(x, y);

        String expectedString = "Back{x=10, y=20, width=32, height=32}";
        assertEquals(expectedString, back.toString());
    }

    // getImgObj loads and returns image successfully when resource exists
    @Test
    public void test_get_img_obj_loads_image_successfully() {
        Back back = new Back(0, 0);
        Image image = back.getImgObj();

        assertNotNull("Image should not be null when resource exists", image);
    }

    // Inheritance from Objet class works properly with all inherited fields
    @Test
    public void test_inherited_fields_initialization() {
        int x = 50;
        int y = 75;
        Back back = new Back(x, y);

        assertEquals(x, back.getX());
        assertEquals(y, back.getY());
        assertEquals(32, back.width);
        assertEquals(32, back.height);
        assertEquals(0, back.getCounter());
        assertFalse(back.getFalling());
        assertFalse(back.getPushableLeft());
        assertFalse(back.getPushableRight());
    }

    // Handle null pointer exceptions during image loading
    @Test
    public void test_image_loading_handles_null_pointer_exception() {
        Back back = new Back(0, 0);
        Image image = back.getImgObj();
        assertNull(image);
    }

    // Test behavior when x,y coordinates are negative
    @Test
    public void test_back_negative_coordinates() {
        int x = -50;
        int y = -100;
        Back back = new Back(x, y);

        assertEquals(x, back.getX());
        assertEquals(y, back.getY());
        assertEquals(32, back.width);
        assertEquals(32, back.height);
    }

    // Image loading is lazy - only happens on first getImgObj call
    @Test
    public void test_lazy_image_loading() {
        Back back = new Back(0, 0);

        // Initially, imgObj should be null
        assertNull(back.imgObj);

        // Call getImgObj to trigger lazy loading
        Image firstCallImage = back.getImgObj();

        // After first call, imgObj should be initialized
        assertNotNull(back.imgObj);

        // Call getImgObj again and ensure the same image is returned
        Image secondCallImage = back.getImgObj();
        assertSame(firstCallImage, secondCallImage);
    }

    // Test behavior when x,y coordinates are very large numbers
    @Test
    public void test_back_large_coordinates() {
        int largeX = Integer.MAX_VALUE;
        int largeY = Integer.MAX_VALUE;
        Back back = new Back(largeX, largeY);

        assertEquals(largeX, back.getX());
        assertEquals(largeY, back.getY());
        assertEquals(32, back.width);
        assertEquals(32, back.height);
    }

    // Check image dimensions match the hardcoded 32x32 size
    @Test
    public void test_back_image_dimensions() {
        Back back = new Back(0, 0);
        Image image = back.getImgObj();
        assertNotNull(image);
        assertEquals(32, image.getWidth(null));
        assertEquals(32, image.getHeight(null));
    }

    // Test behavior when image file is corrupted or invalid format
    @Test
    public void test_get_img_obj_with_invalid_image_path() {
        Back back = new Back(0, 0);
        TestHandler handler = new TestHandler();
        logger.addHandler(handler);

        // Simulate invalid image path by setting icoObj to null
        back.icoObj = null;
        back.imgObj = null;

        Image image = back.getImgObj();

        assertNull(image);
        assertTrue(handler.getLogMessages().contains("Resource not found: /images/solnoir.png"));

        logger.removeHandler(handler);
    }

    private static class TestHandler extends Handler {
        private final StringBuilder logMessages = new StringBuilder();

        @Override
        public void publish(LogRecord record) {
            logMessages.append(record.getMessage());
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() throws SecurityException {
        }

        public String getLogMessages() {
            return logMessages.toString();
        }
    }

    // Test inheritance of collision detection methods from parent class
    @Test
    public void test_collision_detection_methods_inheritance() {
        Back back1 = new Back(100, 200);
        Back back2 = new Back(100, 232); // Positioned to collide with back1 on downContact
        Back back3 = new Back(68, 200); // Positioned to collide with back1 on rightContact

        assertTrue(back1.downContact(back2));
        assertFalse(back1.downContact(back3));

        assertTrue(back1.rightContact(back3));
        assertFalse(back1.rightContact(back2));
    }

    // Ensure image caching works - subsequent getImgObj calls return same instance
    @Test
    public void test_getImgObj_caches_image_instance() {
        Back back = new Back(0, 0);
        Image firstCallImage = back.getImgObj();
        Image secondCallImage = back.getImgObj();

        assertNotNull(firstCallImage);
        assertSame(firstCallImage, secondCallImage);
    }

    // Verify logger properly records errors when image loading fails
    @Test
    public void test_logger_records_error_on_image_load_failure() {
        TestHandler handler = new TestHandler();
        logger.addHandler(handler);

        Back back = new Back(0, 0);

        // Simulate resource not found by setting the path to null
        //back.setImgObj(null);

        back.getImgObj();

        assertTrue(handler.getLogMessages().contains("Resource not found: /images/solnoir.png"));

        logger.removeHandler(handler);
    }


}