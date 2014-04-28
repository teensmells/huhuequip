<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>乎乎设备管理后台</title>
		<style type='text/css'>
		    body {
		      background-color: #CCC;
		    }
		    #content {
		      background-color: #FFF;
		      border-radius: 5px;
		    }
		    #content .main {
		      padding: 20px;
		    }
		    #content .sidebar {
		      padding: 10px;
		    }
		    #content p {
		      line-height: 30px;
		    }
	    </style>
		<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css" rel="stylesheet">
	</head>
	
	
	
	<body>
		<div class="container">
			<div class="navbar navbar-inverse">
				<div class="navbar-inner nav-collapse" style="height:auto;">
					<ul class="nav">
						<li><a href="/huhuequip/huhuequip/equipmanage">设备管理</a></li>
						<li class="active"><a href="/huhuequip/huhuequip/excelimport">导入数据</a></li>
					</ul>
				</div>
			</div>
			<form role="form" method ="post" enctype ="multipart/form-data">
				<input name="excelFile" id="lefile" type="file" style="display:none">
				<input name="upload" type="hidden" value="upload" >
				<div class="input-append">
				    <input name="excelFileName" id="photoCover" class="input-large" type="text" value="${excelFileName!}">
				    <a class="btn" onclick="$('input[id=lefile]').click();">浏览</a>
				    <button type="submit" class="btn btn-default">上传</button>
				</div>
				<span>${msg!}</span>
			</form>
		</div>
	</body>
</html>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript">  
	$('input[id=lefile]').change(function() {  
		$('#photoCover').val($(this).val());
		console.log($('input[id=lefile]').val());
	});
</script>