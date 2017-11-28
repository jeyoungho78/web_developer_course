package logic.equals;

import data.equals.Data;

public class ParentLogic {

	Data dt;
	
	public ParentLogic(Data dt) {
		this.dt = dt;
	}
	
	public boolean equals(Object obj) {
		Data dtCmp = ((ParentLogic)obj).dt;
		int[] dtArr = dt.getArr();
		int[] dtCmpArr = dtCmp.getArr();
		int nSameCnt = 0;
		
		for(int i=0; i<dtArr.length; i++) {
			nSameCnt = 0;
			for(int j=0; j<dtCmpArr.length; j++) {
				if(dtArr[i] == dtCmpArr[j]) {
					nSameCnt += 1;
				}
			}

			if(nSameCnt == 0) {
				return false;
			}
		}
		
		return true;
	}// equals

}// class
