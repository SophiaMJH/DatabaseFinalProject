import java.util.*;
import java.sql.*;


class Account {
	private static String id;
	private static String pw;
	
	public static String getId() {
		return id;
	}
	public static void setId(String inputId) {
		id = inputId;
	}
	public static void setPw(String inputPw) {
		pw = inputPw;
	}
}


public class AccountManager {
	String inputId;
	String inputPw;
	Account account  = new Account();

	public void login() throws SQLException {
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("ID : ");
			inputId = scan.nextLine();
			System.out.print("PW : ");
			inputPw= scan.nextLine();	
			
			if(isIdPwInDatabase(inputId, inputPw)) {
				account.setId(inputId);
				account.setPw(inputPw);
				break;
			} else {
				System.out.println("아이디와 패스워드가 일치하지 않습니다");
			}
		}
	}
	
	public void changeAccount() throws SQLException {
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("ID : ");
			String inputId = scan.nextLine();
			if(!isIdInDatabase(inputId))
				System.out.println("중복된 아이디입니다");
			else{
				account.setId(inputId);
				break;
			}
		}
		System.out.print("PW : ");
			Account.setPw(scan.nextLine());
		
	}
	
	private boolean isIdPwInDatabase(String inputId, String inputPW) throws SQLException {
		boolean flag = false;
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false",
					"root", "ComputerScience14*");
		 Statement stmt = conn.createStatement();
		 String sql = "select * from member where id=" + inputId + 
				      " and password=" + inputPW;
		 ResultSet rs = stmt.executeQuery(sql);
		 if(rs.next()) {
			 rs.close();
			 stmt.close();
			 flag = true;
		 }
		 rs.close();
		 stmt.close();
		 return flag;
	}
	
	private boolean isIdInDatabase(String inputId) throws SQLException {
		boolean flag = false;
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false",
					"root", "ComputerScience14*");
		 Statement stmt = conn.createStatement();
		 String sql = "select * from member where id=" + inputId;
		 ResultSet rs = stmt.executeQuery(sql);
		 if(rs.next()) {
			 rs.close();
			 stmt.close();
			 conn.close();
		 }
		 rs.close();
		 stmt.close();
		 conn.close();
		 return flag;
	}
	

	
}
