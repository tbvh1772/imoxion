<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<link
   href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
   rel="stylesheet" id="bootstrap-css">
<script
   src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
   src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">글수정</h6>
		</div>

   <div class="mb-3">
  <label for="post_no" class="form-label">글번호</label>
  <input type="text" class="form-control" name="title" value = "${view.no }" placeholder="${view.no }" readonly="readonly">
   </div>
   
   <form method = "post">
   

   
  <div class="mb-3">
  <label for="title" class="form-label">제목</label>
  <input type="text" class="form-control" name="title" value = "${view.title }" placeholder="${view.title }">
   </div>
   
    <div class="mb-3">
  <label for="post_content" class="form-label">내용</label>
  <textarea class="form-control" name="content" rows="5">${view.content }</textarea>
   </div>

   <button type = "submit" id = "ok_Btn" class = "btn btn-success">완료</button>
   <script>
   $("#ok_Btn").click(function(){
      alert("저장되었습니다.")
   });
   </script>
   
   <button type="submit" id="back_Btn" class="btn btn-danger">취소</button>
            <script>
               $("#back_Btn").click(function(){
                  alert("취소되었습니다.")
                  history.back();
               });         
            </script>
   <input type="hidden" name="date"/>
   </form>
   </div>
</body>
</html>
