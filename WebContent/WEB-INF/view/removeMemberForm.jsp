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
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
</head>
<body>
<u:navbar/>
<div class="container">
<div class="container">
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<h1>회원탈퇴</h1>
			<form action="${root }/removeMember.do" method="post">
			<div class="form-group">
						<label for="input1-password">비밀번호</label> 
						<input type="password" name="password" class="form-control" id="input1-password">
						<c:if test="${errors.password }">
							<small class="form-text text-muted">현재 암호를 입력하세요</small>
						</c:if>
						<c:if test="${errors.noPw}">
							<small class="form-text text-muted">현재 암호가 일치하지 않습니다.</small>
						</c:if>
			</div>
				<button type="submit" class="btn btn-primary">회원 탈퇴</button>
			</form>
		</div>
	</div>
</div>
</div>
<%--
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
 --%>
</body>
</html> 