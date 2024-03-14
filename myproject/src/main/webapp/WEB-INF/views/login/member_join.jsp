<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<h2>회원가입</h2>

<form action="${pageContext.request.contextPath}/member/join" method="post">
    <div>
        <label for="memberId">아이디:</label>
        <input type="text" id="memberId" name="memberId" required>
    </div>
    <div>
        <label for="memberPasswd">비밀번호:</label>
        <input type="password" id="memberPasswd" name="memberPasswd" required>
    </div>
    <div>
        <label for="memberNickname">닉네임:</label>
        <input type="text" id="memberNickname" name="memberNickname" required>
    </div>
    <div>
        <label for="memberEmail">이메일:</label>
        <input type="email" id="memberEmail" name="memberEmail" required>
    </div>
    <div>
        <label for="memberHp">휴대폰 번호:</label>
        <input type="text" id="memberHp1" name="memberHp1" placeholder="앞자리" required> -
        <input type="text" id="memberHp2" name="memberHp2" placeholder="가운데자리" required> -
        <input type="text" id="memberHp3" name="memberHp3" placeholder="끝자리" required>
    </div>
    <div>
        <label for="memberAddress">주소:</label>
        <input type="text" id="sample6_address" name="sample6_address" placeholder="기본주소" required>
        <input type="text" id="sample6_detailAddress" name="sample6_detailAddress" placeholder="상세주소" required>
        <input type="text" id="sample6_extraAddress" name="sample6_extraAddress" placeholder="참고항목">
    </div>
    <div>
        <button type="submit">회원가입</button>
    </div>
</form>

</body>
</html>