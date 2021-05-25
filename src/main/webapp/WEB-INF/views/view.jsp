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
          
    <div class="mb-3">
  <label for="post_no" class="form-label">글내용</label>
  <input type="text" class="form-control" name="title" value = "${view.no }" placeholder="${view.no }" readonly="readonly">
   </div>
  
  <div class="mb-3">
  <label for="post_title" class="form-label">제목</label>
  <input type="text" class="form-control" name="title" value = "${view.title }" placeholder="${view.title }" readonly="readonly">
   </div>
   
    <div class="mb-3">    
  <label for="post_contact" class="form-label">내용</label>
  <textarea class="form-control" readonly="readonly" name="content" rows="5">${view.content }</textarea>
   </div>
      
      
      
      <br><br><br>
      <input type = "button" value = "수정" class = "btn btn-success" 
      onclick="location.href='/update?no=${view.no}'"/>
      

      <input type="button" value = "삭제" class="btn btn-danger" 
      onclick="location.href='/del?no=${view.no}'"/>
      
      <script>
      $("#del").click(function(){
       alert("삭제되었습니다.")
      });
      </script>
      
</body>
</html>
