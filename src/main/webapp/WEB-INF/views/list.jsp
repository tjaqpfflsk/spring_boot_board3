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
  <h2 class="text-warning">게시판</h2>
  <table class="table table-striped">
      		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<a class="text-warning" href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><button type="button" class="btn btn-outline-warning bg-warning text-white" href="write_view">글작성</button></td>
		</tr>
	</table>

  <ul class="pagination justify-content-center">
  	<c:if test="${pageMaker.prev}">
    <li class="page-item"><a class="page-link btn-outline-warning text-warning" href="list${pageMaker.makeQuery(pageMaker.startPage - 1) }">
    Previous</a></li>
    </c:if>
    
     <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
     <c:out value="${pageMaker.cri.pageNum == idx?'':''}" />
    <li class="page-item"><a class="page-link btn-outline-warning bg-warning text-white"href="list${pageMaker.makeQuery(idx)}">${idx}</a></li>
    </c:forEach>
    
     <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
    <li class="page-item"><a class="page-link btn-outline-warning text-warning" href="list${pageMaker.makeQuery(pageMaker.endPage +1) }">Next</a></li>
    </c:if> 
    
  </ul>
	
</body>
</html>