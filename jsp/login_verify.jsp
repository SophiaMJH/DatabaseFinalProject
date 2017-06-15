<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.sql.*" %>

<%
String userID = request.getParameter("userID");
String userPassword = request.getParameter("userPassword");
String masterID = application.getInitParameter("MasterID");
String masterPassword = application.getInitParameter("MasterPassword");

Connection myConn = null;
Statement stmt = null;
ResultSet rs = null;

if(userID.equals(masterID) && userPassword.equals(masterPassword)) {
	session.setAttribute("user", userID);
	session.setAttribute("master", userID);
	%>
	<jsp:forward page="/master_main.jsp" />
	<%
}
else {
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "db01";
	String passwd = "ss2";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	myConn = DriverManager.getConnection (dburl, user, passwd);
	stmt = myConn.createStatement();
	String mySQL = "select s_id from student where s_id='" + userID + "' and s_pwd='" + userPassword + "'";
	rs = stmt.executeQuery(mySQL);
	if(rs.next()){
		session.setAttribute("user", userID);
		%>
		<jsp:forward page="/main.jsp" />
		<%
	} else { 
		%>
		<script>alert("아이디와 패스워드를 확인하세요!");
		location.href="login.jsp";</script> <%
		}
	
	stmt.close();
	myConn.close();
}
%>
