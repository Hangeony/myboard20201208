<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1> 회원탈퇴 </h1>
<form action="removeMember.do" method="post">
암호 : <input type="password" name="password" />
<c:if test="${errors.pw }">현재 암호를 입력하세요.</c:if>
<c:if test="${errors.noPw}">현재 암호가 일치하지 않습니다.</c:if>
<br />
<input type="submit" value="탈퇴" />
</form>
</div>
</body>
</html>