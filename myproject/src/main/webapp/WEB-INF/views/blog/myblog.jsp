<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Blog</title>
<link rel="stylesheet" href="css/myblog.css">
</head>
<body>
	<header>
		<h1>Welcome to My Blog</h1>
		<nav>
			<ul>
				<li><a href="${pageContext.request.contextPath}/member/blog">myblog</a></li>
				<li><a
					href="${pageContext.request.contextPath}/member/blog/post">post</a></li>
				<li><a
					href="${pageContext.request.contextPath}/member/chat">chat</a></li>
			</ul>
		</nav>
	</header>

	<main>
		<section>
			<h2>Recent Posts</h2>
		</section>
	</main>

	<footer>
		<p>&copy; 2024 My Blog. All rights reserved.</p>
	</footer>
</body>
</html>