<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/jst/core"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
	<%
		pageContext.setAttribute("num",10) ;
	%>
	<c:choose>
		<c:when test="${num1==10}">
			<h3>num���Ե�������10��</h3>
		</c:when>
		<c:when test="${num1==20}">
			<h3>num���Ե�������20��</h3>
		</c:when>
		<c:otherwise>
			<h3>û��һ���������㣡</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>