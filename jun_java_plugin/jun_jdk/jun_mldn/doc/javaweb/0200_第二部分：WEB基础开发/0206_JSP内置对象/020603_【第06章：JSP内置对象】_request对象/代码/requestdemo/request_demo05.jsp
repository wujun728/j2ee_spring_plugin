<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	Enumeration enu = request.getHeaderNames() ;	// ȡ��ȫ����ͷ��Ϣ
	while(enu.hasMoreElements()){
		String headerName = (String) enu.nextElement() ;
		String headerValue = request.getHeader(headerName) ;
%>
		<h5><%=headerName%> --> <%=headerValue%></h5>
<%
	}
%>
</table>
</body>
</html>