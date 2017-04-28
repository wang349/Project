<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%@ page import="java.util.*"%>
<%!
public static final String MEMBER_LIST_URL = "pages/back/admin/member/member_list.jsp";
%>

<jsp:include page="/pages/plugins/include_head.jsp"></jsp:include>
<%
	request.setCharacterEncoding("UTF-8");
	String ids=request.getParameter("ids");
	Set<String> set=new HashSet<String>();
	String result[]=ids.split(",");
	for(int x=0;x<result.length;x++){
		set.add(result[x]);
	}
	boolean flag = false;
	IMemberService service = Factory.getServiceInstance("member.service");
	flag = service.delete(set);
	String msg = "用戶删除失敗";
	if (flag) {
		msg = "用户删除成功";
	}
%>
<jsp:include page="/pages/plugins/forward.jsp">
	<jsp:param value="<%=msg%>" name="msg" />
	<jsp:param value="<%=MEMBER_LIST_URL%>" name="url" />
</jsp:include>
<jsp:include page="/pages/plugins/include_foot.jsp"></jsp:include>