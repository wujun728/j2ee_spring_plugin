$(function() {
	$.messager.defaults = {
		ok : "ȷ��",
		cancel : "ȡ��"
	};

	if ("" != biCode) {
		setFmtCombobox("ywlb", ywlb);
		var inputs = $("#fileTable").find("input[name='gzdg']");
		var files = fileSign.split(",");
		for ( var i = 0; i < files.length; i++) {
			if (inputs.length - 1 < i) {
				break;
			}
			if ("1" === files[i]) {
				$(inputs[i]).attr("checked", true);
			}
		}
		loadFile();
	}

	if ("1" != exeFlag || ("" != actCode && "fillForm" != actCode)) {
		$(":text, :button[class='BUTTON_UP'],:button[name='selActor'], :button[name='unActor'],:checkbox[name='gzdg']").attr(
				"disabled", true);
		disableCombobox("ywlb");
		
	}
	if("filing"==actCode){
		$("#fhrqView").attr("disabled",false);
		$("#bzrqView").attr("disabled",true);
		
	}else if("fillForm"==actCode||""==actCode){
		$("#fhrqView").attr("disabled",true);
		$("#bzrqView").attr("disabled",false);
	}
});

function loadFile() {
	var urlStr = basePath
			+ "/fileAction.do?ExeMethod=shFileList&RELTBLNAME=AD_MATTERINFO&RELOBJID="
			+ billId;
	asyncLoadDataGrid('fileList', urlStr);
}

var fileDelId = new Array();
var fileDelSName = new Array();
var fileAddId = new Array();
var fileAddOName = new Array();
var fileAddSName = new Array();
var fileAddRemark = new Array();
var fileAddTime = new Array();
function commitMatter(){
	var width=650;
	if("fillForm"==actCode){
		var flag=saveOrSubmit(0,1)
	}else{
		 width=650;
	}
	if(flag==false){
		return;
	}
	
	var step=1;
	var nextclxx='';
	if("fillForm"==actCode){
		nextclxx=bname;
		btNname='�ύ';
	}else if("filing"==actCode){
			nextclxx=bname;
			btNname='���';
	}
	var projId = $("#xmbm").val();
	var urlStr = basePath + "/wfActDealAction.do?ExeMethod=loadBaseDealPage"
			+ "&dealUrl=" + dealUrl + "&btNname=" + btNname + "&actCode="
			+ actCode + "&actName=" + actName + "&controlVar=" + controlVar
			+ "&controlVarStr=" + controlVarStr + "&actInstId=" + actInstId
			+ "&billId=" + billId + "&wfCode=WF-BUSMGR-YWHD&wfInstId=" + wfInstId + "&projid="
			+ projId + "&step="+step+"&nextclxx="+nextclxx;
	var returnValue = SystemModalDialog(urlStr, width, 400);
	if (returnValue) {
		//�޸���Ӹ�������
		if("filing"==actCode){
			var fhrq=$.trim($("#fhrqView").val())
			$.ajax( {
				type : "POST",
				url : basePath + "/projectActive.do?ExeMethod:updatefhrq&billId="+billId+"&FHRYMC="+userName+"&FHRYBM="+userCode+"&FHRQ="+fhrq+"&PROJID="+projId,
				dataType : "text",
				success : function(flag) {
				//********************************************************************************************************
				//********************************************************************************************************
				//********************************************************************************************************
					if(returnValue == 101){
						var addBillId="";//1
//						$.ajax({
//								type: "POST",
//								url: basePath + "/projAppAction.do",
//								data: {
//									ExeMethod: "createMatter",
//									wfCode: "WF-BUSMGR-APPLICATION,WF-BUSMGR-APPLICATION2014",
//									addBillId : addBillId,
//									/*
//									* ��������ҵ�����,���ڴ�������ͬʱ����ҵ������
//									*/
//									info:flag,
//									bs:1
//								},
//								dataType: "text",//dataType: "json"
//								success: function(returnData){
//									if(returnData == 0){
//										$.messager.alert("����","����"+btNname+"ʧ�ܣ�","warning");
//									}else{
										window.returnValue = true;
										window.close();
									    dialogArguments.shExecInfoList();
//									}
//								},
//								error: function(request,error){
//									$.messager.alert("����","���ӷ�����ʧ�ܣ����Ժ����ԣ�","error");
//								}
//							});
					}
				//********************************************************************************************************
				//********************************************************************************************************
				//********************************************************************************************************
					
				},
				error : function(request, error) {
					$.messager.alert("����", "���ӷ�����ʧ�ܣ����Ժ�����!", "error");
				}
			});
		}
			
		//window.close();
		//dialogArguments.shExecInfoList();
	}else{
		window.close();
		dialogArguments.shExecInfoList();
		return;
	}
	if("fillForm"==actCode){
		window.close();
		dialogArguments.shExecInfoList();
		return;
	}
	
}
function saveOrSubmit(isSubmit,type) {
	$("ok").data("disabled","disabled");
	if ("" != actCode && "fillForm" != actCode&&type!=1) {
		dealMatter();
		return;
	}
	/**if(biCode==''){
		-------�ж���Ŀ����״̬		var stagewf="";
		$.ajax({
			type: "POST",
			url: basePath + "/wfUndertakeAction.do",
			data: {
				ExeMethod: "findProcessStatus",
				projid : projid,
				step : 7
			},
			async:false,
			dataType: "json",dataType: "json"			success: function(returnData){
				if(returnData[0].STAGE == 2){
					stagewf=1;
				}else{
					$.messager.alert("����","��Ŀ���ݲ�ȫ����ϵ����Ա","warning");
					
				}
			},
			error: function(request,error){
				$.messager.alert("����","���ӷ�����ʧ�ܣ����Ժ����ԣ�","error");
				
			}
		});
		
		if(stagewf!=1){
			return;
		}
		-------�ж���Ŀ����״̬		

	}*/
	var usercodesets=$.trim($("#usercodesets").val());
//	if(isEmpty(usercodesets)&&isSubmit==1){
//		$.messager.alert("����", "��ѡ�������Ա!", "warning");
//		return;
//	}
	var usercodesetsname=usercodesetsname =$.trim($("#usercodesetsname").val());
	var bzrq=$.trim($("#bzrqView").val())
	var fhrq=$.trim($("#fhrqView").val())
	
	
	var dataMap={
		ExeMethod : 'saveProjActiveData',
		USERCODE : userCode,
		USERNAME : userName,
		DEPTCODE : deptCode,
		DEPTNAME : deptName,
		QYDJID : qydjid,
		QYNAME : qyname,
		WFINSTID : wfInstId,
		ACTINSTID : actInstId,
		ACTCODE : actCode,
		ACTNAME : actName,
		CONTROLVAR : controlVar,
		BILLID : billId,
		BICODE : biCode,
		ISSUBMIT : isSubmit,
		USERCODESETS:usercodesets,
		USERCODESETSNAME:usercodesetsname,
		type:type,
		BZRQ:bzrq,
		FHRQ:fhrq
	};
	var inputs = $("#infoTable1,#infoTable2").find(
			"input:hidden, :text, textarea");
	for ( var i = 0; i < inputs.length; i++) {
		var key = $(inputs[i]).attr("name").toUpperCase();
		var value = $(inputs[i]).val();
		dataMap[key] = value;
	}
	dataMap["BZRQ"]=bzrq;
	dataMap["FHRQ"]=fhrq;
	
	var fileSign = "";
	inputs = $("input[name='gzdg']");
	for ( var i = 0; i < inputs.length; i++) {
		if (inputs[i].checked) {
			fileSign += ",1"
		} else {
			fileSign += ",0"
		}
	}
	fileSign = fileSign.length > 0 ? fileSign.substr(1) : fileSign;
	dataMap['FILESIGN'] = fileSign;
	var ywlb = getComboboxValue("ywlb");
	dataMap['YWLB'] = ywlb;
	var hdnr = $.map($("#detailTable tr").find("td:first"), function(obj) {
		return $(obj).text().replace(/,/g, "��COMMA��");
	});
	var hdsybh = $.map($("#detailTable").find("input[name='sybh']"), function(
			obj) {
		return $(obj).val().replace(/,/g, "��COMMA��");
	});
	var zxrybm = $.map($("#detailTable").find("input[name='zxrybm']"),
			function(obj) {
				return $(obj).val().replace(/,/g, "��COMMA��");
			});
	var zxrymc = $.map($("#detailTable").find("input[name='zxrymc']"),
			function(obj) {
				return $(obj).val().replace(/,/g, "��COMMA��");
			});
	var hdid = $.map($("#detailTable").find("input[name='hdid']"),
			function(obj) {
				return $(obj).val().replace(/,/g, "��COMMA��");
			});
	var pid = $.map($("#detailTable").find("input[name='pid']"), function(obj) {
		return $(obj).val().replace(/,/g, "��COMMA��");
	});
	var isend = $.map($("#detailTable").find("input[name='isend']"), function(
			obj) {
		return $(obj).val().replace(/,/g, "��COMMA��");
	});
	dataMap['HDNR'] = hdnr;
	dataMap['HDSYBH'] = hdsybh;
	dataMap['ZXRYBM'] = zxrybm;
	dataMap['ZXRYMC'] = zxrymc;
	dataMap['HDID'] = hdid;
	dataMap['PID'] = pid;
	dataMap['ISEND'] = isend;
	

	if (isEmpty(dataMap['KHBM'])) {
		$.messager.alert("����", "��ѡ�񡰱���Ƶ�λ��!", "warning");
		return false;
	}
	if (isEmpty(dataMap['YWLB'])) {
		$.messager.alert("����", "��ѡ��ҵ�����!", "warning");
		return false;
	}
	if (isEmpty(dataMap['JZRQ'])) {
		$.messager.alert("����", "��ѡ�񡰲��񱨱��ֹ��/�ڼ䡱!", "warning");
		return false;
	}
	if (!$("#ywpjb").attr("checked")) {
		$.messager.alert("����", "��ȷ�����ϴ��׸塰" + $("#dgText1").html() + "��!",
				"warning");
		return false;
	}
	var rows = getDataRows("fileList");
	if (!rows || rows.length == 0) {
		$.messager.alert("����", "û�и��������ϴ��׸塰" + $("#dgText1").html() + "��!",
				"warning");
		return false;
	}

	//��������
	if (rows && rows.length > 0) {
		var smark="";
		var count=0;
		for ( var i = 0; i < rows.length; i++) {
			if ("Y" === rows[i].ISTEMP) {
				fileAddId.push(rows[i].IATTACHMENTID);
				fileAddOName.push(rows[i].SATTACHMENNAME.replace(/,/g,
						"��COMMA��"));
				fileAddSName
						.push(rows[i].SSVRFILENAME.replace(/,/g, "��COMMA��"));
				smark=$.trim(rows[i].SREMARK.replace(/,/g, "��COMMA��"));
				fileAddRemark.push(smark);				
				if(smark.getBytes()>128){
					$.messager.alert("����", "����˵������̫��!","warning");
					count=1;
					break;
				}
				fileAddTime.push(rows[i].SUPLOADTIME);
			}
		}
		if(count==1){
			fileAddId=new Array();
			fileAddOName=new Array();
			fileAddSName=new Array();
			fileAddRemark=new Array();
			fileAddTime=new Array();
			return false;
		}
	}
	dataMap['DELFID'] = fileDelId;
	dataMap['DELFNAME'] = fileDelSName;
	dataMap['ADDFID'] = fileAddId;
	dataMap['ADDFONAME'] = fileAddOName;
	dataMap['ADDFSNAME'] = fileAddSName;
	dataMap['ADDFREMARK'] = fileAddRemark;
	dataMap['ADDFTIME'] = fileAddTime;

	$(document.body).showWaitbar('���ڱ������ݣ����Ժ�...');
	$.ajax( {
		type : "POST",
		url : basePath + "/projectActive.do",
		data : dataMap,
		dataType : "text",
		success : function(flag) {
			if (flag == "1") {
				if(type==0){
					window.close();
					dialogArguments.shExecInfoList();
				}
				
			} else {
				$(document.body).hideWaitbar();
				$.messager.alert("����", (1 == isSubmit ? "�ύ" : "����")
						+ "ʧ��!", "warning");
			}
		},
		error : function(request, error) {
			$(document.body).hideWaitbar();
			$.messager.alert("����", "���ӷ�����ʧ�ܣ����Ժ�����!", "error");
		}
	});
}

function dealMatter() {
	var step=1;
	if("filing"==actCode){
		step=2
	}
	var projId = $("#xmbm").val();
	var urlStr = basePath + "/wfActDealAction.do?ExeMethod=loadBaseDealPage"
			+ "&dealUrl=" + dealUrl + "&btNname=" + btNname + "&actCode="
			+ actCode + "&actName=" + actName + "&controlVar=" + controlVar
			+ "&controlVarStr=" + controlVarStr + "&actInstId=" + actInstId
			+ "&billId=" + billId + "&wfInstId=" + wfInstId + "&projid="
			+ projId+"&step="+step;
	var returnValue = SystemModalDialog(urlStr, 600, 400);
	if (returnValue) {
		window.close();
		dialogArguments.shExecInfoList();
	}
}

function loadAuditInfoBase() {
	var urlStr = basePath
			+ "/auditInfoAction.do?ExeMethod=loadAuditInfoBase&billId="
			+ billId;
	SystemModalDialog(urlStr, 1024, 768);
}

function setFmtCombobox(tagId, val) {
	setComboboxValue(tagId, val);
	$('#' + tagId)
			.combo('setText', getComboboxText(tagId).replace(/^[��]*/, ''));
}

function selCustomerBuss(rec) {
	$('#ywlb').combo('setText', rec.text.replace(/^[��]*/, ''));
}

function chgCustomerBuss() {
	var cusCode = $("#khbm").val();//getComboboxValue("khbm");
	var bussType = getComboboxValue("ywlb");
	if (isEmpty(cusCode) || isEmpty(bussType)) {
		$("#dgText1").html("ҵ��н����۱�");
		return;
	}

	$.ajax( {
		type : "POST",
		url : basePath + "/projectActive.do",
		data : {
			ExeMethod : 'haveCustomerBuss',
			cusCode : cusCode,
			bussType : bussType
		},
		dataType : "text",
		success : function(flag) {
			if (flag == "1") {
				$("#dgText1").html("ҵ�񱣳����۱�");
			} else {
				$("#dgText1").html("ҵ��н����۱�");
			}
		},
		error : function(request, error) {
			$.messager.alert("����", "���ӷ�����ʧ�ܣ����Ժ�����!", "error");
		}
	});
}

function selProject() {
	var urlStr = basePath
			+ "/commAction.do?ExeMethod=loadProjectPage&projNode=0";
	var reutrndata = SystemModalDialog(urlStr, 1024, 768);
	if (reutrndata != undefined) {
		if ($.trim(reutrndata.PROJID) != "") {
			setFmtCombobox("ywlb", reutrndata.BUSSCODE);
			$("#khbm").val(reutrndata.CUSCODE);
			$("#khmc").val(reutrndata.CUSNAME);
			$("#xmbm").val(reutrndata.PROJID);
			$("#xmmc").val(reutrndata.PJNAME);
		} else {
			setFmtCombobox("ywlb", "");
			$("#khbm").val("");
			$("#khmc").val("");
			$("#xmbm").val("");
			$("#xmmc").val("");
		}
		chgCustomerBuss();
	}
}

function unActor(index) {
	var len = $("input[name='hdid']").length;
	if (index >= len) {
		return;
	}
	var hdid = $("#hdid" + index).val();
	var isend = $("#isend" + index).val();
	if ("1" === isend) {
		$("#zxrybm" + index).val("");
		$("#zxrymc" + index).val("������");
	}

	for ( var i = index + 1; i < len; i++) {
		if ($("#pid" + i).val() == hdid) {
			unActor(i);
		}
	}
}

function setActor(code, name, index) {
	var len = $("input[name='hdid']").length;
	if (index >= len) {
		return;
	}
	var hdid = $("#hdid" + index).val();
	var isend = $("#isend" + index).val();
	if ("1" === isend) {
		$("#zxrybm" + index).val(code);
		$("#zxrymc" + index).val(name);
	}

	for ( var i = index + 1; i < len; i++) {
		if ($("#pid" + i).val() == hdid) {
			setActor(code, name, i);
		}
	}
}

function selActor(index) {
	var strUrl = "/workflow/flowmgr/structSel.jsp?selFlag=2&needGroup=0&needRole=0&deptType=4&status=4";
	var reutrndata = window.showModalDialog(strUrl, window,
			"dialogWidth:450px;dialogHeight:480px;resizable:no;");
	if (reutrndata != undefined) {
		if ($.trim(reutrndata.code) != "") {
			setActor(reutrndata.code, reutrndata.name, index);
		} else {
			setActor("", "", index);
		}
	}
}

function uploadFile() {
	var rows = getSelectedItem("fileList");
	var urlStr = basePath + "/common/fileUpload.jsp";
	var retObj = SystemModalDialog(urlStr, 480, getDialogHeight(273));
	if (retObj != null) {
		retObj.SUPSTAFFNAME = userName;
		retObj.ISTEMP = "Y";
		insertDataRow("fileList", 0, retObj);
	}
}

function uploadFileLook() {
	/**var rows = getSelectedItem("fileList");
	var sattachmenname='';
	var sremark='';
	var supstaffname='';
	var	suploadtime='';
	var	ssvrfilepath='';
	var	ssvrfilename='';
	if (rows) {
		sattachmenname= rows.SATTACHMENNAME;
		sremark= $.trim(rows.SREMARK);
		supstaffname= rows.SUPSTAFFNAME;
		suploadtime= rows.SUPLOADTIME;
		ssvrfilepath=rows.SSVRFILEPATH;
		ssvrfilename=rows.SSVRFILENAME;
		var urlStr = basePath + "/common/fileUpload.jsp?SATTACHMENNAME="+encodeURI(sattachmenname)+"&SREMARK="+encodeURIComponent(sremark)+"&SUPSTAFFNAME="+encodeURI(supstaffname)+"&SUPLOADTIME="+encodeURI(suploadtime)+"&SSVRFILEPATH="+encodeURI(ssvrfilepath)+"&SSVRFILENAME="+encodeURI(ssvrfilename);
		var retObj = SystemModalDialog(urlStr, 480, getDialogHeight(273));
		if (retObj != null) {
			retObj.SUPSTAFFNAME = userName;
			retObj.ISTEMP = "Y";
			insertDataRow("fileList", 0, retObj);
		}
	}*/
	
}
function delFile() {
	var rows = getSelectedItems("fileList");
	var files = "";
	var isTemps = "";
	if (rows && rows.length > 0) {
		for ( var i = 0; i < rows.length; i++) {
			if ("Y" === rows[i].ISTEMP) {// �������ʱ�ļ�����ɾ���������ļ�������ֻ���б���ɾ��
				files += "," + rows[i].SSVRFILENAME;
				isTemps += ",Y";
			} else {
				fileDelId.push(rows[i].IATTACHMENTID);
				fileDelSName
						.push(rows[i].SSVRFILENAME.replace(/,/g, "��COMMA��"));
			}
		}
		if (files.length > 0) {
			files = files.substr(1);
			isTemps = isTemps.substr(1);
			$("#newFileName").val(files);
			$("#isTempFile").val(isTemps);
			$("#ExeMethod").val("del");
			document.forms[0].submit();
		} else {
			delCallBack("");
		}
	} else {
		$.messager.alert("��ʾ", "û��ѡ��ļ�¼!", "info");
	}
}

/**
 * ɾ����ص�����
 */
function delCallBack(msg) {
	if ($.trim(msg) != "") {
		$.messager.alert("����", msg, "warning");
	} else {
		var rows = getSelectedItems("fileList");
		if (rows && rows.length > 0) {
			var rIdx = -1;
			var idxArr = new Array();
			for ( var i = 0; i < rows.length; i++) {
				rIdx = getDataRowIndex("fileList", rows[i].IATTACHMENTID);
				idxArr.push(rIdx);
			}
			//��������������ɾ��
			idxArr.sort();
			for ( var i = idxArr.length - 1; i >= 0; i--) {
				deleteDataRow("fileList", idxArr[i]);
			}
		}
	}
}

function downloadFile() {
	var rows = getSelectedItems("fileList");
	if (rows && rows.length > 0) {
		$("#newFileName").val(rows[0].SSVRFILENAME);
		$("#oldFileName").val(rows[0].SATTACHMENNAME);
		$("#isTempFile").val("Y" === rows[0].ISTEMP ? "Y" : "N");
		$("#ExeMethod").val("down");
		document.forms[0].submit();
	} else {
		$.messager.alert("��ʾ", "û��ѡ��ļ�¼!", "info");
	}
}

/**
 * ���غ�ص�����
 */
function downCallBack(msg, arg) {
	if ($.trim(msg) != "") {
		$.messager.alert("����", msg, "warning");
	}
}

function getDigit(val) {
	return $.trim(val).replace(/,/g, "");
}

function formatDigit(val, dlen, scale, minus, comma) {
	val = $.trim(val).replace(/[,��]/g, "");
	if (isEmpty(val)) {
		return "";
	}
	if (!/^(-?\d+(\.\d+)?)/.test(val)) {
		return "";
	}
	val = RegExp.$1;

	if (!minus) {
		val = val.replace(/^-/, "");
	}
	val = val.replace(/^0+/, "0");
	var sign = "";
	if (val.indexOf("-") == 0) {
		sign = "-";
		val = val.substr(1);
	}

	var index = val.indexOf(".");
	var num = "0";
	if (dlen > 0) {
		num = index == -1 ? val : val.substr(0, index);
		num = num.length > dlen ? num.substr(num.length - dlen) : num;
	}
	var dig = "";
	if (scale > 0) {
		dig = index == -1 ? dig : val.substr(index + 1);
		dig = dig.length > scale ? dig.substr(0, scale) : dig;
	}
	for ( var i = dig.length; i < scale; i++) {
		dig += "0";
	}
	val = num + (dig.length > 0 ? "." + dig : "");

	if (comma) {
		/^(\+|-)?(\d+)(\.\d+)?$/.test(val)
		var a = RegExp.$1;
		var b = RegExp.$2;
		var c = RegExp.$3;
		while (/(\d)(\d{3})(,|$)/.test(b)) {
			b = b.replace(/(\d)(\d{3})(,|$)/, "$1,$2$3");
		}
		val = a + "" + b + "" + c;
	}

	return val;
}

function limitDigit(dlen, scale, minus) {
	var exp = (minus ? "-?" : "") + "("
			+ (dlen > 0 ? "\\d{1," + dlen + "}" : "0")
			+ (scale > 0 ? "(\\.(\\d{1," + scale + "})?)?" : "") + ")?";
	var pattern = eval("/^" + exp + "$/");
	var src = event.srcElement;
	var selRange = document.selection.createRange();
	var tempSel = selRange.text;//ѡ��Ĳ���
	var srcRange = src.createTextRange();
	var tempNum = srcRange.text;//��������
	selRange.setEndPoint("StartToStart", srcRange);//�ƶ����	
	var tempMovSel = selRange.text; //�ƶ����������ѡ������
	//ȥ��ѡ��Ĳ�����ɵ�ǰ�벿������
	var srcNumBefore = tempMovSel.substr(0, tempMovSel.length - tempSel.length);
	var srcNum = tempNum.substr(tempMovSel.length);//��벿������
	var eCode = String.fromCharCode(event.keyCode);//���ܼ��̴�����ַ�
	var num = srcNumBefore + eCode + srcNum;
	event.returnValue = pattern.test(num);
}

function LimitText(field, maxlimit) {
	if (field.value.getBytes() > maxlimit) {
		field.value = field.value.subBytes(maxlimit);
	}
}

//����IE6��IE7,IE8,IE9�������ڸ߶ȵ���(��IE8Ϊ��׼)
function getDialogHeight(oldHeight) {
	var newHeight = oldHeight;
	var ua = navigator.userAgent;
	if (ua.lastIndexOf("MSIE 7.0") != -1) {
		if (ua.lastIndexOf("Windows NT 5.1") != -1) {
			newHeight = oldHeight - 51;
		} else if (ua.lastIndexOf("Windows NT 5.0") != -1) {
			newHeight = oldHeight - 104;
		} else if (ua.lastIndexOf("Windows NT 6.1") != -1) { //window 7
			newHeight = oldHeight - 51;
		}
	} else if (ua.lastIndexOf("MSIE 8.0") != -1) {
		if (ua.lastIndexOf("Windows NT 5.1") != -1) { //window xp
			newHeight = oldHeight - 39;
		} else if (ua.lastIndexOf("Windows NT 5.0") != -1) { //window 2000
			newHeight = oldHeight;
		} else if (ua.lastIndexOf("Windows NT 6.1") != -1) { //window 7
			newHeight = oldHeight - 51;
		}
	} else if (ua.lastIndexOf("MSIE 9.0") != -1) {
		if (ua.lastIndexOf("Windows NT 6.1") != -1) { //window 7
			newHeight = oldHeight - 50;
		}
	}
	return newHeight;
}

function matterDeal(tid) {
	var userCodeSets = $('#userCodeSets').val();
	var userCodeSetsName = $('#userCodeSetsName').val();
	if (tid == 0) {
		$.ajax( {
			type : "POST",
			url : basePath + "/assessAction.do",
			data : {
				ExeMethod : "createMatter",
				wfCode : wfCode,
				sxsm : sxsm,
				tid : tid,
				userCodeSets : userCodeSets,
				userCodeSetsName : userCodeSetsName
			},
			dataType : "text",
			success : function(returnData) {
				if (returnData == 0) {
					$.messager.alert("����", "�����ʧ�ܣ�", "error");
				} else {
					window.returnValue = true;
					window.close();
				}
			},
			error : function(request, error) {
				$.messager.alert("����", "���ӷ�����ʧ�ܣ����Ժ����ԣ�", "error");
			}
		});
	}

}


function setdealActor(code, name){
    var strUrl = "/workflow/flowmgr/structSel.jsp?selFlag=2&needGroup=0&needRole=0&deptType=4";
	var reutrndata = window.showModalDialog(strUrl, window, "dialogWidth:450px;dialogHeight:480px;resizable:no;");
	if(reutrndata != undefined){
		if(trim(reutrndata.code)!=""){

			if(code != "") document.getElementById(code).value = reutrndata.code;
			if(name != "") document.getElementById(name).value = reutrndata.name;
		}else{
			if(code != "") document.getElementById(code).value = "";
			if(name != "") document.getElementById(name).value = "";
		}
	}
}

function show(){
	var cuscode = $('#khbm').val();//�ͻ�����
//	var busTypeId = busTypeId;
	var url = basePath + "/projAppAction.do?ExeMethod=loadCommission&cuscode="+cuscode+"&id="+busTypeId;
	SystemModalDialog(url, 600, 340);
}
function countCharacters(str){
    var totalCount = 0;
    for (var i=0; i<str.length; i++){
        var c = str.charCodeAt(i);
        if ((c >= 0x0001 && c <= 0x007e) || (0xff60<=c && c<=0xff9f)){
             totalCount++;
        }else{     
             totalCount+=2;
        }
     }
    return totalCount;
} 
function stripscript(s) {
	var pattern = new RegExp(
			"%")
	var rs = "";
	for ( var i = 0; i < s.length; i++) {
		rs = rs + s.substr(i, 1).replace(pattern, '');
	}
	return rs;
} 