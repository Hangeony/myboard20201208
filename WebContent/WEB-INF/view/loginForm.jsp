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
	<u:navbar />
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<h1>로그인</h1>
				<form action="${root }/login.do" method="post">
					<div class="form-group">
						<label for="input1-id">아이디</label> <input type="text" name="id"
							class="form-control" id="input1-id" value="${param.id }">
						<c:if test="${errors.id }">
							<small class="form-text text-muted">ID를 입력하세요.</small>
						</c:if>
					</div>
					<div class="form-group">
						<label for="input2-password">비밀번호</label> <input type="password"
							name="password" class="form-control" id="input2-password"
							value="${param.password }">
						<c:if test="${errors.password }">
							<small class="form-text text-muted">비밀번호를 입력하세요.</small>
						</c:if>
					</div>
					<button type="submit" class="btn btn-primary">로그인</button>
				</form>
			</div>
		</div>
	</div>
	<%--
<div class="container">
<form action="login.do" method="post">
<c:if test="${errors.idOrPwNotMatch }">
<br />
아이디와 비빌먼호가 일치하지 않습니다
</c:if>
<p>
아이디 <input type="text" name="id" value="${param.id }" />
<br />
<c:if test="${errors.id }"> ID를 입력하세요 </c:if>
</p>
<p>
비밀번호 <input type="password" name="password" value="${param.password }" />
<br />
<c:if test="${errors.password }"> 비밀번호를 입력하세요 </c:if>
</p>
<input type="submit" value="로그인" />
</form>
</div>
 --%>
</body>
</html>