<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	request.setCharacterEncoding("GBK") ;	%>
<h2>sesion���ԣ�<%=session.getAttribute("name")%></h2>
<h2>request���ԣ�<%=request.getAttribute("info")%></h2>
</body>
</html>