<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <%@page import="com.model2.mvc.service.domain.Product"%>
<%@page import="com.model2.mvc.common.util.CommonUtil"%>
<%@page import="com.model2.mvc.common.Page"%>

<%@page import="java.util.List"%>
<%@page import="com.model2.mvc.common.Search"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>





<% 
List<Product> list= (List<Product>) request.getAttribute("list");
Page resultPage=(Page)request.getAttribute("resultPage");

Search search = (Search)request.getAttribute("search");
//==> null �� ""(nullString)���� ����
String searchCondition = CommonUtil.null2str(search.getSearchCondition());
String searchKeyword = CommonUtil.null2str(search.getSearchKeyword());

 %> --%>


<html>
<head>
<title>��ǰ �����ȸ</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">
<!--// �˻� / page �ΰ��� ��� ��� Form ������ ���� JavaScrpt �̿�-->
<script type="text/javascript">

 function fncGetUserList(currentPage) {
	document.getElementById("currentPage").value = currentPage;
   	document.detailForm.submit();		
} 
</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/listProduct.do?menu=${param.menu }" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
						<%-- <%if(request.getParameter("menu").equals("manage")){%>
								 ��ǰ����
								<%}else { %>
								��ǰ �����ȸ  <%}%> --%>
						
						<c:if test="${!empty param.menu}">
								<c:choose>
									<c:when test = "${param.menu=='manage' }">
									��ǰ����
									</c:when>
									<c:when test = "${param.menu=='search' }">
									��ǰ �����ȸ
									</c:when>
									</c:choose>
						</c:if>
							
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option value="0">��ǰ��ȣ</option>
				<option value="1">��ǰ��</option>
				<option value="2">��ǰ����</option>
			</select>
			<input type="text" name="searchKeyword"  class="ct_input_g" style="width:200px; height:19px" />
		</td>
	
		
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetUserList('1');">�˻�</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >��ü  ${resultPage.totalCount} �Ǽ�,	���� ${resultPage.currentPage} ������</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="50">No</td>
		<td class="ct_line02"></td>
			
			<%-- <c:choose>
				<c:when test = "${param.menu=='sale' }">
					<td class="ct_list_b" width="100">������</td>
					<td class="ct_line02"></td>
				</c:when>
			</c:choose> --%>
		
		<td class="ct_list_b" width="150">��ǰ��</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="120">����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">�����

		</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">
		
			<%-- <c:choose>
				<c:when test = "${param.menu=='sale' }">
					���
				</c:when>
				<c:otherwise>
					�������
				</c:otherwise>
			</c:choose> --%>
			�������
				
		</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
<%-- 		<% 
		
		for(int i=0; i<list.size(); i++) {
			Product vo = list.get(i);
			%>
			
			
	<tr class="ct_list_pop">
		<td align="center"><%= i + 1%></td>
		<td></td>
				
				<td align="left"><a href="/getProduct.do?prodNo=<%=vo.getProdNo() %>&menu=<%=request.getParameter("menu")%>">
				<%=vo.getProdName() %></a>
				</td>
		
		<td></td>
		<td align="left"><%=vo.getPrice() %></td>
		<td></td>
		<td align="left"><%=vo.getRegDate() %></td>
		<td></td>
		<td align="left">
		
			�Ǹ���
		
		</td>	
	</tr>
	
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>	
	
	<%} %> --%>
	
	<c:set var="i" value="0"/>
	<c:forEach var="product" items="${list}">
		<c:set var="i" value="${i+1}"/>
	
	<tr class="ct_list_pop">
		<td align="center">${i}</td>
		<td></td>
				
				<td align="left"><a href="/getProduct.do?prodNo=${product.prodNo}&menu=${param.menu}">
				${product.prodName }</a>
				</td>
		
		<td></td>
		<td align="left">${product.price }</td>
		<td></td>
		<td align="left">
			<c:choose>
				<c:when test = "${param.menu=='sale' }">
					${purchase.orderDate}
				</c:when>
				<c:otherwise>
					${product.regDate}
				</c:otherwise>
			</c:choose>
		
		</td>
		<td></td>
		<td align="left">
		
		<c:if test="${param.menu=='manage' }">
			<c:choose >
				<c:when test = "${empty product.prodTranCode}">
						�Ǹ���
				</c:when>
				<c:when test = "${product.prodTranCode=='1  '}">
						���ſϷ� 
						<a href ="/updateTranCodeByProd.do?prodNo=${product.prodNo}&tranCode=2">����ϱ�</a>
				</c:when>
				<c:when test = "${product.prodTranCode=='2  '}">
						�����
				</c:when>
				<c:when test = "${product.prodTranCode=='3  '}">
						��ۿϷ�
				</c:when>
			</c:choose>
		</c:if>		
		
		<c:if test="${param.menu=='search' }">
			<c:choose>
				<c:when test = "${empty product.prodTranCode}">
					�Ǹ���
				</c:when>
				<c:otherwise>
					������
				</c:otherwise>
			</c:choose>
		</c:if>
		
		<c:if test="${param.menu=='sale' }">
			�ǸſϷ�
		</c:if>

		</td>	
	</c:forEach>	
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="center">
		
		 <input type="hidden" id="currentPage" name="currentPage" value="1"/>
			<%-- <% if( resultPage.getCurrentPage() <= resultPage.getPageUnit() ){ %>
					�� ����
			<% }else{ %>
					<a href="javascript:fncGetUserList('<%=resultPage.getCurrentPage()-1%>')">�� ����</a>
			<% } %>

			<%	for(int i=resultPage.getBeginUnitPage();i<= resultPage.getEndUnitPage() ;i++){	%>
					<a href="javascript:fncGetUserList('<%=i %>');"><%=i %></a>
			<% 	}  %>
	
			<% if( resultPage.getEndUnitPage() >= resultPage.getMaxPage() ){ %>
					���� ��
			<% }else{ %>
					<a href="javascript:fncGetUserList('<%=resultPage.getEndUnitPage()+1%>')">���� ��</a>
			<% } %> --%>
			
		<jsp:include page="../common/pageNavigator.jsp"/>	

		
    	</td>
	</tr>
</table>
<!--  ������ Navigator �� -->

</form>

</div>
</body>
</html>
