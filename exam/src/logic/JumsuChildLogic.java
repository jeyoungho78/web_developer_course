package logic;

public class JumsuChildLogic extends JumsuParentLogic{
	
	public JumsuChildLogic(int[] a, int[] b, int[] c) {
		super(a, b, c);
	}

	public void calcTotalAvg() {
		jd.setKorAvg(jd.getKorSum() / korSet.length);
		jd.setEngAvg(jd.getEngSum() / engSet.length);
		jd.setMathAvg(jd.getMathSum() / mathSet.length);
		
		System.out.println("±¹¾î Æò±Õ : " + jd.getKorAvg());
		System.out.println("¿µ¾î Æò±Õ : " + jd.getEngAvg());
		System.out.println("¼öÇÐ Æò±Õ : " + jd.getMathAvg());
	}

}
