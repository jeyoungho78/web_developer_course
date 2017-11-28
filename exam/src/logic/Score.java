package logic;

public class Score {

	int[][] arrScore;
	
	public int[][] getArrScore() {
		return arrScore;
	}

	public void setArrScore(int[][] arrScore) {
		this.arrScore = arrScore;
	}

	public Score(int[][] arrScore) {
		this.arrScore = arrScore;
	}

	//합계
	int calcSum(int[][] arrScore, int subject){
		int sum = 0;
		
		for(int i=0; i<arrScore.length; i++) {
			for(int j=0; j<arrScore[i].length; j++) {
				if(j == subject) {
					sum = sum + arrScore[i][j];
				}
			}
		}
		
		return sum;
	}
	
	//평균
	double calcAvg(int[][] arrScore, int subject){
		int sum = calcSum(arrScore, subject);
		int cnt = arrScore.length;
		double avg = sum / cnt;
		
		return avg;
	}
	
	//최저점수
	int calcMin(int[][] arrScore, int subject){
		int min = arrScore[0][subject];
		
		for(int i=0; i<arrScore.length; i++) {
			for(int j=0; j<arrScore[i].length; j++) {
				if(j == subject) {
					if(arrScore[i][j] < min) {
						min = arrScore[i][j];
					}
				}
			}
		}
		
		return min;
	}
	
	// 2차원 배열의 갯수
	int calcCount(int[][] arrScore) {
		int cnt = 0;
		
		for(int i=0; i<arrScore.length; i++) {
			cnt = cnt + arrScore[i].length;
		}
		
		return cnt;
	}

	
	//결과 출력
	public void printResult() {
		int sum = 0;
		int min = 0;
		double avg = 0.0;
		
		int totalSum = 0;
		int totalCnt = 0;
		double totalAvg = 0.0;
		
		//국어점수 합계, 평균
		sum = calcSum(arrScore, 0);
		avg = calcAvg(arrScore, 0);
		min = calcMin(arrScore, 0);
		totalSum = totalSum + sum;
		
		System.out.println("국어점수 합계 : " + sum + " 평균 : " + avg + " 최소값 : " + min );
	
		//영어점수 합계, 평균
		sum = calcSum(arrScore, 1);
		avg = calcAvg(arrScore, 1);
		min = calcMin(arrScore, 1);
		totalSum = totalSum + sum;
	
		System.out.println("영어점수 합계 : " + sum + " 평균 : " + avg + " 최소값 : " + min );
		
		//수학점수 합계, 평균
		sum = calcSum(arrScore, 2);
		avg = calcAvg(arrScore, 2);
		min = calcMin(arrScore, 2);
		totalSum = totalSum + sum;
	
		System.out.println("수학점수 합계 : " + sum + " 평균 : " + avg + " 최소값 : " + min );
		
		totalCnt = calcCount(arrScore);
		totalAvg = (double)totalSum / totalCnt;
		
		System.out.println("전체 합계 : " + totalSum + " 전체평균 : " + totalAvg);
	}
}
