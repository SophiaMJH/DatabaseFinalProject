import java.sql.SQLException;
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
	
	public String makeStatementForViewing(int mainMenu) {
		sqlStatement = "SELECT * FROM " + makeDatabaseName(mainMenu);
		return sqlStatement;
	}
	
	public String makeStatementForDeletion(int mainMenu, int index) {
		sqlStatement = "DELETE FROM " + makeDatabaseName(mainMenu)
						+ "WHERE " + makeIndexName(mainMenu) + "=" 
						+ Integer.toString(index);
		return sqlStatement;
	}
	public String makeMaxIndexString(int mainMenu){
		String sqlStatement = "";
		if(mainMenu == PHONEBOOK)
			sqlStatement = "SELECT MAX(phoneIndex) FROM PhoneBook";
		else if(mainMenu == SCHEDULE)
			sqlStatement = "SELECT MAX(scheduleIndex) FROM Schedule";
		else if(mainMenu == NOTE)
			sqlStatement = "SELECT MAX(noteIndex) FROM Note";
		return sqlStatement;
	}
	
	public String makeIsInDatabaseString(int mainMenu){
		String sqlStatement = "";
		if(mainMenu == PHONEBOOK)
			sqlStatement = "SELECT * FROM PhoneBook";
		else if(mainMenu == SCHEDULE)
			sqlStatement = "SELECT* FROM Schedule";
		else if(mainMenu == NOTE)
			sqlStatement = "SELECT * FROM Note";
		return sqlStatement;
	}
	
	private String makeDatabaseName(int mainMenu) {
		String databaseName = "";
		if(mainMenu == PHONEBOOK)
			databaseName = "PhoneBook";
		else if(mainMenu == SCHEDULE)
			databaseName = "Schedule";
		else if(mainMenu == NOTE)
			databaseName = "Note";
		else
			;//Exception
		return databaseName;
	}
	
	private String makeAttributesStringForAddition(int mainMenu) {
		String databaseAttributes = "";
		if(mainMenu == PHONEBOOK)
			databaseAttributes = " (id, name, phoneNumber, phoneIndex) ";
		else if(mainMenu == SCHEDULE)
			databaseAttributes = " (id, date, description, scheduleIndex) ";
		else if(mainMenu == NOTE)
			databaseAttributes = " (id, note, noteIndex) ";
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
			valuesForAddition = "VALUES ("
								+ valuesForPhoneBook.id + ", "
								+ valuesForPhoneBook.name +", "
								+ valuesForPhoneBook.phoneNumber + ", "
								+ valuesForPhoneBook.phoneIndex + ")";
		}
		else if(mainMenu == SCHEDULE) {
			Schedule valuesForSchedule = inputFromUser.queryAndSetSchedule(maxIndex);
			valuesForAddition = "VALUES ("
								+ valuesForSchedule.id + ", "
								+ valuesForSchedule.date + ", "
								+ valuesForSchedule.description + ", "
								+ valuesForSchedule.scheduleIndex + ")";
		}
		else if(mainMenu == NOTE) {
			Note valuesForNote = inputFromUser.queryAndSetNote(maxIndex);
			valuesForAddition = "VALUES (" 
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
