package exec;

import logic.Score;

public class ScoreExec {
	public static void main(String[] args) {
		int[][] arrScore = new int[][]{{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};
		
		Score sc = new Score(arrScore);
		
		sc.printResult();
		
	}
}
