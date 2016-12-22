import java.util.*;
import java.io.*;
import java.sql.SQLException;


class PhoneBook{
	String id;
	String name;
	String phoneNumber;
	int phoneIndex;
	
	PhoneBook() {
		Account account = new Account();
		id = account.getId();
	}
}

class Schedule{
	String id;
	Date date;
	String description;
	int scheduleIndex;
	
	Schedule() {
		Account account = new Account();
		id = account.getId();
	}
}

class Note{
	String id;
	String note;
	int noteIndex;
	
	Note() {
		Account account = new Account();
		id = account.getId();
	}
}


public class DailyTasks {

	public static void main(String[] args) throws SQLException {
		AccountManager accountManager = new AccountManager();
		accountManager.login();
		Menu startProgram = new Menu();
		startProgram.showMainMenu();

	}

}
