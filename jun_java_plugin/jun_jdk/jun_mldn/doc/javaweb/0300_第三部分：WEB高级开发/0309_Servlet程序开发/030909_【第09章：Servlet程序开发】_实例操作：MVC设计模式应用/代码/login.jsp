<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<script language="javascript">
	function validate(f){
		if(!(/^\w{5,15}$/.test(f.userid.value))){
			alert("�û�ID������5~15λ��") ;
			f.userid.focus() ;
			return false ;
		}
		if(!(/^\w{5,15}$/.test(f.userpass.value))){
			alert("���������5~15λ��") ;
			f.userpass.focus() ;
			return false ;
		}
	}
</script>
<%
	request.setCharacterEncoding("GBK") ;
%>
<%
	List<String> info = (List<String>) request.getAttribute("info") ;
	if(info != null){	// ����Ϣ����
		Iterator<String> iter = info.iterator() ;
		while(iter.hasNext()){
%>
			<h4><%=iter.next()%></h4>
<%
		}
	}
%>
<form action="LoginServlet" method="post" onSubmit="return validate(this)">
	�û�ID��<input type="text" name="userid"><br>
	��&nbsp;&nbsp;�룺<input type="password" name="userpass"><br>
	<input type="submit" value="��½">
	<input type="reset" value="����">
</form>
</body>
</html>