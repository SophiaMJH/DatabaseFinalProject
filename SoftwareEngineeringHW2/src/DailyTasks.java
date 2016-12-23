import java.util.*;
import java.io.*;
import java.sql.SQLException;


class PhoneBook{
	String name;
	String phoneNumber;
	int phoneIndex;
}

class Schedule{
	String date;
	String description;
	int scheduleIndex;
}

class Note{
	String note;
	int noteIndex;
}


public class DailyTasks {

	public static void main(String[] args) throws Exception {
		AccountManager accountManager = new AccountManager();
		accountManager.login();
		Menu start = new Menu();
		start.showMainMenu();
	}

}
