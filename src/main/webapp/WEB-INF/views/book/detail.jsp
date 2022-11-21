<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세보기</title>
<link href = "${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel ="styleSheet"/>

</head>
<body>
<div class ="jumbotron">
		<div class ="container">
			 <h2 class ="display-4">책 상세보기</h2>
		</div>
	</div>
	<div class ="container">
		<div class ="row">
				<div class ="col-md-12  mb-2">
					<div class ="row">
						<div class ="col-md-2">
							<label for ="title" class ="col-form-label">제목</label>
						</div>
						<div class ="col-md-10">${book.TITLE }</div>
					</div>
				</div>
				<div class ="col-md-12  mb-2">
					<div class ="row">
						<div class ="col-md-2">
							<label for ="title" class ="col-form-label">카테고리</label>
						</div>
						<div class ="col-md-10">${book.CATEGORY }</div>
					</div>
				</div>
				<div class ="col-md-12  mb-2">
					<div class ="row">
						<div class ="col-md-2">
							<label for ="title" class ="col-form-label">가격</label>
						</div>
						<div class ="col-md-10">
							<div class ="col-md-10">${book.PRICE }</div>
						</div>
					</div>
				</div>
				<div class ="col-md-12  mb-2">
					<div class ="row">
						<div class ="col-md-2">
							<label for ="title" class ="col-form-label">입력일</label>
						</div>
						<div class ="col-md-10">
							<div class ="col-md-10">${book.INSERT_DATE }</div>
						</div>
					</div>
				</div>
				<a href ="/book/update.do?bookId=${bookId }" class ="btn btn-info">수정</a>
				<a href ="/book/list.do" class ="btn btn-primary">목록</a>
			</div>
	</div>
</body>
</html>