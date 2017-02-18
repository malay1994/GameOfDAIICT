<html>
<head>
<meta charset="utf-8" />
<title>WebAdmin - Responsive Admin Dashboard Template</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta content="Admin Dashboard" name="description" />
<meta content="ThemeDesign" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="shortcut icon" href="images/favicon.ico">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/icons.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="accountbg"></div>
	<div class="wrapper-page">
		<div class="panel panel-color panel-primary panel-pages">
			<div class="panel-body">
				
				<h4 class="text-muted text-center m-t-0">
					<b>Add Product</b>
				</h4>
				
				<form class="form-horizontal m-t-20" action="<%=request.getContextPath()%>/ProductController" method="post">
				<input type="hidden" name="flag" value="add">
					<div class="form-group">
						<div class="col-xs-12">
							<input class="form-control" type="text" name="products">
								
						</div>
					</div>
					
					<div class="form-group text-center m-t-40">
						<div class="col-xs-12">
							<button
								class="btn btn-primary btn-block btn-lg waves-effect waves-light"
								type="submit">Add</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/modernizr.min.js"></script>
	<script src="js/detect.js"></script>
	<script src="js/fastclick.js"></script>
	<script src="js/jquery.slimscroll.js"></script>
	<script src="js/jquery.blockUI.js"></script>
	<script src="js/waves.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/app.js"></script>
</body>
</html>