<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*,java.io.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="cn.mldn.lxh.util.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	DiskFileItemFactory factory = new DiskFileItemFactory() ;
	factory.setRepository(new File(this.getServletContext().getRealPath("/") + "uploadtemp")) ;		// ��׼ȷ��˵��һ����ʱ�ļ�
	ServletFileUpload upload = new ServletFileUpload(factory) ;
	upload.setFileSizeMax(3 * 1024 * 1024) ;	// ֻ���ϴ�3M
	List<FileItem> items = upload.parseRequest(request) ; // ����ȫ������
	Iterator<FileItem> iter = items.iterator() ;
	IPTimeStamp its = new IPTimeStamp(request.getRemoteAddr()) ;
	while(iter.hasNext()){
		FileItem item = iter.next() ;
		String fieldName = item.getFieldName() ;	// ȡ�ñ��ؼ�������
%>
		<ul><h4><%=fieldName%> --> <%=item.isFormField()%></h4>
<%
		if(!item.isFormField()){		// ������ͨ�ı�
			File saveFile = null ;
			InputStream input = null ;
			OutputStream output = null ;
			input = item.getInputStream() ;
			output = new FileOutputStream(new File(this.getServletContext().getRealPath("/")+"upload"+File.separator+its.getIPTimeRand()+"."+item.getName().split("\\.")[1])) ;
			int temp = 0 ;
			byte data[] = new byte[512] ;
			while((temp=input.read(data,0,512))!=-1){
				output.write(data) ;	// �ֿ鱣��
			}
			input.close() ;
			output.close() ;
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