<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	request.setCharacterEncoding("GBK") ;	%>
<jsp:useBean id="simple" scope="page" class="cn.mldn.lxh.demo.SimpleBean"/>
<jsp:setProperty name="simple" property="*"/>
<h3>������<%=simple.getName()%></h3>
<h3>���䣺<%=simple.getAge()%></h3>
</body>
</html>