<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<%
	request.setCharacterEncoding("GBK") ;
%>
<jsp:useBean id="reg" scope="request" class="cn.mldn.lxh.demo.Register"/>
<body>
	�û�����<jsp:getProperty name="reg" property="name"/><br>
	��&nbsp;&nbsp;�䣺<jsp:getProperty name="reg" property="age"/><br>
	E-MAIL��<jsp:getProperty name="reg" property="email"/><br>
</body>
</html>