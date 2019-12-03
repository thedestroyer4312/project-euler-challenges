
/**
 * Helper class
 * Originally implemented to assist with Euler Problem #13, this class is being
 * continually expanded to assist with other problems as well
 * An immutable helper class that represents large natural numbers using arrays
 * The functions include addition and summing the digits
 * Multiplication, exponentation, other functions are currently in progress
 * @author Trevor Tsai
 */
import java.util.Arrays;

public class BigNum implements Comparable<BigNum>{

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
     * Constructor that takes in a String that represents a natural number
     * @param in An input String (should only be digits)
     */
    public BigNum(String in){
        String input = in.trim();
        //First, we have to check if it's a positive number
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("The String should represent"
                        + " a positive number");
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
     * Clones the given BigNum object with an identical backing array
     * @param input Another BigNum object
     */
    public BigNum(BigNum input){
        digits = new byte[input.digits.length];
        for(int i = 0; i < digits.length; i++){
            digits[i] = input.digits[i];
        }
    }

    /**
     * A private constructor that constructs a new BigNum with an input byte[]
     * It creates a copy of the input array and sets that equal to the field
     * @param input An input array of bytes
     */
    private BigNum(byte[] input){
        digits = new byte[input.length];
        for(int i = 0; i < input.length; i++){
            digits[i] = input[i];
        }
    }

    //Primary methods: addition, multiplication, exponentiation, etc.
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
     * Multiplies two BigNums together and returns a new product
     * @param other The other BigNum
     * @return A new BigNum that is the product of the first two
     */
    public BigNum multiply(BigNum other){
        //this will be easier if we know which one is the longest and shortest
        boolean thisLongest = this.digits.length > other.digits.length;
        BigNum longNum = thisLongest ? this : other;
        BigNum shortNum = thisLongest ? other : this;

        //doing a check to see if either number is zero
        if(isZero() || other.isZero()){
            return new BigNum(0);
        }

        //now to multiply, we go digit by digit, using the other method
    }

    /**
     * Multiplies this BigNum with a natural number and returns a new product
     * @param num A long that represents a natural number ( >= 0);
     * @return
     */
    public BigNum multiply(long num){
        if(num < 0){
            throw new IllegalArgumentException("Must be a natural number "
                    + "(greater than 0)");
        }
        if(num == 0){
            return new BigNum(0);
        }

        BigNum output = new BigNum(0);
        int counter = 0;
        while(num > 0){
            byte[] temp = new byte[digits.length + 1 + counter];
            //creating a copy of digits with a space at the front
            for(int i = 0; i < digits.length; i++){
                temp[i + 1] = digits[i];
            }
            byte digit = (byte) (num % 10);
            int count = digits.length - 1;
            while(count >= 0){

                count--;
            }
        }

        return output;
    }

    //Secondary methods
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

    //Private methods - utility
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

        //what if everything's a 0 - that is, the number is 0?
        if(counter == digits.length){
            byte[] temp = {0};
            return temp;
        }

        //if it's not, carry on as normal
        output = new byte[input.length - counter];
        for(int i = counter, l = 0; i < input.length; i++, l++){
            output[l] = input[i];
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

    public boolean isZero(){
        byte[] temp = {0};
        return Arrays.equals(digits, temp);
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

    /**
     *
     */
    @Override
    public int compareTo(BigNum obj){
        int output;
        //first, a length comparison
        if(this.digits.length > obj.digits.length){
            output = 1;
        }else if(obj.digits.length > this.digits.length){
            output = -1;
        }else{
            //what if they're the same length? we check the first digit
            if(this.digits[0] > obj.digits[0]){
                output = 1;
            }else if(obj.digits[0] > this.digits[0]){
                output = -1;
            }else{
                /* what if the first digits are equal? first, check for overall
                 * equality in the numbers
                 */
                if(this.equals(obj)){
                    output = 0;
                }else{
                    //if they're not equal, we trim and use recursion
                    byte[] newDig1 = new byte[digits.length];
                    byte[] newDig2 = new byte[obj.digits.length];
                    for(int i = 0; i < digits.length - 1; i++){
                        newDig1[i] = this.digits[i + 1];
                        newDig2[i] = obj.digits[i + 1];
                    }
                    output = (new BigNum(newDig1)).compareTo(new BigNum(newDig2));
                }
            }
        }
        return output;
    }
}
