$(function() {
	reSizeWin();
	shExecInfoList();
	if ($.trim(selBillId) != "") {
		selectRecord('execMatterList', selBillId);
	}
	if($.trim(permi_matterAdd)!="true") disableToolbarButton('matterAdd');
	if($.trim(permi_matterDel)!="true") disableToolbarButton('matterDel');
});

function reSizeWin() {
	resizeToDatagrid('execMatterList', document.body.clientWidth,
			document.body.clientHeight - 29);
}
window.onresize = reSizeWin;

function shExecInfoList() {
	var url = basePath + "/projectActive.do?ExeMethod=queryTaskList";
	asyncLoadDataGrid("execMatterList", url);
}

function loadMatter() {
	var url = basePath + "/projectActive.do?ExeMethod=loadEditPage&exeFlag=1";
	SystemModalDialog(url, 1024, 768);
}

function deleteMatter() {
	var record = getSelectedItem("execMatterList");
	if (!record) {
		$.messager.alert("��ʾ", "û��ѡ��ļ�¼!", "info");
		return;
	}

	$.messager.confirm("����", "ȷ��ɾ����ѡ������?", function(isOK) {
		if (isOK) {
			var biCode = record.BICODE;
			var billId = record.BILLID;
			var wfInstId = record.WFINSTID;
			$.ajax( {
				type : "POST",
				url : basePath + "/projectActive.do",
				data : {
					ExeMethod : "delProjActiveData",
					biCode : biCode,
					billId : billId,
					wfInstId : wfInstId
				},
				success : function(flag) {
					if (flag == "1") {
						$.messager.alert("��ʾ", "����ɾ���ɹ�!", "info", function() {
							shExecInfoList();
						});
					} else {
						$.messager.alert("����", "����ɾ��ʧ��!", "warning");
					}
				},
				error : function(request, textStatus) {
					$.messager.alert("����", "���ӷ�����ʧ�ܣ����Ժ�����!", "error");
				}
			});
		}
	});
}

function clickMatter() {
	var record = getSelectedItem("execMatterList");
	if (record) {
		var biCode = record.BICODE;
		var billId = record.BILLID;
		var wfInstId = record.WFINSTID;
		var actInstId = record.ACTINSTID;
		var actCode = record.ACTCODE;
		var exeMethod = "loadEditPage";
		var url = basePath + "/projectActive.do?ExeMethod=" + exeMethod
				+ "&biCode=" + biCode + "&billId=" + billId + "&wfInstId="
				+ wfInstId + "&actInstId=" + actInstId + "&actCode=" + actCode
				+ "&exeFlag=1";
		SystemModalDialog(url, 1024, 768);
	} else {
		$.messager.alert("��ʾ", "û��ѡ��ļ�¼!", "info");
	}
}

function loadControlPage() {
	var tab = getSelectedTab("tabs");
	var iframe = tab.children("iframe");
	iframe.attr("src", basePath + "/projectActive/control.jsp");
}

function loadHistoryPage() {
	var tab = getSelectedTab("tabs");
	var iframe = tab.children("iframe");
	iframe.attr("src", basePath + "/projectActive/history.jsp");
}

function showWfPic() {
	var record = getSelectedItem("execMatterList");
	if (record) {
		var wfInstId = record.WFINSTID;
		var strUrl = "/workflow/flow.do?method=viewDiagram&id=" + wfInstId;
		SystemModalDialogOfScroll(strUrl, 800, 400);
	} else {
		$.messager.alert("��ʾ", "û��ѡ��ļ�¼!", "info");
	}
}