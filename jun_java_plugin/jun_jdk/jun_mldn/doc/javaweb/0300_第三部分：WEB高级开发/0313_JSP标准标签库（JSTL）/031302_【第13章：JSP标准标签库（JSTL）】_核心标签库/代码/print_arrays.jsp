<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/jst/core"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
	<%
		String info[] = {"MLDN","LiXingHua","www.MLDNJAVA.cn"} ;
		pageContext.setAttribute("ref",info) ;
	%>
	<h3>���ȫ����
	<c:forEach items="${ref}" var="mem">
		${mem}��
	</c:forEach></h3>
	<h3>���ȫ�������Ϊ2����
	<c:forEach items="${ref}" var="mem" step="2">
		${mem}��
	</c:forEach></h3>
	<h3>���ǰ������
	<c:forEach items="${ref}" var="mem" begin="0" end="1">
		${mem}��
	</c:forEach></h3>
</body>
</html>