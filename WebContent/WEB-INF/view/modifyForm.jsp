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
<u:navbar/>
<div class="container">
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<h1>게시글 변경</h1>
			<form action="${root }/article/modify.do" method="post">
			<input type="text" name="no" value="${modReq.articleNumber }" hidden/>
				번호 <br /> ${modReq.articleNumber }
              <!-- div.form-group>label[for=input1-title]+input.form-control#input1-title[name=title] -->
              <div class="form-group">
                <label for="input1-title">제목</label>
                <input value="${modReq.title }" type="text" class="form-control" id="input1-title" name="title" />
                <c:if test="${errors.title }">
                  <small class="form-text text-muted">제목을 입력하세요.</small>
                </c:if>
              </div>
              <!-- .form-group>label[for=textarea1-content]+textarea.form-control#textarea1-content -->
              <div class="form-group">
                <label for="textarea1-content">내용</label>
                <textarea name="content" style="resize:none" id="textarea1-content" cols="30" rows="10" class="form-control" style=rize:none>${modReq.content }</textarea>
              </div>
              <button type="submit" class="btn btn-primary">글 수정</button>
            </form>
		</div>
	</div>
</div>
<%-- 
<div class="container">
<form action="modify.do" method="post">
<input type="text" name="no" value="${modReq.articleNumber }" hidden/>
<p>
번호 <br /> ${modReq.articleNumber }
</p>
<p>
제목 <br /> <input type="text" name = "title" value="${modReq.title }" />
<c:if test="${errors.title }">제목을 입력하시오</c:if>
</p>
<p>
내용 <br /> 
<textarea name="content" id="" cols="30" rows="5">${modReq.content }</textarea>
</p>
<input type="submit" value="글 수정" />
</form>
</div>
--%> 
</body>
</html>