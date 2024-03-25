<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/member/blog/post" enctype="multipart/form-data">
title : <input type="text">
content : <input type="text">
image : <input type="file" multiple accept="image/*">
<input type="submit" value="등록">
<input type="reset" value="초기화">
</form>
</body>
</html>