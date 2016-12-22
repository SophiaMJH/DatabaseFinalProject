import java.util.*;
import java.sql.*;

public class DatabaseExecutor {
	private int selectedFunction;
	private String back="B";
	final int ADD = 1;
	final int VIEW = 2;
	final int DELETE = 3;
	final int PHONEBOOK = 2;
	final int SCHEDULE = 3;
	final int NOTE = 4;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	

	private void executeDatabase(String statement) throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false",
												"root", "ComputerScience14*");
		stmt = conn.createStatement();
		String sql = statement;
		stmt.executeUpdate(sql);
	}
	
	public void executeFunction(int mainMenu, int subMenu) throws Exception {
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
	
	private void executeAddFunction(int mainMenu) throws Exception  {
		StatementForMenu executeStatement = new StatementForMenu();
		int maxIndex = makeMaxIndexFromDatabase(mainMenu);
		String sql = executeStatement.makeStatementForAddition(mainMenu, maxIndex);
		executeDatabase(sql);
		rs.close();
		stmt.close();
		conn.close();
	}

	private void executeViewFunction(int mainMenu) throws SQLException {
		StatementForMenu executeStatement = new StatementForMenu();
		String sql = executeStatement.makeStatementForViewing(mainMenu);
		if(mainMenu == PHONEBOOK)
			viewPhonebookTable(sql);
		else if(mainMenu == SCHEDULE)
			viewScheduleTable(sql);
		else if(mainMenu == NOTE)
			viewNoteTable(sql);
		else
			System.out.println("DatabaseExecutor class error");
	}
	
	private void executeDeleteFunction(int mainMenu) throws SQLException {
		InputFromUser indexSelectedByUser = new InputFromUser();
		int selectedIndex = indexSelectedByUser.queryForindexNumber(mainMenu);
		while(!isInDatabase(selectedIndex, mainMenu))
			selectedIndex = indexSelectedByUser.reQueryForindexNumber(mainMenu);
		StatementForMenu executeStatement=new StatementForMenu();
		String sql = executeStatement.makeStatementForDeletion(mainMenu, selectedIndex);
		executeDatabase(sql);
		rs.close();
		stmt.close();
		conn.close();
	}
	
	private void viewPhonebookTable(String sql) throws SQLException {
		Scanner scan=new Scanner(System.in);
		String id,name,phoneNumber,userRequest;
		int phoneIndex;
		boolean flag=true;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false", "root", "ComputerScience14*");
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
		conn.close();
		while(flag) {
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest = scan.next();
			if(userRequest.equals(back)) 
				flag = false;
		}
	}
	///////////////////////////////////////////////////출력값 줄맞추기 해야돼!!!!!!!!!!!!!!!!!!!!
	private void viewScheduleTable(String sql) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String id,date,description;
		int scheduleIndex;
		Menu backMenu = new Menu();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false", "root", "ComputerScience14*");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		System.out.print("id\t"+"date\t"+"description\t"+"index\n");
		while(rs.next()) {
			id = rs.getString("id");
			date = rs.getString("date");
			description = rs.getString("description");
			scheduleIndex = rs.getInt("scheduleIndex");
			System.out.print(id+"\t"+date+"\t\t\t"+description+"\t"+scheduleIndex+"\n");
		}
		rs.close();
		stmt.close();
		conn.close();
		backMenu.queryBackMenu();
	}
	
	private void viewNoteTable(String sql) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String id,note,userRequest;
		int noteIndex;
		boolean flag=true;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false", "root", "ComputerScience14*");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		System.out.print("id\t"+"note\t"+"index\n");
		while(rs.next()) {
			id = rs.getString("id");
			note = rs.getString("note");
			noteIndex = rs.getInt("noteIndex");
			System.out.print(id+"\t"+note+"\t"+noteIndex+"\n");
		}
		rs.close();
		stmt.close();
		conn.close();
		while(flag) {
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest=scan.nextLine();
			if(userRequest.equals(back)) 
				flag = false;
		}
	}
	
	private int makeMaxIndexFromDatabase(int mainMenu) throws SQLException {
		int max = 0;
		StatementForMenu executeStatement=new StatementForMenu();
		String sql = executeStatement.makeMaxIndexString(mainMenu);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false",
				"root", "ComputerScience14*");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			max = rs.getInt(1);
			max = max+1;
		}
		return max;
	}

	//selected 인덱스 받아왔음
	private boolean isInDatabase(int index, int mainMenu) throws SQLException  {
		boolean flag = false;
		String indexName = setIndexName(mainMenu);
		StatementForMenu executeStatement=new StatementForMenu();
		String sql = executeStatement.makeIsInDatabaseString(indexName, mainMenu, index);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false",
				"root", "ComputerScience14*");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			if(rs.getInt(indexName) == index) 
				flag = true;
		}
		System.out.println(flag);///////////////////////////////////////////////여기도 지워라
		return flag;
	}
	
	private String setIndexName(int mainMenu){
		String indexName = "";
		if(mainMenu == PHONEBOOK){
			indexName = "phoneIndex";
		}
		else if(mainMenu == SCHEDULE){
			indexName = "scheduleIndex";
		}
		else if(mainMenu == NOTE){
			indexName = "noteIndex";
		}
		return indexName;
		
	}

}
