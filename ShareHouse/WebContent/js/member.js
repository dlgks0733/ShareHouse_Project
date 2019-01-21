/**
 * member 자바스크립트
 */

// 회원 유효성 검사
function memValidate() {

	if (document.frm.memId.value.length == 0) {
		alert("학번을 입력해주세요.");
		frm.memId.focus();
		return false;
	}
	if (document.frm.memId.value.length > 8) {
		alert("학번 8자리를 입력해주세요.");
		frm.memId.focus();
		return false;
	}
	if (document.frm.memName.value == "") {
		alert("이름을 입력해주세요.");
		frm.memName.focus();
		return false;
	}
	if (document.frm.memPwd.value.length == 0) {

		alert("비밀번호를 입력해주세요.");
		frm.memPwd.focus();
		return false;
	} else {
		return true;
	}
}

// 숫자만 입력하기
function onlyNumber(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
			|| keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
		return;
	else
		return false;
}

// 숫자가 아니면 글자 지우기
function removeChar(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if (keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
		return;
	else
		event.target.value = event.target.value.replace(/[^0-9]/g, "");
}

function popupOpen(memId){
	var memId = document.frm.memId.value;
	var popUrl = "member?command=popupFormAction&memId="+memId;	//팝업창에 출력될 페이지 URL

	var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)

		window.open(popUrl,"",popOption);

	}



