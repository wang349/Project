<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	public static final String MEMBER_ADD_URL="pages/back/admin/member/member_add_do.jsp";
%>

<jsp:include page="/pages/plugins/include_head.jsp"></jsp:include>
<script type="text/javascript" src="js/back/admin/member/member_add.js"></script>
<script type="text/javascript" src="plugins/laydate/laydate.js"></script>
<form action="<%=MEMBER_ADD_URL %>" method="post" id="memberform" onsubmit="">
<table border="1" width="80%" cellpadding="1" cellspacing="1">

	<tr bgcolor="#ffffff">
		<td>用户名：</td>
		<td><input type="text" id="mid" name="mid" placeholder="用户名"
			class="init" /></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td>真实姓名：</td>
		<td><input type="text" id="name" name="name"
			placeholder="请填写真实姓名" class="init" /></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td>出生日期：</td>
		<td><input type="text" id="birthday" name="birthday"
			placeholder="请选择出生日期" class="init laydate-icon" readonly="readonly" /></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td>工资：</td>
		<td><input type="text" id="sal" name="sal" placeholder="月薪"
			class="init" /></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td>个人简介：</td>
		<td>&nbsp;</td>
	</tr>
	<tr bgcolor="#ffffff">
		<td colspan="2"><textarea id="note" name="note" class="init" /></textarea></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td colspan="2">
		<input type="submit" value="增加" id="subBtn" /> <input
			type="reset" id="reset"></td>
	</tr>

</table>
	<jsp:include page="/pages/plugins/include_foot.jsp"></jsp:include>