<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="org.lxh.eldemo.vo.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	// ���ڼ�����Щ��������Servlet���
	Dept dept = new Dept() ;
	dept.setDeptno(10) ;
	dept.setDname("MLDN��ѧ��") ;
	dept.setLoc("����������") ;
	request.setAttribute("deptinfo",dept) ;
%>
<h3>���ű�ţ�${deptinfo.deptno}</h3>
<h3>�������ƣ�${deptinfo.dname}</h3>
<h3>����λ�ã�${deptinfo.loc}</h3>
</body>
</html>