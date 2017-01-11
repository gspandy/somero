function jumpPage(traceId) {
	var appId = $("#appList").val();
	window.open(ctp+"/index/traceinfo.html?traceId="+traceId+"&appId="+appId);
}

$(document).ready(function() {
    // 初始化日期控件
    $("#startTime").datetimepicker({
        language: "zh-CN",
        format: 'yyyy-mm-dd hh:ii',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    });
    $("#endTime").datetimepicker({
        language: "zh-CN",
        format: 'yyyy-mm-dd hh:ii',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    });
    
    // 初始化app列表
    $.ajax({
        type: "get",
        url: ctp + "/service/appList",
        success: function(data, textStatus) {
            if (data != null) {
                for (var i = 0; i < data.length; i++) {
                    $("#appList").append("<option value=\"" + data[i].id + "\">" + data[i].name + "</option>");
                }
            }

        },
        error: function() {}
    });
    
    // 初始化服务列表
    $("#appListTr").delegate("select", "change",
    function() {
        var serviceId = $("#appList").val();
        if (serviceId == "") {
            $("#serviceList").empty();
            return;
        }
        $("#serviceList").empty();
        $.ajax({
            type: "get",
            url: ctp + "/service/getSeviceList",
            data:{serviceId:serviceId},
            success: function(data, textStatus) {
                if (data != null) {
                    for (var i = 0; i < data.length; i++) {
                        $("#serviceList").append("<option value=\"" + data[i].id + "\">" + data[i].name + "</option>");
                    }
                }

            },
            error: function() {}
        });
    });
    
    // 绑定提交按钮事件
    $("#sub").click(function() {
    	var data = $("#myForm").serialize();
    	var serviceName = $("#serviceList").find("option:selected").text();
    	$('#dataList').datagrid({
    		url : ctp + "/trace/getTraceDataGrid?"+data,
    		method : 'get',
    		columns : [[
    		{field:'serviceId',title:'服务ID',align:'center',hidden:true},
    		{field:'serviceName',title:'服务名称',align:'center',width:350,
    			formatter: function(value,row,index){
    				var edit = serviceName;
    				return edit;
    			}
    		},
    		{field:'timestamp',title:'调用时间',align:'center',width:250,formatter: formatTime},
    		{field:'duration',title:'调用时长(ms)',align:'center',width:150},
    		{field:'traceId',title:'调用ID',align:'center',hidden:true},
    		{field:'operate',title:'操作',align:'center',width:250,
    			formatter: function(value,row,index){
    				var edit = "<a class='btn btn-info btn-sm' href='javascript:jumpPage("+row.traceId+");'>查看详细</a>";
    				return edit;
    			}
    		}]],
    		nowrap:false,
    		striped:true,//设置为true将交替显示行背景
            singleSelect:true,//设置为true将只允许选择一行
            checkOnSelect:false,//如果设置为 true，当用户点击一行的时候checkbox checked(选择)/unchecked(取消选择)
    	    selectOnCheck:true,
            rownumbers:true, //设置为true将显示行数
    	    pagination:true, //设置true将在数据表格底部显示分页工具栏
    	    remoteSort:false,
//    	    fitColumns : true,
    	    pageNumber:1,//当设置分页属性时，初始化分页码
    	    pageSize:50,//当设置分页属性时，初始化每页记录数
    	    pageList:[50,100,200] //当设置分页属性时，初始化每页记录数列表
    	});	
    	return false;
    });
});