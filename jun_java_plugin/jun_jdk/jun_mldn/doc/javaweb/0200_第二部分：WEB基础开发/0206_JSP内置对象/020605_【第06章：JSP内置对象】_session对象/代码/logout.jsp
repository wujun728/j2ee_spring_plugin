<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	response.setHeader("refresh","2;URL=login.jsp") ;
	session.invalidate() ;	// ע������ʾ��ǰ��sessionʧЧ
%>
<h3>���ѳɹ��˳���ϵͳ���������ת����ҳ��</h3>
<h3>���û����ת���밴<a href="login.jsp">����</a>��</h3>
</body>
</html>