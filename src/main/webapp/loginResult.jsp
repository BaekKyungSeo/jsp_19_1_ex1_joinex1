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
	<%=name %>�� �α��ο� �����ϼ̽��ϴ�.<br>
	<%=id %>���� ID�� "<%=name %>"�Դϴ�.<br>
	<%=id %>���� ID�� "<%=gender %>"�Դϴ�.<br>
	�����Ͻ� ȸ�������� �����ϽǷ��� �Ʒ� [ȸ����������]�� Ŭ�����ּ���<br><br>

<h3><a href="modify.jsp">[ȸ����������]</a></h3>
</body>
</html>