<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	// ��ŵ�������
	pageContext.setAttribute("num1",20) ;
	pageContext.setAttribute("num2",30) ;
%>
<h3>����жϣ�${num1 == num2} �� ${num1 eq num2}</h3>
<h3>�����жϣ�${num1 != num2} �� ${num1 ne num2}</h3>
<h3>С���жϣ�${num1 < num2} �� ${num1 lt num2}</h3>
<h3>�����жϣ�${num1 > num2} �� ${num1 gt num2}</h3>
<h3>С�ڵ����жϣ�${num1 <= num2} �� ${num1 le num2}</h3>
<h3>���ڵ����жϣ�${num1 >= num2} �� ${num1 ge num2}</h3>
</body>
</html>