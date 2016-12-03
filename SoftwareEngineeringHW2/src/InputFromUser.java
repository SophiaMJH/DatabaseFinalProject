import java.util.*;

public class InputFromUser {
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
}
