import java.util.*;
import java.io.*;


class Account {
	public static String id;
	private static String pw;
	//id,pw�� db�� �ִٰ��ϸ�
	
	public static String getPw() {
		return pw;
	}
	public static void setPw(String pw) {
		Account.pw = pw;
	}
}


public class AccountManager {
	final int LOGIN=1;
	final int CHANGE=2;
	String inputId;
	String inputPw;

	private int login(String id, String pw) {
		Scanner scan = new Scanner(System.in);
		//Account accountCheck= new Account();
		
		System.out.print("ID : ");
		inputId = scan.nextLine();
		System.out.print("PW : ");
		inputPw= scan.nextLine();	
		
		if(id == inputId && pw == inputPw) {
			return 1;
		}
		else
			return login(id, pw);
	}
	
	public void changeAccount() {
		//newid�� newpw�� �޾Ƽ� ! �־�a!
		Scanner scan = new Scanner(System.in);
		System.out.print("ID : ");
		Account.id = scan.nextLine();
		System.out.print("PW : ");
		Account.setPw(scan.nextLine());
		
		
		//db������ �ñ�
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
