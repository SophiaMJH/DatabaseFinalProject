<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "list.jsp" %>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�����ͺ��̽��� Ȱ���� ������û �ý��� �Դϴ�.</title>
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
				<td height = "28" width = "100">�й�</td>
				<td>�̸�</td>
				<td>�а�</td>
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
						<td align="center"><a href="modify_master_student.jsp?s_id=<%=s_id%>">����</a></td>
						<td align="center"><a href="delete_master_student.jsp?s_id=<%=s_id%>">����</a></td>
						<%} %>
						</tr>
						<%
					}
					rs.close();
					
				} else {
					%>
					<tr>
						<td colspan="4">���ڵ� ����</td>
					</tr>
					<%
				}
			
				%>
				</table>
				 <table>
        			<tr><td colspan="4" height="5"></td></tr>
        			<tr align="center">
        				<td align="right"><input type="submit" value="�߰�" /></td>
        			</tr>
        </table>
</form>
   		 <%
		if(lastRow > 0) {	// �������� �Ѿ �� �Ѱ��� �Ķ����
			int setPage = 1;	// ������ �������� ��ȣ�� ����
			int lastPage = 0;
			if(lastRow % listSize == 0)
				lastPage = lastRow / listSize;
			else
				lastPage = lastRow / listSize + 1;	// ���ڵ� ���� ���� �ʹ�ȣ�� �ű��.	
			if(currentPage > setPage){
	%>
				<a href="master_student.jsp?pageNum=<%=currentPage-1%>">[����]</a>
	<% 		}
				
			while(setPage <= lastPage) {
				if(setPage != currentPage){%>
					<a href="master_student.jsp?pageNum=<%=setPage%>">[<%=setPage%>]</a>
	<%			}
					setPage = setPage + 1;
			}
	
			if(lastPage > currentPage) {%>
				<a href="master_student.jsp?pageNum=<%=currentPage+1%>">[����]</a>
	<%		}
		}
	%>

</div>
</body>
</html>