<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.sql.*" %>
<%
String userID = request.getParameter("userID");
String userPassword = request.getParameter("userPassword");

Connection myConn = null;
Statement stmt = null;
ResultSet rs = null;
String dburl = "jdbc:oracle:thin:@localhost:1521:xe"; /*xe�ڸ��� �ڱ� DB �̸� �־�� �����*/
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
	<script>alert("���̵�� �н����带 Ȯ���ϼ���!");
	location.href="login.jsp";</script> <%
	}

stmt.close();
myConn.close();
%>
