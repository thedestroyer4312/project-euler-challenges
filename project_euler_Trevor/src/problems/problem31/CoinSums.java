package problems.problem31;


public class CoinSums{

	public static final int[] COINS = {1, 2, 5, 10, 20, 50, 100, 200};
	
	public static void main(String[] args){
		long count = makeChange(200, COINS);
		System.out.println(count);
	}
	
	/**
	 * Returns the number of ways to make change with given coins
	 * @param amount Nonnegative amount of money for which to make change
	 * @param coins Nonempty int[] containing coin denominations, sorted in ascending order
	 * @return Number of ways to make change for the given amount of money
	 */
	public static long makeChange(int amount, int[] coins) {
		// Let D[i,j] be the number of ways to make change for amount i with coins {c_1,...,c_j}
		long[][] D = new long[amount + 1][coins.length + 1];
		// Base cases: D[0][j] = 1 for all j, D[i][0] = 0 for all i > 0
		for(int j = 0; j <= coins.length; j++) {
			D[0][j] = 1;
		}
		// Consider D[i,j]. Then, we either include coin c_j or exclude it.
		// Case 1: Include c_j
		// If we include c_j, then the number of ways to make change is D[i - c_j, j]
		// Case 2: Exclude c_j
		// If we exclude c_j, then the number of ways to make change is D[i, j - 1]
		// Because these are mutually exclusive, take the sum of the 2 cases
		// D[i,j] = D[i - c_j, j] + D[i, j - 1]
		
		// We have to iterate in increasing order of i and j
		for(int i = 1; i <= amount; i++) {
			for(int j = 1; j <= coins.length; j++) {
				long in, out;
				int c_j = coins[j - 1];
				if(c_j > i) {
					in = 0;
				}else{
					in = D[i - c_j][j];
				}
				out = D[i][j - 1];
				D[i][j] = in + out;
			}
		}
		return D[amount][coins.length];
	}
}
