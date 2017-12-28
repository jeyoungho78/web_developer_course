package JavaFirst;

public class EnumTest02 {
/*	public static final MemManage FIRST_MEMBER = new MemManage();
	public static final MemManage SECOND_MEMBER = new MemManage();
	public static final MemManage THIHRD_MEMBER = new MemManage();
	*/
	
	public enum MemManage{
		FIRST_MEMBER(30), SECOND_MEMBER(20), THIHRD_MEMBER(10);
		
		int cnt;
		MemManage(int cnt){
			this.cnt = cnt;
		}
		
		public String getCnt() {
			return cnt + "%";
		}
	}
	
	public static void main(String[] args) {
		MemManage mm = MemManage.FIRST_MEMBER;
		System.out.println(mm);
		System.out.println(mm.getCnt());
		
		for(MemManage x : MemManage.values()) {
			System.out.println(x + ":" + x.getCnt());
		}
	}

}
