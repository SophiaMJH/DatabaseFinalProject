<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "list.jsp" %>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>데이터베이스를 활용한 수강신청 시스템 입니다.</title>
<link rel="stylesheet" href="master_menu.css">
<link rel="stylesheet" href="master_main.css">
<script>
function check() {
	var fr = document.getElemntById(master_course);
		fr.submit();
}
</script>
</head>
<body>
<%@ include file="master_menu.jsp" %>
<div id="content" align="center">
<form id = "master_student" action = "master_student_process" onsubmit="return check()">
	<table>
			<tr height="5"><td width="5"></td></tr>
			<tr style = "border-color: rgb(13,45,132); border-style: solid; text-align: center; color: black">
				<td height = "28" width = "100">학번</td>
				<td>이름</td>
				<td>학과</td>
			</tr>
				<%
				String mySQL = "SELECT COUNT(*) FROM student";
				DBExecutor aDBExecutor = new DBExecutor();
				ResultSet rs = aDBExecutor.queryString(mySQL);
				if(rs.next())
					lastRow = rs.getInt(1);
				
				if(lastRow > 0) {
					mySQL = "select s_id, s_name, s_major FROM student ORDER BY s_id";
					rs = aDBExecutor.queryString(mySQL);
					for(i = 1; rs.next(); i++) {
						if(i >= startRow && i <= endRow) {
							String s_id = rs.getString("s_id");
							String s_name = rs.getString("s_name");
							String s_major = rs.getString("s_major");
						
						%>
						<tr>
						<td align = "center"><%=s_id %></td>
						<td align = "center"><%=s_name %></td>
						<td align = "center"><%=s_major %></td>
						<td align="center"><a href="modify_master_student.jsp?s_id=<%=s_id%>">수정</a></td>
						<td align="center"><a href="delete_master_student.jsp?s_id=<%=s_id%>">삭제</a></td>
						<%} %>
						</tr>
						<%
					}
					rs.close();
					
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
        				<td align="right"><input type="submit" value="추가" /></td>
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