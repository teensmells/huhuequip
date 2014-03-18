<#include "/WEB-INF/pages/pageutil.ftl" >
<#assign params="method=${method!}&specialtyId=${specialtyId!0}">
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
						<li class="active"><a href="/huhuequip/equipmanage">设备查看</a></li>
						<li><a href="/huhuequip/excelimport">添加数据</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="jumbotron">
				<form class="form-inline" role="form">
					<#if specialtyVOs??&&(specialtyVOs?size>0)>
						<span>专业：</span>
						<select name="specialtyId" class="form-control">
							<#list specialtyVOs as specialty>
								<option <#if specialtyId==specialty.id>selected="selected"</#if>value="${specialty.id}">${specialty.specialtyName}</option>
							</#list>
						</select>
					</#if>
					<button type="submit" class="btn btn-default">搜索</button>
					<input type="hidden" name="method" value="search" >
				</form>
			</div>
			<table class="table table-striped table-hover table-condensed table-bordered">
				<thead>
					<tr>
						<th width="7%">价格年份</th>
						<th width="7%">设备名称</th>
						<th width="7%">规格型号</th>
						<th width="7%">技术参数</th>
						<th width="5%">单位</th>
						<th width="10%">单价(万元)</th>
						<th width="7%">价格来源</th>
						<th width="7%">合同编号</th>
						<th width="7%">项目名</th>
						<th width="7%">子项目名</th>
						<th width="4%">专业</th>
						<th width="10%">供应商</th>
						<th width="7%">备注</th>
						<th width="8%">添加时间</th>
					</tr>
				</thead>
				<#if pageModel??&&(pageModel.list??)&&(pageModel.list?size>0)>
					<tbody>
						<#list pageModel.list as equip>
							<tr>
								<td>${equip.priceYear!}</td>
								<td>${equip.name!}</td>
								<td>${equip.specification!}</td>
								<td>${equip.techParams!}</td>
								<td>${equip.unit!}</td>
								<td>${equip.unitPrice!}</td>
								<td>${equip.priceSource!}</td>
								<td>${equip.contractNo!}</td>
								<td>${equip.project!}</td>
								<td>${equip.subProject!}</td>
								<td>${equip.specialtyName!}</td>
								<td>${equip.supplierAndContact!}</td>
								<td>${equip.memo!}</td>
								<td>${equip.updateTime?string('MM-dd HH:ss')}</td>
							</tr>
						</#list>
					</tbody>
				</#if>
			</table>
			<#if pageModel??&&(pageModel.list??)&&(pageModel.pageCount>1)>
				<@pageutil pageModel params />
			</#if>
		</div>
	</body>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</html>