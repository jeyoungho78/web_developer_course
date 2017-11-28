/**
 * board 관련 javascript
 */

/**
 * chkSearchForm
 * : boardList에서 검색시 유효성 체크 
 */
function chkSearchForm(){
	var objSel = document.getElementById('select_field');
	var objTxt = document.getElementById('search_word');
	var objfrm = document.getElementById('frm_search');
	
	var selIdx = objSel.options.selectedIndex;
	if(objSel.options[selIdx].text == "선택"){
		alert("항목을 선택하세요.");
		return false;
	}
	
	if(objTxt.value == ""){
		alert("검색값을 입력하세요.");
		return false;
	}
	
	objfrm.submit();
	
	return true;
}

/**
 * addFileInp
 * : boardWrite에서 파일업로드 입력창 생성
 */
function addFileInp() {
	var fileArea = document.getElementById("file_area");

	var fileInput = document.createElement("div");
	fileInput.setAttribute("class", "file_wrap");
	fileInput.setAttribute("name", "fileInput");
	fileArea.appendChild(fileInput);

	var fileInputCheckBox = document.createElement("input");
	fileInputCheckBox.setAttribute("type", "checkbox");
	fileInputCheckBox.setAttribute("name", "chkbox");
	fileInput.appendChild(fileInputCheckBox);

	var fileInputBox = document.createElement("input");
	fileInputBox.setAttribute("type", "file");
	fileInputBox.setAttribute("name", "org_nm");
	fileInput.appendChild(fileInputBox);
}

/**
 * deleteInp
 * : boardWrite에서 파일업로드 입력창 삭제
 */
function deleteInp() {
	var fileArea = document.getElementById("file_area");
	var fileInput = document.getElementsByName("fileInput");
	var fileInputCheckBox = document.getElementsByName("chkbox");

	var chkCnt = 0;
	for (var i = 0; i < fileInputCheckBox.length; i++) {
		if (fileInputCheckBox[i].checked) {
			fileArea.removeChild(fileInput[i]);
			i--;

			chkCnt++;
		}
	}

	if (chkCnt == 0) {
		alert("삭제할 데이터가 없습니다.");
	}
}