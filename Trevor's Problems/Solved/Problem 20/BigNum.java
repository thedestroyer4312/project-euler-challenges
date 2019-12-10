
/**
 * Helper class
 * @version 12/5/19
 * Originally implemented to assist with Euler Problem #13, this class is being
 * continually expanded to assist with other problems as well
 * An immutable helper class that represents large natural numbers using
 * arrays
 * The functions include addition, multiplication, and exponentiation
 * Secondary functions include summing of digits
 * Working on negative numbers, subtraction, division, to come
 * @author Trevor Tsai
 */
import java.util.Arrays;

public class BigNum implements Comparable<BigNum>{

    //instance variables
    private byte[] digits;

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
     * @param input A copy of the given BigNum object
     */
    public BigNum(BigNum input){
        this(input.digits);
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

    //Static methods
    /**
     * Returns a BigNum representing the factorial of an input number
     * @param num A long input
     * @return num! in the form of a BigNum
     */
    public static BigNum factorial(long num){
        if(num < 0){
            throw new IllegalArgumentException("Cannot be negative");
        }
        BigNum output = new BigNum(1);
        for(long i = 1; i <= num; i++){
            output = output.multiply(i);
        }
        return output;
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
        newDigits = parseRemainders(newDigits);

        //trimming a zero if there is one at the beginning
        newDigits = trimZeroes(newDigits);
        return new BigNum(newDigits);
    }

    /**
     * Adds a BigNum with a natural number by converting the number to a BigNum
     * After converting the natural number, calls the other add() method
     * @param input An input natural number. If < 0, throws
     * IllegalArgumentException @return A new BigNum that is the su m of these
     * two numbers
     */
    public BigNum add(long input){
        if(input < 0){
            throw new IllegalArgumentException("Must be a natural number "
                    + "(greater than 0)");
        }

        BigNum other = new BigNum(input);
        return this.add(other);
    }

    /**
     * Multiplies two BigNums together and returns a new product
     * @param other The other BigNum
     * @return A new BigNum that is the product of the first two
     */
    public BigNum multiply(BigNum other){
        //doing a check to see if either number is zero
        if(isZero() || other.isZero()){
            return new BigNum(0);
        }

        //this will be easier if we know which one is the longest and shortest
        boolean thisLongest = this.digits.length > other.digits.length;
        BigNum longNum = thisLongest ? this : other;
        BigNum shortNum = thisLongest ? other : this;

        //now to multiply, we go digit by digit, using the other method
        BigNum output = new BigNum(0);
        for(int i = shortNum.digits.length - 1, l = 0; i >= 0; i--, l++){
            int multiplier = (int) (Math.pow(10, l));
            output = output.add(longNum.multiply(shortNum.digits[i] * multiplier));
        }
        return output;
    }

    /**
     * Multiplies this BigNum with a natural number and returns a new product
     * @param num A long that represents a natural number ( >= 0)
     * @return A new BigNum that is the product of these two numbers
     */
    public BigNum multiply(long num){
        if(num < 0){
            throw new IllegalArgumentException("Must be a natural number "
                    + "(greater than 0)");
        }
        if(num == 0 || isZero()){
            return new BigNum(0);
        }

        BigNum output = new BigNum(0);
        //counter keeps track of the tens place in multiplying
        int counter = 0;
        while(num > 0){
            //creating a copy of digits with a space at the front and back
            byte[] temp = new byte[digits.length + 1 + counter];
            byte digit = (byte) (num % 10);
            //we also multiply by the last digit
            int i, l;
            for(i = temp.length - 1 - counter, l = digits.length - 1; l >= 0; i--, l--){
                temp[i] = (byte) (digits[l] * digit);
            }
            //now we parse the remainders
            temp = parseRemainders(temp);
            //create a new BigNum object using this and add that to the output
            output = output.add(new BigNum(temp));

            num /= 10;
            counter++;
        }

        return output;
    }

    /**
     * Returns a BigNum raised to an input long power
     * The input will not accept BigNums because that would be extremely large
     * and hopefully not required, as it depends on a for loop
     * Also will not accept negative numbers because that is outside the
     * current scope of the implementation of this class
     * @param exp The exponent to raise this BigNum to
     * @return A BigNum that is this^exp
     */
    public BigNum power(long exp){
        if(exp < 0){
            throw new IllegalArgumentException("Exponent must be 0 or greater");
        }

        BigNum output;
        if(exp == 0){
            output = new BigNum(1);
        }else if(exp == 1){
            output = new BigNum(this);
        }else{
            output = new BigNum(1);
            for(long i = 0; i < exp; i++){
                output = output.multiply(this);
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
        boolean allZeroes = true;

        //parsing through the array to count the leading 0s
        for(int i = 0; i < input.length; i++){
            counter = i;
            if(input[i] != (byte) 0){
                allZeroes = false;
                break;
            }
        }

        //what if everything's a 0
        if(allZeroes){
            byte[] temp = {0};
            return temp;
        }else{
            //if it's not, carry on as normal
            output = new byte[input.length - counter];
            for(int i = counter, l = 0; i < input.length; i++, l++){
                output[l] = input[i];
            }
            return output;
        }
    }

    /**
     * Given a byte[] with digits > 10, breaks up each and adds the remainders
     * to the next, like with addition or multiplication
     * @param input The input array that requires remainder parsing
     * @return A new array that has been parsed for remainders
     */
    private byte[] parseRemainders(byte[] input){
        byte[] output = new byte[input.length + 1];
        //copying over digits with a 0 at the beginning for space
        for(int i = 0; i < input.length; i++){
            output[i + 1] = input[i];
        }

        //now we remove remainders and add them to the slot previous (next digit)
        for(int i = output.length - 1; i > 0; i--){
            byte remainder = (byte) (output[i] / 10);
            output[i] %= 10;
            output[i - 1] += remainder;
        }
        output = trimZeroes(output);
        return output;
    }

    /**
     * Parses trailing zeroes in a scientific notation representation of a
     * number
     * @param input The input String to be trimmed
     * @return A corrected scientific notation number with removed trailing
     * zeroes
     */
    private String parseTrailingZeroes(String input){
        //counting the number of trailing zeroes
        int zeroCounter = 0;
        for(int i = input.indexOf("E") - 1; i >= 0; i--){
            if(input.charAt(i) != '0'){
                break;
            }
            zeroCounter++;
        }

        //now let's remove the zeroes, if applicable
        String output = input;
        if(zeroCounter > 0){
            output = output.substring(0, output.indexOf("E") - zeroCounter)
                    + output.substring(output.indexOf("E"));
        }
        if(output.contains(".E")){
            output = output.substring(0, output.indexOf(".E"))
                    + output.substring(output.indexOf("E"));
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

    /**
     * Returns the first n digits of this BigNum as a byte[]
     * @param n The number of digits
     * @return A byte[] with the first n digits (or up to, if n > digits.length)
     */
    public byte[] getFirstDigits(int n){
        int length = (n > digits.length) ? digits.length : n;
        byte[] output = new byte[length];
        for(int i = 0; i < length; i++){
            output[i] = digits[i];
        }
        return output;
    }

    /**
     * Returns the last n digits of this BigNum as a byte[]
     * @param n The number of digits
     * @return A byte[] with the last n digits (or up to, if n > digits.length)
     */
    public byte[] getLastDigits(int n){
        int length = (n > digits.length) ? digits.length : n;
        byte[] output = new byte[length];
        for(int i = 0; i < length; i++){
            output[output.length - 1 - i] = digits[digits.length - 1 - i];
        }
        return output;
    }

    /**
     * Returns the length of the BigNum
     * @return length of the digits[]
     */
    public int length(){
        return digits.length;
    }

    /**
     * Returns this BigNum in the form of scientific notation
     * Default is 15 significant digit precision with trimmed trailing zeroes
     * @return A String in the form x.yyyEw
     */
    public String toScientific(){
        return toScientific(15, false);
    }

    /**
     * Returns this BigNum in the form of scientific notation
     * Uses n-digit precision but trims trailing zeroes for ease of reading
     * @param num The level of precision specified
     * @param trailingZeroes if they want trailing zeroes kept for precision
     * @return A String in the form x.yyEw
     */
    public String toScientific(int num, boolean trailingZeroes){
        if(num <= 0){
            throw new IllegalArgumentException("Need 1 or more digits of "
                    + "precision");
        }

        String output = "";
        output += digits[0];
        if(digits.length > 1 && num > 1){
            output += ".";
        }
        num--; //number of significant digits left
        for(int i = 1; i < num + 1 && i < digits.length; i++){
            output += digits[i];
        }
        output += "E" + (digits.length - 1);
        if(!trailingZeroes){
            output = parseTrailingZeroes(output);
        }

        return output;
    }

    /**
     * An overloaded toScientific method with assumed trailingZeroes false
     * @param num The precision specified
     * @return Scientific notation of this number, no trailing zeroes
     */
    public String toScientific(int num){
        return toScientific(num, false);
    }

    /**
     * Checks if the current BigNum is 0
     * @return true if 0, false otherwise
     */
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
     * Compares the value of two BigNum objects
     * @param obj The other BigNum object
     * @return 1 if this object is greater than the other, -1 if not, 0 if equal
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
                    //if they're not equal, we go down the line
                    output = 0;
                    for(int i = digits.length - 1; i >= 0; i--){
                        if(this.digits[i] > obj.digits[i]){
                            output = 1;
                            break;
                        }
                        if(obj.digits[i] > this.digits[i]){
                            output = -1;
                            break;
                        }
                    }
                }
            }
        }
        return output;
    }
}
