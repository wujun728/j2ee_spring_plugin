<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	DiskFileItemFactory factory = new DiskFileItemFactory() ;
	ServletFileUpload upload = new ServletFileUpload(factory) ;
	upload.setFileSizeMax(3 * 1024 * 1024) ;	// ֻ���ϴ�3M
	List<FileItem> items = upload.parseRequest(request) ; // ����ȫ������
	Iterator<FileItem> iter = items.iterator() ;
	while(iter.hasNext()){
		FileItem item = iter.next() ;
		String fieldName = item.getFieldName() ;	// ȡ�ñ��ؼ�������
%>
		<ul><h4><%=fieldName%> --> <%=item.isFormField()%></h4>
<%
		if(!item.isFormField()){		// ������ͨ�ı�
			String fileName = item.getName() ;	// ȡ���ļ�������
			String contentType = item.getContentType() ;	// �ļ�����
			long sizeInBytes = item.getSize() ;
%>
			<li>�ϴ��ļ����ƣ�<%=fileName%>
			<li>�ϴ��ļ����ͣ�<%=contentType%>
			<li>�ϴ��ļ���С��<%=sizeInBytes%>
<%
		} else {
			String value = item.getString() ;
%>
			<li>��ͨ������<%=value%>
<%
		}
%>		</ul>
<%
	}
%>
</body>
</html>