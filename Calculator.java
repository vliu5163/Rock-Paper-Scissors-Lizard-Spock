/**
 * This class calculates the winner between two throws. 
 * @author vivianliu
 *
 */
public class Calculator {
	
	/**
	 * Calculates the winner based on a 2D array. Solution was presented in class.
	 * Does not matter which throw is inputed first, the loser will be removed from
	 * the screen.
	 * @param throw1 
	 * @param throw2
	 * @return
	 */
	public int calculate(ThrowTypes throw1, ThrowTypes throw2) {
		String throw1String = throw1.getThrowName();
		String throw2String = throw2.getThrowName();
		int index1 = 0;
		int index2 = 0;
		for (int i = 0;i < throwList.length;i++) {
		    if (throw1String.equals(throwList[i])) {
		        index1 = i;
		    }
		    if (throw2String.equals(throwList[i])) {
		        index2 = i;
		    }
		}
		return rules[index1][index2];
	}

	private int[][] rules = {
            {0, -1, 1, -1, 1},
            {1, 0, -1, 1, -1},
            {-1, 1, 0, -1, 1},
            {1, -1, 1, 0, -1},
            {-1, 1, -1, 1, 0}
        };
	private String[] throwList = {"rock", "paper", "scissor", "spock",
			"lizard"};
}
