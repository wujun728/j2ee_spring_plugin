<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	// ��ŵ�������
	pageContext.setAttribute("num1",10) ;
	pageContext.setAttribute("num2",20) ;
	pageContext.setAttribute("num3",30) ;
%>
<h3>empty������${empty info}</h3>
<h3>��Ŀ������${num1>num2 ? "����" : "С��"}</h3>
<h3>���Ų�����${num1 * (num2 + num3)}</h3>
</body>
</html>