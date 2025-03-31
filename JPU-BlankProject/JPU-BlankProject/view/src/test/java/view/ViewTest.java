//package view;
//
//import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import contract.ControllerOrder;
//
//public class ViewTest {
//    View view;
//
//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        view = new View();
//    }
//
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @SuppressWarnings("static-access")
//    @Test
//    public void testKeyCodeToControllerOrder() {
//        final int left = 37;
//        final int right = 39;
//        final int up = 38;
//        final int down = 40;
//        ControllerOrder order1 = view.keyCodeToControllerOrder(left);
//        ControllerOrder order2 = view.keyCodeToControllerOrder(up);
//        ControllerOrder order3 = view.keyCodeToControllerOrder(right);
//        ControllerOrder order4 = view.keyCodeToControllerOrder(down);
//
//        assertNotNull(order1);
//        assertNotNull(order2);
//        assertNotNull(order3);
//        assertNotNull(order4);
//        assertEquals(ControllerOrder.LEFT, order1);
//        assertEquals(ControllerOrder.RIGHT, order3);
//        assertEquals(ControllerOrder.UP, order2);
//        assertEquals(ControllerOrder.DOWN, order4);
//
//    }
//
//
//}
