<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="cn.mldn.lxh.factory.*,cn.mldn.lxh.vo.*"%>
<%@ page import="java.util.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<%	request.setCharacterEncoding("GBK") ;	%>
<body>
<%
	String keyWord = request.getParameter("kw") ;
	if(keyWord == null){
		keyWord = "" ;	// ���û�в�ѯ�ؼ��֣����ѯȫ��
	}
	List<Emp> all = DAOFactory.getIEmpDAOInstance().findAll(keyWord) ;
	Iterator<Emp> iter = all.iterator() ;
%>
<center>
<form action="emp_list.jsp" method="post">
	�������ѯ�ؼ��֣�<input type="text" name="kw">
	<input type="submit" value="��ѯ">
</form>
<table border="1" width="80%"> 
	<tr>
		<td>��Ա���</td>
		<td>��Ա����</td>
		<td>��Ա����</td>
		<td>��Ӷ����</td>
		<td>��������</td>
	</tr>
<%
	while(iter.hasNext()){
		Emp emp = iter.next() ;
%>
	<tr>
		<td><%=emp.getEmpno()%></td>
		<td><%=emp.getEname()%></td>
		<td><%=emp.getJob()%></td>
		<td><%=emp.getHiredate()%></td>
		<td><%=emp.getSal()%></td>
	</tr>
<%
	}
%>
</table>
</center>
</body>
</html>