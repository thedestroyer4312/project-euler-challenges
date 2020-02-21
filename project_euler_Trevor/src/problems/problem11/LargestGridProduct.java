package problems.problem11;

/**
 * ***SOLVED***
 * Euler Problem #11
 * Attempts to find the largest product of four adjacent numbers in a given 20x20 grid
 * @author Trevor Tsai
 */
public class LargestGridProduct{

	public static void main(String[] args){
		int[][] grid = {{8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8}, {49, 49, 99, 40, 17,
				81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0}, {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40,
						67, 53, 88, 30, 3, 49, 13, 36, 65}, {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56,
								71, 37, 2, 36, 91}, {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66,
										33, 13, 80}, {24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35,
												17, 12, 50}, {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54,
														70, 66, 18, 38, 64, 70}, {67, 26, 20, 68, 2, 62, 12, 20, 95, 63,
																94, 39, 63, 8, 40, 91, 66, 49, 94, 21}, {24, 55, 58, 5,
																		66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88,
																		34, 89, 63, 72}, {21, 36, 23, 9, 75, 0, 76, 44,
																				20, 45, 35, 14, 0, 61, 33, 97, 34, 31,
																				33, 95}, {78, 17, 53, 28, 22, 75, 31,
																						67, 15, 94, 3, 80, 4, 62, 16,
																						14, 9, 53, 56, 92}, {16, 39, 5,
																								42, 96, 35, 31, 47, 55,
																								58, 88, 24, 0, 17, 54,
																								24, 36, 29, 85, 57}, {
																										86, 56, 0, 48,
																										35, 71, 89, 7,
																										5, 44, 44, 37,
																										44, 60, 21, 58,
																										51, 54, 17, 58},
				{19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40}, {4, 52, 8, 83, 97, 35,
						99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66}, {88, 36, 68, 87, 57, 62, 20, 72, 3, 46,
								33, 67, 46, 55, 12, 32, 63, 93, 53, 69}, {4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18,
										8, 46, 29, 32, 40, 62, 76, 36}, {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69,
												82, 67, 59, 85, 74, 4, 36, 16}, {20, 73, 35, 29, 78, 31, 90, 1, 74, 31,
														49, 71, 48, 86, 81, 16, 23, 57, 5, 54}, {1, 70, 54, 71, 83, 51,
																54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48}};
		System.out.println(largestProduct(grid, 4));
	}

	/**
	 * Finds the largest product of n adjacent digits in a given 2d array of int
	 * Note that this means four in one direction, so we can't non-straight
	 * lines
	 * @param input The input grid of ints
	 * @param digits The number of digits for the product to have
	 * @return the largest n adjacent digit product in input
	 */
	public static long largestProduct(int[][] input, int digits){
		for(int i = 0; i < input.length; i++){
			if(input.length != input[i].length){
				throw new IllegalArgumentException("Must have a square grid.");
			}
		}
		if(digits > input.length){
			throw new IllegalArgumentException("The number of digits cannot be greater than the length of the grid.");
		}

		long largestProduct = -1;
		int times = input.length - digits + 1;
		/* We're going to use a pointer as the top-left corner of our 2d array
		 * That is being analyzed */

		for(int i = 0; i < times; i++){
			for(int j = 0; j < times; j++){
				int[][] temp = fillArray(i, j, input, digits);
				long tempProduct = largestProduct(temp);
				if(tempProduct > largestProduct){
					largestProduct = tempProduct;
				}
			}
		}
		return largestProduct;
	}

	/**
	 * Finds the largest product in a given 2d array, assumed length of the
	 * array's length
	 * @param input The input grid of ints
	 * @return the largest adjacent digit product in the input
	 */
	public static long largestProduct(int[][] input){
		// first,let's do rows and columns simultaneously
		long largestProduct = -1;
		for(int i = 0; i < input.length; i++){
			long rowProduct = 1;
			long colProduct = 1;

			for(int j = 0; j < input[0].length; j++){
				rowProduct *= input[i][j];
				colProduct *= input[j][i];
			}

			if(rowProduct > largestProduct){
				largestProduct = rowProduct;
			}
			if(colProduct > largestProduct){
				largestProduct = colProduct;
			}
		}

		// now, let's do the two diagonals
		long diagProduct1 = 1;
		long diagProduct2 = 1;
		for(int i = 0; i < input.length; i++){
			diagProduct1 *= input[i][i];
			diagProduct2 *= input[input.length - 1 - i][i];
		}
		if(diagProduct1 > largestProduct){
			largestProduct = diagProduct1;
		}
		if(diagProduct2 > largestProduct){
			largestProduct = diagProduct2;
		}

		return largestProduct;
	}

	/**
	 * Fills an nxn array starting at given coordinates from a source 2d array
	 * @param rIndex The row index that we are starting at (inclusive)
	 * @param cIndex The column index that we are starting at (inclusive)
	 * @param grid The source 2d array we are drawing from
	 * @param n How big the output array should be (n x n)
	 * @return An nxn array starting at the given indexes (inclusive)
	 */
	public static int[][] fillArray(int rIndex, int cIndex, int[][] grid, int n){
		int[][] output = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				output[i][j] = grid[rIndex + i][cIndex + j];
			}
		}
		return output;
	}

}
