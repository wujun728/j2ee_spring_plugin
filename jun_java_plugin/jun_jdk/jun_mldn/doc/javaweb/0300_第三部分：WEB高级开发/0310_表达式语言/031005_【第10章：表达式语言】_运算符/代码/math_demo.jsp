<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	// ��ŵ�������
	pageContext.setAttribute("num1",20) ;
	pageContext.setAttribute("num2",30) ;
%>
<h3>�ӷ�������${num1 + num2}</h3>
<h3>����������${num1 - num2}</h3>
<h3>�˷�������${num1 * num2}</h3>
<h3>����������${num1 / num2}��${num1 div num2}</h3>
<h3>ȡģ������${num1 % num2}��${num1 mod num2}</h3>
</body>
</html>