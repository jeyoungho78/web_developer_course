/**
 * board κ΄??javascript
 */

/**
 * chkSearchForm
 * : boardList?? κ²?? ? ?¨μ?μ²΄ν?
 */
function chkSearchForm(){	
	if($("#select_field option:selected").text() == "? ?"){
		alert("?­λͺ©μ ? ???Έμ.");
		return false;
	}
	
	if($("#search_word").val() == ""){
		alert("κ²?κ°? ??₯ν?Έμ.");
		return false;
	}
	
	$("#frm_search").submit();
	
	return true;
}

/**
 * addFileInp
 * : boardWrite?? ??Όμλ‘? ??₯μ°½ ???
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
 * : boardWrite?? ??Όμλ‘? ??₯μ°½ ?­?
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
		alert("?­??  ?°μ΄ν°κ? ??΅λ??");
	}
}