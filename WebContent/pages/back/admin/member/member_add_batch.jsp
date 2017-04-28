<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	public static final String MEMBER_ADD_URL="pages/back/admin/member/member_add_batch_do.jsp";
%>

<jsp:include page="/pages/plugins/include_head.jsp"></jsp:include>
<form action="<%=MEMBER_ADD_URL %>" method="post" id="memberform" onsubmit="">
<table border="1" width="80%" cellpadding="1" cellspacing="1">

	
	<tr bgcolor="#ffffff">
		<td>批量添加：</td>
		<td>&nbsp;</td>
	</tr>
	<tr bgcolor="#ffffff">
		<td colspan="2"><textarea id="memberinfo" name="memberinfo" class="init" /></textarea></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td colspan="2">
		<input type="submit" value="批量添加" id="subBtn" /> <input
			type="reset" id="reset"></td>
	</tr>

</table>
	<jsp:include page="/pages/plugins/include_foot.jsp"></jsp:include>