<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	Cookie c[] = request.getCookies() ;	// ȡ�ÿͻ��˵�ȫ��Cookie
	System.out.println(c) ;
	for(int x=0;x<c.length;x++){
%>
		<h3><%=c[x].getName()%> --> <%=c[x].getValue()%></h3>
<%
	}
%>
</body>
</html>