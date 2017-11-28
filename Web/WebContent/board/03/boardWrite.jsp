<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="./include/headInfo.html" %>
<title>Insert title here</title>
<script type="text/javascript" src="/board/02/js/board.js"></script>
</head>
<body>
 <div class="wrap">
    <form action="/BoardAction" method="POST" enctype="multipart/form-data">
      <input type="hidden" id="cmd" name="cmd" value="write">
      <div class="input_wrapper">
        <div class="title_wrap">
          <label for="title">제목</lable>
        </div>
        <div class="input_wrap">
          <input type="text" id="title" class="input_title" name="boardTitle">
        </div>
      </div>
      <div class="input_wrapper">
        <div class="title_wrap">
            <label for="name">작성자</lable>
        </div>
        <div class="input_wrap">
          <input type="text" id="name" name="boardWriter">
        </div>
      </div>
      <div class="cont_wrapper">
        <div class="title_wrap">
          <label for="content">내용</lable>
        </div>
        <textarea rows="10" cols="100" placeholder="내용입력" title="내용입력" id="content" name="boardContent"></textarea>
      </div>
      <div class="inpute_wrapper">
	    <div class="title_wrap">
	      <label for="file">파일</label>
	    </div>
	    <div class="input_wrap">
	      <button type="button" class="unrole_btn" onclick="addFileInp()">추가</button>
	      <button type="button" class="unrole_btn" onclick="deleteInp()">삭제</button>
	    </div>
	  </div>
	  <div id="file_area">
	  </div>  
      <div class="submit_wrapper">
        <input type="submit" value="확인" class="unrole_btn">
      </div>
    </form>
  </div>
</body>
<!-- <script type="text/javascript">
	/**
	 * addFileInp
	 * : boardWrite에서 파일업로드 입력창 생성
	 */
	var org_nm_num = 0;
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
		org_nm_num += 1; 
		fileInputBox.setAttribute("name", "org_nm" + org_nm_num);
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

</script> -->
</html>