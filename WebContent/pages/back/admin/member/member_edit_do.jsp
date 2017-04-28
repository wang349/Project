<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%!
public static final String MEMBER_LIST_URL = "pages/back/admin/member/member_list.jsp";
%>

<jsp:include page="/pages/plugins/include_head.jsp"></jsp:include>
<%
	request.setCharacterEncoding("UTF-8");
	Member vo = new Member();
	vo.setMid(request.getParameter("mid"));
	vo.setName(request.getParameter("name"));
	vo.setBirthday(new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")));
	vo.setNote(request.getParameter("note"));
	vo.setSal(Double.parseDouble(request.getParameter("sal")));
	boolean flag = false;
	IMemberService service = Factory.getServiceInstance("member.service");
	flag = service.edit(vo);
	String msg = "用戶修改失敗";
	if (flag) {
		msg = "用户修改成功";
	}
%>
<jsp:include page="/pages/plugins/forward.jsp">
	<jsp:param value="<%=msg%>" name="msg" />
	<jsp:param value="<%=MEMBER_LIST_URL%>" name="url" />
</jsp:include>
<jsp:include page="/pages/plugins/include_foot.jsp"></jsp:include>