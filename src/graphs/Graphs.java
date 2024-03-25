package graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graphs {
	public static void dftraversal(int[][] adjacencyMatrix, int currentVertex, boolean[] visited) {
		System.out.print(currentVertex + " ");
		visited[currentVertex] = true;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[currentVertex][i] == 1 && visited[i] == false) {
				// i is neighbour
				dftraversal(adjacencyMatrix, i, visited);
			}

		}
	}

	public static void dftraversal(int[][] adjacencyMatrix) {
		if (adjacencyMatrix.length == 0) {
			return;
		}
		boolean[] visted = new boolean[adjacencyMatrix.length];
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (visted[i] == false) {
				dftraversal(adjacencyMatrix, i, visted);
			}
		}

	}

	public static void bfTraversal(int[][] adjacencyMatrix) {
		if (adjacencyMatrix.length == 0) {
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[adjacencyMatrix.length];
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				bfTraversal(adjacencyMatrix, i, q, visited);
			}
		}
	}

	public static void bfTraversal(int[][] adjacencyMatrix, int startVertex, Queue<Integer> q, boolean[] visited) {
		q.add(startVertex);
		visited[startVertex] = true;
		while (!q.isEmpty()) {
			int currentVertex = q.poll();
			System.out.print(currentVertex + " ");
			for (int i = 0; i < adjacencyMatrix.length; i++) {
				if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

	public static boolean hasPath(int[][] adjacencyMatrix, int v1, int v2) {
		if (adjacencyMatrix.length == 0) {
			return false;
		}
		boolean[] visted = new boolean[adjacencyMatrix.length];

		return hasPath(adjacencyMatrix, v1, visted, v2);

	}

	public static boolean hasPath(int[][] adjacencyMatrix, int currentVertex, boolean[] visited, int destVertex) {
		if (currentVertex == destVertex) {
			return true;
		}
		boolean res = false;
		visited[currentVertex] = true;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[currentVertex][i] == 1 && visited[i] == false) {
				// i is neighbour
				res = res || hasPath(adjacencyMatrix, i, visited, destVertex);
			}
		}
		return res;
	}

	public static ArrayList<Integer> getDFSPath(int[][] adjacencyMatrix, int v1, int v2) {
		if (adjacencyMatrix.length == 0) {
			return new ArrayList<>();
		}

		boolean[] visted = new boolean[adjacencyMatrix.length];

		return getDFSPath(adjacencyMatrix, v1, visted, v2);

	}

	public static ArrayList<Integer> getDFSPath(int[][] adjacencyMatrix, int currentVertex, boolean[] visited,
			int destVertex) {

		if (currentVertex == destVertex) {
			// System.out.print(currentVertex+" ");
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(currentVertex);
			visited[currentVertex] = true;
			return arr;
		}
		visited[currentVertex] = true;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[currentVertex][i] == 1 && visited[i] == false) {
				// i is neighbour
				ArrayList<Integer> nArr = new ArrayList<>();
				nArr = getDFSPath(adjacencyMatrix, i, visited, destVertex);

				if (nArr != null) {
					nArr.add(currentVertex);
				}
				visited[currentVertex] = true;
				return nArr;
			}

		}
		return null;
	}

	public static ArrayList<Integer> getBFSPath(int[][] adjacencyMatrix, int v1, int v2) {
		if (adjacencyMatrix.length == 0) {
			return new ArrayList<>();
		}

		boolean[] visted = new boolean[adjacencyMatrix.length];
		Queue<Integer> q = new LinkedList<>();
		return getBFSPath(adjacencyMatrix, v1, visted, v2, q);

	}

	public static ArrayList<Integer> getBFSPath(int[][] adjacencyMatrix, int currentVertex, boolean[] visited,
			int destVertex, Queue<Integer> q) {

		q.add(currentVertex);
		visited[currentVertex] = true;
		ArrayList<Integer> arr = new ArrayList<>();
		HashMap<Integer, Integer> map=new HashMap<>();
		map.put(currentVertex, -1);
		while (!q.isEmpty()) {

			int CV = q.poll();
			
		

			for (int i = 0; i < adjacencyMatrix.length; i++) {
				if (adjacencyMatrix[CV][i] == 1 && !visited[i]) {

					q.add(i);
					map.put(i,CV);
					visited[i] = true;
					if (i == destVertex) {
						arr.add(i);
						int k=map.get(i);
						while(k!=-1) {
							arr.add(k);
							k=map.get(k);
						}
						return arr;
					}
				}
			}
		}
		return null;
	}
	
	
	
	public static void isConnected(int[][] adjacencyMatrix, int currentVertex, boolean[] visited) {
		//System.out.print(currentVertex + " ");
		
		visited[currentVertex] = true;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[currentVertex][i] == 1 && visited[i] == false) {
				// i is neighbour
				isConnected(adjacencyMatrix, i, visited);
			}

		}
	}

	public static boolean isConnected(int[][] adjacencyMatrix) {
		if (adjacencyMatrix.length == 0) {
			return true;
		}
		boolean[] visted = new boolean[adjacencyMatrix.length];
		int c=0;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (visted[i] == false) {
				c++;
				isConnected(adjacencyMatrix, i, visted);
			}
		}
		if(c>1) {
			return false;
		}
		return true;

	}
	
	
	public static void allConnectedComponents(int[][] adjacencyMatrix) {
		if (adjacencyMatrix.length == 0) {
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[adjacencyMatrix.length];
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				allConnectedComponents(adjacencyMatrix, i, q, visited);
				System.out.println();
			}
		}
	}

	public static void allConnectedComponents(int[][] adjacencyMatrix, int startVertex, Queue<Integer> q, boolean[] visited) {
		q.add(startVertex);
		visited[startVertex] = true;
		ArrayList <Integer> arr=new ArrayList<>();
		while (!q.isEmpty()) {
			int currentVertex = q.poll();
			// System.out.print(currentVertex + " ");
			arr.add(currentVertex);
			for (int i = 0; i < adjacencyMatrix.length; i++) {
				if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}

		Collections.sort(arr);

		for(int i=0;i<arr.size();i++)
		{
			System.out.print(arr.get(i) + " ");
		}

	}


	public static int numConnected(int[][] edges, int n) {
		return islands(edges);
	}

	public static int islands(int[][] adjacencyMatrix) {
		if (adjacencyMatrix.length == 0) {
			return 0;
		}
		Queue<Integer> q = new LinkedList<>();
		int res = 0;
		boolean[] visited = new boolean[adjacencyMatrix.length];
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				res += islands(adjacencyMatrix, i, q, visited);
				// System.out.println();
			}
		}
		return res;
	}

	public static int islands(int[][] adjacencyMatrix, int startVertex, Queue<Integer> q, boolean[] visited) {
		q.add(startVertex);
		int c = 0;
		visited[startVertex] = true;
		ArrayList<Integer> arr = new ArrayList<>();
		while (!q.isEmpty()) {
			int currentVertex = q.poll();
			// System.out.print(currentVertex + " ");
			arr.add(currentVertex);
			for (int i = 0; i < adjacencyMatrix.length; i++) {
				if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}

		Collections.sort(arr);
		c++;
		for (int i = 0; i < arr.size(); i++) {
			// System.out.print(arr.get(i) + " ");
		}
		return c;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int vertices = s.nextInt();
		int edges = s.nextInt();
		int[][] adjacencyMatrix = new int[vertices][vertices];
		for (int i = 0; i < edges; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjacencyMatrix[v1][v2] = 1;
			adjacencyMatrix[v2][v1] = 1;

		}
//		dftraversal(adjacencyMatrix);
//		bfTraversal(adjacencyMatrix);
		// System.out.println("Enter points");
//		int v1 = s.nextInt();
//		int v2 = s.nextInt();
		// System.out.println(hasPath(adjacencyMatrix,v1,v2));

		// System.out.println(getDFSPath(adjacencyMatrix, v1, v2));
		//System.out.println(getBFSPath(adjacencyMatrix, v1, v2));
		//System.out.println(isConnected(adjacencyMatrix));
		//allConnectedComponents(adjacencyMatrix);
		islands(adjacencyMatrix);
	}
	

}
