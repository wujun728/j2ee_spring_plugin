<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	pageContext.setAttribute("info","page���Է�Χ") ;
	request.setAttribute("info","request���Է�Χ") ;
	session.setAttribute("info","session���Է�Χ") ;
	application.setAttribute("info","application���Է�Χ") ;
%>
<h3>${info}</h3>
</body>
</html>