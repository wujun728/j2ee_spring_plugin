<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="mytag" uri="mldn"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%	// �˴���ֻ��Ϊ�˲��ԣ�ʵ���д˲���Ӧ����servlet����
	List<String> all = new ArrayList<String>() ;
	all.add("www.MLDN.cn") ;
	all.add("www.MLDNJAVA.cn") ;
	all.add("www.JIANGKER.com") ;
	request.setAttribute("all",all) ;	// �����ݱ����ڱ�ǩִ��
%>
<mytag:present name="all" scope="request">
	<mytag:iterate id="url" name="all" scope="request">
		<h3>��վ��${url}</h3>
	</mytag:iterate>
</mytag:present>
</body>
</html>