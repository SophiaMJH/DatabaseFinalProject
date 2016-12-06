import java.util.*;
import java.sql.*;

public class DatabaseExecutor {
	private int selectedFunction;
	final int ADD=1;
	final int VIEW=2;
	final int DELETE=3;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	//executeDatabase 함수를 어디서 호출하느냐에 따라 파라미터가 바뀌어야 할 듯!
	//일단 파라미터 안쓰고 StatementForMenu객체에서 sql문 뽑아오는걸로 구현했음
	private void executeDatabase(String statement) {
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask",
												"root", "ComputerScience14*");
			stmt=conn.createStatement();
			String sql = statement;
			rs=stmt.executeQuery(sql);
		}catch(Exception e){
			System.out.println("DatabaseExecutor class error");
		}
	}
	
	//이것도 어디서 state랑 select넣어서 호출하는지 몰라서 일단 맘대로 구현했음
	public void executeFunction(int mainMenu, int subMenu) throws SQLException {
		if(subMenu==ADD) {
			executeAddFunction(mainMenu);
			return; // 가장 최근의 메뉴를 print
		}
		else if(subMenu==VIEW) {
			executeViewFunction(mainMenu);
		}
		else if(subMenu==DELETE) {
			executeDeleteFunction(mainMenu);
			return; //가장 최근의 메뉴로 돌아간다.
		}
	}
	
	private void executeAddFunction(int mainMenu) {
		StatementForMenu executeStatement=new StatementForMenu();
		int maxIndex = makeMaxIndexFromDatabase();
		String sql = executeStatement.makeStatementForAddition(mainMenu, maxIndex+1);
		executeDatabase(sql);
	}

	private void executeViewFunction(int mainMenu) throws SQLException {
		if(mainMenu==1)
			viewPhonebookTable();
		else if(mainMenu==2)
			viewScheduleTable();
		else if(mainMenu==3)
			viewNoteTable();
		else
			System.out.println("DatabaseExecutor class error");
	}
	
	private void executeDeleteFunction(int mainMenu) {
		InputFromUser indexSelectedByUser = new InputFromUser();
		int selectedIndex = indexSelectedByUser.queryForindexNumber(mainMenu);
		while(!isInDatabase(selectedIndex))
			selectedIndex = indexSelectedByUser.reQueryForindexNumber(mainMenu);
		StatementForMenu executeStatement=new StatementForMenu();
		String sql = executeStatement.makeStatementForDeletion(mainMenu, selectedIndex);
		executeDatabase(sql);
	}
	
	private int viewPhonebookTable() throws SQLException {
		Scanner scan=new Scanner(System.in);
		String id,name,phoneNumber,userRequest;
		int phoneIndex;
		
		System.out.print("id\t"+"name\t"+"phoneNumber\t"+"index\n");
		while(rs.next()){
			id=rs.getString("id");
			name=rs.getString("name");
			phoneNumber=rs.getString("phoneNumber");
			phoneIndex=rs.getInt("phoneIndex");
			System.out.print(id+"\t"+name+"\t"+phoneNumber+"\t"+phoneIndex+"\n");
		}
		rs.close();
		stmt.close();
		while(true) {
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest=scan.nextLine();
			if(userRequest=="B") return 0;
		}
	}
	
	private int viewScheduleTable() throws SQLException {
		Scanner scan=new Scanner(System.in);
		String id,date,description,userRequest;
		int scheduleIndex;
		System.out.print("id\t"+"date\t"+"description\t"+"index\n");
		while(rs.next()) {
			id=rs.getString("id");
			date=rs.getString("date");
			description=rs.getString("description");
			scheduleIndex=rs.getInt("phoneIndex");
			System.out.print(id+"\t"+date+"\t"+description+"\t"+scheduleIndex+"\n");
		}
		rs.close();
		stmt.close();
		while(true) {
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest=scan.nextLine();
			if(userRequest=="B") return 0;
		}
	}
	
	private int viewNoteTable() throws SQLException {
		Scanner scan=new Scanner(System.in);
		String id,note,userRequest;
		int noteIndex;
		System.out.print("id\t"+"note\t"+"index\n");
		while(rs.next()) {
			id=rs.getString("id");
			note=rs.getString("note");
			noteIndex=rs.getInt("phoneIndex");
			System.out.print(id+"\t"+note+"\t"+noteIndex+"\n");
		}
		rs.close();
		stmt.close();
		while(true) {
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest=scan.nextLine();
			if(userRequest=="B") return 0;
		}
	}
	
	private int  makeMaxIndexFromDatabase() {
		
		
	}
	
	private boolean inInDatabase(int index) {
		
	}
}

// 일단 maxIndex를 어떻게 전달할건지부터 정해야 함
// maxIndex는 add할때는 +1
// 뷰랑 딜리트때는 디비에서 제일 큰애를 받아온다!