<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	long start = session.getCreationTime() ;
	long end = session.getLastAccessedTime() ;
	long time = (end - start) / 1000 ;
%>
<h3>���Ѿ�ͣ����<%=time%>�룡</h3>
</body>
</html>