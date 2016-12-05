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
	public void executeDatabase(String statement){
		try{
			StatementForMenu executeStatement=new StatementForMenu();
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask",
												"root", "ComputerScience14*");
			stmt=conn.createStatement();
			String sql=executeStatement.sqlStatement;
			char firstCharacter=sql.charAt(0);
			if(firstCharacter=='S'){
				rs=stmt.executeQuery(sql);
				selectedFunction=VIEW;
			}
			else if(firstCharacter=='I'){
				stmt.executeUpdate(sql);
				selectedFunction=ADD;
			}
			else if(firstCharacter=='D'){
				stmt.executeUpdate(sql);
				selectedFunction=DELETE;
			}
			else System.out.println("DatabaseExecutor class error");
		}catch(Exception e){
			System.out.println("DatabaseExecutor class error");
		}
	}
	
	//이것도 어디서 state랑 select넣어서 호출하는지 몰라서 일단 맘대로 구현했음
	public void executeFunction(int state, int select) throws SQLException{
		if(selectedFunction==ADD)
			return; // 가장 최근의 메뉴를 print
		if(selectedFunction==VIEW){
			if(state==1)
				viewPhonebookTable();
			else if(state==2)
				viewScheduleTable();
			else if(state==3)
				viewNoteTable();
			else
				System.out.println("DatabaseExecutor class error");
		}
		if(selectedFunction==DELETE){
			return; //가장 최근의 메뉴로 돌아간다.
		}
			
	}
	
	private int viewPhonebookTable() throws SQLException{
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
		while(true){
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest=scan.nextLine();
			if(userRequest=="B") return 0;
		}
	}
	
	private int viewScheduleTable() throws SQLException{
		Scanner scan=new Scanner(System.in);
		String id,date,description,userRequest;
		int scheduleIndex;
		System.out.print("id\t"+"date\t"+"description\t"+"index\n");
		while(rs.next()){
			id=rs.getString("id");
			date=rs.getString("date");
			description=rs.getString("description");
			scheduleIndex=rs.getInt("phoneIndex");
			System.out.print(id+"\t"+date+"\t"+description+"\t"+scheduleIndex+"\n");
		}
		rs.close();
		stmt.close();
		while(true){
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest=scan.nextLine();
			if(userRequest=="B") return 0;
		}
	}
	
	private int viewNoteTable() throws SQLException{
		Scanner scan=new Scanner(System.in);
		String id,note,userRequest;
		int noteIndex;
		System.out.print("id\t"+"note\t"+"index\n");
		while(rs.next()){
			id=rs.getString("id");
			note=rs.getString("note");
			noteIndex=rs.getInt("phoneIndex");
			System.out.print(id+"\t"+note+"\t"+noteIndex+"\n");
		}
		rs.close();
		stmt.close();
		while(true){
			System.out.print("메뉴로 돌아가시려면 B를 입력해주세요 : ");
			userRequest=scan.nextLine();
			if(userRequest=="B") return 0;
		}
	}
}

// 일단 maxIndex를 어떻게 전달할건지부터 정해야 함
// maxIndex는 add할때는 +1
// 뷰랑 딜리트때는 디비에서 제일 큰애를 받아온다!