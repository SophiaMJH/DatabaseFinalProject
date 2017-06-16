package databaseFinal;
import java.sql.*;

public class DBExecutor {
	private Connection myConn = null;
	private Statement stmt = null;
	private String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String user = "db01";
	private String passwd = "ss2";

	public ResultSet queryString(String mySQL) throws SQLException, ClassNotFoundException {
		prepareClassAndDriver();
		stmt = myConn.createStatement();
		return stmt.executeQuery(mySQL);
	}
	
	public int updateString(String mySQL)  throws SQLException, ClassNotFoundException {
		prepareClassAndDriver();
		stmt = myConn.createStatement();
		return stmt.executeUpdate(mySQL);
	}
	
	public PreparedStatement getPreparedStatement(String mySQL) throws ClassNotFoundException, SQLException {
		prepareClassAndDriver();
		return myConn.prepareStatement(mySQL);
	}
	
	public ResultSet queryPreparedStatement(PreparedStatement pstmt) throws SQLException {
		return pstmt.executeQuery();
	}
	
	public int updatePreparedStatement(PreparedStatement pstmt) throws SQLException {
		return pstmt.executeUpdate();
	}
		
	public void closeStatementAndConnection() throws SQLException {
		stmt.close();
		myConn.close();
	}

	public void closePreparedStatementAndConnection(PreparedStatement pstmt) throws SQLException {
		pstmt.close();
		myConn.close();
	}
	
	private void prepareClassAndDriver() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		myConn = DriverManager.getConnection (dburl, user, passwd);
	}
	
}
