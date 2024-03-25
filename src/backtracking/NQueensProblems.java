package backtracking;



public class NQueensProblems {
	public static int queens(boolean[][] board,int row) {
		if(row==board.length) {
			display(board);
			System.out.println();
			return 1;
		}
		int count=0;
		//check every column in a particular row
		for(int col=0;col<board.length;col++) {
			if(isSafe(board,row,col)) {
				board[row][col]=true;
				count+=queens(board,row+1);
				board[row][col]=false;
			}
		}
		return count;
	}

	private static boolean isSafe(boolean[][] board, int row, int col) {
		// TODO Auto-generated method stub
		//vertical
		for(int i=0;i<row;i++) {
			if(board[i][col]) {
				return false;
			}
		}
		//daigonal left
//		int maxLeft=Math.min(row, col);
//		for(int i=1;i<=maxLeft;i++) {
//			if(board[row-i][col-i]) {
//				return false;
//			}
//		}
		for(int i=row,j=col;i>=0 && j>=0;i--,j--) {
			if(board[i][j]) {
				return false;
			}
		}
		//daigonal right
//				int maxRight=Math.min(row, board.length-col-1);
//				for(int i=1;i<=maxRight;i++) {
//					if(board[row-i][col+i]) {
//						return false;
//					}
//				}
		for(int i=row,j=col;i>=0 && j<=board.length-1;i--,j++) {
			if(board[i][j]) {
				return false;
			}
		}
		return true;
	}

	private static void display(boolean[][] board) {
		// TODO Auto-generated method stub
		for(boolean row[]:board) {
			for(boolean ele:row) {
				if(ele) {
					System.out.print("Q ");
				}
				else {
					System.out.print("X "); 
				}
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		boolean[][] board = {   { true, true, true }, 
//				{ true, true, true }, 
//				{ true, true, true } };
		boolean[][] board=new boolean[4][4];
		
		System.out.println(queens(board, 0));
		

	}

}
