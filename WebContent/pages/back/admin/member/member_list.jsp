<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%!
public static final String MEMBER_EDIT_URL = "pages/back/admin/member/member_edit.jsp";
public static final String MEMBER_DELETE_URL = "pages/back/admin/member/member_delete_do.jsp";
%>

<jsp:include page="/pages/plugins/include_head.jsp"></jsp:include>
<script type="text/javascript" src="js/back/admin/member/member_list.js"></script>
<script type="text/javascript">
var deleteUrl="<%=request.getAttribute("basePath")%><%=MEMBER_DELETE_URL%>";
</script>
<%
	request.setCharacterEncoding("UTF-8");
	IMemberService service=Factory.getServiceInstance("member.service");
	List<Member> all=service.listByDelete(0);
	Iterator<Member> iter=all.iterator();
%>
	<table border="1" width="80%" cellpadding="1" cellspacing="1">
	<tr bgcolor="#ffffff">
		<td width=5%><input type="checkbox" id="selectall"></td>
		<td width=20%>用户名：</td>
		<td width=20%>真实姓名：</td>
		<td width=20%>生日：</td>
		<td width=20%>基本工资：</td>
		<td width=60%>个人信息：</td>	
	</tr>
	<%
	while(iter.hasNext()){
		Member vo=iter.next();
	%>
	<tr bgcolor="#ffffff">
	<td><input type="checkbox" id="mid" value="<%=vo.getMid() %>"></td>
	<td><a href="<%=MEMBER_EDIT_URL%>?mid=<%=vo.getMid()%>"><%=vo.getMid()%></a></td>
	<td><%=vo.getName() %></td>
	<td><%=vo.getBirthday() %></td>
	<td><%=vo.getSal() %></td>
	<td><%=vo.getNote() %></td>
	</tr>
	<%
	}
	%>
	</table>

	<button id="deleteBtn">gc</button>
<jsp:include page="/pages/plugins/include_foot.jsp"></jsp:include>