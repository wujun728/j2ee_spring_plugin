<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> --%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
    request.setAttribute("basePath", basePath);
    Map actDefMap = (Map)request.getAttribute("actDefMap");
    //Map actMap = (Map)request.getAttribute("actMap");
   // String actName = "";
    //if(!actMap.isEmpty()){
    //	actName = (String)actMap.get("ACTNAME");
    //}
    String exeFlag = request.getAttribute("exeFlag").toString();
    String biCode = request.getAttribute("biCode").toString();
    String actCode = request.getAttribute("actCode").toString();
    String billId = request.getAttribute("billId").toString();
    
    String toolbar = "[";
    if ("1".equals(exeFlag)
            && ("".equals(biCode) || "fillForm".equals(actCode))) {
        toolbar += "{id:'fileAdd', text:'�ϴ�', iconCls:'icon-upload', handler:uploadFile},"
                + "{id:'fileDel', text:'ɾ��', iconCls:'icon-delete', handler:delFile},";
    }
    toolbar += "{id:'fileDown', text:'����', iconCls:'icon-download', handler:downloadFile}]";
    String sqlStr = "SELECT BUSSCODE AS id,LPAD('��', (LEVEL - 1) * 4, '��') || BUSSNAME AS text"
            + " FROM DEF_BUSSTYPE WHERE ISUSE = 1 START WITH PBUSSCODE = 0"
            + " CONNECT BY PRIOR BUSSCODE = PBUSSCODE";
    //ҵ�����Ϊ������������֮��״̬�Ŀͻ�
    String cusSql = "SELECT A.CUSCODE AS id , A.CUSNAME AS text FROM CM_CUSTOMER A"
            + " WHERE A.CHANGFLAG > 0";
%>

<html>
	<head>

		<title>����ҵ���༭</title>
		
	<link rel="stylesheet" href="/ptxtag/css/default.css" />
	<script type="text/javascript">
		var basePath = "${requestScope.basePath}"; 
		var id = "${dMap.ID}";
		var bname=btNname;
	</script>
	<script type="text/javascript" src="<%=basePath%>/template/js/edit.js"></script>
	</head>
	<body style="background-color: #FAFCFF;">
	<table cellpadding="0" cellspacing="0" border="0" width="100%">
        <tr>
          <td style="text-align:right;width:30%">
              <%if(!"0".equals(exeFlag.trim())&&biCode!="") {%>
            	<a href="#" class="easyui-linkbutton" id="ok" plain="true" iconCls="icon-ok" onclick="commitMatter();">
            	${requestScope.actMap.BTNNAME}</a>
      		<%}  %>
            	<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onclick="loadAuditInfoBase();">������</a>
          </td>
        </tr>
      </table>
		<div style="width: 100%; text-align: center; font: bold 15px sans-serif; padding: 15px;">
			����ҵ�������
		</div>

		<div id="mainDiv"
			style="width: 100%; height: 300px; text-align: center; overflow: auto;">
			<table id="infoTable1" style="width: 98%; margin-bottom: 5px;table-layout:fixed;">
				<tr height="40px"  valign="top">
					<td width="9%"  align="right" >
						����Ƶ�λ��
					</td>
					<td width="25%" >
						<input type="hidden" id="khbm" name="khbm" value="${dMap.KHBM}" />
						<input type="text" id="khmc" name="khmc" style="width: 150px;"
							value="${dMap.KHMC}" readonly="readonly" /><input type="button" value="ѡ��" name="selProject"
							class="BUTTON_UP" style="width: 35px;" onclick="selProject();" />&nbsp;<font color="red">*</font>
							<div  style="background-color:#FF00FF;width: 205px;">���û�ҵ�����Ƶ�λ,�������Ŀί��!</div>
					</td>
					<td width="8%"  align="right" >
						ҵ�����
					</td>
					<td width="25%">
						<ptx:Combobox id="ywlb" name="ywlb" style="width:185px;"
							sql="<%=sqlStr%>" panelHeight="200" value="01"
							editable="false" disabled="true" />
					</td>
					<td width="9%"   align="right"  >
						�����ţ�
					</td>
					<td>
						<input type="text" id="sybh" name="sybh" style="width:185px;"
							onKeyDown="LimitText(this, 16)" onKeyUp="LimitText(this, 16)"
							onkeypress="LimitText(this, 16)" onpaste="LimitText(this, 16)" onblur="this.value = stripscript(this.value);"
							value="${dMap.SYBH}" />
					</td>
				</tr>
				<tr>
					<td align="right" >
						��Ŀ���ƣ�
					</td>
					<td>
						<input type="hidden" id="xmbm" name="xmbm" value="${dMap.XMBM}" />
						<input type="text" id="xmmc" name="xmmc" style="width:185px;"
							onKeyDown="LimitText(this, 128)" onKeyUp="LimitText(this, 128)"
							onkeypress="LimitText(this, 128)" onpaste="LimitText(this, 128)"
							value="${dMap.XMMC}" readonly="readonly" />
					</td>
					<td align="right" >
						���񱨽�&nbsp;&nbsp;&nbsp;&nbsp;<br/>ֹ��/�ڼ䣺
					</td>
					<td>
						<input type="hidden" id="ksrq" name="ksrq" value="${dMap.KSRQ}" />
<!-- 						<input type="text" id="jzrq" name="jzrq" style="width:185px;" -->
<!-- 							class="Wdate" value="${fn:substring(dMap.JZRQ, 0, 10)}" -->
<!-- 							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});" -->
<!-- 							readonly="readonly" /> -->
							&nbsp;<font color="red">*</font>
					</td>
					<td width="9%"  align="right" >
						������Ա��
					</td>
					<td>
						<input type="hidden" id="bzrybm" name="bzrybm"
							value="${biCode eq '' ? userCode : dMap.BZRYBM}" />
						<input type="text" id="bzrymc" name="bzrymc" style="width:185px;"
							value="${biCode eq '' ? userName : dMap.BZRYMC}"
							readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td align="right" >
						�������ڣ�
					</td>
					<td>
						<input type="hidden" id="bzrq" name="bzrq"
							value="${biCode eq '' ? now : dMap.BZRQ}" />
<!-- 						<input type="text" id="bzrqView" name="bzrqView" -->
<!-- 							style="width:185px;" class="Wdate" -->
<!-- 							value="${fn:substring(biCode eq '' ? now : dMap.BZRQ, 0, 10)}" -->
<!-- 							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});" readonly="readonly" -->
<!-- 							 /> -->
					</td>
					<td align="right" >
						�������ڣ�
					</td>
					<td>
						<input type="hidden" id="fhrq" name="fhrq"
							value="${actCode eq 'audit' && exeFlag eq '1' ? now : dMap.FHRQ}" />
<!-- 						<input type="text" id="fhrqView" name="fhrqView" -->
<!-- 							style="width:185px;" class="Wdate" -->
<!-- 							value="${fn:substring(actCode eq 'audit' && exeFlag eq '1' ? now : dMap.FHRQ, 0, 10)}" -->
<!-- 							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});" -->
<!-- 							readonly="readonly" /> -->
					</td>
					<td style="font-weight: bold;">
						<!-- ������Ա�� -->
						<input type="hidden" id="fhrybm" name="fhrybm"
							value="${actCode eq 'audit' && exeFlag eq '1' ? userCode : dMap.FHRYBM}" />
						<input type="hidden" id="fhrymc" name="fhrymc" style="width:185px;"
							value="${actCode eq 'audit' && exeFlag eq '1' ? userName : dMap.FHRYMC}"
							readonly="readonly" />
					</td>
					<%if(!billId.equals("")){%>
					<td style="width:15%;text-align: left;">
					  <label>
					   <input type="button" name="queryInfo" style="width:185px;" value="&nbsp;&nbsp;&nbsp;&nbsp;�鿴��Ŀί����Ϣ&nbsp;&nbsp;&nbsp;&nbsp;" onclick="show();" class="button" />
					  </label>
					</td>
					<%}  %>
				</tr>
			</table>

			<table id="infoTable2" style="width: 98%;table-layout:fixed;">
				<tr>
					<td style="font-weight: bold;">
						һ��ע����ʦ��Ŀ�꣺
					</td>
				</tr>
				<tr>
					<td>
						${biCode eq '' ? dataList[0].ZKMB : dMap.ZKMB}
					</td>
				</tr>
				<tr height="5px">
					<td></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">
						������ƹ����˶Ա�
					</td>
				</tr>
			</table>

			<table id="detailTable" class="mimicHtc" cellpadding="1"
				cellspacing="1" style="width: 98%;table-layout:fixed;">
				<tr class="mimicHtc_tr">
					<th class="mimicHtc_item" width="50%" >
						����ҵ������
					</th>
					<th class="mimicHtc_item" width="10%" >
						������
					</th>
					<th class="mimicHtc_item" >
						ִ����
					</th>
				</tr>
				<c:forEach var="data" items="${dataList}" varStatus="status" >
					<tr class="mimicHtc_tr"  style="height:40px;">
						<td ><span style="width:99.8%; height:40px;overflow:auto;" >${data.HDNR}</span></td>
						<td style="background-color: #C9F1C9;" >
							<input type="text" name="sybh" value="${data.SYBH}" class="centerInput"
								onKeyDown="LimitText(this, 16)" onKeyUp="LimitText(this, 16)"
								onkeypress="LimitText(this, 16)" onpaste="LimitText(this, 16)"  onblur="this.value = stripscript(this.value);"/>
						</td>
						<td>
							<input type="hidden" id="hdid${status.index}"
								name="hdid" value="${data.HDID}" /> <input type="hidden"
								id="pid${status.index}" name="pid" value="${data.PID}" /> 
							<input type="hidden" id="isend${status.index}" name="isend"
								value="${data.ISEND}" />
							<input type="hidden" id="zxrybm${status.index}" name="zxrybm" 
								value="${data.ZXRYBM}"/>
							<input type="text" id="zxrymc${status.index}" name="zxrymc" 
								value="${data.ZXRYMC}" class="centerInput" style="width: 60%;"
								readonly="readonly" />
								<label>
								<input type="button" value="&nbsp;&nbsp;&nbsp;������&nbsp;&nbsp;&nbsp;" name="unActor" 
								class="button" style="width: 40px;"
								onclick="unActor(${status.index})" />
								
								</label>
								<label>
								&nbsp;&nbsp;<input type="button"
								value="&nbsp;&nbsp;ѡ��&nbsp;&nbsp;" name="selActor" class="button" style="width: 40px;"
								onclick="selActor(${status.index})" />
								</label>
						</td>
					</tr>
					</c:forEach>
			</table>
		</div>
		<div style="width: 100%;">
			<table id="fileTable" width="100%">
				<tr class="table_title" height="25">
					<td>ȷ�ϵ׸�</td>
				</tr>
				<tr>
					<td width="30%">
						<input type="checkbox" id="ywpjb" name="gzdg" value="1" />
						
						<c:choose>
						   <c:when test="${requestScope.dMap.UDTAKETYPE == 'ҵ�񱣳�'}"> 
						   		<span id="dgText1" style="margin-right: 30px;"
							onclick="$('#ywpjb').click();">ҵ�񱣳�-���۱�</span>
						   </c:when>
						   <c:otherwise> 
						   		<span id="dgText1" style="margin-right: 30px;"
							onclick="$('#ywpjb').click();">ҵ��н�-���۱�</span>
						   </c:otherwise>
	      				</c:choose>			
      			
							
						<input type="checkbox" id="qtgzdg" name="gzdg" value="1" />
						<span onclick="$('#qtgzdg').click();">���������׸�</span>
					</td>
				</tr>
				<tr>
					<td valign="top">
						<ptx:DataGrid border="true" id="fileList" pagination="false" height="120" singleSelect="false" remoteSort="false" striped="true" ondblclick="uploadFileLook" idField="IATTACHMENTID" toolbar="<%=toolbar%>">
							<ptx:DataGridRow>
								<ptx:DataGridField field="ck" title="   " checkbox="true" />
								<ptx:DataGridField field="SATTACHMENNAME" title="��������"
									width="300" align="center" dataAlign="left" />
								<ptx:DataGridField field="SREMARK" title="��������" width="400"
									align="center" dataAlign="left" />
								<ptx:DataGridField field="SUPSTAFFNAME" title="�ϴ���Ա "
									width="125" align="center" dataAlign="left" />
								<ptx:DataGridField field="SUPLOADTIME" title="�ϴ�ʱ�� " width="125"
									align="center" dataAlign="center" />
								<ptx:DataGridField field="SSVRFILEPATH" title="����������·��"
									hidden="true" />
								<ptx:DataGridField field="SSVRFILENAME" title="������������ "
									hidden="true" />
								<ptx:DataGridField field="ISTEMP" title="�Ƿ���ʱ�ļ�" hidden="true" />
								<ptx:DataGridField field="IATTACHMENTID" title="����ID"
									hidden="true" />
							</ptx:DataGridRow>
						</ptx:DataGrid>
					</td>
				</tr>
			</table>
			<form action="<%=basePath%>/FileUpload" id="iForm" name="iForm"
				method="post" target="iFrame">
				<input type="hidden" id="ExeMethod" name="ExeMethod" value="" />
				<input type="hidden" id="isTempFile" name="isTempFile" value="" />
				<input type="hidden" id="newFileName" name="newFileName" value="" />
				<input type="hidden" id="oldFileName" name="oldFileName" value="" />
			</form>
			<iframe name="iFrame" id="iFrame" height="0px;" width="0px;"
				style="display: none"></iframe>
		</div>

		<div style="width: 100%;">
			<table style="width: 100%;">
				<tr>
					<td align="center" valign="middle" style="height: 40px; padding-bottom: 10px;">
						<c:if test="${requestScope.exeFlag == '1' &&('fillForm'==actCode||(biCode eq ''))}"><!-- && (biCode eq '') "filing"==actCode-->
							<label>
								<input type="button" name="btSave"
									value="&nbsp;&nbsp;����&nbsp;&nbsp;" onclick="saveOrSubmit(0,0);"
									class="button" />
							</label>
						&nbsp;&nbsp;
						</c:if>
						<label>
							<input type="button" name="btClose"
								value="&nbsp;&nbsp;�ر�&nbsp;&nbsp;" onclick="window.close();"
								class="button" />
						</label>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
