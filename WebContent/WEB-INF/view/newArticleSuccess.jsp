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
게시글을 등록 했습니다.
<br />
<a href="${root }/article/list.do">[게시글 목록 보기]</a>
<a href="${root }/article/read.do?no=${newArticleNo}">[게시글 내용 보기]</a>
</div>
</body>
</html>