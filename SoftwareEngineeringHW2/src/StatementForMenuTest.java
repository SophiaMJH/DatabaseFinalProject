import static org.junit.Assert.*;

import org.junit.Test;

public class StatementForMenuTest {
	final int PHONEBOOK = 2;
	final int SCHEDULE = 3;
	final int NOTE = 4;
	
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
	
	
	@Test
	public void makeIndextest() {
		assertNull(makeIndexName(5));
	}
	
	@Test
	public void makeDatabaseNametest(){
		assertTrue(makeDatabaseName(4)=="note");
	}
	
	
	private String makeIndexName(int mainMenu) {
		String indexName = null;
		if(mainMenu == PHONEBOOK)
			indexName = "phoneIndex";
		else if(mainMenu == SCHEDULE)
			indexName = "scheduleIndex";
		else if(mainMenu == NOTE)
			indexName = "noteIndex";
		else
			;
		return indexName;
	}
	
	private String makeDatabaseName(int mainMenu) {
		String databaseName = "";
		if(mainMenu == PHONEBOOK)
			databaseName = "phonebook";
		else if(mainMenu == SCHEDULE)
			databaseName = "schedule";
		else if(mainMenu == NOTE)
			databaseName = "note";
		else
			;//Exception
		return databaseName;
	}

}
