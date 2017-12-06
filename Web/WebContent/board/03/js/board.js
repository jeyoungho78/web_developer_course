/**
 * board 관련 javascript
 */

/**
 * chkSearchForm
 * : boardList에서 검색시 유효성 체크 
 */
function chkSearchForm(){	
	if($("#select_field option:selected").text() == "선택"){
		alert("항목을 선택하세요.");
		return false;
	}
	
	if($("#search_word").val() == ""){
		alert("검색값을 입력하세요.");
		return false;
	}
	
	$("#frm_search").submit();
	
	return true;
}

/**
 * addFileInp
 * : boardWrite에서 파일업로드 입력창 생성
 */
var org_nm_num = 0;
function addFileInp() {
    var fileArea = $("#file_area");

	var fileInput = $("<div></div>");
	fileInput.attr("class", "file_wrap");
	fileInput.attr("name", "fileInput");
	fileArea.append(fileInput);

	var fileInputCheckBox = $("<input></input>");
	fileInputCheckBox.attr("type", "checkbox");
	fileInputCheckBox.attr("name", "chkbox");
	fileInput.append(fileInputCheckBox);

	var fileInputBox = $("<input></input>");
	fileInputBox.attr("type", "file");
	org_nm_num += 1;
	fileInputBox.attr("name", "org_nm" + org_nm_num);
	fileInput.append(fileInputBox);
}

/**
 * deleteInp
 * : boardWrite에서 파일업로드 입력창 삭제
 */
function deleteInp() {
	var fileArea = $("#file_area");
	var fileInput = $("[name='fileInput']");
	var fileInputCheckBox = $("[name='chkbox']");

	var chkCnt = 0;
	for (var i = 0; i < fileInputCheckBox.length; i++) {
		if (fileInputCheckBox[i].checked) {
			fileInput.eq(i).remove();
			chkCnt++;
		}
	}

	if (chkCnt == 0) {
		alert("삭제할 데이터가 없습니다.");
	}
}