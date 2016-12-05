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
	
	public int queryForindexNumber(int state){
		int selectedIndex=0;
		Scanner scan = new Scanner(System.in);
		if(state == PHONEBOOK){
			System.out.print("����� ���� ����� �ε����� �Է��ϼ���: ");
			selectedIndex=scan.nextInt();
		}
		else if(state == SCHEDULE){
			System.out.print("����� ���ϴ� ������ �ε����� �Է��� �ּ���: ");
			selectedIndex=scan.nextInt();
		}
		else if(state == NOTE){
			System.out.print("����� ���ϴ� ��Ʈ�ε����� �Է��� �ּ��� : ");
			selectedIndex=scan.nextInt();
		}
		else{
			// Exception
		}
		return selectedIndex;
	}
	
	/*
	private void reQueryForindexNumber(int state){
		
		if(state == PHONEBOOK){
			System.out.print("��ȣ �ε����� �ٽ� �Է����ּ��� : ");
		}
		else if(state == SCHEDULE){
			System.out.print("������ �ε����� �ٽ� �Է��� �ּ��� : ");
		}
		else if(state == NOTE){
			System.out.print("��Ʈ�ε����� �ٽ� �Է��� �ּ��� : ");
		}
		else{
			// Exception
		}
	}*/
}
