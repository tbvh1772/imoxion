<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body>

<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">글목록</h6>
		</div>

		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover"
					width="100%" cellspacing="0">

					<thead style="text-align: center">
						<!-- 1.목록이름 -->
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성일</th>
							
							
						</tr>
					</thead>
					
					<c:forEach items="${list }" var="list">
						<tr style="text-align: center; width: 100%;">
							<td style="width: 20%">${list.no }</td>
							<td style="width: 40%"><a
								href="/view?no=${list.no }">${list.title }</a></td>
							<td style="width: 40%">${list.date }</td>
									
							
						</tr>
					</c:forEach>
					
					
</table>
</div>
<button type="button" class="btn btn-info btn-md"
							onclick="location.href='insert'">글쓰기</button>
</div>

</div>

</body>
</html>
