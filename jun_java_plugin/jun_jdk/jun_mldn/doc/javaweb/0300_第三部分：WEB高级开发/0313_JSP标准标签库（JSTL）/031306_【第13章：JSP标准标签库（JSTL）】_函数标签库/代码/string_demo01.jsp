<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="fn" uri="http://www.mldn.cn/jst/fn"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	pageContext.setAttribute("info","Hello MLDN ,Hello LiXingHua") ;
%>
<h3>����MLDN��${fn:contains(info,"MLDN")}</h3>
<h3>����MLDN��${fn:containsIgnoreCase(info,"mldn")}</h3>
<h3>�жϿ�ͷ��${fn:startsWith(info,"Hello")}</h3>
<h3>�жϽ�β��${fn:endsWith(info,"Hello")}</h3>
<h3>����λ�ã�${fn:indexOf(info,",")}</h3>
</body>
</html>