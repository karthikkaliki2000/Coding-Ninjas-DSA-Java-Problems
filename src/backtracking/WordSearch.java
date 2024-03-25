package backtracking;

public class WordSearch {
    public static boolean present(char [][]board, String word, int n, int m) {
       // Write your code here.
   	char[][] visited=new char[n][m];
   	for(int i=0;i<n;i++) {
   		for(int j=0;j<m;j++) {
   			if(board[i][j]==word.charAt(0)) {
   				if( search(board,word,n,m,visited,1,i,j)) {
   					return true;
   				}
   			}
   		}
   	}
   	return false;
   }
	static int[] row= {0,1,0,-1};
   static int[] col= {+1,0,-1,0};
	private static boolean search(char[][] board, String word, int n, int m, char[][] visited, int ci,int i,int j) {
		// TODO Auto-generated method stub
		if(word.length()==ci) {
			return true;
		}
		visited[i][j]=1;

		for(int move=0;move<4;move++) {
			int nextRow=i+row[move];
			int nextCol=j+col[move];
			if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m && visited[nextRow][nextCol]==0 && word.charAt(ci)==board[nextRow][nextCol]) {
				if( search(board,word,n,m,visited,ci+1,nextRow,nextCol)) {
				     return true;
				}
			}
		}

		// //right direction
		// if(j+1<m && visited[i][j+1]==0 && word.charAt(ci)==board[i][j+1]) {
		// 	if( search(board,word,n,m,visited,ci+1,i,j+1)) {
		// 	     return true;
		// 	}
		// }
		
		// //down direction
		// if(i+1<n && visited[i+1][j]==0 && word.charAt(ci)==board[i+1][j]) {
		// 	if( search(board,word,n,m,visited,ci+1,i+1,j)) {
		// 		return true;
		// 	}
		// }
		// //left
		// if(j-1>=0 && visited[i][j-1]==0 && word.charAt(ci)==board[i][j-1]) {
		// 	if(search(board,word,n,m,visited,ci+1,i,j-1)) {
		// 		return true;
		// 	}
		// }
		// //up
		// if(i-1>=0 && visited[i-1][j]==0 && word.charAt(ci)==board[i-1][j]) {
		// 	if(search(board,word,n,m,visited,ci+1,i-1,j)) {
		// 		return true;
		// 	}
		// }
		visited[i][j]=0;
		return false;
	}
}