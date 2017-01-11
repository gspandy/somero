<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
	<link href="<%=request.getContextPath() %>/resources/css/jquery.qtip.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/resources/css/dashboard.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/resources/css/trace.css" rel="stylesheet">
	<script src="<%=request.getContextPath() %>/resources/jquery/jquery-1.12.3.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/qtip/jquery.qtip.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var ctp = "<%=request.getContextPath() %>";
	</script>
	<script src="<%=request.getContextPath() %>/resources/d3/d3.v3.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/js/sequence-service.js"></script>
	<script src="<%=request.getContextPath() %>/resources/js/tree-service.js"></script>
	<script src="<%=request.getContextPath() %>/resources/js/utils.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/draw.js"></script>
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
  		<div class="traceDiv">
        <div id="treeDiv" class="viewDiv" style="width:25%;"></div>
         <div id="sequenceDiv" class="viewDiv" style="height: 500px;width: 74%;"></div>
        </div>
  </div>
</body>
</html>