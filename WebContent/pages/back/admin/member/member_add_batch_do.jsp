<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%@ page import="java.util.*"%>
<%!
public static final String MEMBER_ADD_URL = "pages/back/admin/member/member_add_batch.jsp";
%>

<jsp:include page="/pages/plugins/include_head.jsp"></jsp:include>
<%
	request.setCharacterEncoding("UTF-8");
	String memberInfo=request.getParameter("memberinfo").trim();
	Set<Member> allMembers=new HashSet<Member>();
	String result[]=memberInfo.split(",");
	for(int x=0; x < result.length ; x++){
		String temp[]=result[x].split(":");
		Member vo=new Member();
		vo.setMid(temp[0]);
		vo.setName(temp[1]);
		vo.setBirthday(new java.text.SimpleDateFormat("yyyy-MM-dd").parse(temp[2]));
		vo.setSal(Double.parseDouble(temp[3]));
		vo.setDel(Integer.parseInt(temp[4]));
		vo.setNote(temp[5]);
		allMembers.add(vo);
		
	}
	boolean flag = false;
	IMemberService service = Factory.getServiceInstance("member.service");
	flag = service.addBatch(allMembers);
	String msg = "用戶批量增加失敗";
	if (flag) {
		msg = "用户批量增加成功";
	}
%>
<jsp:include page="/pages/plugins/forward.jsp">
	<jsp:param value="<%=msg%>" name="msg" />
	<jsp:param value="<%=MEMBER_ADD_URL%>" name="url" />
</jsp:include>
<jsp:include page="/pages/plugins/include_foot.jsp"></jsp:include>