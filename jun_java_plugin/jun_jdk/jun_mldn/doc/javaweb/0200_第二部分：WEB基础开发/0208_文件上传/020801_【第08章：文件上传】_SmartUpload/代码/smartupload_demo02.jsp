<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="org.lxh.smart.*"%>
<%@ page import="cn.mldn.lxh.util.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	request.setCharacterEncoding("GBK") ;
%>
<%
	SmartUpload smart = new SmartUpload() ;
	smart.initialize(pageContext) ;	// ��ʼ���ϴ�����
	smart.upload() ;			// �ϴ�׼��
	String name = smart.getRequest().getParameter("uname") ;
	IPTimeStamp its = new IPTimeStamp(request.getRemoteAddr()) ;	// ȡ�ÿͻ��˵�IP��ַ
	String ext = smart.getFiles().getFile(0).getFileExt() ;	// ��չ����
	String fileName = its.getIPTimeRand() + "." + ext ;
	smart.getFiles().getFile(0).saveAs(this.getServletContext().getRealPath("/")+"upload"+java.io.File.separator + fileName) ;
%>
<%=smart.getFiles().getFile(0).getFileName().matches("^\\w+.(jpg|gif)$")%>
<h2>������<%=name%></h2>
<img src="../upload/<%=fileName%>">
</body>
</html>