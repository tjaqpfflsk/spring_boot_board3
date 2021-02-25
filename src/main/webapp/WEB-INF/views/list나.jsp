<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="container">
  <h2>게시판</h2>           
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>제목</th>
        <th>날짜</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="dto">
      <tr>
        <td>${dto.bId}</td>
        <td>${dto.bName}</td>
        <c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
        <td>${dto.bTitle}</td>
        <td>${dto.bDate}</td>
        <td>${dto.bHit}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
    <ul class="pager">
  <li><a href="#">Previous</a></li>
    <li><a href="#">Previous</a></li>
    <li><a href="#">Next</a></li>
  </ul>
  
</div>

<c:if test="${pageMaker.prev}">
         <a href="list${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
      </c:if>

      <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
         <c:out value="${pageMaker.cri.pageNum == idx?'':''}" />
         <a href="list${pageMaker.makeQuery(idx)}">${idx}</a>
      </c:forEach>
      
      <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
         <a href="list${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a>
      </c:if> <br>
	
	<button type="submit">글쓰기</button>

</body>
</html>