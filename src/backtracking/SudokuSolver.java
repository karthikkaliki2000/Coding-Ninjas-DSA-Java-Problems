package backtracking;


public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int[][] board = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
				  {5, 2, 0, 0, 0, 0, 0, 0, 0},
				  {0, 8, 7, 0, 0, 0, 0, 3, 1},
				  {0, 0, 3, 0, 1, 0, 0, 8, 0},
				  {9, 0, 0, 8, 6, 3, 0, 0, 5},
				  {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
				  {1, 3, 0, 0, 0, 0, 2, 5, 0},
				  {0, 0, 0, 0, 0, 0, 0, 7, 4},
				  {0, 0, 5, 2, 0, 6, 3, 0, 0} };
		  
		if(solve(board)) {
			display(board);
		}
	}
	
	public static boolean solve(int[][] board) {
		int n=board.length;
		int row=-1;
		int col=-1;
		boolean emptyLeft=true;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]==0) {
					row=i;col=j;
					emptyLeft=false;
					break;
				}
			}
			if(emptyLeft==false) {
				break;
			}
		}
		//if no empty found then we completed sudoku
		if(emptyLeft==true) {
			return true;
		}
		
		//backtrack
		for(int i=1;i<=9;i++) {
			if(isSafe(board, row, col, i)) {
				board[row][col]=i;
				if(solve(board)) {
					//display(board);
					//System.out.println();
					return true;
				}
				else {
					//backtrack
					board[row][col]=0;
				}
			}
		}
		return false;
	}
	private static void display(int[][] board) {
		// TODO Auto-generated method stub
		for(int row[]:board) {
			for(int ele:row) {
			System.out.print(ele+" ");
			}
			System.out.println();
			
		}
		
	}
	public static boolean isSafe(int[][] board,int row,int col,int num) {
		//for row
		for(int i=0;i<board.length;i++) {
			if(board[row][i]==num) {
				return false;
			}
		}
		
		//for col
		for(int rows[]: board) {
			if(rows[col]==num) {
				return false;
			}
		}
		//for 3x3 matrix
		int sqrt=(int)Math.sqrt(board.length);
		int rowStart=row-row%sqrt;
		int colStart=col-col%sqrt;
		for(int i=rowStart;i<sqrt+rowStart;i++) {
			for(int j=colStart;j<sqrt+colStart;j++) {
				if(board[i][j]==num) {
					return false;
				}
			}
		}
		return true;
		
		
	}

}
