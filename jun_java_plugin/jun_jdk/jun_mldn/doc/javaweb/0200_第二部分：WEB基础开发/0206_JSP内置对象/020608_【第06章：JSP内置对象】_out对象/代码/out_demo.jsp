<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	int buffer = out.getBufferSize() ;
	int avaliable = out.getRemaining() ;
	int use = buffer - avaliable ;
%>
<h3>��������С��<%=buffer%></h3>
<h3>���õĻ�������С��<%=avaliable%></h3>
<h3>ʹ���еĻ�������С��<%=use%></h3>
</body>
</html>