package problems.problem18;

/**
 * ***SOLVED***
 * Euler Problem #18
 * Finds the maximum total from top to bottom of a given number triangle
 * Restrictions: has to move down a row with adjacent numbers only
 * @author Trevor Tsai
 */
import java.util.*;

public class MaxPathSum1{

	public static void main(String[] args){
		String triangleString =
				"75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01 23 75 03 34 88 02 77 73 07 63 67 99 65 04 28 06 16 "
						+ "70 92 41 41 26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51"
						+ " 14 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 04 68 "
						+ "89 53 67 30 73 16 69 87 40 31 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
		/* okay, so we have a String representing the triangle. Let's run
		 * a method to parse this String to turn it into a pyramid -- that is,
		 * a 2d array of ints */
		int[][] triangle = parseTriangle(triangleString);
		int maxSum = maxPathSum(triangle);
		System.out.println(maxSum);
	}

	public static int maxPathSum(int[][] triangle){
		return maxPathSum(triangle, 0, 0, new HashMap<List<Integer>, Integer>());
	}

	/**
	 * Finds the sum of the largest path down an input triangle (jagged array)
	 * @param triangle An input jagged array representing a triangle of numbers
	 * @return The maximum sum of the paths in the triangle
	 */
	private static int maxPathSum(int[][] triangle, int r, int c, Map<List<Integer>, Integer> paths){
		/* The numbers are in no particular order, so a greedy algorithm will not work effectively here.
		 * Instead, we will break the triangle down into subcases since there are 2 choices for each number you are at.
		 * That means that for each number, there are two subcases. We find the maximum of those two choices and pick
		 * the one that is maximal. We continue this recursive process until we reach the bottom, where the maximum
		 * of the paths is trivial, a comparison between two numbers.
		 * We will use a passed-in HashMap to optimize this process since there will be mutual subcases */
		if(r == triangle.length - 1){
			return triangle[r][c];
		}
		List<Integer> coordinates = new ArrayList<Integer>(2);
		coordinates.add(r);
		coordinates.add(c);
		if(paths.containsKey(coordinates)){
			return paths.get(coordinates);
		}else{
			paths.put(coordinates, triangle[r][c] + max(maxPathSum(triangle, r + 1, c, paths), maxPathSum(triangle, r
					+ 1, c + 1, paths)));
		}
		return triangle[r][c] + max(maxPathSum(triangle, r + 1, c, paths), maxPathSum(triangle, r + 1, c + 1, paths));
	}

	/**
	 * Parses a String and returns a triangle in the form of a 2d array Format
	 * is that the nth row has nth element - that is, the first row has 1
	 * element, the second 2, the third 3, and so forth
	 * @param input An input String, with spaces between each of the numbers
	 * @return A jagged 2d array representing a triangle
	 */
	public static int[][] parseTriangle(String input){
		input += " ";
		int numCounter = 0;
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == ' '){
				numCounter++;
			}
		}

		// now given the total number of numbers, let's calculate the rows
		int numRows = 0;
		int temp = 0;
		while(numCounter > 0){
			temp++;
			numCounter -= temp;
			numRows++;
		}

		int[][] triangle = new int[numRows][];
		List<Integer> numList = parseInt(input);

		// i represents the row we're working on, l is the index tracker for numList
		for(int i = 0, l = 0; i < triangle.length; i++, l += i){
			// create the row, then we fill it
			int[] row = new int[i + 1];
			for(int j = 0, k = l + j; j < row.length; j++, k++){
				row[j] = numList.get(k);
			}
			triangle[i] = row;
		}
		return triangle;
	}

	/**
	 * Parses through a String that has numbers with spaces and returns a List<Integer>
	 * @param input An input String that should only have numbers and spaces
	 * @return A List<Integer> with each slot containing an Integer in order from the input string
	 */
	public static List<Integer> parseInt(String input){
		input = input.trim() + " ";
		List<Integer> numbers = new ArrayList<Integer>();
		while(input.indexOf(' ') != -1){
			int index = input.indexOf(' ');
			String number = input.substring(0, index);
			int num = Integer.parseInt(number);
			numbers.add(num);
			input = input.substring(index + 1);
		}
		return numbers;
	}

	/**
	 * Returns the maximum of two integers
	 * @param x an integer
	 * @param y an integer
	 * @return the maximum of the two
	 */
	public static int max(int x, int y){
		return x > y ? x : y;
	}
}
