<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://www.mldn.cn/jst/fmt"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<fmt:parseNumber value="3,531,989.357" var="num"/>
<h3>����ʽ�����֣�${num}</h3>
<fmt:parseNumber value="3.532E6" pattern="##.###E0" var="num"/>
<h3>����ѧ��������${num}</h3>
<fmt:parseNumber value="3.5%" pattern="00%" var="num"/>
<h3>���ٷֱȣ�${num}</h3>
</body>
</html>

