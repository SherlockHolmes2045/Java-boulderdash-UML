package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ViewPanel3Test {
	ViewPanel3 viewPanel;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.viewPanel=new ViewPanel3();
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void testViewPanel3() {

		assertNotNull(viewPanel.dash);
		assertEquals(36,viewPanel.getNbr_diamond());
		assertNotNull(viewPanel.exit1);
		assertFalse(viewPanel.isExitable());
	}

	@Test
	public void testIsExitable() {
		assertFalse(viewPanel.isExitable());
	}
	@SuppressWarnings("static-access")
	@Test 
	public void testMapImage() {
		assertNotNull(viewPanel.tabObjets);
	}


}
