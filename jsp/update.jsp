<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������û ����� ���� ����</title>
<link rel="stylesheet" href="menu.css">
<link rel="stylesheet" href="table.css">
</head>
<body>



<%@ include file="menu.jsp" %>
<% 
	if(session_id == null){
		response.sendRedirect("login.jsp");
	}
		
	String userID = session_id;
	Connection myConn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl"; /*xe�ڸ��� �ڱ� DB �̸� �־�� �����*/
	String user = "db01";
	String passwd = "ss2";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	myConn = DriverManager.getConnection (dburl, user, passwd);

	stmt = myConn.createStatement();
	String mySQL = "select s_addr,s_pwd,s_major, s_name from student where s_id='" + userID + "'";
	rs = stmt.executeQuery(mySQL);
%>




<table align="center">
<FORM method="post" action="update_verify.jsp" >

<%
while(rs.next()){
	
	String s_name = rs.getString("s_name");
	String s_pwd =rs.getString("s_pwd");
	String s_addr = rs.getString("s_addr");
	String s_major = rs.getString("s_major");
	%>
	<h3 align="center"><%=s_name%>���� ������ �����մϴ�.</h3>
	
	<tr><td><div align="center">ID</div></td>
	<td><div align="center"><input type="text" name="userID" value=<%=userID %> readonly="readonly" ></td></tr>
	</div></td>
	</tr>
	
	
	<tr><td><div align="center">�н�����</div></td>
	<td><div align="center"><input type="text" name="s_pwd" value=<%=s_pwd %>>
	</div></td>
	</tr>
	
	<tr><td><div align="center">����</div></td>
	<td><div align="center"><input type="text" name="s_major" value=<%=s_major %>>
	</div></td>
	</tr>

	<tr><td><div align="center">�ּ�</div></td>
	<td><div align="center"><input type="address" name="s_addr" value=<%=s_addr %>>
	</div></td>
	</tr>
		
<% }%>
	



<tr>
<td colspan=2><div align="center">
<INPUT TYPE="SUBMIT" NAME="Modify" VALUE="����">
<INPUT TYPE="RESET" VALUE="���" onclick="javascript:window.location='main.jsp'">
</div></td>
</tr>
</table>
</FORM>

</body>
</html>