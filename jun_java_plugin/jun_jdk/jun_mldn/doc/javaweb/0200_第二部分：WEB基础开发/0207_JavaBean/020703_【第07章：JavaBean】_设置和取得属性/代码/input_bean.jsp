<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	request.setCharacterEncoding("GBK") ;	%>
<jsp:useBean id="simple" scope="page" class="cn.mldn.lxh.demo.SimpleBean"/>
<jsp:setProperty name="simple" property="*"/>
<h3>������<jsp:getProperty name="simple" property="name"/></h3>
<h3>���䣺<jsp:getProperty name="simple" property="age"/></h3>
</body>
</html>