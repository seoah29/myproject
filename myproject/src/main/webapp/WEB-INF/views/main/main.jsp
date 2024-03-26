<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
	<header>
		<div class="header-left">
			<h1>BLOG</h1>
		</div>
		<div class="header-right">
			<input type="search" placeholder="Search" id="searchInput">
			<button type="button" id="searchBtn">Search</button>
			<button type="button" id="notificationBtn">🔔</button>
			<!-- 로그인 여부에 따라 다르게 표시 -->
			<sec:authorize access="isAuthenticated()">
				<button type="button"
					onclick="location.href='${pageContext.request.contextPath}/member/blog'">My
					Blog</button>
				<button type="button"
					onclick="location.href='${pageContext.request.contextPath}/member/myPage'">My
					Page</button>
				<form action="${pageContext.request.contextPath}/logout"
					method="post">
					<input type="submit" value="Logout" /> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</sec:authorize>

			<sec:authorize access="!isAuthenticated()">
				<button type="button"
					onclick="location.href='${pageContext.request.contextPath}/member/login'">Login</button>
			</sec:authorize>

		</div>
	</header>

	<section class="post-grid">
		<!-- 각 포스트 타일을 나타내는 div. 실제 애플리케이션에서는 서버 사이드에서 반복문으로 생성될 것입니다. -->
		<div class="post-tile">
			<img src="path/to/image.jpg" alt="Post Image">
			<h2>Post Title</h2>
			<p>Post excerpt...</p>
			<!-- 기타 메타데이터 정보 -->
		</div>
		<!-- 반복 -->
	</section>

	<footer>
		<p>&copy; 2024 My Blog. All rights reserved.</p>
	</footer>
</body>
</html>