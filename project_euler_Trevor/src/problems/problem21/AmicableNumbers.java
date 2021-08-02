package problems.problem21;

import java.util.*;
import java.util.stream.Collectors;

public class AmicableNumbers{

	public static void main(String[] args){
		long amicableSum = sumAmicable(10000);
		System.out.println(amicableSum);
	}

	/**
	 * Finds the sum of all amicable numbers in the range [0, ceiling)
	 * @param ceiling Upper boundary, exclusive
	 * @return Sum of all amicable in this range
	 */
	public static long sumAmicable(int ceiling){
		// Generate lists of proper divisors for each number in [0,ceiling)
		List<List<Integer>> properDivisors = getProperDivisors(ceiling);

		// Now, map lists of proper divisors to their sums
		List<Integer> properDivisorSums = properDivisors.stream().map(list -> list.stream()
			.reduce(0, Integer::sum))
			.collect(Collectors.toList());

		// Iterate over the list and add if they are amicable
		// If so, add to a set
		Set<Integer> amicableNums = new HashSet<Integer>();
		for(int i = 0; i < ceiling; i++){
			int a = i;
			int pDivisorSumOfA = properDivisorSums.get(a);

			int b = pDivisorSumOfA;
			if(b >= ceiling){
				continue;
			}
			int pDivisorSumOfB = properDivisorSums.get(b);

			if(pDivisorSumOfA == b && pDivisorSumOfB == a && a != b){
				amicableNums.add(a);
				amicableNums.add(b);
			}
		}

		return amicableNums.stream().reduce(0, Integer::sum);
	}

	// Precondition: ceiling >= 2
	public static List<List<Integer>> getProperDivisors(int ceiling){
		List<List<Integer>> properDivisorList = new ArrayList<List<Integer>>(ceiling);

		// To get the list of divisors for each number i in [0,ceiling),
		// Iterate from 1 to sqrt(i), which is O(sqrt(i))

		// Base cases: 0 and 1, which have no proper divisors
		properDivisorList.add(new LinkedList<Integer>());
		properDivisorList.add(new LinkedList<Integer>());

		for(int i = 2; i < ceiling; i++){
			List<Integer> currProperDivisors = new LinkedList<Integer>();
			for(int j = 1; j <= Math.floor(Math.sqrt(i)); j++){
				if(i % j == 0){
					int div1 = j;
					int div2 = i / j;
					currProperDivisors.add(j);
					if(div1 != div2 && div1 != 1){
						currProperDivisors.add(i / j);
					}
				}
			}
			properDivisorList.add(currProperDivisors);
		}

		return properDivisorList;
	}

}
