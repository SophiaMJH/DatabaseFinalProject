<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String session_id= (String)session.getAttribute("user");
String log;
if (session_id==null) log="<a href=login.jsp>로그인</a>";
else log="<a href=logout.jsp>로그아웃</a>";
%>
<header id="main_header">
<span id="icon">
<a href="master_main.jsp">
<img src="signiture.jpg">
</a>
</span>
<nav id="menu_bar">
<ul>
<li><b><%=log%></b></li>
<li><b><a href="master_main.jsp">강의 정보</a></b></li>
<li><b><a href="master_student.jsp">학생 및 수강신청</a></b></li>
</ul>
</nav>
</header>