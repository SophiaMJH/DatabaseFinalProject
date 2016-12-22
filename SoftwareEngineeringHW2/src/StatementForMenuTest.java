import static org.junit.Assert.*;

import org.junit.Test;

public class StatementForMenuTest {
	final int PHONEBOOK = 1;
	final int SCHEDULE = 2;
	final int NOTE = 3;
	
	@Test
	public void testMakeStatementForViewing() {
		StatementForMenu statementForMenu = new StatementForMenu();
		String result = "SELECT * FROM phonebook";
		assertTrue(result.equals(statementForMenu.makeStatementForViewing(PHONEBOOK)));
	}
	
	@Test
	public void testMakeStatementForDeletion() {
		StatementForMenu statementForMenu = new StatementForMenu();
		String result = "DELETE FROM schedule WHERE scheduleIndex=12";
		assertTrue(result.equals(statementForMenu.makeStatementForDeletion(SCHEDULE, 12)));
	} 
	
	@Test
	public void testMakeMaxIndexString() {
		StatementForMenu statementForMenu = new StatementForMenu();
		String result = "SELECT MAX(phoneIndex) FROM phonebook";
		assertEquals(statementForMenu.makeMaxIndexString(PHONEBOOK), result);
	}
	
	@Test
	public void testMakeIsInDatabaseString() {
		StatementForMenu statementForMenu = new StatementForMenu();
		String result = "SELECT* FROM schedule";
		assertEquals(statementForMenu.makeIsInDatabaseString(SCHEDULE), result);
	}


}
