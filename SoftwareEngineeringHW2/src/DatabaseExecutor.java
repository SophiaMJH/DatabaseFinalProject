import java.util.*;
import java.sql.*;

public class DatabaseExecutor {
	private int selectedFunction;
	final int ADD = 1;
	final int VIEW = 2;
	final int DELETE = 3;
	final int PHONEBOOK = 1;
	final int SCHEDULE = 2;
	final int NOTE = 3;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	

	private void executeDatabase(String statement) throws SQLException {
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false",
												"root", "ComputerScience14*");
			stmt = conn.createStatement();
			String sql = statement;
			rs = stmt.executeQuery(sql);
		}catch(Exception e){
			System.out.println("DatabaseExecutor class error");
		}
		rs.close();
		stmt.close();
		conn.close();
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
	
	private void executeAddFunction(int mainMenu) throws SQLException {
		StatementForMenu executeStatement = new StatementForMenu();
		int maxIndex = makeMaxIndexFromDatabase(mainMenu);
		String sql = executeStatement.makeStatementForAddition(mainMenu, maxIndex+1);
		executeDatabase(sql);
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
	}
	
	private int viewPhonebookTable(String sql) throws SQLException {
		Scanner scan=new Scanner(System.in);
		String id,name,phoneNumber,userRequest;
		int phoneIndex;
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
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false", "root", "ComputerScience14*");
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
		conn.close();
		while(true) {
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest=scan.nextLine();
			if(userRequest == "B") return 0;
		}
	}
	
	private int viewNoteTable(String sql) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String id,note,userRequest;
		int noteIndex;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask?autoReconnect=true&useSSL=false", "root", "ComputerScience14*");
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
		conn.close();
		while(true) {
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest=scan.nextLine();
			if(userRequest=="B") return 0;
		}
	}
	
	private int  makeMaxIndexFromDatabase(int mainMenu) throws SQLException {
		int max = 0;
		StatementForMenu executeStatement=new StatementForMenu();
		String sql = executeStatement.makeMaxIndexString(mainMenu);
		executeDatabase(sql);
		if(rs.next()) {
			max = rs.getInt(1);
			max = max+1;
		}
		return max;
	}

	
	private boolean isInDatabase(int index, int mainMenu) throws SQLException {
		boolean flag = false;
		String indexName = setIndexName(mainMenu);
		StatementForMenu executeStatement=new StatementForMenu();
		String sql = executeStatement.makeMaxIndexString(mainMenu);
		executeDatabase(sql);
		if(rs.next()) {
			if(rs.getInt(indexName) == index) 
				flag = true;
		}
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
