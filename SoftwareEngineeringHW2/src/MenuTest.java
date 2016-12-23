import static org.junit.Assert.*;

import org.junit.Test;

public class MenuTest {
	
	@Test
	public void logoutMainMenuTest() throws Exception {
		Menu menu = new Menu();
		menu.showMainMenu();
		assertEquals(menu.subMenu,0);
		}
	}
	