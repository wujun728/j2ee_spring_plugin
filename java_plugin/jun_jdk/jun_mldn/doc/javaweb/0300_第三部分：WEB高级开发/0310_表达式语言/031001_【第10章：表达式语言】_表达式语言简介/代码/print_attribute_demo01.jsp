<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	// �������µ��������Բ�������Servlet֮�����
	request.setAttribute("info","www.MLDNJAVA.cn") ;	// ����һ��request���Է�Χ
%>
<%
	if(request.getAttribute("info") != null){	// ���������Դ���
%>
		<h3><%=request.getAttribute("info")%></h3>
<%
	}
%>
</body>
</html>