<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/jst/core"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	pageContext.setAttribute("info","<www.MLDN.cn>") ;
%>
<h3>���Դ��ڣ�<c:out value="${info}"/></h3>
<h3>���Բ����ڣ�<c:out value="${ref}" default="û�д����ݣ�"/></h3>
<h3>���Դ��ڣ�<c:out value="${ref}">û�д����ݣ�</c:out></h3>
</body>
</html>