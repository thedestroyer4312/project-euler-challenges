
/**
 * ***SOLVED***
 * Euler Problem #2
 * Find the sum of the even-valued Fibonacci terms that do not exceed four million.
 * @author Trevor Tsai
 */

import java.util.*;

public class EvenFibonacciNumbers{

    public static void main(String[] args){
        long sum = evenFibonacciSum(4000000l);
        System.out.println(sum);
    }

    /**
     * Finds the sum of the even-valued Fibonacci sequence numbers under a
     * limit.
     * @param input A long which specifies the upper limit of this method.
     * @return The sum of the even-valued numbers in the Fibonacci sequence
     * under the upper limit.
     */
    public static long evenFibonacciSum(long input){
        long sum = 0;
        ArrayList<Long> fibonacciSeq = new ArrayList<Long>();
        fibonacciSeq.add(1l);
        fibonacciSeq.add(2l);
        //Finding the rest of the numbers in the sequence up to input
        for(int i = 1; fibonacciSeq.get(i) < 4000000l; i++){
            fibonacciSeq.add(fibonacciSeq.get(i) + fibonacciSeq.get(i - 1));
        }
        for(int i = 0; i < fibonacciSeq.size(); i++){
            if(fibonacciSeq.get(i) % 2 == 0){
                sum += fibonacciSeq.get(i);
            }
        }
        return sum;
    }
}
