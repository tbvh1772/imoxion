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
<title>insert here</title>

   <!-- 게시글 제목없으면 작성안되게 유효성검사 -->
<script language="javascript">
	function validate() {
		
		var title = document.getElementById("title");
		
		
		if (title.value == "") { //제목를 기입하지 않은 경우
			alert("제목을 입력해 주세요");
			title.focus();
			title.value = "";
			return false;
		}
	}
	function check(re, what, message) {
		if (re.test(what.value)) {
			return true;
		}
		alert(message);
		what.value = "";
		what.focus();
		//return false;
	}
</script>

</head>

<body>
<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">글입력</h6>
		</div>
   
    <form action='<c:url value='insert'/>' method="post" onsubmit = "return validate();">
    	

    	
        <div class="form-group">
              <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="제목을 작성해주세요.">
        </div>
    
          <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="content" name="content" rows="10"></textarea>
          </div>
          
        <br>&nbsp;<button type="submit" class="btn btn-info">등록하기</button>
    </form>
</div>
</body>
</html>