<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="fn" uri="http://www.mldn.cn/jst/fn"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	pageContext.setAttribute("info","Hello MLDN ,Hello LiXingHua") ;
%>
<h3>�滻��${fn:replace(info,"MLDN","www.MLDNJAVA.cn")}</h3>
<h3>��ȡ��${fn:substring(info,0,10)}</h3>
<h3>��֣�${fn:split(info," ")[0]}</h3>
</body>
</html>