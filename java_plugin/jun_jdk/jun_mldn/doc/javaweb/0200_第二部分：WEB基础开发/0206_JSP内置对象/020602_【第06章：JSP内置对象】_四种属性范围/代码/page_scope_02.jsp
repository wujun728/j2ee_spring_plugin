<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	// ��������
	pageContext.setAttribute("name","���˻�") ;
	pageContext.setAttribute("birthday",new Date()) ;
%>
<jsp:forward page="page_scope_03.jsp"/>
</body>
</html>