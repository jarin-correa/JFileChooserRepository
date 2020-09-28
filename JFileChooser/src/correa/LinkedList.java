package correa;

import java.util.ArrayList;

public class LinkedList {
	public static Node root;
	/**
	 * Adds a value into the linked list
	 * @param root Node being added
	 * @param n Value of root
	 * @return root Returns the root as the head of the list
	 */
	 

	public static Node addToList(Node root, double n) {
		Node temp = new Node(n);
		temp.value = n;
		temp.next = root;
		root = temp;
		return root;

	}
	/**
	 * Converts an array to a linked list
	 * @param arr array being converted
	 * @param n array length
	 * @return A full list from an array
	 */

	public static Node arrayToList(double arr[], int n) {
		root = null;
		for (int i = n - 1; i >= 0; i--)
			root = addToList(root, arr[i]);
		return root;
	}
	/**
	 * Finds the average in a list
	 * @param root Node starting the traversing to go through the list
	 * @param n length of the list
	 * @return The average of the list
	 */

	public static double mean(Node root, int n) {
		double total = 0;
		double average;
		while (root != null) {
			total += root.value;
			root = root.next;
		}
		average = total / n;
		return average;
	}
	/**
	 * Finds the standard deviation by traversing through the list, converting it into an arraylist
	 * finding the mean, and doing the stardard deviation formula
	 * @return The standard deviation calculations
	 * 
	 */

	public static double calculateSD() {
		ArrayList<Double> nums = new ArrayList<Double>();
		Node travel = root;
		int sum = 0;

		while (travel != null) {
			nums.add(travel.value);
			sum += travel.value;
			travel = travel.next;
		}

		double mean = sum / nums.size();
		double denominator = nums.size() - 1;
		int numerator = 0;

		for (int i = 0; i < nums.size(); i++) {
			numerator += Math.pow((nums.get(i) - mean), 2);
		}
		double standardDeviation = Math.sqrt(numerator / denominator);

		return standardDeviation;
	}

	public static Node getRoot() {
		return root;
	}

	public static void setRoot(Node root) {
		LinkedList.root = root;
	}

}
