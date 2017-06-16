<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "list.jsp" %>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("utf-8");
	String master = (String)session.getAttribute("master");  
	String user = (String)session.getAttribute("user");
	
	if(master==null && user==null){%>
		<script>
			alert("로그인이 필요합니다.");
			window.location = "main.jsp"
		</script>
	<%} %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>데이터베이스를 활용한 수강신청 시스템 입니다.</title>
<link rel="stylesheet" href="master_menu.css">
<link rel="stylesheet" href="master_main.css">
</head>
<body>
<%@ include file="master_menu.jsp" %>
<div id="content" align="center">
<form id="master_main">
	<table>
			<tr height="5"><td width="5"></td></tr>
			<tr style = "background-color: rgb(13,45,132); text-align: center; color: white">
				<td height = "28" width = "100">학번</td>
				<td>이름</td>
				<td>전공</td>
				<td>과목번호</td>
				<td>과목명</td>
				<td>분반</td>
				<td height = "28" width = "65"></td>
			</tr>
				<%
				double e_year = 0;
				double e_semester = 0;
				Calendar c = Calendar.getInstance();
				e_year = (double)c.get(Calendar.YEAR);
				int e_month = c.get(Calendar.MONTH);
				if(e_month >= 1 && e_month <= 6)
					e_semester = 1;
				else
					e_semester = 2;	
				
				String mySQL = "SELECT COUNT(*) FROM enroll";
				DBExecutor aDBExecutor = new DBExecutor();
				ResultSet rs = aDBExecutor.queryString(mySQL);
				if(rs.next())
					lastRow = rs.getInt(1);
				
				if(lastRow > 0) {
					mySQL = "SELECT e.s_id, e.c_id, e.c_id_no, s.s_name, s.s_major, c.c_name " + 
							"FROM enroll e, course c, student s " + 
							" WHERE e.s_id = s.s_id AND e.c_id = c.c_id AND e.c_id_no = c.c_id_no AND e.e_year = " + e_year + " AND e.e_semester = " + e_semester +
							"ORDER BY s.s_name ASC, e.s_id ASC";
					rs = aDBExecutor.queryString(mySQL);
					for(i = 1; rs.next(); i++) {
						if(i >= startRow && i <= endRow) {
							String s_id = rs.getString("s_id");
							String c_id = rs.getString("c_id");
							String c_id_no = rs.getString("c_id_no");
							String s_name = rs.getString("s_name");
							String s_major = rs.getString("s_major");
							String c_name = rs.getString("c_name");
						
						%>
						<tr>
						<td align = "center"><%=s_id %></td>
						<td align = "center"><%=s_name %></td>
						<td align = "center"><%=s_major %></td>
						<td align = "center"><%=c_id %></td>
						<td align = "center"><%=c_name %></td>
						<td align = "center"><%=c_id_no %></td>
						<td align="center"><a href="master_delete_enroll.jsp?s_id=<%=s_id %>&c_id=<%=c_id%>&c_id_no=<%=c_id_no%>">신청삭제</a></td>
						<%} %>
						</tr>
						<%
					}
					rs.close();
					aDBExecutor.closeStatementAndConnection();					
				} else {
					%>
					<tr>
						<td colspan="4">레코드 없음</td>
					</tr>
					<%
				}
			
				%>
	 </table>
	 <table>
        	<tr><td colspan="4" height="5"></td></tr>
        	<tr align="center">
        		<td align="right"><a href="master_delete_student.jsp" onClick="window.open(this.href, '', 'width=400, height=200'); return false;">학생삭제</a></td>
        	</tr>
     </table>
</form>
				
   		 <%
		if(lastRow > 0) {	// 페이지가 넘어갈 때 넘겨줄 파라미터
			int setPage = 1;	// 마지막 페이지의 번호를 저장
			int lastPage = 0;
			if(lastRow % listSize == 0)
				lastPage = lastRow / listSize;
			else
				lastPage = lastRow / listSize + 1;	// 레코드 수에 따라 쪽번호를 매긴다.	
			if(currentPage > setPage){
	%>
				<a href="master_student.jsp?pageNum=<%=currentPage-1%>">[이전]</a>
	<% 		}
				
			while(setPage <= lastPage) {
				if(setPage != currentPage){%>
					<a href="master_student.jsp?pageNum=<%=setPage%>">[<%=setPage%>]</a>
	<%			}
					setPage = setPage + 1;
			}
	
			if(lastPage > currentPage) {%>
				<a href="master_student.jsp?pageNum=<%=currentPage+1%>">[다음]</a>
	<%		}
		}
	%>

</div>
</body>
</html>