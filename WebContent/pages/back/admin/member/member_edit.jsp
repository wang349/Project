<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.*"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%!
	public static final String MEMBER_EDIT_URL="pages/back/admin/member/member_edit_do.jsp";
%>

<jsp:include page="/pages/plugins/include_head.jsp"></jsp:include>
<script type="text/javascript" src="js/back/admin/member/member_edit.js"></script>
<script type="text/javascript" src="plugins/laydate/laydate.js"></script>
<%
String mid=request.getParameter("mid");
IMemberService service=Factory.getServiceInstance("member.service");
Member vo=service.editPre(mid);
%>
<form action="<%=MEMBER_EDIT_URL %>" method="post" id="memberform" onsubmit="">
<table border="1" width="80%" cellpadding="1" cellspacing="1">

	<tr bgcolor="#ffffff">
		<td>用户名：</td>
		<td><%=vo.getMid() %></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td>真实姓名：</td>
		<td><input type="text" id="name" name="name"
			placeholder="请填写真实姓名" class="init"  value="<%=vo.getName() %>"/></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td>出生日期：</td>
		<td><input type="text" id="birthday" name="birthday"
			placeholder="请选择出生日期" class="init laydate-icon" readonly="readonly" value="<%=vo.getBirthday() %>"/></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td>工资：</td>
		<td><input type="text" id="sal" name="sal" placeholder="月薪"
			class="init"  value="<%=vo.getSal() %>"/></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td>个人简介：</td>
		<td>&nbsp;</td>
	</tr>
	<tr bgcolor="#ffffff">
		<td colspan="2"><textarea id="note" name="note" class="init" ><%=vo.getNote()%></textarea></td>
	</tr>
	<tr bgcolor="#ffffff">
		<td colspan="2">
		<input type="hidden" name="mid" value="<%=vo.getMid() %>">
		<input type="submit" value="编辑" id="subBtn" /> <input
			type="reset" id="reset"></td>
	</tr>
</table>
</form>
	<jsp:include page="/pages/plugins/include_foot.jsp"></jsp:include>