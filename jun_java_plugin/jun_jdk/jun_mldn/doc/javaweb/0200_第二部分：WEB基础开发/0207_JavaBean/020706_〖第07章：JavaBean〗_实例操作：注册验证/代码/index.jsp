<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<%
	request.setCharacterEncoding("GBK") ;
%>
<jsp:useBean id="reg" scope="request" class="cn.mldn.lxh.demo.Register"/>
<body>
<form action="check.jsp" method="post">
	�û�����<input type="text" name="name" value="<jsp:getProperty name="reg" property="name"/>"/><%=reg.getErrorMsg("errname")%><br>
	��&nbsp;&nbsp;�䣺<input type="text" name="age" value="<jsp:getProperty name="reg" property="age"/>"/><%=reg.getErrorMsg("errage")%><br>
	E-MAIL��<input type="text" name="email" value="<jsp:getProperty name="reg" property="email"/>"/><%=reg.getErrorMsg("erremail")%><br>
	<input type="submit" value="ע��">
	<input type="reset" value="����">
</form>
</body>
</html>