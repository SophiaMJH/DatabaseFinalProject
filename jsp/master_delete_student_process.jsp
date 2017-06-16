<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>학생삭제</title>
<script>
	function returnToParent() {
		opener.parent.location.reload();
		window.close();
	}
</script>
</head>
<body>
<%
	String s_id = request.getParameter("s_id");
	if(s_id == null) { %>
		<script>alert("에러")</script>
<%	} else {
		String mySQL;
		DBExecutor aDBExecutor = new DBExecutor();
		int result = 0;
		ResultSet rs = null;
		
		mySQL = "SELECT COUNT(*) FROM student WHERE s_id=" + s_id;
		rs = aDBExecutor.queryString(mySQL);
		if(rs.next()) {
			if(rs.getInt(1) == 1)
				result = 1;
		}
		rs.close();
		aDBExecutor.closeStatementAndConnection();
		
		if(result == 1) {
			mySQL = "DELETE FROM student WHERE s_id=" + s_id;
			result = aDBExecutor.updateString(mySQL);
			aDBExecutor.closeStatementAndConnection();%>
			<script>window.returnToParent()</script>
<%		} else {%>
			<script>alert("에러")</script>
<%		}
	}
%>
</body>
</html>