<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	request.setCharacterEncoding("GBK") ;// ���õ���ͳһ����
	//String content = new // String(request.getParameter("info").getBytes("ISO8859-1")) ;
	String content = request.getParameter("info") ;
%>
<h2><%=content%></h2>
</body>
</html>