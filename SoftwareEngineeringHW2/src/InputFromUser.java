import java.text.ParseException;
import java.util.*;

public class InputFromUser {
	final int PHONEBOOK = 2;
	final int SCHEDULE = 3;
	final int NOTE = 4;
	
	public PhoneBook queryAndSetPhoneBook(int index) {
		
		Scanner scan = new Scanner(System.in);
		PhoneBook phoneBookForAddition = new PhoneBook();
		System.out.print("name : ");
		phoneBookForAddition.name = scan.nextLine();
		System.out.print("phone : ");
		phoneBookForAddition.phoneNumber = scan.nextLine();
		phoneBookForAddition.phoneIndex = index;
		return phoneBookForAddition;
	}
	
	public Schedule queryAndSetSchedule(int index) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		Schedule scheduleForAddition = new Schedule();
		int year, month, day;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy mm dd");
		System.out.print("date : ");
		String dateString = scan.nextLine();
		scheduleForAddition.date = format.parse(dateString);
		System.out.println("description : ");
		scheduleForAddition.description = scan.nextLine();
		scheduleForAddition.scheduleIndex = index;
		return scheduleForAddition;
	}
	
	public Note queryAndSetNote(int index) {
		Scanner scan = new Scanner(System.in);
		Note noteForAddition = new Note();
		System.out.print("["+index+"] note : " );
		noteForAddition.note = scan.nextLine();
		noteForAddition.noteIndex = index;
		return noteForAddition;
	}
	
	public int queryForindexNumber(int mainMenu) {
		Scanner scan = new Scanner(System.in);
		int selectedIndex;
		if(mainMenu == PHONEBOOK) {
			System.out.print("지우고 싶은 사람의 인덱스를 입력하세요: ");
		}
		else if(mainMenu == SCHEDULE) {
			System.out.print("지우길 원하는 스케줄 인덱스를 입력해 주세요: ");
		}
		else if(mainMenu == NOTE) {
			System.out.print("지우길 원하는 노트인덱스를 입력해 주세요 : ");
		}
		else{
			// Exception
		}
		selectedIndex = scan.nextInt();
		return selectedIndex;
	}
	
	
	public int reQueryForindexNumber(int mainMenu) {
		Scanner scan = new Scanner(System.in);
		int selectedIndex;
		if(mainMenu == PHONEBOOK) {
			System.out.print("번호 인덱스를 다시 입력해주세요 : ");
		}
		else if(mainMenu == SCHEDULE) {
			System.out.print("스케줄 인덱스를 다시 입력해 주세요 : ");
		}
		else if(mainMenu == NOTE) {
			System.out.print("노트인덱스를 다시 입력해 주세요 : ");
		}
		else{
			// Exception
		}
		selectedIndex = scan.nextInt();
		return selectedIndex;
	}
}
