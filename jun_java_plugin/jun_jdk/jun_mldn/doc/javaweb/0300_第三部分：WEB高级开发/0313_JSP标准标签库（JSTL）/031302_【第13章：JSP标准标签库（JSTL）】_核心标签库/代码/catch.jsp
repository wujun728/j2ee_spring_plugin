<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/jst/core"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
	<c:catch var="errmsg">
		<%
			int result = 10 / 0 ;
		%>
	</c:catch>
	<h3>�쳣��Ϣ��${errmsg}</h3>
</body>
</html>