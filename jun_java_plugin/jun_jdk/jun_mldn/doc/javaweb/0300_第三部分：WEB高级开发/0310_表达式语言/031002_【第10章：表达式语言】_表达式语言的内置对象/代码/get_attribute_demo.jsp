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
<h3>PAGE�������ݣ�${pageScope.info}</h3>
<h3>REQUEST�������ݣ�${requestScope.info}</h3>
<h3>SESSION�������ݣ�${sessionScope.info}</h3>
<h3>APPLICATION�������ݣ�${applicationScope.info}</h3>
</body>
</html>