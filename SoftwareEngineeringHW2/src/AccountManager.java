import java.util.*;
import java.io.*;


public class Account {
	public String id;
	private String pw;
	//id,pw�� db�� �ִٰ��ϸ�
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
		//newid�� newpw�� �޾Ƽ� ! �־�a!
		
		System.out.print("ID : ");
		id = scan.nextLine();
		System.our.print("PW : ");
		pw = scan.nextLine();
		
		
		//db������ �ñ�
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
