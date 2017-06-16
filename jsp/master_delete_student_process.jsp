<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
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
	double e_year = 0, e_semester = 0;
	Calendar c = Calendar.getInstance();
	e_year = (double)c.get(Calendar.YEAR);
	int e_month = c.get(Calendar.MONTH);
	if(e_month >= 1 && e_month <= 4)
		e_semester = 1;
	else if(e_month >= 5 && e_month <= 10)
		e_semester = 2;	
	else if(e_month >= 11 && e_month <= 12) {
		e_semester = 1;
		e_year += 1;
	}

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
			mySQL = "DELETE FROM enroll WHERE s_id=" + s_id + " AND e_year='" + e_year + "' AND e_semester='" + e_semester + "'";
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