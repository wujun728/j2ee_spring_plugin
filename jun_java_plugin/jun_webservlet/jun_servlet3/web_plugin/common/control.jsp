<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<html>
	<head>
	<title>����ҵ�����</title>
	<script type="text/javascript">
		var basePath = "<%=basePath%>";
	</script>
	<script type="text/javascript" src="<%=basePath%>/template/js/control.js"></script>
	</head>
	<body scroll="no">
		<table id="ctrlTable" cellpadding="0" cellspacing="0"
			style="width: 100%; height: 100%; margin: 0px;">
			<tr>
				<td valign="top">
					<ptx:DataGrid id="controlMatterList" pagination="true"
						pageSize="25" pageList="[25,50,100]" singleSelect="true"
						remoteSort="false" striped="true" ondblclick="clickMatter"
						border="0"
						toolbar="[{text:'����ͼ',iconCls:'icon-photo',handler:showWfPic}]">
						<ptx:DataGridRow>
							<ptx:DataGridField field="ACTSTATENAME" width="100"
								align="center" title="�������" sortable="true" />
							<ptx:DataGridField field="BICODE" width="200" align="center"
								title="�����" dataAlign="left" sortable="true"/>
							<ptx:DataGridField field="KHMC" width="250" align="center"
								title="����Ƶ�λ" dataAlign="left" sortable="true" />
							<ptx:DataGridField field="BUSSNAME" width="120" align="center"
								title="ҵ�����" dataAlign="left" sortable="true" />
							<ptx:DataGridField field="SYBH" width="100" align="center"
								title="������" dataAlign="left" sortable="true"/>
							<ptx:DataGridField field="XMMC" width="250" align="center"
								title="��Ŀ����" dataAlign="left" sortable="true"/>
							<ptx:DataGridField field="BZRYMC" width="120" align="center"
								title="������Ա" dataAlign="left" sortable="true"/>
							<ptx:DataGridField field="BZRQ" width="120" align="center"
								title="��������" dataAlign="center" sortable="true"/>
							<ptx:DataGridField field="FHRYMC" width="120" align="center"
								title="������Ա" dataAlign="left" sortable="true" />
							<ptx:DataGridField field="FHRQ" width="120" align="center"
								title="��������" dataAlign="center" sortable="true"/>

							<ptx:DataGridField field="BILLID" width="" title="����ID"
								hidden="true" />
							<ptx:DataGridField field="THBZ" width="" title="�˻ر�ʶ"
								hidden="true" />
							<ptx:DataGridField field="WFINSTID" width="" title="����ʵ��ID"
								hidden="true" />
							<ptx:DataGridField field="ACTINSTID" width="" title="�ʵ��ID"
								hidden="true" />
							<ptx:DataGridField field="ACTCODE" width="" title="��������"
								hidden="true" />
							<ptx:DataGridField field="YNCODE" width="" title="�༭Ȩ��"
								hidden="true" />
							<ptx:DataGridField field="QYJDID" width="" title="��������"
								hidden="true" />
						</ptx:DataGridRow>
					</ptx:DataGrid>
				</td>
			</tr>
		</table>
	</body>
</html>
