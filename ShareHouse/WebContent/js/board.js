/**
 *  @author Lee Han
 */

function validateBoard(){
	if (document.frm.bodTitle.value == "") {
		alert("제목을 입력해주세요.");
		frm.bodTitle.focus();
		return false;
	}
	if (document.frm.bodContents.value == "") {
		alert("내용을 입력해주세요.");
		frm.bodContents.focus();
		return false;
	}
	alert("등록되었습니다.");
	return true;
}


