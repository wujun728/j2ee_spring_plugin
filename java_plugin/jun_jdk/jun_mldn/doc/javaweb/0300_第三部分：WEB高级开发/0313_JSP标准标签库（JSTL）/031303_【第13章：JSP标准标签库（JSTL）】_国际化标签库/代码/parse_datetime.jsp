<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://www.mldn.cn/jst/fmt"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<fmt:parseDate value="2009��7��5�� ������ ����11ʱ47��45�� CST" type="both" dateStyle="full" timeStyle="full" var="date"/>
<h3>�ַ�����Ϊ���ڣ�${date}</h3>
<fmt:parseDate value="2009��07��05�� 11ʱ47��45��062����" type="both" pattern="yyyy��MM��dd�� HHʱmm��ss��SSS����" var="date"/>
<h3>�ַ�����Ϊ���ڣ�${date}</h3>
</body>
</html>

