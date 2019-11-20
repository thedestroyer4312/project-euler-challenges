
/**
 * ***SOLVED***
 * Euler Problem #7
 * Tries to find the largest product of 13 consecutive digits in a 100 digit number
 * @author Trevor Tsai
 */
import java.lang.*;

public class LargestProduct{

    public static void main(String[] args){
        String input = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
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
