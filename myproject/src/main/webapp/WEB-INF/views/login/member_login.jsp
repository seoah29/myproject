<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

	<h2>Login</h2>

	<!-- 로그인 실패 메시지 -->
	<c:if test="${param.error != null}">
		<div>Invalid username and password.</div>
	</c:if>

	<!-- 로그아웃 메시지 -->
	<c:if test="${param.logout != null}">
		<div>You have been logged out.</div>
	</c:if>

	<!-- 로그인 폼 -->
	<form action="/login" method="post">
		<div>
			<label for="username">Username:</label> <input type="text"
				id="username" name="username" required>
		</div>
		<div>
			<label for="password">Password:</label> <input type="password"
				id="password" name="password" required>
		</div>
		<div>
			<button type="submit">Log in</button>
		</div>
		<!-- Spring Security가 요구하는 CSRF 토큰 필드 -->
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

</body>
</html>