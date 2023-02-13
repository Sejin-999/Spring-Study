<%@ page import="hello.demo.domain.member.MemberRepository" %>
<%@ page import="hello.demo.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li>id=<%=member.getId()%></li>
    <li>id=<%=member.getUsername()%></li>
    <li>id=<%=member.getAge()%></li>
</ul>
<a href="index.html">메인으로</a>
</body>
</html>
