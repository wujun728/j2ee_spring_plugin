<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://www.mldn.cn/jst/fmt"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	pageContext.setAttribute("dateref",new java.util.Date()) ;
%>
<fmt:timeZone value="HST">
	<fmt:formatDate value="${dateref}" type="both" dateStyle="full" timeStyle="full" var="date"/>
</fmt:timeZone>
<h3>FULL��ʾ����ʱ�䣺${date}</h3>
</body>
</html>

