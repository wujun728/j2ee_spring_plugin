<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	// ����Ѿ����ù���session���ԣ���϶���Ϊ��
	if(session.getAttribute("userid")!=null){
%>
		<h3>��ӭ<%=session.getAttribute("userid")%>���ٱ�ϵͳ��<a href="logout.jsp">ע��</a></h3>
<%
	} else {	// û��session����Ӧ�ø�����ʾ����ȥ��½
%>
		<h3>���Ƚ���ϵͳ��<a href="login.jsp">��½</a>��</h3>
<%
	}
%>
</body>
</html>