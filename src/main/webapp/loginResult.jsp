<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String name =  (String)session.getAttribute("name");
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		String gender = (String)session.getAttribute("gender");
	%>
	<%=name %>님 로그인에 성공하셨습니다.<br>
	<%=id %>님의 ID는 "<%=name %>"입니다.<br>
	<%=id %>님의 ID는 "<%=gender %>"입니다.<br>
	가입하신 회원정보를 수정하실려면 아래 [회원정보수정]을 클릭해주세요<br><br>

<h3><a href="modify.jsp">[회원정보수정]</a></h3>
</body>
</html>