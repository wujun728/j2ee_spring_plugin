<%@ page language="java" pageEncoding="UTF-8"%>
 <!DOCTYPE HTML>
 <html>
   <head>
     <title>Servlet3.0ʵ���ļ��ϴ�</title>
   </head>
   
   <body>
         <fieldset>
             <legend>
                 �ϴ������ļ�
             </legend>
             <!-- �ļ��ϴ�ʱ����Ҫ���ñ���enctype="multipart/form-data"-->
             <form action="${pageContext.request.contextPath}/UploadServlet"
                 method="post" enctype="multipart/form-data">
                 �ϴ��ļ���
                 <input type="file" name="file">
                 <br>
                 <input type="submit" value="�ϴ�">
             </form>
         </fieldset>
         <hr />
         <fieldset>
             <legend>
                 �ϴ�����ļ�
             </legend>
             <!-- �ļ��ϴ�ʱ����Ҫ���ñ���enctype="multipart/form-data"-->
             <form action="${pageContext.request.contextPath}/UploadServlet"
                 method="post" enctype="multipart/form-data">
                 �ϴ��ļ���
                 <input type="file" name="file1">
                 <br>
                 �ϴ��ļ���
                 <input type="file" name="file2">
                 <br>
                 <input type="submit" value="�ϴ�">
             </form>
         </fieldset>
     </body>
 </html>