/**
 * board Í¥Ä??javascript
 */

/**
 * chkSearchForm
 * : boardList?ê?ú Í≤Ä?â?ú ?†?®ÏÑ?Ï≤¥ÌÅ?
 */
function chkSearchForm(){	
	if($("#select_field option:selected").text() == "?†?ù"){
		alert("?≠Î™©ÏùÑ ?†?ù?ò?∏Ïöî.");
		return false;
	}
	
	if($("#search_word").val() == ""){
		alert("Í≤Ä?âÍ∞í?Ñ ?Ö?•Ìïò?∏Ïöî.");
		return false;
	}
	
	$("#frm_search").submit();
	
	return true;
}

/**
 * addFileInp
 * : boardWrite?ê?ú ?å?ºÏóÖÎ°ú?ú ?Ö?•Ï∞Ω ?ù??
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
 * : boardWrite?ê?ú ?å?ºÏóÖÎ°ú?ú ?Ö?•Ï∞Ω ?≠?ú
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
		alert("?≠?ú?† ?∞Ïù¥ÌÑ∞Í? ?Ü?µÎãà??");
	}
}