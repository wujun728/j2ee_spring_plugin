<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	// ��ŵ�������
	pageContext.setAttribute("flagA",true) ;
	pageContext.setAttribute("flagB",false) ;
%>
<h3>�������${flagA && flagB} �� ${flagA and flagB}</h3>
<h3>�������${flagA || flagB} �� ${flagA or flagB}</h3>
<h3>�ǲ�����${!flagA} �� ${not flagB}</h3>
</body>
</html>