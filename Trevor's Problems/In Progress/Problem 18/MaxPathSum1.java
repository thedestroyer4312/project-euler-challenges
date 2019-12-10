
/**
 * ***WORK IN PROGRESS***
 * Euler Problem #18
 * Finds the maximum total from top to bottom of a given number triangle
 * Restrictions: has to move down a row with adjacent numbers only
 * @author Trevor Tsai
 */
import java.util.*;

public class MaxPathSum1{

    public static void main(String[] args){
        String triangleString = "75 95 64 17 47 82 18 35 87 10 20 4 82 47 65 19 1 23"
                + " 75 3 34 88 2 77 73 7 63 67 99 65 4 28 6 16 70 92 41 41 "
                + "26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 "
                + "65 25 43 91 52 97 51 14 70 11 33 28 77 73 17 78 39 68 17 57 "
                + "91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 4 68 89 53 67 "
                + "30 73 16 69 87 40 31 4 62 98 27 23 9 70 98 73 93 38 53 60 "
                + "4 23";
        /* okay, so we have a String representing the triangle. Let's run
         * a method to parse this String to turn it into a pyramid -- that is,
         * a 2d array of ints
         */
        int[][] triangle = parseTriangle(triangleString);
        for(int[] t : triangle){
            for(int t2 : t){
                System.out.print(t2);
            }
            System.out.println();
        }
        //int maxSum = maxPathSum(triangle);
        //System.out.println(maxSum);
    }

    /**
     * Finds the sum of the largest path down an input triangle (jagged array)
     * @param triangle An input jagged array representing a triangle of numbers
     * @return The maximum sum of the paths in the triangle
     */
    public static int maxPathSum(int[][] triangle){
        int sum = 0;
        return sum;
    }

    /**
     * Parses a String and returns a triangle in the form of a 2d array Format
     * is that the nth row has nth element - that is, the first row has 1
     * element, the second 2, the third 3, and so forth
     * @param input An input String, with spaces between each of the numbers
     * @return A jagged 2d array representing a triangle
     */
    public static int[][] parseTriangle(String input){
        int numCounter = 1;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                numCounter++;
            }
        }

        //now given the total number of numbers, let's calculate the rows
        int numRows = 0;
        int temp = 0;
        while(numCounter > 0){
            temp++;
            numCounter -= temp;
            numRows++;
        }

        int[][] triangle = new int[numRows][];
        int[] numList = parseInt(input);

        //i represents the row we're working on, l is the index tracker for numList
        for(int i = 0, l = 0; i < triangle.length; i++, l += i + 1){
            int[] row = new int[i + 1];
            for(int j = 0, k = l + i; j < row.length; j++, k++){
                System.out.println("iteration " + (j + 1) + " of the loop");
                row[j] = numList[k];
            }
            triangle[i] = row;
        }
        return triangle;
    }

    /**
     * Parses through a String that has numbers with spaces and returns an int[]
     * @param input An input String that should only have numbers and spaces
     * @return An int[] with each slot having an int from the input string
     */
    public static int[] parseInt(String input){
        input = " " + input;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                String num = "";
                for(int j = i + 1; j < input.length(); j++){
                    if(input.charAt(j) == ' '){
                        break;
                    }else{
                        num += input.charAt(j);
                    }
                }
                temp.add(Integer.parseInt(num));
            }
        }

        int[] output = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            output[i] = temp.get(i);
        }
        return output;
    }
}
