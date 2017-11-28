package logic;

public class Paging {
	
	private int contentsCount;   // 게시물 갯수
	private int contentsPerPage; // 페이지당 게시물 갯수
	private int pageCount;       // 페이지당 출력되는 페이지 수
	private int movingPage;      // 이동할 페이지
	
	public int getContentsCount() {
		return contentsCount;
	}	
	public void setContentsCount(int contentsCount) {
		this.contentsCount = contentsCount;
	}
	public int getContentsPerPage() {
		return contentsPerPage;
	}	
	public void setContentsPerPage(int contentsPerPage) {
		this.contentsPerPage = contentsPerPage;
	}
	public int getpageCount() {
		return pageCount;
	}	
	public void setpageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getMovingPage() {
		return movingPage;
	}	
	public void setMovingPage(int movingPage) {
		this.movingPage = movingPage;
	}
	
	public void printPage() {
		int pageMok = 0;
		int pageNamuji = 0;
		
		int viewPageCount = 0;
		int realViewPageCount = 0;
		
		String strViewPageNumber = "";
		
		// 컨텐츠수와 1 페이지당 컨텐츠 수로 나눈 몫과 나머지 구하기
		pageMok = contentsCount / contentsPerPage;
		pageNamuji = contentsCount % contentsPerPage;
		
		System.out.println("pageMok : " + pageMok + " pageNamuji : " + pageNamuji);
		
		if(pageNamuji > 0) {
			viewPageCount = pageMok + 1;
		} else {
			viewPageCount = pageMok;
		}
		
		System.out.println("viewPageCount : " + viewPageCount );
		
		if (viewPageCount < pageCount) {
			realViewPageCount = viewPageCount;
		} else {
			realViewPageCount = pageCount;
		}
		
		System.out.println("realViewPageCount : " + realViewPageCount );
		
		for (int i=1; i <= realViewPageCount; i++) {
			strViewPageNumber = strViewPageNumber + " " + i;
		}
		
		System.out.println(strViewPageNumber);
	}

	public void printMovingPage() {
		int pageMok = 0;
		int pageNamuji = 0;
		
		int viewPageCount = 0;
		
		int realViewPageCountStart = 0;
		int realViewPageCountEnd = 0;
		
		String strViewPageNumber = "";
		
		pageMok = contentsCount / contentsPerPage;
		pageNamuji = contentsCount % contentsPerPage;
		
		System.out.println("pageMok : " + pageMok + " pageNamuji : " + pageNamuji);
		
		if(pageNamuji > 0) {
			viewPageCount = pageMok + 1;
		} else {
			viewPageCount = pageMok;
		}
		
		System.out.println("viewPageCount : " + viewPageCount );
		System.out.println("movingPage : " + movingPage );
		
		if(movingPage > viewPageCount) {
			System.out.println("");
			System.out.println("표시할 페이지 범위를 넘어갔습니다.");
		} else {
			if (viewPageCount < pageCount) {
				realViewPageCountStart = 1;
				realViewPageCountEnd = viewPageCount;
			} else {
				realViewPageCountStart = ( movingPage / pageCount) * pageCount + 1;
				realViewPageCountEnd = realViewPageCountStart + pageCount - 1;
			}
			
			System.out.println("realViewPageCountStart : " + realViewPageCountStart );
			System.out.println("realViewPageCountEnd : " + realViewPageCountEnd );
			
			for (int i=realViewPageCountStart; i <= realViewPageCountEnd; i++) {
				if(i == realViewPageCountEnd) {
					strViewPageNumber = strViewPageNumber + i;
				} else 
					strViewPageNumber = strViewPageNumber + i + " | ";
			}
			
			System.out.println("");
			System.out.println(strViewPageNumber);
		}
	}
	
	public void printContentsMovingPage() {
		int pageMok = 0;
		int pageNamuji = 0;
		int viewPageCount = 0;
		
		// 실제 보여지 페이지 넘버 범위
		int realViewPageNumberStart = 0;
		int realViewPageNumberEnd = 0;
		String strViewPageNumber = "";
		
		// 실제 보여지는 컨텐츠 넘버 범위
		int realViewContentsNumerStart = 0;
		int realViewContentsNumerEnd = 0;
		String strViewContentsNumber = "";
		
		// 들여쓰기 공백
		int spacingEnd = 0;
		String strSpacing = "";
		
		pageMok = contentsCount / contentsPerPage;
		pageNamuji = contentsCount % contentsPerPage;
		
		System.out.println("pageMok : " + pageMok + " pageNamuji : " + pageNamuji);
		
		// 보여질 페이지 갯수
		if(pageNamuji > 0) {
			viewPageCount = pageMok + 1;
		} else {
			viewPageCount = pageMok;
		}
		
		System.out.println("viewPageCount : " + viewPageCount );
		System.out.println("movingPage : " + movingPage );
		
		if(movingPage > viewPageCount) {
			System.out.println("");
			System.out.println("표시할 페이지 범위를 넘어갔습니다.");
		} else {
			// 컨텐츠 넘버링 보여질 부분
			realViewContentsNumerStart = contentsCount - (contentsPerPage * (movingPage-1));
			realViewContentsNumerEnd = contentsCount - (contentsPerPage * movingPage);
			
			if(realViewContentsNumerEnd < 0) {
				realViewContentsNumerEnd = 0;
			}
			
			System.out.println("realViewContentsNumerStart : " + realViewContentsNumerStart );
			System.out.println("realViewContentsNumerEnd : " + realViewContentsNumerEnd );
			
			// 하단 보여질 페이지 수 출력 부분 
			if (viewPageCount < pageCount) {
				realViewPageNumberStart = 1;
				realViewPageNumberEnd = viewPageCount;
			} else {
				realViewPageNumberStart = ((movingPage - 1) / pageCount) * pageCount + 1;
				realViewPageNumberEnd = realViewPageNumberStart + pageCount - 1;
			}
			
			System.out.println("realViewPageNumberStart : " + realViewPageNumberStart );
			System.out.println("realViewPageNumberEnd : " + realViewPageNumberEnd );
			
			for (int i=realViewPageNumberStart; i <= realViewPageNumberEnd; i++) {
				if(i == realViewPageNumberEnd) {
					strViewPageNumber += i;
				} else 
					strViewPageNumber += i + " | ";
			}
			
			spacingEnd = strViewPageNumber.indexOf(Integer.toString(movingPage));
			System.out.println("spacingEnd : " + spacingEnd );
			
			for(int i = 1; i <= spacingEnd; i++) {
				strSpacing = strSpacing + " ";
			}
			
			for(int i = realViewContentsNumerStart; i > realViewContentsNumerEnd; i--) {
				//strViewContentsNumber += strSpacing + i + "\r\n"; // 실제로 공백은 필요없음
				strViewContentsNumber += i + "\r\n";
			}
			
			System.out.println("");
			System.out.println(strViewContentsNumber);
			System.out.println(strViewPageNumber);
		}
	}//PrintContentsMovingPage
}//class
