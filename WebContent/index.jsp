<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
</head>
<body>
  <u:navbar />
  <div class="container">
    <%--
  <c:if test="${not empty authUser }">
    ${authUser.name }님, 안녕하세요.
    <a href="logout.do">[로그아웃하기]</a>
    <a href="changePwd.do">[암호변경하기]</a>
  </c:if>
  <c:if test="${empty authUser }">
    <a href="join.do">[회원가입하기]</a>
    <a href="login.do">[로그인하기]</a>
  </c:if>
  --%>
  <%--
    <u:isLogin>
    ${authUser.name }님, 안녕하세요.
    <a href="logout.do">[로그아웃하기]</a>
    <a href="changePwd.do">[암호변경하기]</a>
    <a href="removeMember.do">[회원 탈퇴하기]</a>
    <a href="article/list.do">[게시물 보기]</a>
	<a href="article/write.do">[게시물 쓰기]</a> 
    </u:isLogin>
    <u:notLogin>
      <a href="join.do">[회원가입하기]</a>
      <a href="login.do">[로그인하기]</a>
    </u:notLogin>
 --%>
<div class="jumbotron">
  <h1 class="display-4">하위</h1>
  <p class="lead">혼자만 있고 싶어요</p>
  <hr class="my-4">
  <p>이제 나가세요</p>
  <a class="btn btn-primary btn-lg" href="${root }/join.do" role="button">아니 나가기전에 회원가입하세요.</a>
</div>
  </div>
</body>
</html>
