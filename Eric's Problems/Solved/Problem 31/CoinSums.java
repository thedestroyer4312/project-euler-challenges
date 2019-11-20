/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

/**
 *
 * @author twojineric
 */
public class CoinSums {

    public static void main(String[] args) {
        int[] coinValues = {200, 100, 50, 20, 10, 5, 2, 1};
        
        System.out.println(coinSums(coinValues, 0, 200));
    }
    //given an array of coin values, how many different times can you make change?
    public static int coinSums(int[] coinValues, int indexTry, int target) {
       
        int coinVal = coinValues[indexTry];
        if(target < 0)
            return 0;
        if(target == 0)
            return 1;
        if (indexTry == coinValues.length - 1) {
            if (target % coinVal == 0) 
                return 1;
            else 
                return 0; 
        }
        
        return coinSums(coinValues,indexTry,target - coinVal) 
                + coinSums(coinValues,indexTry + 1, target);
        
        

    }
}
