import java.util.*;
import java.io.*;


public class Account {
	public String id;
	private String pw;
	//id,pw가 db에 있다고하면
}


public class AccountManager {
	final int LOGIN=1;
	final int CHANGE=2;
	String inputId;
	String inputPw;

	private int login(string id, string pw) {
		Scanner scan = new Scanner(System.in);
		Account accountCheck= new Account();
		
		System.out.print("ID : ");
		inputId = scan.nextLine();
		System.out.print("PW : ");
		inputPw= scan.nextLine();	
		
		if(id == inputId && pw == inputPw) {
			showMenu();
		}
		else if 
			return login(id, pw);
	}
	
	private void changeAccount(void){
		//newid와 newpw를 받아서 ! 넣어줭!
		
		System.out.print("ID : ");
		id = scan.nextLine();
		System.our.print("PW : ");
		pw = scan.nextLine();
		
		
		//db연결이 시급
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
