import java.util.*;
import java.sql.*;

public class DatabaseExecutor {
	private int selectedFunction;
	final int ADD = 1;
	final int VIEW = 2;
	final int DELETE = 3;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	private void executeDatabase(String statement) {
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask", "root", "ComputerScience14*");
			stmt = conn.createStatement();
			stmt.executeUpdate(statement);
		}catch(Exception e){
			System.out.println("DatabaseExecutor class error");
		}
	}
	
	public void executeFunction(int mainMenu, int subMenu) throws SQLException {
		if(subMenu == ADD) {
			executeAddFunction(mainMenu);
			return;
		}
		else if(subMenu == VIEW) {
			executeViewFunction(mainMenu);
		}
		else if(subMenu == DELETE) {
			executeDeleteFunction(mainMenu);
			return;
		}
	}
	
	private void executeAddFunction(int mainMenu) {
		StatementForMenu executeStatement = new StatementForMenu();
		int maxIndex = makeMaxIndexFromDatabase();
		String sql = executeStatement.makeStatementForAddition(mainMenu, maxIndex+1);
		executeDatabase(sql);
	}

	private void executeViewFunction(int mainMenu) throws SQLException {
		StatementForMenu executeStatement = new StatementForMenu();
		String sql = executeStatement.makeStatementForViewing(mainMenu);
		
		if(mainMenu == 1)
			viewPhonebookTable(sql);
		else if(mainMenu == 2)
			viewScheduleTable(sql);
		else if(mainMenu == 3)
			viewNoteTable(sql);
		else
			System.out.println("DatabaseExecutor class error");
	}
	
	private void executeDeleteFunction(int mainMenu) {
		InputFromUser indexSelectedByUser = new InputFromUser();
		int selectedIndex = indexSelectedByUser.queryForindexNumber(mainMenu);
		while(!isInDatabase(selectedIndex))
			selectedIndex = indexSelectedByUser.reQueryForindexNumber(mainMenu);
		StatementForMenu executeStatement = new StatementForMenu();
		String sql = executeStatement.makeStatementForDeletion(mainMenu, selectedIndex);
		executeDatabase(sql);
	}
	
	private int viewPhonebookTable(String sql) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String id,name,phoneNumber,userRequest;
		int phoneIndex;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask", "root", "ComputerScience14*");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		System.out.print("id\t"+"name\t"+"phoneNumber\t"+"index\n");
		while(rs.next()){
			id = rs.getString("id");
			name = rs.getString("name");
			phoneNumber = rs.getString("phoneNumber");
			phoneIndex = rs.getInt("phoneIndex");
			System.out.print(id+"\t"+name+"\t"+phoneNumber+"\t"+phoneIndex+"\n");
		}
		rs.close();
		stmt.close();
		while(true) {
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest = scan.nextLine();
			if(userRequest == "B") return 0;
		}
	}
	
	private int viewScheduleTable(String sql) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String id,date,description,userRequest;
		int scheduleIndex;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask", "root", "ComputerScience14*");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		System.out.print("id\t"+"date\t"+"description\t"+"index\n");
		while(rs.next()) {
			id = rs.getString("id");
			date = rs.getString("date");
			description = rs.getString("description");
			scheduleIndex = rs.getInt("phoneIndex");
			System.out.print(id+"\t"+date+"\t"+description+"\t"+scheduleIndex+"\n");
		}
		rs.close();
		stmt.close();
		while(true) {
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest = scan.nextLine();
			if(userRequest == "B") return 0;
		}
	}
	
	private int viewNoteTable(String sql) throws SQLException {
		Scanner scan=new Scanner(System.in);
		String id,note,userRequest;
		int noteIndex;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask", "root", "ComputerScience14*");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		System.out.print("id\t"+"note\t"+"index\n");
		while(rs.next()) {
			id = rs.getString("id");
			note = rs.getString("note");
			noteIndex = rs.getInt("phoneIndex");
			System.out.print(id+"\t"+note+"\t"+noteIndex+"\n");
		}
		rs.close();
		stmt.close();
		while(true) {
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest = scan.nextLine();
			if(userRequest == "B") return 0;
		}
	}
	
	private int makeMaxIndexFromDatabase() {
		
		return 0;
	}
	
	private boolean isInDatabase(int index) {
		
		return true;
	}
}

// 일단 maxIndex : 뷰랑 딜리트 때 디비에서 제일 큰애를 받아온다!