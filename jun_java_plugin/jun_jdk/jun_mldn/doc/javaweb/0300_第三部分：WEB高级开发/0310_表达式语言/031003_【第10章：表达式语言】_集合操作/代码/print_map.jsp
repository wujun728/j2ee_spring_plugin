<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	Map map = new HashMap() ;
	map.put("lxh","���˻�") ;
	map.put("mldn","www.MLDNJAVA.cn") ;
	map.put("email","mldnqa@163.com") ;
	request.setAttribute("info",map) ;	// ���ϱ�����request��Χ
%>
<h3>KEYΪlxh�����ݣ�${info["lxh"]}</h3>
<h3>KEYΪmldn�����ݣ�${info["mldn"]}</h3>
<h3>KEYΪemail�����ݣ�${info["email"]}</h3>
</body>
</html>