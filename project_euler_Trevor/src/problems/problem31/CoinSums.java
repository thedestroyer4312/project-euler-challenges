package problems.problem31;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class CoinSums{

	private static class ArrayWrapper{

		private int[] arr;

		private ArrayWrapper(int[] input){
			arr = input;
		}

		@Override
		public boolean equals(Object o){
			return o instanceof ArrayWrapper && Arrays.equals(arr, ((ArrayWrapper) o).arr);
		}
	}

	public static final int[] COINS = {1, 2, 5, 10, 20, 50, 100, 200};

	public static void main(String[] args){
		long count = makeChange(200);
		System.out.println(count);
	}

	/**
	 * Public function that determines the number of ways to make change of a certain number of pence
	 * @param pence The number of pence
	 * @return The number of ways to make chnage of a certain number of pence by calling a private function with passed
	 * in Hashmap for memoization optimization
	 */
	public static long makeChange(int pence){
		return makeChange(pence, new HashSet<ArrayWrapper>(), new int[8], new HashMap<Integer, Long>());
	}

	/**
	 * Uses recursion and memoization to determine how many ways you can make change from a particular
	 * @param pence The number of pence that you are trying to make change for
	 * @param change A passed in Map that keeps track of repetitive calls
	 * @return The number of ways you can make change for a certain number of pence
	 */
	private static long makeChange(int pence, Set<ArrayWrapper> combinations, int[] counts, Map<Integer, Long> log){
		if(pence == 0){
			return combinations.add(new ArrayWrapper(counts)) ? 1 : 0;
		}else if(pence < 0){
			return 0;
		}else{
			if(log.containsKey(pence)){
				return log.get(pence);
			}else{
				long count = 0;
				for(int i = 0; i < COINS.length; i++){
					int[] newCounts = counts.clone();
					newCounts[i]++;
					log.put(pence - COINS[i], makeChange(pence - COINS[i], combinations, newCounts.clone(), log));
					count += makeChange(pence - COINS[i], combinations, newCounts.clone(), log);
				}
				return count;
			}
		}
	}
}
