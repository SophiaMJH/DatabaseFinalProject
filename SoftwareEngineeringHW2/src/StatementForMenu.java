import java.util.*;

public class StatementForMenu {
	final int PHONEBOOK = 1;
	final int SCHEDULE = 2;
	final int NOTE = 3;
	private String sqlStatement="";

	public String makeStatementForAddition(int mainMenu, int maxIndex) {
		sqlStatement = "INSERT INTO " 
						+ makeDatabaseName(mainMenu)
						+ makeAttributesStringForAddition(mainMenu)
						+ makeValueStringForAddition(mainMenu, maxIndex);
		return sqlStatement;
	}
	
	private String makeStatementForViewing(int mainMenu) {
		sqlStatement = "SELECT * FROM " + makeDatabaseName(mainMenu);
		return sqlStatement;
	}
	
	String makeStatementForDeletion(int mainMenu, int index) {
		sqlStatement = "DELETE FROM " + makeDatabaseName(mainMenu)
						+ "WHERE " + makeIndexName(mainMenu) + "=" 
						+ Integer.toString(index);
		return sqlStatement;
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
	
	private String makeAttributesStringForAddition(int mainMenu) {
		String databaseAttributes = "";
		if(mainMenu == PHONEBOOK)
			databaseAttributes = "(id, name, phoneNumber, phoneIndex ) ";
		else if(mainMenu == SCHEDULE)
			databaseAttributes = "(id, date, description, scheduleIndex ) ";
		else if(mainMenu == NOTE)
			databaseAttributes = "(id, note, noteIndex ) ";
		else
			;//Exception
		return databaseAttributes;
	}
	
	private String makeValueStringForAddition(int mainMenu, int maxIndex) {
		Scanner scan = new Scanner(System.in);
		String valuesForAddition = "";
		InputFromUser inputFromUser = new InputFromUser();
		if(mainMenu == PHONEBOOK) {
			PhoneBook valuesForPhoneBook = inputFromUser.queryAndSetPhoneBook(maxIndex);
			valuesForAddition = "values("
								+ valuesForPhoneBook.id + ", "
								+ valuesForPhoneBook.name +", "
								+ valuesForPhoneBook.phoneNumber + ", "
								+ valuesForPhoneBook.phoneIndex + ")";
		}
		else if(mainMenu == SCHEDULE) {
			Schedule valuesForSchedule = inputFromUser.queryAndSetSchedule(maxIndex);
			valuesForAddition = "values("
								+ valuesForSchedule.id + ", "
								+ valuesForSchedule.date + ", "
								+ valuesForSchedule.description + ", "
								+ valuesForSchedule.scheduleIndex + ") ";
		}
		else if(mainMenu == NOTE) {
			Note valuesForNote = inputFromUser.queryAndSetNote(maxIndex);
			valuesForAddition = "values(" 
								+ valuesForNote.id + ", "
								+ valuesForNote.note + ", "
								+ valuesForNote.noteIndex + ")";
		}
		else {
			//exception
		}
		return valuesForAddition;
	}
	
	private String makeIndexName(int mainMenu) {
		String indexName = "";
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
	

}
