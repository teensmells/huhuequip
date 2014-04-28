<#include "/WEB-INF/pages/pageutil.ftl" >
<#assign params="specialtyId=${specialtyId!0}">
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
		      padding: 10px;
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
						<li class="active"><a href="/huhuequip/huhuequip/equipmanage">设备管理</a></li>
						<li><a href="/huhuequip/huhuequip/excelimport">导入数据</a></li>
					</ul>
				</div>
			</div>
			<div id="content" class="row-fluid">
				<div class="span2 sidebar">
					<ul class="nav nav-tabs nav-stacked">
						<li <#if specialtyId==-1>class="active"</#if>><a href="/huhuequip/huhuequip/equipmanage">全部</a></li>
						<#if specialtyVOs??&&(specialtyVOs?size>0)>
							<#list specialtyVOs as specialty>
								<li <#if specialtyId=specialty.id>class="active"</#if>><a href="/huhuequip/huhuequip/equipmanage?specialtyId=${specialty.id}">${specialty.specialtyName}</a></li>
							</#list>
						</#if>
					</ul>
				</div>
				
				<div class="span10 main" style="position:relative;right:30px;">
					<p><a href="#modal_add" data-toggle="modal" class="btn btn-primary disabled">新增设备</a></p>
					<div id="modal_add" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  	<div class="modal-header">
			              	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			              	<h3>新增设备</h3>
			            </div>
					  	<div class="modal-body">
				    		<h4>价格年份</h4>
				    		<input id="modal_add_priceYear">
				    		
				    		<h4>设备名称</h4>
				    		<input id="modal_add_name">
				    	
					    	<h4>规格型号</h4>
					    	<input id="modal_add_specification">
				    	
					    	<h4>技术参数</h4>
					    	<input id="modal_add_techParams">
				    	
					    	<h4>单位</h4>
					    	<input id="modal_add_unit">
				    	
					    	<h4>单价(万元)</h4>
					    	<input id="modal_add_unitPrice">
				    	
					    	<h4>价格来源</h4>
					    	<input id="modal_add_priceSource">
				    	
					    	<h4>合同编号</h4>
					    	<input id="modal_add_contractNo">
				    	
					    	<h4>项目名</h4>
					    	<input id="modal_add_project">
				    	
					    	<h4>子项目名</h4>
					    	<input id="modal_add_subProject">
				    	
					    	<h4>专业</h4>
					    	<select id="modal_add_specialtyName">
					    		<#list specialtyVOs as specialty>
					    			<option value="${specialty.id}">${specialty.specialtyName}</option>
					    		</#list>
					    	</select>
				    	
					    	<h4>供应商</h4>
					    	<input id="modal_add_supplierAndContact">
				    	
					    	<h4>备注</h4>
					    	<input id="modal_add_memo">
					  	</div>
					  	<div class="modal-footer">
					  		<span style="display:none;color:red;"></span>
					    	<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					    	<button class="btn btn-primary submit">提交</button>
					  	</div>
					</div>
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th width="8%">价格年份</th>
								<th width="8%">设备名称</th>
								<th width="8%">规格型号</th>
								<th width="8%">技术参数</th>
								<th width="5%">单位</th>
								<th width="5%">单价</th>
								<th width="8%">价格来源</th>
								<th width="8%">合同编号</th>
								<th width="7%">项目名</th>
								<th width="8%">子项目名</th>
								<th width="5%">专业</th>
								<th width="7%">供应商</th>
								<th width="5%">备注</th>
								<th width="5%"></th>
							</tr>
						</thead>
						<#if pageModel??&&(pageModel.list??)&&(pageModel.list?size>0)>
							<tbody>
								<#list pageModel.list as equip>
									<tr>
										<td title="${equip.priceYear!}">${equip.cutPriceYear!}</td>
										<td title="${equip.name!}">${equip.cutName!}</td>
										<td title="${equip.specification!}">${equip.cutSpecification!}</td>
										<td title="${equip.techParams!}">${equip.cutTechParams!}</td>
										<td title="${equip.unit!}">${equip.cutUnit!}</td>
										<td title="${equip.unitPrice!}">${equip.unitPrice!}</td>
										<td title="${equip.priceSource!}">${equip.cutPriceSource!}</td>
										<td title="${equip.contractNo!}">${equip.cutContractNo!}</td>
										<td title="${equip.project!}">${equip.cutProject!}</td>
										<td title="${equip.subProject!}">${equip.cutSubProject!}</td>
										<td title="${equip.specialtyName!}">${equip.cutSpecialtyName!}</td>
										<td title="${equip.supplierAndContact!}">${equip.cutSupplierAndContact!}</td>
										<td title="${equip.memo!}">${equip.cutMemo!}</td>
										<td><a href="#modal${equip.id}" data-toggle="modal">详情</a></td>
									</tr>
									<div id="modal${equip.id}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									  	<div class="modal-header">
							              	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							              	<h3>${equip.name!}</h3>
							              	<input value="${equip.name!}" style="display:none">
							              	<p style="display:none">${equip.id!}</p>
							            </div>
									  	<div class="modal-body">
								    		<h4>价格年份</h4>
								    		<p class="modal_priceYear">${equip.priceYear!}</p>
								    		<input class="modal_priceYear" value="${equip.priceYear!}" style="display:none">
								    	
									    	<h4>规格型号</h4>
									    	<p class="modal_specification">${equip.specification!}</p>
									    	<input class="modal_specification" value="${equip.specification!}" style="display:none">
								    	
									    	<h4>技术参数</h4>
									    	<p class="modal_techParams">${equip.techParams!}</p>
									    	<input class="modal_techParams" value="${equip.techParams!}" style="display:none">
								    	
									    	<h4>单位</h4>
									    	<p class="modal_unit">${equip.unit!}</p>
									    	<input class="modal_unit" value="${equip.unit!}" style="display:none">
								    	
									    	<h4>单价(万元)</h4>
									    	<p class="modal_unitPrice">${equip.unitPrice!}</p>
									    	<input class="modal_unitPrice" value="${equip.unitPrice!}" style="display:none">
								    	
									    	<h4>价格来源</h4>
									    	<p class="modal_priceSource">${equip.priceSource!}</p>
									    	<input class="modal_priceSource" value="${equip.priceSource!}" style="display:none">
								    	
									    	<h4>合同编号</h4>
									    	<p class="modal_contractNo">${equip.contractNo!}</p>
									    	<input class="modal_contractNo" value="${equip.contractNo!}" style="display:none">
								    	
									    	<h4>项目名</h4>
									    	<p class="modal_project">${equip.project!}</p>
									    	<input class="modal_project" value="${equip.project!}" style="display:none">
								    	
									    	<h4>子项目名</h4>
									    	<p class="modal_subProject">${equip.subProject!}</p>
									    	<input class="modal_subProject" value="${equip.subProject!}" style="display:none">
								    	
									    	<h4>专业</h4>
									    	<p class="modal_specialtyName">${equip.specialtyName!}</p>
									    	<select class="modal_specialtyName" style="display:none">
									    		<#list specialtyVOs as specialty>
									    			<option <#if specialty.specialtyName=equip.specialtyName>selected="selected"</#if> value="${specialty.id}">${specialty.specialtyName}</option>
									    		</#list>
									    	</select>
									    	
									    	<h4>供应商</h4>
									    	<p class="modal_supplierAndContact">${equip.supplierAndContact!}</p>
									    	<input class="modal_supplierAndContact" value="${equip.supplierAndContact!}" style="display:none">
								    	
									    	<h4>备注</h4>
									    	<p class="modal_memo">${equip.memo!}</p>
									    	<input class="modal_memo" value="${equip.memo!}" style="display:none">
									  	</div>
									  	<div class="modal-footer">
									  		<span style="display:none;color:red;"></span>
									    	<button class="btn" data-dismiss="modal" aria-hidden="true" style="display:none">关闭</button>
									    	<button class="btn btn-primary clo">关闭</button>
									    	<button class="btn btn-primary edit">编辑</button>
									    	<button class="btn btn-primary cancel" style="display:none">取消</button>
									    	<button class="btn btn-primary save">保存</button>
									  	</div>
									</div>
								</#list>
							</tbody>
						</#if>
					</table>
					<#if pageModel??&&(pageModel.list??)&&(pageModel.pageCount>1)>
						<@pageutil pageModel params />
					</#if>
				</div>
			</div>
		</div>
	</body>
</html>
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function(){
		$("button.edit").click(function(){
			$(this).parent().prev("div").prev("div").children("h3").hide();
			$(this).parent().prev("div").prev("div").children("input").show();
			$(this).parent().prev("div").children("p").hide();
			$(this).parent().prev("div").children("input").show();
			$(this).parent().prev("div").children("select").show();
			$(this).hide();
			$(this).next("button").show();
		});
		$("button.cancel").click(function(){
			$(this).parent().prev("div").prev("div").children("h3").show();
			$(this).parent().prev("div").prev("div").children("input").hide();
			$(this).parent().prev("div").children("p").show();
			$(this).parent().prev("div").children("input").hide();
			$(this).parent().prev("div").children("select").hide();
			$(this).hide();
			$(this).prev("button").show();
		});
		$("button.clo").click(function(){
			$(this).parent().prev("div").prev("div").children("h3").show();
			$(this).parent().prev("div").prev("div").children("input").hide();
			$(this).parent().prev("div").children("p").show();
			$(this).parent().prev("div").children("input").hide();
			$(this).parent().prev("div").children("select").hide();
			$(this).next("button").show();
			$(this).next("button").next("button").hide();
			$(this).prev("button").click();
		});
		$("button.save").click(function(){
			var btnSave = $(this),
				nameP = $(this).parent().prev("div").prev("div").children("h3"),
				nameInput = $(this).parent().prev("div").prev("div").children("input"),
				priceYearP = $(this).parent().prev("div").children("p.modal_priceYear"),
				priceYearInput = $(this).parent().prev("div").children("input.modal_priceYear"),
				specificationP = $(this).parent().prev("div").children("p.modal_specification"),
				specificationInput = $(this).parent().prev("div").children("input.modal_specification"),
				techParamsP = $(this).parent().prev("div").children("p.modal_techParams"),
				techParamsInput = $(this).parent().prev("div").children("input.modal_techParams"),
				unitP = $(this).parent().prev("div").children("p.modal_unit"),
				unitInput = $(this).parent().prev("div").children("input.modal_unit"),
				unitPriceP = $(this).parent().prev("div").children("p.modal_unitPrice"),
				unitPriceInput = $(this).parent().prev("div").children("input.modal_unitPrice"),
				priceSourceP = $(this).parent().prev("div").children("p.modal_priceSource"),
				priceSourceInput = $(this).parent().prev("div").children("input.modal_priceSource"),
				contractNoP = $(this).parent().prev("div").children("p.modal_contractNo"),
				contractNoInput = $(this).parent().prev("div").children("input.modal_contractNo"),
				projectP = $(this).parent().prev("div").children("p.modal_project"),
				projectInput = $(this).parent().prev("div").children("input.modal_project"),
				subProjectP = $(this).parent().prev("div").children("p.modal_subProject"),
				subProjectInput = $(this).parent().prev("div").children("input.modal_subProject"),
				specialtyNameP = $(this).parent().prev("div").children("p.modal_specialtyName"),
				specialtyNameSel = $(this).parent().prev("div").children("select.modal_specialtyName"),
				supplierAndContactP = $(this).parent().prev("div").children("p.modal_supplierAndContact"),
				supplierAndContactInput = $(this).parent().prev("div").children("input.modal_supplierAndContact"),
				memoP = $(this).parent().prev("div").children("p.modal_memo"),
				memoInput = $(this).parent().prev("div").children("input.modal_memo");
		
			$.post("/huhuequip/ajax/equipupdate",
			{
				id:$(this).parent().prev("div").prev("div").children("p").text(),
				name:nameInput.val(),
				priceYear:priceYearInput.val(),
				specification:specificationInput.val(),
				techParams:techParamsInput.val(),
				unit:unitInput.val(),
				unitPriceStr:unitPriceInput.val(),
				priceSource:priceSourceInput.val(),
				contractNo:contractNoInput.val(),
				project:projectInput.val(),
				subProject:subProjectInput.val(),
				specialtyName:specialtyNameSel.find("option:selected").text(),
				supplierAndContact:supplierAndContactInput.val(),
				memo:memoInput.val()
			},
			function(data,msg){
				var span = btnSave.prev("button").prev("button").prev("button").prev("button").prev("span");
				span.text(data.msg);
				span.show();
				if(data.code == 200){
					location.reload();
				}
			});
		});
	});
	
	$("button.submit").click(function(){
		var btnSubmit = $(this),
			nameInput = $(this).parent().prev("div").children("input#modal_add_name"),
			priceYearInput = $(this).parent().prev("div").children("input#modal_add_priceYear"),
			specificationInput = $(this).parent().prev("div").children("input#modal_add_specification"),
			techParamsInput = $(this).parent().prev("div").children("input#modal_add_techParams"),
			unitInput = $(this).parent().prev("div").children("input#modal_add_unit"),
			unitPriceInput = $(this).parent().prev("div").children("input#modal_add_unitPrice"),
			priceSourceInput = $(this).parent().prev("div").children("input#modal_add_priceSource"),
			contractNoInput = $(this).parent().prev("div").children("input#modal_add_contractNo"),
			projectInput = $(this).parent().prev("div").children("input#modal_add_project"),
			subProjectInput = $(this).parent().prev("div").children("input#modal_add_subProject"),
			specialtyNameSel = $(this).parent().prev("div").children("select#modal_add_specialtyName"),
			supplierAndContactInput = $(this).parent().prev("div").children("input#modal_add_supplierAndContact"),
			memoInput = $(this).parent().prev("div").children("input#modal_add_memo");
		$.post("/huhuequip/ajax/equipadd",
			{
				name:nameInput.val(),
				priceYear:priceYearInput.val(),
				specification:specificationInput.val(),
				techParams:techParamsInput.val(),
				unit:unitInput.val(),
				unitPriceStr:unitPriceInput.val(),
				priceSource:priceSourceInput.val(),
				contractNo:contractNoInput.val(),
				project:projectInput.val(),
				subProject:subProjectInput.val(),
				specialtyName:specialtyNameSel.find("option:selected").text(),
				supplierAndContact:supplierAndContactInput.val(),
				memo:memoInput.val()
			},
			function(data,msg){
				var span = btnSubmit.prev("button").prev("span");
				span.text(data.msg);
				span.show();
				if(data.code == 200){
					window.location = "/huhuequip/huhuequip/equipmanage"
				}
			});
	});
	
</script>