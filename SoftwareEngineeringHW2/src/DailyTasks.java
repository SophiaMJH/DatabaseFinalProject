import java.util.*;
import java.io.*;


class Statement{
	
	final int PHONEBOOK = 1;
	final int SCHEDULE = 2;
	final int NOTE = 3;
	
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
		if(state == PHONEBOOK)
			databaseName = "PhoneBook";
		else if(state == SCHEDULE)
			databaseName = "Schedule";
		else if(state == NOTE)
			databaseName = "Note";
		else
			;//Exeption
	}
	
	private void setDatabaseAttributesForAddition(int state){
		if(state == PHONEBOOK)
			databaseAttributes = "(id, name, phoneNumber, phoneIndex ) ";
		else if(state == SCHEDULE)
			databaseAttributes = "(id, date, description, scheduleIndex ) ";
		else if(state == NOTE)
			databaseAttributes = "(id, note, noteIndex ) ";
		else
			;//Exeption
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
	
	private String makeStatementForAddition(int state, int index){
		
		setIndex(index);
		setDatabaseName(state);
		setDatabaseAttributesForAddition(state);
		setValuesForAddition(state);
		sqlStatement = "INSERT INTO " + databaseName + databaseAttributes + valuesForAddition;
		return sqlStatement;
	}
	
}



public class DailyTasks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
