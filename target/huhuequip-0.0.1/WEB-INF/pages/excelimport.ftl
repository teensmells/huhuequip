<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>乎乎设备管理后台</title>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	</head>
	<body>
		<div class="navbar navbar-default" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="/huhuequip/equipmanage">设备管理</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="/huhuequip/equipmanage">设备查看</a></li>
						<li class="active"><a href="/huhuequip/excelimport">添加数据</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="jumbotron">
				<form role="form" method ="post" enctype ="multipart/form-data">
					<div class="form-group">
						<input name="excelFile" name="excelFile" type="file">
					</div>
					<button type="submit" class="btn btn-default">上传</button>
					<span>${msg!}</span>
				</form>
			</div>
		</div>
	</body>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</html>