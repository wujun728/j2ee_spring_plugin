$(function(){
	reSizeWin();
	shHistoryInfoList();
});

function reSizeWin(){
	resizeToDatagrid('historyMatterList', document.body.clientWidth, document.body.clientHeight);
}
window.onresize = reSizeWin;

function shHistoryInfoList(){
	var url = basePath + "/projectActive.do?ExeMethod=queryHistoryList";
	asyncLoadDataGrid("historyMatterList", url);
}

function clickMatter(){
	var record = getSelectedItem("historyMatterList");
	if (record) {
		var biCode = record.BICODE;
		var billId = record.BILLID;
		var wfInstId = record.WFINSTID;
		var actInstId = record.ACTINSTID;//Ϊ��
		var actCode = record.ACTCODE;//Ϊ��
		var exeMethod = "loadEditPage";
		var url = basePath + "/projectActive.do?ExeMethod=" + exeMethod+"&exeFlag=0"
				+ "&biCode=" + biCode + "&billId=" + billId + "&wfInstId="
				+ wfInstId + "&actInstId=" + actInstId + "&actCode=" + actCode;
		SystemModalDialog(url, 1024, 768);
	} else {
		$.messager.alert("��ʾ", "û��ѡ��ļ�¼!", "info");
	}
}

function showWfPic(){
	var record = getSelectedItem("historyMatterList");
	if (record) {
		var wfInstId = record.WFINSTID;
		var strUrl = "/workflow/flow.do?method=viewDiagram&id=" + wfInstId;
		SystemModalDialogOfScroll(strUrl, 850, 450);
	} else {
		$.messager.alert("��ʾ", "û��ѡ��ļ�¼!", "info");
	}
}