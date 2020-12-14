<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%--
<c:if test="${! empty authUser }"> 
${authUser.name }님, 안녕하세요.
<br />
<a href="login.do">[로그아웃]</a>
<a href="changePwd.do">[비밀번호 변경]</a>
</c:if>
<c:if test="${empty authUser }">
<a href="join.do">[회원가입]</a>
<a href="login.do">[로그인]</a>
</c:if>
<br />
 --%>
<u:isLogin>
${authUser.name }님, 안녕하세요.
<br />
<a href="login.do">[로그아웃]</a>
<a href="changePwd.do">[비밀번호 변경]</a>
<a href="removeMember.do">[회원탈퇴]</a>
<a href="article/list.do">[게시물 보기]</a>
<a href="article/write.do">[게시물 쓰기]</a>
</u:isLogin>
<u:notLogin>
<a href="join.do">[회원가입]</a>
<a href="login.do">[로그인]</a>
</u:notLogin>
</body>
</html>