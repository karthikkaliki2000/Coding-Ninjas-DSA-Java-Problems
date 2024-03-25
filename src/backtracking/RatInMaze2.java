package backtracking;


public class RatInMaze2 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] maze= {{1,1,0},{1,1,0},{1,1,1}};
		int[][] maze= {{1,1},{1,1}};
		//boolean pathPossible=ratInMaze(maze);
		//System.out.println(pathPossible);
		int[][]path=new int[maze.length][maze.length];
		printAllPaths(maze, 0, 0, path);

	}

	private static boolean ratInMaze(int[][] maze) {
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
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					System.out.print(path[r][c]+" ");
				}
				System.out.println();
			}
			
			return true;
		}
		
		//check top
		if(solveMaze(maze,i-1,j,path)) {
			//System.out.print("Top ");
			return true;
		}
		//check right
		if(solveMaze(maze,i,j+1,path)) {
			//System.out.print("Right ");
			return true;
		}
		//check down
		if(solveMaze(maze,i+1,j,path)) {
			//System.out.print("Down ");
			return true;
		}
		//check left
		if(solveMaze(maze,i,j-1,path)) {
			//System.out.print("Left ");
			return true;
		}
		return false;
	}

	
	private static void printAllPaths(int[][] maze, int i, int j, int[][] path) {
		int n=maze.length;
		// TODO Auto-generated method stub
		//check valid i,j and the cell 
		if(i<0 || j<0 || i>=n || j>=n || maze[i][j]==0 || path[i][j]==1) {
			return;
		}
		path[i][j]=1;
		//if we reached destination
		if(i==n-1 && j==n-1) {
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					System.out.print(path[r][c]+" ");
				}
				System.out.println();
			}
			path[i][j]=0;
			System.out.println();
			return;
		}
		
		//check top
		printAllPaths(maze,i-1,j,path);
		//check right
		printAllPaths(maze,i,j+1,path);
		//check down
		printAllPaths(maze,i+1,j,path);
		
		//check left
		printAllPaths(maze,i,j-1,path);
		path[i][j]=0;
		return;
	}

}
