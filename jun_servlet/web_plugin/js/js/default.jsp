<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head id="Head1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI- 1.2.5 ���⻻��</title>
    <%@ include file="/common/common.jsp" %>
    <script type="text/javascript" src="<%=basePath%>easyui/js/outlook2.js"></script>
    <script type="text/javascript">
	 var _menus = {"menus":[
						{"menuid":"1","icon":"icon-sys","menuname":"�ؼ�ʹ��",
							"menus":[
									{"menuid":"12","menuname":"������","icon":"icon-add","url":"http://hxling.cnblogs.com"},
									{"menuid":"13","menuname":"�û�����","icon":"icon-users","url":"demo2.html"},
									{"menuid":"14","menuname":"��ɫ����","icon":"icon-role","url":"demo2.html"},
									{"menuid":"15","menuname":"Ȩ������","icon":"icon-set","url":"demo.html"},
									{"menuid":"16","menuname":"ϵͳ��־","icon":"icon-log","url":"demo1.html"}
								]
						},{"menuid":"8","icon":"icon-sys","menuname":"Ա������",
							"menus":[{"menuid":"21","menuname":"Ա���б�","icon":"icon-nav","url":"demo.html"},
									{"menuid":"22","menuname":"��Ƶ���","icon":"icon-nav","url":"demo1.html"}
								]
						},{"menuid":"56","icon":"icon-sys","menuname":"���Ź���",
							"menus":[{"menuid":"31","menuname":"��Ӳ���","icon":"icon-nav","url":"demo1.html"},
									{"menuid":"32","menuname":"�����б�","icon":"icon-nav","url":"demo2.html"}
								]
						},{"menuid":"28","icon":"icon-sys","menuname":"�������",
							"menus":[{"menuid":"41","menuname":"��֧����","icon":"icon-nav","url":"demo.html"},
									{"menuid":"42","menuname":"����ͳ��","icon":"icon-nav","url":"demo1.html"},
									{"menuid":"43","menuname":"���֧��","icon":"icon-nav","url":"demo2.html"}
								]
						},{"menuid":"39","icon":"icon-sys","menuname":"�̳ǹ���",
							"menus":[{"menuid":"51","menuname":"��Ʒ����","icon":"icon-nav","url":"demo.html"},
									{"menuid":"52","menuname":"��Ʒ�б�","icon":"icon-nav","url":"demo1.html"},
									{"menuid":"53","menuname":"��Ʒ����","icon":"icon-nav","url":"demo2.html"}
								]
						}
				]};
        //���õ�¼����
        function openPwd() {
            $('#w').window({
                title: '�޸�����',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //�رյ�¼����
        function closePwd() {
            $('#w').window('close');
        }

        

        //�޸�����
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('ϵͳ��ʾ', '���������룡', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('ϵͳ��ʾ', '����һ���������룡', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('ϵͳ��ʾ', '�������벻һ��������������', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
                msgShow('ϵͳ��ʾ', '��ϲ�������޸ĳɹ���<br>����������Ϊ��' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })
            
        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('ϵͳ��ʾ', '��ȷ��Ҫ�˳����ε�¼��?', function(r) {

                    if (r) {
                        location.href = '/ajax/loginout.ashx';
                    }
                });
            })
            changeThemeFun = function(themeName) {/*��������*/
    			$common_easyuiTheme = $('#common_easyuiTheme');
    			var url = $common_easyuiTheme.attr('href');
    			$common_easyuiTheme.attr('href', url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css');
    		};
        });
		
		

    </script>


</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='��Ǹ���뿪���ű�֧�֣�' />
</div></noscript>
   <div region="north" split="true" border="false" style="overflow: hidden; height: 40px;background:#B9E7FE;
        line-height: 20px;color: #fff; font-family: Verdana, ΢���ź�,����">
        <span style="padding-left:10px; font-size: 16px;float:left;position:absolute; "><img src="images/blocks.gif" width="20" height="20" align="absmiddle" />jQuery easyUI ��������</span>
        <div class="head" style="float:right;background:#B9E7FE;padding:5px;width:180px;border:0px solid #B9E7FE;">  
		    <a href="#" class="easyui-menubutton" style="float:right;"  menu="#mm2" iconCls="icon-help">ע��</a>  
		    <a href="#" class="easyui-menubutton" style="float:right;"  menu="#mm1" iconCls="icon-edit" >�������</a>  
		</div>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">��Ȩ����</div>
    	
    </div>
    <div region="west" hide="true" split="true" title="�����˵�" style="width:180px;" id="west">
<div id="nav" class="easyui-accordion" fit="true" border="false">
		<!--  �������� -->
				
			</div>

    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="��ӭʹ��" style="padding:20px;overflow:hidden; color:red; " >
				<h1 style="font-size:24px;">* BLOG: <a style="font-size:24px;color:green;" href="<%=basePath%>/MyJsp.jsp">link</a></h1>
				<h1 style="font-size:24px;">* ��棺</h1>
			</div>
		</div>
    </div>
    <!--�޸����봰��-->
    <div id="w" class="easyui-window" title="�޸�����" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>�����룺</td>
                        <td><input id="txtNewPass" type="password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>ȷ�����룺</td>
                        <td><input id="txtRePass" type="password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    ȷ��</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">ȡ��</a>
            </div>
        </div>
    </div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabupdate">ˢ��</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">�ر�</div>
		<div id="mm-tabcloseall">ȫ���ر�</div>
		<div id="mm-tabcloseother">����֮��ȫ���ر�</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">��ǰҳ�Ҳ�ȫ���ر�</div>
		<div id="mm-tabcloseleft">��ǰҳ���ȫ���ر�</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">�˳�</div>
	</div>

	<div id="mm1" style="width:150px;">  
		    <div class="menu-sep"></div>  
		    <div iconCls="icon-redo">  
		        <span>��������</span>  
		        <div style="width:150px;">  
		            <div onclick="changeThemeFun('default');">default</div>  
		            <div onclick="changeThemeFun('metro');">metro</div>  
		            <div onclick="changeThemeFun('gray');">gray</div>  
		        </div>  
		    </div>  
		    <div iconCls="icon-undo">��������</div>  
		</div>   
		<div id="mm2" style="width:100px;">  
		    <div>���µ�¼</div>  
		    <div>�˳�ϵͳ</div>  
		</div>  
</body>
</html>