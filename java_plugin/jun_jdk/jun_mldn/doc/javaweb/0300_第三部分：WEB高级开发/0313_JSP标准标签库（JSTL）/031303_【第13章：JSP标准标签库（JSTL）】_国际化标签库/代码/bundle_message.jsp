<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://www.mldn.cn/jst/fmt"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<fmt:setLocale value="zh_CN"/>
<fmt:setBundle basename="Message" var="msg"/>
<fmt:message key="name" var="nameref" bundle="${msg}"/>
<h3>������${nameref}</h3>
<fmt:message key="info" var="inforef" bundle="${msg}">
	<fmt:param value="MLDN"/>
</fmt:message>
<h3>��Ϣ��${inforef}</h3>
</body>
</html>

