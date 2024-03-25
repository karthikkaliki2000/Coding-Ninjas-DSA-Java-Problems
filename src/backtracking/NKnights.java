package backtracking;


public class NKnights {
	public static void knights(boolean[][] board,int row,int col,int knightsNum) {
		if(knightsNum==0) {
			display(board);
			System.out.println();
			return;
		}
		
		if(row==board.length-1 && col==board.length) {
			return;
		}
		 if(col==board.length) {
			 knights(board,row+1,0,knightsNum);
			 return;
		 }
		 if(isSafe(board,row,col)) {
			 board[row][col]=true;
			 knights(board,row,col+1,knightsNum-1);
			 board[row][col]=false;
		 }
		 knights(board,row,col+1,knightsNum);
		
	}
	public static boolean isValid(boolean[][] board,int row,int col) {
		if(row>=0 && row<board.length && col>=0 && col<board.length) {
			return true;
		}
		return false;
	}
	public static boolean isSafe(boolean[][] board, int row, int col) {
		// TODO Auto-generated method stub
		if(isValid(board,row-2,col-1)) {
			if(board[row-2][col-1]) {
				return false;
			}
		}
		
		if(isValid(board,row-1,col-2)) {
			if(board[row-1][col-2]) {
				return false;
			}
		}
		
		if(isValid(board,row-1,col+2)) {
			if(board[row-1][col+2]) {
				return false;
			}
		}
		
		if(isValid(board,row-2,col+1)) {
			if(board[row-2][col+1]) {
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
					System.out.print("K ");
				}
				else {
					System.out.print("O "); 
				}
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board=new boolean[4][4];
		
		knights(board, 0,0,4);

	}

}
