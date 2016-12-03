import java.util.*;

public class StatementForMenu {
	final int PHONEBOOK = 1;
	final int SCHEDULE = 2;
	final int NOTE = 3;

	private String makeStatementForAddition(int state, int maxIndex){
		String sqlStatement;
		sqlStatement = "INSERT INTO " 
						+ makeDatabaseName(state)
						+ makeAttributesStringForAddition(state)
						+ makeValueStringForAddition(state, maxIndex);
		return sqlStatement;
	}
	
	private String makeStatementforViewing(int state){
		String sqlStatement;
		sqlStatement = "SELECT * FROM " + makeDatabaseName(state);
		return sqlStatement;
	}
	
	private String deleteStatementforViewing(int state, int selectedIndex){
		String sqlStatement;
		sqlStatement = "DELETE FROM " + makeDatabaseName(state)
						+ "WHERE " + makeIndexName(state) + "=" + selectedIndex;
		return sqlStatement;
	}
	
	private String makeDatabaseName(int state){
		String databaseName = "";
		if(state == PHONEBOOK)
			databaseName = "PhoneBook";
		else if(state == SCHEDULE)
			databaseName = "Schedule";
		else if(state == NOTE)
			databaseName = "Note";
		else
			;//Exception
		return databaseName;
	}
	
	private String makeAttributesStringForAddition(int state){
		
		String databaseAttributes = "";
		if(state == PHONEBOOK)
			databaseAttributes = "(id, name, phoneNumber, phoneIndex ) ";
		else if(state == SCHEDULE)
			databaseAttributes = "(id, date, description, scheduleIndex ) ";
		else if(state == NOTE)
			databaseAttributes = "(id, note, noteIndex ) ";
		else
			;//Exception
		return databaseAttributes;
	}
	
	private String makeValueStringForAddition(int state, int maxIndex){
		
		Scanner scan = new Scanner(System.in);
		String valuesForAddition = "";
		InputFromUser inputFromUser = new InputFromUser();
		if(state == PHONEBOOK){
			PhoneBook valuesForPhoneBook = inputFromUser.queryAndSetPhoneBook(maxIndex);
			valuesForAddition = "values("
								+ valuesForPhoneBook.id + ", "
								+ valuesForPhoneBook.name +", "
								+ valuesForPhoneBook.phoneNumber + ", "
								+ valuesForPhoneBook.phoneIndex + ")";
		}
		else if(state == SCHEDULE){
			Schedule valuesForSchedule = inputFromUser.queryAndSetSchedule(maxIndex);
			valuesForAddition = "values("
								+ valuesForSchedule.id + ", "
								+ valuesForSchedule.date + ", "
								+ valuesForSchedule.description + ", "
								+ valuesForSchedule.scheduleIndex + ") ";
		}
		else if(state == NOTE){
			Note valuesForNote = inputFromUser.queryAndSetNote(maxIndex);
			valuesForAddition = "values(" 
								+ valuesForNote.id + ", "
								+ valuesForNote.note + ", "
								+ valuesForNote.noteIndex + ")";
		}
		else{
			//exception
		}
		return valuesForAddition;
	}
	
	private String makeIndexName(int state){
		String indexName = "";
		if(state == PHONEBOOK)
			indexName = "phoneIndex";
		else if(state == SCHEDULE)
			indexName = "scheduleIndex";
		else if(state == NOTE)
			indexName = "noteIndex";
		else
			;
		return indexName;
	}

}
