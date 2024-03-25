package backtracking;

public class NQueens {
	public static void placeNQueens(int[][] board,int n,int row) {
		if(row==n) {
			for(int i=0;i<board.length;i++) {
				for(int j=0;j<board[i].length;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
