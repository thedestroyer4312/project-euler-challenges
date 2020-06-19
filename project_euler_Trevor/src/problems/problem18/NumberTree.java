package problems.problem18;

/**
 * Helper class for Problem 18 meant to represent the given number tree
 * Works like a normal unordered binary tree, but with only one entry and no key
 * Adds elements starting at the left and filling the row before moving to the next row,
 * in line with the principles of a complete tree
 * @author Trevor Tsai
 */
public class NumberTree{
	Node root;
	int size;
	
	class Node{
		Node parent;
		Node left;
		Node right;
		int value;
		
		// Constructor
		Node(Node parent, int entry){
			this.value = entry;
		}
	}
	
	public NumberTree(){
	}
	
	/**
	 * Adds a value into this tree as described above (left, then advancing down the rows)
	 * @param entry An input integer
	 */
	public void put(int entry){
		if(root == null)
			root = new Node(null, entry);
		else{
			
		}
	}
	
	Node put(Node node, int entry, int level){
		if(node == null)
			return null;
		else
			return null;
	}
	
	/**
	 * Returns the upper bound on size given the level (ex for level 3 there should be
	 * @param level
	 * @return
	 */
	private static int sizeLevel(int level){
		return -1;
	}
	
	/**
	 * Returns the maximum path of this tree, starting at the root and using a helper method
	 * @return The sum of the maximum values of this path
	 */
	public int maxPath(){
		return 0;
	}
}
