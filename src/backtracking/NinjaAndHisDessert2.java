package backtracking;

import java.util.*;

public class NinjaAndHisDessert2 {
	public static int closestCost(int n, int m, ArrayList<Integer> baseCosts, ArrayList<Integer> toppings, int target) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = close(difference(toppings, 0, baseCosts.get(i), target), ans, target);
		}
		return ans;
	}

	private static int close(int a, int b, int target) {
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}
		if (Math.abs(target - a) == Math.abs(target - b)) {
			return a < b ? a : b;
		}
		return Math.abs(target - a) < Math.abs(target - b) ? a : b;
	}

	private static int difference(ArrayList<Integer> toppings, int i, int sum, int target) {

		if (i >= toppings.size()) {

			return sum;

		}

		int a = difference(toppings, i + 1, sum + toppings.get(i), target);

		int b = difference(toppings, i + 1, sum + toppings.get(i) * 2, target);

		int c = difference(toppings, i + 1, sum, target);

		sum = close(a, close(b, c, target), target);

		return sum;

	}

}
