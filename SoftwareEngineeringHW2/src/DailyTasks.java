import java.util.*;
import java.io.*;


<<<<<<< HEAD
class Statement{
	
	final int PHONEBOOK = 1;
	final int SCHEDULE = 2;
	final int NOTE = 3;
<<<<<<< HEAD

	private String makeDatabaseName(int state){
		String databaseName = "";
=======
	
	private String sqlStatement;
	private String databaseName;
	private String databaseAttributes;
	private String valuesForAddition;
	private int index;
	private String id;
	
	private void setIndex(int maxIndex){
		index = maxIndex;	// add 할 때의 index 넣는다.
	}
	
	private void setDatabaseName(int state){
>>>>>>> parent of 32eb892... Statement
		if(state == PHONEBOOK)
			databaseName = "PhoneBook";
		else if(state == SCHEDULE)
			databaseName = "Schedule";
		else if(state == NOTE)
			databaseName = "Note";
		else
<<<<<<< HEAD
			;//Exception
		return databaseName;
=======
			;//Exeption
>>>>>>> parent of 32eb892... Statement
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
<<<<<<< HEAD
			;//Exception
		return databaseAttributes;
=======
			;//Exeption
>>>>>>> parent of 32eb892... Statement
	}
	
	private void setValuesForAddition(int state){
		
		Scanner scan = new Scanner(System.in);
		if(state == PHONEBOOK){
			String name = "";
			String phoneNumber = "";
			
			System.out.print("name : ");
			name = scan.next();
			System.out.print("phone : ");
			phoneNumber = scan.next();
			valuesForAddition = "values("+id+", "+name+", "+phoneNumber+", "+index+")";
		}
		else if(state == SCHEDULE){
			Date date;
			int year, month, day;
			String description = "";
			
			System.out.print("date : ");
			year = scan.nextInt();
			month = scan.nextInt();
			day = scan.nextInt();
			date = new Date(year, month, day);
			
			System.out.print("description : ");
			description = scan.nextLine();
			valuesForAddition = "values("+id+", "+date+", "+description+", "+index+") ";
		}
		else if(state == NOTE){
			String note = "";
			
			System.out.print("["+index+"] note : " );
			note = scan.nextLine();
			valuesForAddition = "values("+id+", "+note+", "+index+")";;
		}
		else{
			//exception
		}
	}
	
<<<<<<< HEAD
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
	
}





class InputFromUser{
	
	final int PHONEBOOK = 1;
	final int SCHEDULE = 2;
	final int NOTE = 3;
	
	public PhoneBook queryAndSetPhoneBook(int index){
		
		Scanner scan = new Scanner(System.in);
		PhoneBook phoneBookForAddition = new PhoneBook();
		///id
		System.out.print("name : ");
		phoneBookForAddition.name = scan.nextLine();
		System.out.print("phone : ");
		phoneBookForAddition.phoneNumber = scan.nextLine();
		phoneBookForAddition.phoneIndex = index;
		return phoneBookForAddition;
	}
	
	public Schedule queryAndSetSchedule(int index){
		
		Scanner scan = new Scanner(System.in);
		Schedule scheduleForAddition = new Schedule();
		///id
		int year, month, day;
		System.out.print("date : ");
		year = scan.nextInt();
		month = scan.nextInt();
		day = scan.nextInt();
		scheduleForAddition.date = new Date(year, month, day);
		System.out.print("description : ");
		scheduleForAddition.description = scan.nextLine();
		scheduleForAddition.scheduleIndex = index;
		return scheduleForAddition;
	}
	
	public Note queryAndSetNote(int index){
		
		Scanner scan = new Scanner(System.in);
		Note noteForAddition = new Note();
		//id
		System.out.print("["+index+"] note : " );
		noteForAddition.note = scan.nextLine();
		noteForAddition.noteIndex = index;
		return noteForAddition;
	}
	
	private void queryForindexNumber(int state){
		
		if(state == PHONEBOOK){
			System.out.print("지우고 싶은 사람의 인덱스를 입력하세요: ");
		}
		else if(state == SCHEDULE){
			System.out.print("지우길 원하는 스케줄 인덱스를 입력해 주세요: ");
		}
		else if(state == NOTE){
			System.out.print("지우길 원하는 노트인덱스를 입력해 주세요 : ");
		}
		else{
			// Exception
		}
	}
	
	private void reQueryForindexNumber(int state){
		
		if(state == PHONEBOOK){
			System.out.print("번호 인덱스를 다시 입력해주세요 : ");
		}
		else if(state == SCHEDULE){
			System.out.print("스케줄 인덱스를 다시 입력해 주세요 : ");
		}
		else if(state == NOTE){
			System.out.print("노트인덱스를 다시 입력해 주세요 : ");
		}
		else{
			// Exception
		}
	}
=======
	private String makeStatementForAddition(int state, int index){
		
		setIndex(index);
		setDatabaseName(state);
		setDatabaseAttributesForAddition(state);
		setValuesForAddition(state);
		sqlStatement = "INSERT INTO " + databaseName + databaseAttributes + valuesForAddition;
		return sqlStatement;
	}
	
>>>>>>> parent of 32eb892... Statement
}

=======
class PhoneBook{
	String id;
	String name;
	String phoneNumber;
	int phoneIndex;
}

class Schedule{
	String id;
	Date date;
	String description;
	int scheduleIndex;
}

class Note{
	String id;
	String note;
	int noteIndex;
}
>>>>>>> origin/master


public class DailyTasks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
