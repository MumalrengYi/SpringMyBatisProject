<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;                
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }
                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
</head>
<body>
<form:form action="memJoin" method="post" name="frm" modelAttribute="MemberCommand"> 
	<input type="hidden" name="dongAddress" id="sample4_extraAddress" placeholder="참고항목">
	<table border = 1 align="center">
		<tr><td>아이디</td>
	<td>
		<form:input path="memberId"/>
		<form:errors path="memberId"/>
	</td>	
</tr>
<tr><td>비밀번호</td>
	<td><form:password path="memberPw"/>
		<form:errors path="memberPw"/>
	</td>
</tr>
<tr>
	<td>비밀번호확인</td>
	<td><form:password path="memberPwCon"/>
		<form:errors path="memberPwCon"/></td>
</tr>
<tr>
	<td>이름</td>
	<td><form:input path="memberName"/>
		<form:errors path="memberName"/></td>
</tr>
<tr>
	<td>우편번호</td>
	<td><form:input path="postNumber" id="sample4_postcode" readonly="true"/>
		<form:errors path="postNumber"/></td>
</tr>
<tr>
	<td>주소</td>
	<td>
		<form:input path="memberAddress" id="sample4_roadAddress" size="30" readonly="true"/>
		<a href="javascript:sample4_execDaumPostcode();">주소 검색</a>
		<form:errors path="memberAddress"/>
	</td>
</tr>
<tr>
	<td>상세주소</td>
	<td><form:input path="detailAdd"/>
		<form:errors path="detailAdd"/></td>
</tr>
<tr>
	<td>연락처</td>
	<td><form:input path="memberPhone"/>
		<form:errors path="memberPhone"/></td>
</tr>
<tr>
	<td>이메일</td>
	<td><form:input path="memberEmail"/>
		<form:errors path="memberEmail"/></td>
</tr>
<tr>
	<td>생년월일</td>
	<td><input type="date" name="memberBirth">
		<form:errors path="memberBirth"/></td>
</tr>
<tr>
	<td>성별</td>
	<td>
		<form:radiobutton path="memberGender" value="M"/>남자
		<form:radiobutton path="memberGender" value="M"/>여자
		<form:errors path="memberGender"/>
	</td>
</tr>
<tr>
	<td>계좌번호</td>
	<td><form:input path="memberAccount"/>
		<form:errors path="memberAccount"/></td>
</tr>
<tr>
	<td>이메일수신여부</td>
	<td>
	
		<form:radiobutton path="memberEmailCk" value="Y"/>예
		<form:radiobutton path="memberEmailCk" value="N"/>아니오
		<form:errors path="memberEmailCk"/>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="submit" value="가입"/>
	<input type="reset" value="가입취소"/>
	<input type="button" value="홈으로" onclick="javascript:location.href='main'"/>
	</td>
</tr>
</table>
</form:form>
</body>
</html>