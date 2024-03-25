package backtracking;


public class PrintPaths {
	public static void printPaths(int row, int col, String up, int reachp1, int reachp2) {
		if (row == 1 && col == 1) {
			System.out.println(up + "Destination");

			return;
		}
		// down
		if (row > 0) {
			printPaths(row - 1, col, up + "Down->", reachp1, reachp2);

		}
		// right
		if (col > 0) {
			printPaths(row, col - 1, up + "Right->", reachp1, reachp2);
		}
	}

	public static void printPathsDiagonal(int row, int col, String up, int reachp1, int reachp2) {
		if (row == 1 && col == 1) {
			System.out.println(up + "Destination");

			return;
		}
		// down
		if (row > 0) {
			printPathsDiagonal(row - 1, col, up + "Down->", reachp1, reachp2);

		}
		// right
		if (col > 0) {
			printPathsDiagonal(row, col - 1, up + "Right->", reachp1, reachp2);
		}
		// diagonal
		if (row > 0 && col > 0) {
			printPathsDiagonal(row - 1, col - 1, up + "Diagonal->", reachp1, reachp2);
		}
	}

	public static void printPathsDiagonalWithObstacles(int row, int col, String up, boolean[][] board, int i, int j) {
		if (i == row - 1 && j == col - 1) {
			System.out.println(up + "Destination");
			return;
		}
		if (i < row && j < col && board[i][j] == false) {
			return;
		}
		// down
		if (i < row) {
			printPathsDiagonalWithObstacles(row, col, up + "Down->", board, i + 1, j);

		}
		// right
		if (j < col) {
			printPathsDiagonalWithObstacles(row, col, up + "Right->", board, i, j + 1);
		}
		// diagonal
		if (i < row && j < col) {
			printPathsDiagonalWithObstacles(row, col, up + "Diagonal->", board, i + 1, j + 1);
		}
	}

	public static void printPathsAllDirections(int row, int col, String up, boolean[][] board, int i, int j) {
		if (i == board.length - 1 && j == board[0].length - 1) {
			System.out.println(up + "Destination");
			return;
		}
		if (!board[i][j]) {
			return;
		}
		
		//considering this is in my path
		board[i][j]=false;
		// down
		if (i < board.length-1) {
			printPathsAllDirections(row, col, up + "Down->", board, i + 1, j);

		}
		// right
		if (j < board[0].length-1) {
			printPathsAllDirections(row, col, up + "Right->", board, i, j + 1);
		}

		// up
		if (i > 0) {
			printPathsAllDirections(row, col, up + "Up->", board, i - 1, j);
		}

		// left
		if (j > 0) {
			printPathsAllDirections(row, col, up + "Left->", board, i , j-1);
		}
		
//	   //diagonal
//		if(i<row-1 && j<col-1) {
//			printPathsAllDirections(row,col,up+"Diagonal->",board,i+1,j+1);
//		}
		board[i][j]=true;
		
	}

	
	public static void printPathMatrix(int row, int col, String up, boolean[][] board, int i, int j,int[][] pathMatrix,int c) {
		if (i == board.length - 1 && j == board[0].length - 1) {
			//System.out.println(up + "Destination");
			pathMatrix[i][j]=c+1;
			for(int x=0;x<pathMatrix.length;x++) {
				for(int y=0;y<pathMatrix[0].length;y++) {
					System.out.print(pathMatrix[x][y]+" ");
				}
				System.out.println();
			}
			System.out.println();
			pathMatrix[i][j]=0;
			return;
		}
		if (!board[i][j]) {
			return;
		}
		
		//considering this is in my path
		board[i][j]=false;
		c++;
		pathMatrix[i][j]=c;
		
		// down
		if (i < board.length-1) {
			printPathMatrix(row, col, up + "Down->", board, i + 1, j,pathMatrix,c);

		}
		// right
		if (j < board[0].length-1) {
			printPathMatrix(row, col, up + "Right->", board, i, j + 1,pathMatrix,c);
		}

		// up
		if (i > 0) {
			printPathMatrix(row, col, up + "Up->", board, i - 1, j,pathMatrix,c);
		}

		// left
		if (j > 0) {
			printPathMatrix(row, col, up + "Left->", board, i , j-1,pathMatrix,c);
		}
		
//	   //diagonal
//		if(i<row-1 && j<col-1) {
//			printPathMatrix(row,col,up+"Diagonal->",board,i+1,j+1);
//		}
		board[i][j]=true;
		pathMatrix[i][j]=0;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printPaths(3,3, "",1,1);
		// printPathsDiagonal(3,3, "",1,1);
		boolean[][] board = {   { true, true, true }, 
								{ true, true, true }, 
								{ true, true, true } };
		// boolean[][] board=
		// {{true,true,true,true},{true,true,true,true},{true,true,true,true},{true,true,true,true}};
	//	printPathsDiagonalWithObstacles(board.length, board[0].length, "", board, 0, 0);
		//printPathsAllDirections(board.length, board[0].length, "", board, 0, 0);
		int[][] pathMatrix=new int[board.length][board[0].length];
		int c=0;
		printPathMatrix(board.length, board[0].length, "", board, 0, 0,pathMatrix,c);
		
	}

}
