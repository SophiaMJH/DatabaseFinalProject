import java.util.*;
import java.sql.*;

public class DatabaseExecutor {
	
	public void executeDatabase(String statement){
		StatementForMenu executeStatement=new StatementForMenu();
		Connection conn;
		Statement stmt;
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dailytask", "root", "ComputerScience14*");
			stmt=conn.createStatement();
			String sql=executeStatement.sqlStatement;
			char firstCharacter=sql.charAt(0);
			if(firstCharacter=='S')
				stmt.executeQuery(sql);
			else
				stmt.executeUpdate(sql);
			
		}catch(Exception e){
			System.out.println("DatabaseExecutor class error");
		}
		
	}
	
	
	
	public void executeFunction(int state, int select){
		
	}
}


// maxIndex는 add할때는 +1
// 뷰랑 딜리트때는 디비에서 제일 큰애를 받아온다!