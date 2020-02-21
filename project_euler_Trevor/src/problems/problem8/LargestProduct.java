package problems.problem8;

/**
 * ***SOLVED***
 * Euler Problem #8
 * Tries to find the largest product of 13 consecutive digits in a 100 digit number
 * @author Trevor Tsai
 */

public class LargestProduct{

	public static void main(String[] args){
		String input = "73167176531330624919225119674426574742355349194934969835203127745063262395783180169"
				+ "848018694788518438586156078911294949545950173795833195285320880551112540698747158"
				+ "523863050715693290963295227443043557668966489504452445231617318564030987111217223"
				+ "83113622298934233803081353362766142828064444866452387493035890729629049156044077"
				+ "23907138105158593079608667017242712188399879790879227492190169972088809377665727"
				+ "33300105336788122023542180975125454059475224352584907711670556013604839586446706"
				+ "324415722155397536978179778461740649551492908625693219784686224828397224137565705"
				+ "60574902614079729686524145351004748216637048440319989000889524345065854122758866"
				+ "68811642717147992444292823086346567481391912316282458617866458359124566529476545"
				+ "68284891288314260769004224219022671055626321111109370544217506941658960408071984"
				+ "0385096245544436298123098787992724428490918884580156166097919133875499200524063"
				+ "68991256071760605886116467109405077541002256983155200055935729725716362695618826"
				+ "70428252483600823257530420752963450";
		System.out.println(largestProduct(input, 13));
	}

	/**
	 * Returns the largest product of any n consecutive digits in a number
	 * (represented as a String)
	 * @param input The string to be analyzed, allowing for more digits than a
	 * pure number
	 * @return the largest product of n consecutive digits in the input
	 */
	public static long largestProduct(String input, int digits){
		String temp;
		long largest = 0;
		for(int i = 0; i < input.length() - (digits - 1); i++){
			temp = input.substring(i, i + digits);
			byte[] numbers = toByteArray(temp);
			long mult = 1;
			for(int j = 0; j < numbers.length; j++){
				mult *= numbers[j];
			}
			if(mult > largest){
				largest = mult;
			}
		}
		return largest;
	}

	/**
	 * Takes in a String representing a String of digits and returns a byte
	 * array of the digits
	 * @param input The string of digits which should already be pre-sized
	 * @return a array of byte numbers representing the digits of the String
	 */
	public static byte[] toByteArray(String input){
		byte[] output = new byte[input.length()];
		for(int i = 0; i < input.length(); i++){
			output[i] = Byte.parseByte("" + input.charAt(i));
		}
		return output;
	}
}
