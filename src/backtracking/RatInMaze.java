package backtracking;


public class RatInMaze {


	public static boolean ratInAMaze(int[][] maze) {
		// TODO Auto-generated method stub
		int[][]path=new int[maze.length][maze.length];
		return solveMaze(maze,0,0,path);
	}

	private static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
		int n=maze.length;
		// TODO Auto-generated method stub
		//check valid i,j and the cell 
		if(i<0 || j<0 || i>=n || j>=n || maze[i][j]==0 || path[i][j]==1) {
			return false;
		}
		path[i][j]=1;
		//if we reached destination
		if(i==n-1 && j==n-1) {
			
			return true;
		}
		
		//check top
		if(solveMaze(maze,i-1,j,path)) {
			//System.out.print("Top ");
			return true;
		}
		//check right
		if(solveMaze(maze,i,j+1,path)) {
		//	System.out.print("Right ");
			return true;
		}
		//check down
		if(solveMaze(maze,i+1,j,path)) {
		//	System.out.print("Down ");
			return true;
		}
		//check left
		if(solveMaze(maze,i,j-1,path)) {
			//System.out.print("Left ");
			return true;
		}
		return false;
	}
}

