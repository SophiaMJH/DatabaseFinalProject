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
	
	//executeDatabase �Լ��� ��� ȣ���ϴ��Ŀ� ���� �Ķ���Ͱ� �ٲ��� �� ��!
	//�ϴ� �Ķ���� �Ⱦ��� StatementForMenu��ü���� sql�� �̾ƿ��°ɷ� ��������
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
	
	//�̰͵� ��� state�� select�־ ȣ���ϴ��� ���� �ϴ� ����� ��������
	public void executeFunction(int state, int select) throws SQLException{
		if(selectedFunction==ADD)
			return; // ���� �ֱ��� �޴��� print
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
			return; //���� �ֱ��� �޴��� ���ư���.
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
			System.out.print("�޴��� ���ư��÷��� B�� �Է����ּ��� : ");
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
			System.out.print("�޴��� ���ư��÷��� B�� �Է����ּ��� : ");
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
			System.out.print("�޴��� ���ư��÷��� B�� �Է����ּ��� : ");
			userRequest=scan.nextLine();
			if(userRequest=="B") return 0;
		}
	}
}

// �ϴ� maxIndex�� ��� �����Ұ������� ���ؾ� ��
// maxIndex�� add�Ҷ��� +1
// ��� ����Ʈ���� ��񿡼� ���� ū�ָ� �޾ƿ´�!