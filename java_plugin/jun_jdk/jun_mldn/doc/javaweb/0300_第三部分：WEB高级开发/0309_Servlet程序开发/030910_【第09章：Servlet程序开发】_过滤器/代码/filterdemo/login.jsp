<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<form action="login.jsp" method="post">
	�û�����<input type="text" name="uname"><br>
	��&nbsp;&nbsp;�룺<input type="password" name="upass"><br>
	<input type="submit" value="��½">
	<input type="reset" value="����">
</form>
<%	// ֱ��ͨ��һ���̶����û���������
	String name = request.getParameter("uname") ;
	String password = request.getParameter("upass") ;
	if(!(name==null || "".equals(name) || password==null || "".equals(password))){
		if("lixinghua".equals(name) && "mldn".equals(password)){
			// �����½�ɹ���������session���Է�Χ��
			session.setAttribute("userid",name) ;
			response.setHeader("refresh","2;URL=welcome.jsp") ;
%>
			<h3>�û���½�ɹ����������ת����ӭҳ��</h3>
			<h3>���û����ת���밴<a href="welcome.jsp">����</a>��</h3>
<%
		} else {
%>
			<h3>������û��������룡</h3>
<%
		}
	}
%>
</body>
</html>