
/**
 * ***WORK IN PROGRESS***
 * Euler Problem #17
 * Find the number of letters in writing out 1 to 1000 (inclusive)
 * @author Trevor Tsai
 */
import java.util.*;

public class NumberLetterCounts{

    //hashmap instance variable
    private Map<Integer, String> numbers;
    private Map<Integer, String> places;

    //Constructor
    /**
     * Initializes the values of the HashMap instance variables
     */
    public NumberLetterCounts(){
        numbers = new HashMap<Integer, String>();
        places = new HashMap<Integer, String>();
        //filling numbers from 1 to 19
        String[] numStrings = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        for(int i = 0; i < numStrings.length; i++){
            numbers.put(i, numStrings[i]);
        }
        //now, we fill the places
        places.put(20, "twenty");
        places.put(30, "thirty");
        places.put(40, "forty");
        places.put(50, "fifty");
        places.put(60, "sixty");
        places.put(70, "seventy");
        places.put(80, "eighty");
        places.put(90, "ninety");
        places.put(100, "hundred");
        places.put(1000, "thousand");
    }

    public static void main(String[] args){
        NumberLetterCounts obj = new NumberLetterCounts();
        int numLetters = 0;
        for(int i = 1; i <= 1000; i++){
            numLetters += obj.letterCount(i);
        }
        System.out.println(numLetters);
    }

    /**
     * Returns the number of letters in num
     * @param input A whole number (greater than 1)
     * @return The number of letters in writing out num (British spelling)
     */
    public int letterCount(int input){
        if(input < 0){
            throw new IllegalArgumentException("Must be a whole number");
        }

        String num = String.valueOf(input);
        if(input < 20){
            return numbers.get(input).length();
        }else if(input == 1000){
            return places.get(input).length();
        }else{ //20 - 999
            if(num.length() == 3){
                int count = numbers.get(Integer.valueOf(num.charAt(0) + "")).length() + places.get(100).length();
                return count + 3 + letterCount(Integer.valueOf(num.substring(1)));
                //the 3 is for "and"
            }else{//length 2
                int tens = Integer.valueOf(num.charAt(0) + "");
                int ones = Integer.valueOf(num.charAt(1) + "");
                return places.get(tens * 10).length() + numbers.get(ones).length();
            }
        }
    }

    /*
    /**
     * Returns the number of digits in n
     * @param n An int
     * @return The number of digits in n
     *
    public static int numDigits(int n){
        int counter = 0;
        while(n > 0){
            n /= 10;
            counter++;
        }
        return counter;
    }
     */
}
