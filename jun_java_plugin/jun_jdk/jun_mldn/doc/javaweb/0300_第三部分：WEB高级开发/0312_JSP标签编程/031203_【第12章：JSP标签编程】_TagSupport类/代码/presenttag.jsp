<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="mytag" uri="mldn"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
	<%
		String scope = "session" ;	// ���������жϵ���session��Χ
		session.setAttribute("username","���˻�") ;
	%>
	<mytag:present name="username" scope="<%=scope%>">
		<h2><%=scope%>��Χ�������ԣ������ǣ���${sessionScope.username}��</h2>
	</mytag:present>
	<mytag:present name="allusers" scope="request">
		<h2>request��Χ�������ԣ������ǣ���${requestScope.allusers}��</h2>
	</mytag:present>
</body>
</html>