import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StatementForMenuTest {
	final int PHONEBOOK = 2;
	final int SCHEDULE = 3;
	final int NOTE = 4;
	Account account = new Account();
	
	@Before
	public void setUp() {
		account.setId("abc");
	}
	
	@Test
	public void testMakeStatementForViewing() {
		StatementForMenu statementForMenu = new StatementForMenu();
		String expectedOutput = "SELECT * FROM phonebook WHERE id='abc'";
		assertTrue(expectedOutput.equals(statementForMenu.makeStatementForViewing(PHONEBOOK)));
	}
	
	@Test
	public void testMakeStatementForDeletion() {
		StatementForMenu statementForMenu = new StatementForMenu();
		String expectedOutput = "DELETE FROM schedule WHERE scheduleIndex='12' AND id='abc'";
		assertTrue(expectedOutput.equals(statementForMenu.makeStatementForDeletion(SCHEDULE, 12)));
	} 
	
	@Test
	public void testMakeMaxIndexString() {
		StatementForMenu statementForMenu = new StatementForMenu();
		String expectedOutput = "SELECT MAX(phoneIndex) FROM phonebook WHERE id='abc'";
		assertEquals(statementForMenu.makeMaxIndexString(PHONEBOOK), expectedOutput);
	}
	
	@Test
	public void testMakeIsInDatabaseString() {
		StatementForMenu statementForMenu = new StatementForMenu();
		String expectedOutput = "SELECT * FROM schedule WHERE scheduleIndex='12' AND id='abc'";
		assertEquals(statementForMenu.makeIsInDatabaseString("scheduleIndex", SCHEDULE, 12), expectedOutput);
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
