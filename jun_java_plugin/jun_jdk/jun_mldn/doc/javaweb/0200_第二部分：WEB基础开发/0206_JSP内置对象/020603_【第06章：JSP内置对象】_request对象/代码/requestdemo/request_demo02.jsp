<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	request.setCharacterEncoding("GBK") ;// ���õ���ͳһ����
	String id = request.getParameter("id") ;
	String name = request.getParameter("uname") ;
	String inst[] = request.getParameterValues("inst") ;
%>
<h3>��ţ�<%=id%></h3>
<h3>������<%=name%></h3>
<h3>��Ȥ��
<%
if(inst != null) {
	for(int x=0;x<inst.length;x++){
%>
		<%=inst[x]%>��
<%
	}
}
%>
</h3>
</body>
</html>