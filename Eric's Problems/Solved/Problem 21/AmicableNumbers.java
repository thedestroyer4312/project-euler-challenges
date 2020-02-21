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
public class AmicableNumbers {

     /**
     * PROJECT EULER 21
     * @return Finds the sum of all amicable numbers from 1 to n
     */
    public static void main(String[] args)
    {
        System.out.println(amicableNumbers(10000));
    }
    public static int amicableNumbers(int n)
     {
        int sum = 0;
        for(int i = 1; i < n; i++)
        {
            int tempSum = sumOfFactors(i);
            if(sumOfFactors(tempSum) == i && tempSum != i)
                sum = sum + i;
        }
        return sum;
    }
    public static int sumOfFactors(int n)
    {
        int sum = 0;
        for(int i = 1; i < n; i++)
       {
           if(n % i == 0)
               sum = sum + i;
       }
        return sum;
    }
}
