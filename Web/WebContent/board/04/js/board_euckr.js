/**
 * board 관??javascript
 */

/**
 * chkSearchForm
 * : boardList?�?� 검?�?� ?�?��?체�?
 */
function chkSearchForm(){	
	if($("#select_field option:selected").text() == "?�?�"){
		alert("?�목을 ?�?�?�?�요.");
		return false;
	}
	
	if($("#search_word").val() == ""){
		alert("검?�값?� ?�?�하?�요.");
		return false;
	}
	
	$("#frm_search").submit();
	
	return true;
}

/**
 * addFileInp
 * : boardWrite?�?� ?�?�업로?� ?�?�창 ?�??
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
 * : boardWrite?�?� ?�?�업로?� ?�?�창 ?�?�
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
		alert("?�?�?� ?�이터�? ?�?�니??");
	}
}