
/**
 * ***WORK IN PROGRESS***
 * Euler Problem #17
 * Find the number of letters in writing out 1 to 1000 (inclusive)
 * @author Trevor Tsai
 */
import java.util.HashMap;

public class NumberLetterCounts{

    //hashmap instance variable
    private HashMap<Integer, String> numbers;
    private HashMap<Integer, String> places;

    //Constructor
    /**
     * Initializes the values of the HashMap instance variables
     */
    public NumberLetterCounts(){
        numbers = new HashMap<Integer, String>();
        places = new HashMap<Integer, String>();
        //filling numbers from 1 to 19
        String[] numStrings = {"one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen"};
        for(int i = 1; i <= numStrings.length; i++){
            numbers.put(i, numStrings[i - 1]);
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
     * @param num A whole number (greater than 1)
     * @return The number of letters in writing out num
     */
    public int letterCount(int num){
        if(num < 1){
            throw new IllegalArgumentException("Must be a whole number");
        }
    }

    /**
     * Returns the number of digits in n
     * @param n An int
     * @return The number of digits in n
     */
    public static int numDigits(int n){
        int counter = 0;
        while(n > 0){
            n /= 10;
            counter++;
        }
        return counter;
    }
}
