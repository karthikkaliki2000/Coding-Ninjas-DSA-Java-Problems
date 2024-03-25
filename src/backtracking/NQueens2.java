package backtracking;


public class NQueens2 {
	public static void placeNQueens(int[][] board,int n,int row) {
		if(n==row) {
			for(int i=0;i<board.length;i++) {
				for(int j=0;j<board[i].length;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for(int j=0;j<n;j++) {
			if(isBoardSafe(board,row,j,n)) {
				board[row][j]=1;
				placeNQueens(board,n,row+1);
				board[row][j]=0;
				
			}
		}
	}

	public static boolean isBoardSafe(int[][] board, int row, int col, int n) {
		// TODO Auto-generated method stub
//		//horizontal check is no need because we placed one queen at one row according to logic
//		for(int i=0;i<col;i++) {
//			if(board[row][i]==1) {
//				return false;
//			}
//		}
		
		//vertical Check
		for(int i=0;i<row;i++) {
			if(board[i][col]==1) {
				return false;
			}
		}
		
		//diagonal check1 first half only
		
		for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		//diagonal check2 first half only
		for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		placeQueens(5);

	}

	private static void placeQueens(int i) {
		// TODO Auto-generated method stub
		int[][] board=new int[i][i];
		placeNQueens(board, i, 0);
	}

}