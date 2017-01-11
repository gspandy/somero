<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
	<link href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/resources/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/resources/esayui/themes/bootstrap/easyui.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/resources/esayui/themes/icon.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/resources/css/dashboard.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/resources/css/app.css" rel="stylesheet">
	<script src="<%=request.getContextPath() %>/resources/jquery/jquery-1.12.3.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script src="<%=request.getContextPath() %>/resources/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<script src="<%=request.getContextPath() %>/resources/esayui/js/jquery.easyui.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/esayui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		var ctp = "<%=request.getContextPath() %>";
	</script>
    <script src="<%=request.getContextPath() %>/resources/js/utils.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/query.js"></script>
</head>
<body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">SOMERO-WEB</a></div>
      <div id="navbar" class="navbar-collapse collapse"></div>
    </div>
  </nav>
  <div class="container-fluid">
    <div class="row">
      <div class="sidebar">
        <div id="query" class="queryDiv">
          <form class="form-horizontal" id="myForm" name="myForm">
            <table class="table table-striped table-bordered" style="width: 100%;">
              <thead>
                <tr>
                  <th colspan="2" style="text-align: center;">查询跟踪</th></tr>
              </thead>
              <tbody>
                <tr id="appListTr">
                  <td style="width: 120px;text-align: center;">所属应用:</td>
                  <td>
                    <select style="width: 100%;" class="form-control" id="appList" name="appList">
                      <option value="">选择一个应用</option>
                    </select>
                  </td>
                </tr>
                <tr>
                  <td style="text-align: center;">服务名:</td>
                  <td>
                    <select style="width: 100%;" class="form-control" id="serviceList" name="serviceList">
                    </select>
                </tr>
                <tr>
                  <td style="text-align: center;">开始时间:</td>
                  <td>
                    <div class="input-group date form_datetime col-md-5">
                      <input class="form-control" size="16" type="text"  readonly style="width: 150px" id="startTime" name="startTime" value="2016-05-12 09:55" data-format="yyyy-MM-dd hh:mm"/>
                      <span class="input-group-addon">
                        <span class="glyphicon glyphicon-remove"></span>
                      </span>
                      <span class="input-group-addon">
                        <span class="glyphicon glyphicon-th"></span>
                      </span>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td style="text-align: center;">结束时间:</td>
                  <td>
                    <div class="input-group date form_datetime col-md-5">
                      <input class="form-control" size="16" type="text" readonly style="width: 150px" id="endTime" name="endTime" value="2016-05-12 10:00" data-format="yyyy-MM-dd hh:mm"/>
                      <span class="input-group-addon">
                        <span class="glyphicon glyphicon-remove"></span>
                      </span>
                      <span class="input-group-addon">
                        <span class="glyphicon glyphicon-th"></span>
                      </span>
                    </div>
                  </td>
                </tr>
                <tr>
                  <th colspan="2" style="text-align: center;">可选条件（以下筛选条件只能选择一种）</th></tr>
                <tr>
                  <td style="text-align: center;">调用时长(ms):</td>
                  <td>
                    <input id="durationMin" name="durationMin" type="number" min="0" max="5000" class="form-control" style="width: 90px;height: 30px;float: left" />
                    <span style="float: left">---</span>
                    <input id="durationMax" name="durationMax" type="number" min="0" max="5000" class="form-control" style="width: 90px;height: 30px;float: left" />
                  </td>
                </tr>
                <tr>
                  <td style="text-align: center;">异常状况:</td>
                  <td>
                    <button id="ex" type="button" class="btn btn-warning" data-toggle="button">忽略异常</button></td>
                </tr>
                <tr>
                  <td colspan="2" style="text-align: center;">
                    <button id="sub" type="submit" class="btn btn-success" style="width: 200px;">查询</button></td>
                </tr>
              </tbody>
            </table>
          </form>
        </div>
      </div>
      <div class="main">
        <h2 class="sub-header">调用列表</h2>
        <div class="table-responsive">
        	<table id="dataList" style="width: 98%; height: auto !important;" align="center"></table>
        </div>
      </div>
    </div>
  </div>
</body>
</html>