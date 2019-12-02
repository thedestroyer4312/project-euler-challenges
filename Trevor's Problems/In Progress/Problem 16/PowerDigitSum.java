
/**
 * ***WORK IN PROGRESS***
 * Euler Problem #16
 * Find the sum of the digits of 2^1000
 * @author Trevor Tsai
 */
public class PowerDigitSum{

    public static void main(String[] args){
        String output = power(2, 1000);
        int digSum = digitSum(output);
        System.out.println(digSum);
    }
    
    /**
     * 
     * @param base
     * @param exp
     * @return 
     */
    public static String power(int base, int exp){
        String output;
    }
    
    /**
     * 
     * @param input
     * @return 
     */
    public static int digitSum(String input){
        int sum = 0;
        for(int i = 0; i < input.length(); i++){
            sum += Character.getNumericValue(input.charAt(i));
        }
        return sum;
    }
}
