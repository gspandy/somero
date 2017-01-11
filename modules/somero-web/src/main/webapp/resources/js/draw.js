
$(document).ready(function() {
	var traceId = getUrlParamStr("traceId"); // 获取traceId
	var appId = getUrlParamStr("appId"); // 获取appId
	var serviceMap = {}; // 存放service列表
	$.ajax({
        type: "get",
        url: ctp + "/service/getSeviceList",
        data:{serviceId:appId},
        async: false,
        success: function(data, textStatus) {
            if (data != null) {
                for (var i = 0; i < data.length; i++) {
                	serviceMap[data[i].id] = data[i].name;
                }
            }

        },
        error: function() {}
    });
	var datas;
	$.ajax({
        type: "get",
        url: ctp + "/trace/getTraceInfo?traceId="+traceId,
        async: false,
        success: function(data, textStatus) {
        	datas = data;
        },
        error: function() {}
    });
	
	sequence.getMyTrace(datas, serviceMap);
	var spanMap = sequence.getSpanMap(datas);
	sequence.createView(datas);//生成时序图的svg
	sequence.createSpanAndDetail(datas, spanMap);//生成时序图的具体细节
	
	tree.createTree(datas);//生成树的svg
    tree.createTreeDetail(datas);//生成树的具体结构
});