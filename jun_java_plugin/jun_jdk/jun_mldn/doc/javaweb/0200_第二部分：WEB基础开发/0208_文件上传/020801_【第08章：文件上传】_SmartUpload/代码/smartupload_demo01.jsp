<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="org.lxh.smart.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	SmartUpload smart = new SmartUpload() ;
	smart.initialize(pageContext) ;	// ��ʼ���ϴ�����
	smart.upload() ;			// �ϴ�׼��
	smart.save("upload") ;	// �ļ�����
%>
</body>
</html>