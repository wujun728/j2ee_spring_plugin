<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	request.setCharacterEncoding("GBK") ;// ���õ���ͳһ����
	Enumeration enu = request.getParameterNames() ;
%>
<table border="1">
	<tr>
		<td>��������</td>
		<td>��������</td>
	</tr>
<%
	while(enu.hasMoreElements()){
		String paramName = (String) enu.nextElement() ;
%>
		<tr>
			<td><%=paramName%></td>
			<td>
<%
			if(paramName.startsWith("**")){		// ����**��ͷ
				String paramValue[] = request.getParameterValues(paramName) ;
				for(int x=0;x<paramValue.length;x++){
%>
					<%=paramValue[x]%>��
<%
				}
			} else {
				String paramValue = request.getParameter(paramName) ;
%>
				<%=paramValue%>
<%
			}
%>
			</td>
		</tr>
<%
	}
%>
</table>
</body>
</html>