<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.sql.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%!
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	public static final String DBURL = "jdbc:mysql://localhost:3306/mldn" ;
	public static final String DBUSER = "root" ;
	public static final String DBPASS = "mysqladmin" ;
%>
<%
	Connection conn = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;
%>
<%
try{
	Class.forName(DBDRIVER) ;
	conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;
	String sql = "SELECT empno,ename,job,sal,hiredate FROM emp" ;
	pstmt = conn.prepareStatement(sql) ;
	rs = pstmt.executeQuery() ;
%>
<center>
<table border="1" width="80%">
	<tr>
		<td>��Ա���</td>
		<td>��Ա����</td>
		<td>��Ա����</td>
		<td>��Ա����</td>
		<td>��Ӷ����</td>
	</tr>
<%
	while(rs.next()){
		int empno = rs.getInt(1) ;
		String ename = rs.getString(2) ;
		String job = rs.getString(3) ;
		float sal = rs.getFloat(4) ;
		java.util.Date date = rs.getDate(5) ;
%>
	<tr>
		<td><%=empno%></td>
		<td><%=ename%></td>
		<td><%=job%></td>
		<td><%=sal%></td>
		<td><%=date%></td>
	</tr>	
<%
	}
%>
</table>
</center>
<%
}catch(Exception e)	{
	System.out.println(e) ;
}finally{
	rs.close() ;
	pstmt.close() ;
	conn.close() ;	// ���ֱ�ӹر�����Ҳ����
}
%>
</body>
</html>