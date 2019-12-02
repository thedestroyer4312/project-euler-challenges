package HelperClasses;
/**
 * Euler Problem #13 - Helper class
 * An immutable helper class that represents large natural numbers using arrays
 * The only function is addition and summing the digits
 * @author Trevor Tsai
 */
import java.util.Arrays;

public class BigNum{

    public static void main(String[] args){
        System.out.println("Adding 999999 + 999999 should be 1999998");
        BigNum num1 = new BigNum("999999");
        BigNum num2 = new BigNum("999999");
        System.out.println(num1.add(num2));

        System.out.println("Adding 500 + 500");
        BigNum num3 = new BigNum(500);
        BigNum num4 = new BigNum(500);
        System.out.println("num3 = " + num3 + ", num4 = " + num4);
        System.out.println("num3 + num4 = " + num3.add(num4));
        
        System.out.println("Adding 333 + 669 = 1002");
        BigNum num5 = new BigNum(333);
        BigNum num6 = new BigNum(669);
        System.out.println("num5 = " + num5 + ", num6 = " + num6);
        System.out.println("num5 + num6 = " + num5.add(num6));
        
        System.out.println("Adding 9999 + 26 = 10025");
        BigNum num7 = new BigNum(9999);
        BigNum num8 = new BigNum(26);
        System.out.println("num7 = " + num7 + ", num8 = " + num8);
        System.out.println("num7 + num8 = " + num7.add(num8));
    }

    //instance variables
    byte[] digits;

    //Constructors
    /**
     * First constructor that takes in a String that represents a natural number
     * @param input An input String (should only be digits)
     */
    public BigNum(String input){
        //First, we have to check if it's a number
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("The String should represent"
                        + " a number");
            }
        }

        //Now that we've checked that, we can fill the array now
        digits = new byte[input.length()];
        for(int i = 0; i < input.length(); i++){
            /* although we're using chars, we can convert them to bytes using
             * their ascii values and subtraction
             */
            digits[i] = (byte) (input.charAt(i) - 48);
        }
        digits = trimZeroes(digits);
    }

    /**
     * A second constructor that takes a long and converts it to a BigNum
     * @param input An input natural number
     */
    public BigNum(long input){
        this(String.valueOf(input));
    }

    /**
     * A private constructor that constructs a new BigNum with an input byte[]
     * It creates a copy of the input array and sets that equal to the field
     * @param input An input array of bytes
     */
    private BigNum(byte[] input){
        byte[] copy = new byte[input.length];
        for(int i = 0; i < input.length; i++){
            copy[i] = input[i];
        }
        digits = copy;
    }

    //Instance methods
    /**
     * Adds two BigNum objects like numbers and returns an output
     * @param other The other BigNum
     * @return a new BigNum that is the sum of these two BigNums
     */
    public BigNum add(BigNum other){
        //finding which BigNum is longer (has more digits)
        boolean thisLongest = this.digits.length > other.digits.length;
        byte[] longer = (thisLongest) ? this.digits : other.digits;
        byte[] shorter = (thisLongest) ? other.digits : this.digits;
        
        /* if you add two numbers, you can at most increase the digits by 1
         * keeping that in mind, we make a copy of the longest digits array
         */
        byte[] newDigits = new byte[longer.length + 1];
        newDigits[0] = 0;
        for(int i = 0; i < longer.length; i++){
            newDigits[newDigits.length - 1 - i] = longer[longer.length - 1 - i];
        }
        
        //now we add the digits together
        for(int i = 0; i < shorter.length; i++){
            newDigits[newDigits.length - 1 - i] += shorter[shorter.length - 1 - i];
        }
        
        //calculating remainders and adjusting numbers
        for(int i = newDigits.length - 1; i > 0; i--){
            byte remainder = (byte) (newDigits[i] / 10);
            newDigits[i] %= 10;
            newDigits[i - 1] += remainder;
        }
        
        //trimming a zero if there is one at the beginning
        newDigits = trimZeroes(newDigits);
        return new BigNum(newDigits);
    }

    /**
     * Trims the leading 0s off the array input Intended to be used only by this
     * class
     * @param input the input array which may or may not need trimming
     * @return a new array with leading 0s removed
     */
    private byte[] trimZeroes(byte[] input){
        byte[] output;
        int counter = 0; //the number of leading 0s

        //parsing through the array to count the leading 0s
        for(int i = 0; i < input.length; i++){
            counter = i;
            if(input[i] != (byte) 0){
                break;
            }
        }

        output = new byte[input.length - counter];
        for(int i = counter, l = 0; i < input.length; i++, l++){
            output[l] = input[i];
        }
        return output;
    }

    /**
     * Returns the sum of the digits of this BigNum
     * @return sum of each digit in the byte[] digits
     */
    public long getDigitSum(){
        long output = 0;
        for(int i = 0; i < digits.length; i++){
            output += digits[i];
        }
        return output;
    }

    //Getter methods
    /**
     * Returns a copy of the digits
     * @return a copy of digits, a byte[]
     */
    public byte[] getDigits(){
        byte[] output = new byte[digits.length];
        for(int i = 0; i < output.length; i++){
            output[i] = digits[i];
        }
        return output;
    }

    //Overriding
    /**
     * Overrides the toString method Prints the digits consecutively, like a
     * normal number
     * @return A String representation of the digits
     */
    @Override
    public String toString(){
        String output = "";
        for(int i = 0; i < digits.length; i++){
            output += "" + digits[i];
        }
        return output;
    }

    /**
     * Comparison method between two BigNum objects
     * @param obj An input BigNum object (or if not, it returns false)
     * @return true if the digit arrays are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        BigNum e;
        if(!(obj instanceof BigNum)){
            return false;
        }else{
            e = (BigNum) obj;
        }

        return Arrays.equals(this.digits, e.digits);
    }
}
