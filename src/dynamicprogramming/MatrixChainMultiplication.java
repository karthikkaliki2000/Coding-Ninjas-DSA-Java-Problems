package dynamicprogramming;

import java.util.*;

import java.io.*;

public class MatrixChainMultiplication {

	static int mps(int i, int j, int[] arr, int[][] dp) {

		if (i == j)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int mini = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {

			int steps = (arr[i - 1] * arr[k] * arr[j])

					+ mps(i, k, arr, dp) + mps(k + 1, j, arr, dp);

			mini = Math.min(mini, steps);

		}

		return dp[i][j] = mini;

	}

	public static int matrixMultiplication(int[] arr, int n) {

		int[][] dp = new int[n][n];

		for (int[] row : dp) {

			Arrays.fill(row, -1);

		}

		return mps(1, n - 1, arr, dp);

	}

}
