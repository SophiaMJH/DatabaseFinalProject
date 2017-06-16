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
			alert("�α����� �ʿ��մϴ�.");
			window.location = "main.jsp"
		</script>
	<%} %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�����ͺ��̽��� Ȱ���� ������û �ý��� �Դϴ�.</title>
<link rel="stylesheet" href="master_menu.css">
<link rel="stylesheet" href="master_main.css">
<script>
function check(){
	var fr = document.getElementById(board);
	<%
	if(master != null)
		;
	else{
		if(user != null){
	%>		fr.submit();
	<%
		}else{
	%>
			alert("�α����ϼ���");
			return false;
	<%	}
	}
	%>

}
</script>
</head>
<body>
<%@ include file="master_menu.jsp" %>
<div id="content" align="center">
<form id="master_main" action="master_register.jsp" onsubmit="return check()">
	<table>
			<tr height="5"><td width="5"></td></tr>
			<tr style = "background-color: rgb(13,45,132); text-align: center; color: white">
				<td height = "28" width = "100">������</td>
				<td>����</td>
				<td>����</td>
				<td>���۽ð�</td>
				<td>����ð�</td>
				<td>����</td>
				<td>����</td>
				<td height = "28" width = "50"></td>
				<td height = "28" width = "50"></td>
			</tr>
				<%
				String mySQL = "SELECT COUNT(*) FROM teach";
				DBExecutor aDBExecutor = new DBExecutor();
				ResultSet rs = aDBExecutor.queryString(mySQL);
				if(rs.next())
					lastRow = rs.getInt(1);
				
				if(lastRow > 0) {
					mySQL = "select t.p_id, t.c_id, t.c_id_no, p_name, c_name, t_day, t_start, t_end, t_max, t_room " + 
							"FROM teach t, course c, professor p " + 
							"WHERE p.p_id = t.p_id AND c.c_id = t.c_id AND c.c_id_no = t.c_id_no " +
							"ORDER BY c_name ASC, p_name ASC"; // AND t.t_year=" + year + " AND t.t_semester=" + semester
					rs = aDBExecutor.queryString(mySQL);
					for(i = 1; rs.next(); i++) {
						if(i >= startRow && i <= endRow) {
							String p_id = rs.getString("p_id");
							String c_id = rs.getString("c_id");
							String c_id_no = rs.getString("c_id_no");
							String p_name = rs.getString("p_name");
							String c_name = rs.getString("c_name");
							String t_day = rs.getString("t_day");
							String t_start = rs.getString("t_start");
							String t_end = rs.getString("t_end");
							String t_max = rs.getString("t_max");
							String t_room = rs.getString("t_room");
						
						%>
						<tr>
						<td align = "center"><%=p_name %></td>
						<td align = "center"><%=c_name %></td>
						<td align = "center"><%=t_day %></td>
						<td align = "center"><%=t_start %></td>
						<td align = "center"><%=t_end %></td>
						<td align = "center"><%=t_max %></td>
						<td align = "center"><%=t_room %></td>
						<td align="center"><a href="master_modify.jsp?p_id=<%=p_id%>&c_id=<%=c_id%>&c_id_no=<%=c_id_no%>" onClick="window.open(this.href, '', 'width=400, height=430'); return false;">����</a></td>
						<td align="center"><a href="master_delete.jsp?p_id=<%=p_id%>&c_id=<%=c_id%>&c_id_no=<%=c_id_no%>">����</a></td>
						<%} %>
						</tr>
						<%
					}
					rs.close();
					aDBExecutor.closeStatementAndConnection();					
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
				<a href="master_main.jsp?pageNum=<%=currentPage-1%>">[����]</a>
	<% 		}
				
			while(setPage <= lastPage) {
				if(setPage != currentPage){%>
					<a href="master_main.jsp?pageNum=<%=setPage%>">[<%=setPage%>]</a>
	<%			}
					setPage = setPage + 1;
			}
	
			if(lastPage > currentPage) {%>
				<a href="master_main.jsp?pageNum=<%=currentPage+1%>">[����]</a>
	<%		}
		}
	%>

</div>
</body>
</html>