<%@page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.sql.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<center>
<h1>��½����</h1>
<hr>
<%!	// �������ɸ����ݿ�����ӳ���
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	public static final String DBURL = "jdbc:mysql://localhost:3306/mldn" ;
	public static final String DBUSER = "root" ;
	public static final String DBPASS = "mysqladmin" ;
%>
<%
	Connection conn = null ;		// ���ݿ�����
	PreparedStatement pstmt = null ;	// ���ݿ�Ԥ�������
	ResultSet rs = null ;		// ��ѯҪ��������
	boolean flag = false ;	// ������
	String name = null ;	// ������ʵ����
%>
<%
try{
%>
<%
	Class.forName(DBDRIVER) ;
	conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;
	String sql = "SELECT name FROM user WHERE userid=? AND password=?" ;
	pstmt = conn.prepareStatement(sql) ;
	pstmt.setString(1,request.getParameter("id")) ;
	pstmt.setString(2,request.getParameter("password")) ;
	rs = pstmt.executeQuery() ;	// ��ѯ
	if(rs.next()){	// ��������ݣ������ִ��
		flag = true ;	//  ��ʾ��½�ɹ�
		name = rs.getString(1) ;
	}	
%>
<%
}catch(Exception e)	{
	e.printStackTrace() ;
}
finally{
	try{
		rs.close() ;
		pstmt.close() ;
		conn.close() ;
	} catch(Exception e){}
}
%>
<%
	if(flag){	// ��½�ɹ�
%>
		<jsp:forward page="login_success.jsp">
			<jsp:param name="uname" value="<%=name%>"/>
		</jsp:forward>
<%
	} else {		// ��½ʧ��
%>
		<jsp:forward page="login_failure.jsp"/>
<%
	}
%>
</center>
</body>
</html>