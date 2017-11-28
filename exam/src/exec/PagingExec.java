package exec;

import logic.Paging;

public class PagingExec {

	public static void main(String[] args) {
		Paging pg = new Paging();
		
		pg.setContentsCount(84);
		pg.setContentsPerPage(10);
		pg.setpageCount(10);
		pg.setMovingPage(1);
		
		//pg.printPage();
		//pg.printMovingPage();
		pg.printContentsMovingPage();
	}

}
