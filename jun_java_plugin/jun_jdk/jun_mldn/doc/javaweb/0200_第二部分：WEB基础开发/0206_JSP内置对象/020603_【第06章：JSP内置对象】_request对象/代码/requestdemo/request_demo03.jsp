<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	request.setCharacterEncoding("GBK") ;// ���õ���ͳһ����
	String param1 = request.getParameter("name") ;
	String param2 = request.getParameter("password") ;
%>
<h3>������<%=param1%></h3>
<h3>���룺<%=param2%></h3>
</body>
</html>