/**
 * @author Lee Han
 * 
 */

function validateGalBoard(){
	if (document.frm.galTitle.value == "") {
		alert("제목을 입력해주세요.");
		frm.galTitle.focus();
		return false;
	}
	if (document.frm.galContents.value == "") {
		alert("내용을 입력해주세요.");
		frm.galContents.focus();
		return false;
	}
	alert("등록되었습니다.");
	return true;
}

function validateUpdateBoard(){
	if (document.frm.galTitle.value == "") {
		alert("제목을 입력해주세요.");
		frm.galTitle.focus();
		return false;
	}
	if (document.frm.galContents.value == "") {
		alert("내용을 입력해주세요.");
		frm.galContents.focus();
		return false;
	}
	alert("수정되었습니다.");
	return true;

}