package JavaFirst;

public class ScoreRanData implements Comparable<ScoreRanData> {
	String name;
	int kor;
	int math;
	int eng;
	int physicalEducation;
	double avg;
	
	public void avg2() {
		this.avg = (double)(kor + math + eng + physicalEducation) / 4;
	}
	
	@Override
	public int compareTo(ScoreRanData o) {
		if (this.avg > o.avg) {
			return -1;
		} else if (this.avg == o.avg) {
			return 0;
		} else {
			return 1;
		}
	}
}
