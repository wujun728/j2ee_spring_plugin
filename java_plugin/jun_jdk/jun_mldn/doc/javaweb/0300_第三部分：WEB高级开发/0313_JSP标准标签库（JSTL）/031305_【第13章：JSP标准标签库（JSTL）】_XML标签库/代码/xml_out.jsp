<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/jst/core"%>
<%@ taglib prefix="x" uri="http://www.mldn.cn/jst/x"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
	<c:import var="add" url="/xml_jstl/address.xml" charEncoding="GBK"/>
	<x:parse var="addressXml" doc="${add}"/>
	<h3>������<x:out select="$addressXml/addresslist/linkman/name"/>����ţ�<x:out select="$addressXml/addresslist/linkman/name/@id"/>��</h3>
	<h3>���䣺<x:out select="$addressXml/addresslist/linkman/email"/></h3>
</body>
</html>