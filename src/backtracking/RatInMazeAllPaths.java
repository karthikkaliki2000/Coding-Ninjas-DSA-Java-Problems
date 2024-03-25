package backtracking;
/*
Note:
To get all the test cases accepted, make recursive calls in following order: Top, Down, Left, Right.
This means that if the current cell is (x, y), then order of calls should be: top cell (x-1, y), 
down cell (x+1, y), left cell (x, y-1) and right cell (x, y+1).
*/  

public class RatInMazeAllPaths {


static void ratInAMaze(int maze[][], int n) {
	int[][] path=new int[n][n];
	printAllPaths(maze,0,0,path,n);
}
private static void printAllPaths(int[][] maze, int i, int j, int[][] path,int n) {
	
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
		//	System.out.println();
		}
		path[i][j]=0;
		System.out.println();
		return;
	}
	
	//check top
	printAllPaths(maze,i-1,j,path,n);
	//check right
	printAllPaths(maze,i,j+1,path,n);
	//check down
	printAllPaths(maze,i+1,j,path,n);
	
	//check left
	printAllPaths(maze,i,j-1,path,n);
	path[i][j]=0;
	return;
}


}
