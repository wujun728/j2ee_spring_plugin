<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<jsp:useBean id="cou" scope="page" class="cn.mldn.lxh.demo.Count"/>
<body>
<h3>��<jsp:getProperty name="cou" property="count"/>�η��ʣ�</h3>
<jsp:forward page="page_bean02.jsp"/>
</body>
</html>