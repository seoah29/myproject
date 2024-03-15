<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(document).ready(function() {
	var idChecked = false;

    $("#checkIdDuplicate").click(function() {
        var memberId = $("#memberId").val();
        if (!memberId) {
            $("#idCheckResult").html("아이디를 입력해 주세요.").css("color", "red");
            idChecked = false;
            return;
        }

        // 실제 AJAX 요청에 맞는 URL로 변경
        var contextPath = "${pageContext.request.contextPath}";
        $.ajax({
            url: contextPath + '/member/id-verification/' + memberId,
            type: 'POST',
            // contentType: "application/json; charset=utf-8", // JSON 문자열을 보낼 때 사용
            // data: JSON.stringify({ memberId: memberId }), // JSON 문자열로 서버에 데이터 전송
            success: function(response) {
                if (response === "Y") {
                    $("#idCheckResult").html("이미 사용중인 아이디입니다.").css("color", "red");
                    idChecked = false;
                } else {
                    $("#idCheckResult").html("사용 가능한 아이디입니다.").css("color", "green");
                    idChecked = true;
                }
            },
            error: function(xhr, status, error) {
                $("#idCheckResult").html("아이디 중복 체크 중 오류가 발생했습니다. 서버 상태를 확인해주세요.").css("color", "red");
                idChecked = false;
            }
        });
    });

    $("#memberPasswd, #memberPasswdConfirm").keyup(function() {
        checkPasswordMatch();
        validatePassword();
    });

    function validatePassword() {
        var password = $("#memberPasswd").val();
        var regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
        
        if (!regex.test(password)) {
            $("#passwordValidationResult").html("비밀번호는 8자리 이상 영문 대소문자, 숫자, 특수문자가 각각 1개 이상이어야 합니다.").css("color", "red");
        } else {
            $("#passwordValidationResult").html("유효한 비밀번호입니다.").css("color", "green");
        }
    }

    function checkPasswordMatch() {
        var password = $("#memberPasswd").val();
        var confirmPassword = $("#memberPasswdConfirm").val();
        
        if (password != confirmPassword) {
            $("#passwordMatchAlert").html("비밀번호가 일치하지 않습니다.").css("color", "red");
        } else {
            $("#passwordMatchAlert").html("").css("color", "green");
        }
    }

    // 폼 제출 전 최종 검증
    $("#memberForm").submit(function(event) {
        if (!idChecked) {
            alert("아이디 중복 체크를 해주세요.");
            event.preventDefault();
            return;
        }
        if ($("#passwordValidationResult").text() !== "유효한 비밀번호입니다." || $("#passwordMatchAlert").text() === "비밀번호가 일치하지 않습니다.") {
            alert("비밀번호 조건을 만족시키지 못했습니다.");
            event.preventDefault();
        }
    });
});
</script>
</head>
<body>

	<h2>회원가입</h2>

	<form id="memberForm"
		action="${pageContext.request.contextPath}/member/join" method="post">
		<div>
			<label for="memberId">아이디:</label> <input type="text" id="memberId"
				name="memberId" required>
			<button type="button" id="checkIdDuplicate">중복 체크</button>
			<div id="idCheckResult"></div>
		</div>
		<div>
			<label for="memberPasswd">비밀번호:</label> <input type="password"
				id="memberPasswd" name="memberPasswd" required>
			<div id="passwordValidationResult"></div>
		</div>
		<div>
			<label for="memberPasswdConfirm">비밀번호 확인:</label> <input
				type="password" id="memberPasswdConfirm" required>
			<div id="passwordMatchAlert"></div>
		</div>
		<div>
			<label for="memberNickname">닉네임:</label> <input type="text"
				id="memberNickname" name="memberNickname" required>
		</div>
		<div>
			<label for="memberEmail">이메일:</label> <input type="email"
				id="memberEmail" name="memberEmail" required>
		</div>
		<div>
			<label for="memberHp">휴대폰 번호:</label> <input type="text"
				id="memberHp1" name="memberHp1" placeholder="앞자리" required>
			- <input type="text" id="memberHp2" name="memberHp2"
				placeholder="가운데자리" required> - <input type="text"
				id="memberHp3" name="memberHp3" placeholder="끝자리" required>
		</div>
		<div>
			<label for="memberAddress">주소:</label> <input type="text"
				id="sample6_address" name="sample6_address" placeholder="기본주소"
				required> <input type="text" id="sample6_detailAddress"
				name="sample6_detailAddress" placeholder="상세주소" required> <input
				type="text" id="sample6_extraAddress" name="sample6_extraAddress"
				placeholder="참고항목">
		</div>
		<div>
			<button type="submit">회원가입</button>
		</div>
	</form>

</body>
</html>
