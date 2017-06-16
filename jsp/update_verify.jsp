<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.sql.*" %>
<html>
<head><title>수강신청 사용자 정보 수정</title></head>
<body>
<%
	String userID = request.getParameter("userID");
	String s_pwd = request.getParameter("s_pwd");
	if(s_pwd != null) {
		s_pwd = new String(s_pwd.getBytes("8859_1"), "EUC-KR");
	}
	String s_addr = request.getParameter("s_addr");
	if(s_addr != null) {
		s_addr = new String(s_addr.getBytes("8859_1"), "EUC-KR");
	}
	String s_major = request.getParameter("s_major");
	if(s_major != null) {
		s_major = new String(s_major.getBytes("8859_1"), "EUC-KR");
	}

	Connection myConn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "db01";
	String passwd = "ss2";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	myConn = DriverManager.getConnection (dburl, user, passwd);

	PreparedStatement pstmt=null;
	int n=0;
	
	stmt = myConn.createStatement();
	String mySQL = "UPDATE student SET s_pwd=?, s_major=?, s_addr=? WHERE s_id='"+userID+"'"; 
	
	try{
		pstmt = myConn.prepareStatement(mySQL);
		pstmt.setString(1,s_pwd);
		pstmt.setString(2,s_major);
		pstmt.setString(3,s_addr);
		n=pstmt.executeUpdate();
	
	%>
	<script>
		alert("학생정보가 수정되었습니다");
		location.href="update.jsp";
	</script>
	<%
	}catch(SQLException ex){
		String sMessage;
		if(ex.getErrorCode() ==20002)
			sMessage="암호는 4자리 이상이어야 합니다.";
		else if(ex.getErrorCode()== 20003)
			sMessage = "암호에 공란은 입력되지 않습니다.";
		else
			sMessage = "잠시 후 다시 시도하십시오.";
	%>
	
	<script>
		alert("<%=sMessage%>" );
		location.href = "update.jsp";
	</script>
	<%} %>
	
</body>
</html>