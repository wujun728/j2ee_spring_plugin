<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://www.mldn.cn/jst/fmt"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<fmt:bundle basename="Message">
	<fmt:message key="name" var="nameref"/>
</fmt:bundle>
<h3>������${nameref}</h3>
<fmt:bundle basename="Message">
	<fmt:message key="info" var="inforef">
		<fmt:param value="MLDN"/>
	</fmt:message>
</fmt:bundle>
<h3>��Ϣ��${inforef}</h3>
</body>
</html>

