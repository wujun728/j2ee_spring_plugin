<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	if(session.isNew()){
%>
		<h3>��ӭ���û����٣�</h3>
<%
	} else {
%>
		<h3>���Ѿ������û��ˣ�</h3>
<%
	}
%>
</body>
</html>