<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/jst/core"%>
<%@ taglib prefix="sql" uri="http://www.mldn.cn/jst/sql"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<sql:setDataSource dataSource="jdbc/mldn" var="mldnds"/>
<sql:query var="result" dataSource="${mldnds}" maxRows="2" startRow="2">
	SELECT empno,ename,job,hiredate,sal FROM emp ;
</sql:query>
<h3>һ����${result.rowCount}����¼��</h3>
<table border="1" width="100%">
	<tr>
		<td>��Ա���</td>
		<td>��Ա����</td>
		<td>��Ա����</td>
		<td>��Ա����</td>
		<td>��Ӷ����</td>
	</tr>
	<c:forEach items="${result.rows}" var="row">
		<tr>
			<td>${row.empno}</td>
			<td>${row.ename}</td>
			<td>${row.job}</td>
			<td>${row.sal}</td>
			<td>${row.hiredate}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>