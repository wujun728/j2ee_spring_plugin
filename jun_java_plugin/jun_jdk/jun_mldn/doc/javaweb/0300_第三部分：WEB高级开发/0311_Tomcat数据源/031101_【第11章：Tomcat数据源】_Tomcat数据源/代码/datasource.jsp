<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="javax.naming.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="java.sql.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	String DSNAME = "java:comp/env/jdbc/mldn" ;	// ����
	Context ctx = new InitialContext() ;
	DataSource ds = (DataSource) ctx.lookup(DSNAME) ;
	Connection conn = ds.getConnection() ;	// �����ӳ���ȡ����
%>
<%=conn%>
<%
	conn.close() ;	// ��ʾ�����ӷŻص���֮��
%>
</body>
</html>