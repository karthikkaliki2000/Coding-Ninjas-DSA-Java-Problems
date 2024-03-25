package dynamicprogramming;
public class CountPaths {
	
	public static int countPaths(int row, int col, int[][] board) {// only have to go right and down
		if (row == 1 || col == 1) {
			return 1;
		}
		int down = countPaths(row - 1, col, board);
		int right = countPaths(row, col - 1, board);
		return down + right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPaths(3, 3, new int[3][3]));
	}

}