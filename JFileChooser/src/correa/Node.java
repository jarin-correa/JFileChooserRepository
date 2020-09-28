package correa;

public class Node {
	public double value;
	public Node next;
	public Node right;

	// EXPLICIT CONSTRUCTOR
	public Node(double n) {
		value = n;
		next = null;
		
	}

	public String toString() { // when you print the objects
		return "(Node value: " + value + ")";

	}

}
