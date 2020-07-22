package problems.problem17;

/**
 * ***WORK IN PROGRESS***
 * Euler Problem #17
 * Find the number of letters in writing out 1 to 1000 (inclusive)
 * @author Trevor Tsai
 */
import java.util.Map;

public class NumberLetterCounts{

	private static Map<Integer, String> numbers;

	public static void main(String[] args){
		Dictionary.main(null);
		numbers = Dictionary.numbers;
		int numLetters = letterCountRange(1, 1000);
		System.out.println(numLetters);
	}

	/**
	 * Returns the number of letters in num
	 * @param input A whole number (greater than 1)
	 * @return The number of letters in writing out num (British spelling)
	 */
	public static int letterCount(int input){
		if(input < 0){
			throw new IllegalArgumentException("Must be a whole number");
		}

		if(input <= 20){
			return numbers.get(input).length();
		}else if(input == 1000){
			return numbers.get(1).length() + numbers.get(1000).length();
		}else{ // 21 - 999
				// 100-999
			if(input >= 100 && input <= 999){
				int count = numbers.get(input / 100).length() + numbers.get(100).length();
				return count + ((input % 100 == 0) ? 0 : "and".length() + letterCount(input % 100));
			}else{// 21-99
				int tens = input / 10;
				int ones = input % 10;
				return numbers.get(tens * 10).length() + numbers.get(ones).length();
			}
		}
	}

	/**
	 * Counts the number of letters of all natural numbers between start and end, inclusive
	 * @param start The starting integer (must be 0 or greater)
	 * @param end The ending integer (should be no more than 1000)
	 * @return the number of letters of all natural numbers in this range
	 */
	public static int letterCountRange(int start, int end){
		int count = 0;
		for(int i = start; i <= end; i++){
			count += letterCount(i);
		}
		return count;
	}
}
