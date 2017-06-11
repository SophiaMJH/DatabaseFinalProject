<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.sql.*" %>
<%
String userID = request.getParameter("userID");
String userPassword = request.getParameter("userPassword");

Connection myConn = null;
Statement stmt = null;
ResultSet rs = null;
String dburl = "jdbc:oracle:thin:@localhost:1521:xe"; /*xe자리에 자기 DB 이름 넣어야 연결됨*/
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
} else { %>
	<script>alert("아이디와 패스워드를 확인하세요!");
	location.href="login.jsp";</script> <%
	}

stmt.close();
myConn.close();
%>
