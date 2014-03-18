<#macro pageutil pageModel params>
	<#assign curpage=pageModel.page>
	<#assign pagecount=pageModel.pageCount>
	<ul class="pagination">
	  <#if (curpage>1)><li><a href="/huhuequip/equipmanage?${params}">首页</a></li></#if>
	  <#if (curpage>1)><li><a href="/huhuequip/equipmanage?${params}&page=${curpage-1}">上一页</a></li></#if>
	  <li class="active"><a href="#">${curpage} <span class="sr-only">(current)</span></a></li>
	  <#if (curpage<pagecount)><li><a href="/huhuequip/equipmanage?${params}&page=${curpage+1}">下一页</a></li></#if>
	  <#if (curpage<pagecount)><li><a href="/huhuequip/equipmanage?${params}&page=${pagecount}">末页</a></li></#if>
	</ul>
</#macro>