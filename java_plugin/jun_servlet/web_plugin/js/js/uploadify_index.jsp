<%@ page language="java" contentType="text/html; charset=gbk"%>

<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>Upload</title>

		<!--װ���ļ�-->
		<link href="uploadify-v3.1/uploadify.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="uploadify-v3.1/jquery.uploadify-3.1.js"></script>
		<script type="text/javascript" src="js/swfobject.js"></script>
		

		<!--ready�¼�-->
		<script type="text/javascript">
		 	$(document).ready(function () {
				��$("#uploadify").uploadify({
					��'swf': 'uploadify-v3.1/uploadify.swf', 
					  'uploader':'servlet/upload', 
					��//'script':'upload!doUpload.action?name=yangxiang',
					��//'script': 'servlet/Upload?name=yangxiang',  
					��//'cancel' : 'uploadify/uploadify-cancel.png',                  
					��'queueID' : 'fileQueue', 
					 //�ʹ�Ŷ��е�DIV��idһ��  
					��//'fileDataName': 'fileupload', //���룬������input��name����һ��                   
					��'auto'  : false, //�Ƿ��Զ���ʼ  
					��'multi': true, //�Ƿ�֧�ֶ��ļ��ϴ�  
					  'buttonText': 'ѡ���ļ�', //��ť�ϵ�����  
					��'simUploadLimit' : 1, //һ��ͬ���ϴ����ļ���Ŀ  
					��//'sizeLimit': 19871202, //���õ����ļ���С���ƣ���λΪbyte  
					��'fileSizeLimit' : '6000KB',
					  'queueSizeLimit' : 100, //������ͬʱ���ڵ��ļ���������  
					��'fileTypeExts': '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//����ĸ�ʽ
					  'fileTypeDesc': '֧�ָ�ʽ:jpg/gif/jpeg/png/bmp.', //������������µ�'fileExt'���ԣ���ô��������Ǳ����  
					��'onUploadSuccess': function ( fileObj, response, data) {  
					��		alert("�ļ�:" + fileObj.name + "�ϴ��ɹ�");
					��},  
					��'onUploadError': function(event, queueID, fileObj) {  
					��		alert("�ļ�:" + fileObj.name + "�ϴ�ʧ��");  
					��},  
					��'onCancel': function(event, queueID, fileObj){  
					��		alert("ȡ����" + fileObj.name);  
					������} 
				��});
				
			});

    	</script>
	</head>

	<body>

		<div id="fileQueue" style="width:30%"></div>

		<input type="file" name="uploadify" id="uploadify" />

		<p>

			<a href="javascript:jQuery('#uploadify').uploadify('upload','*')">��ʼ�ϴ�</a>&nbsp;

			<a href="javascript:jQuery('#uploadify').uploadifyClearQueue()">ȡ�������ϴ�</a>

		</p>

	</body>

</html>

