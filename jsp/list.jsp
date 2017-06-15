
<%
String pageNum = request.getParameter("pageNum");
if(pageNum == null)
	pageNum = "1";

int listSize = 20;
int currentPage = Integer.parseInt(pageNum);
int nextPage = currentPage + 1;
int startRow = (currentPage - 1) * listSize + 1;
int endRow = currentPage * listSize;
int lastRow = 0;
int i = 0;
int n = 0;
int num[] = {0};
int row = startRow;
%>
