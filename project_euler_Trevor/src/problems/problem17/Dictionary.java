package problems.problem17;

import java.util.Map;
import java.util.HashMap;

public class Dictionary{

	public static Map<Integer, String> numbers;

	// initialize our dictionary
	public static void main(String[] args){
		numbers = new HashMap<Integer, String>();
		String[] words = {
				"",
				"one",
				"two",
				"three",
				"four",
				"five",
				"six",
				"seven",
				"eight",
				"nine",
				"ten",
				"eleven",
				"twelve",
				"thirteen",
				"fourteen",
				"fifteen",
				"sixteen",
				"seventeen",
				"eighteen",
				"nineteen",
				"twenty",
				"thirty",
				"forty",
				"fifty",
				"sixty",
				"seventy",
				"eighty",
				"ninety",
				"hundred",
				"thousand"};
		int[] integers = {
				0,
				1,
				2,
				3,
				4,
				5,
				6,
				7,
				8,
				9,
				10,
				11,
				12,
				13,
				14,
				15,
				16,
				17,
				18,
				19,
				20,
				30,
				40,
				50,
				60,
				70,
				80,
				90,
				100,
				1000};
		for(int i = 0; i < words.length; i++){
			numbers.put(integers[i], words[i]);
		}
	}
}
