<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/jst/core"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
	<c:if test="${param.ref=='mldn'}" var="res1" scope="page">
		<h3>��ӭ${param.ref}����</h3>
	</c:if>
	<c:if test="${10<30}" var="res2">
		<h3>10��30С</h3>
	</c:if>
</body>
</html>