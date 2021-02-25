<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2 class="text-warning">${content_view.bTitle}</h2>
  <form action="${pageContext.request.contextPath}/board/modify" method="post"> 
  <table class="table table-striped">
  		<input type="hidden" name="bId" value="${content_view.bId}"/> 
  		<tr>
			<td>번호</td>
			<td>${content_view.bId}</td>
		</tr>
		<tr>
			<td>히트</td>
			<td>${content_view.bHit}</td>
		</tr>
      	<tr>
			<td>이름</td>
			<td><input type="text" name="bName" value="${content_view.bName}"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="bTitle" value="${content_view.bTitle}"/></td>
		</tr>
		<tr>
		<td>내용</td>
			<td><textarea rows= "10" cols="100" name="bContent"/>${content_view.bContent}</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" class="btn btn-outline-warning bg-warning text-white" 
			value="수정">
			<button type="button" class="btn btn-outline-warning bg-warning text-white"
			onclick="location.href='${pageContext.request.contextPath}/board/list'">목록보기</button>
			<button type="button" class="btn btn-outline-warning bg-warning text-white"
			onclick="location.href='${pageContext.request.contextPath}/board/delete?bId=${content_view.bId}'">삭제</button>
			<button type="button" class="btn btn-outline-warning bg-warning text-white"
			onclick="location.href='${pageContext.request.contextPath}/board/reply_view?bId=${content_view.bId}'">답변</button>
			</td>
			
		</tr>
	</table>
	</form>
	
</body>
</html>