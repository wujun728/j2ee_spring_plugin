<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="org.lxh.listenerdemo.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	LoginUser user = new LoginUser("MLDN") ;
	session.setAttribute("info",user) ;	// ֱ�ӱ���LoginUser����
%>
</body>
</html>