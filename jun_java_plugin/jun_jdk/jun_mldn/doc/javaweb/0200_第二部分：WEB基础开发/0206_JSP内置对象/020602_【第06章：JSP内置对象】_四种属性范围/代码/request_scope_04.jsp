<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	// ��������
	pageContext.setAttribute("name","���˻�",PageContext.REQUEST_SCOPE) ;
	pageContext.setAttribute("birthday",new Date(),PageContext.REQUEST_SCOPE) ;
%>
<jsp:forward page="request_scope_02.jsp"/>
</body>
</html>