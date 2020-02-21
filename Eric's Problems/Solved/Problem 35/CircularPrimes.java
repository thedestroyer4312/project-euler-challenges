/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.util.*;

/**
 * @author twojineric
 */
public class CircularPrimes {

    public static void main(String[] args) {
        System.out.println(circularPrimes(1000000));
    }

    public static int circularPrimes(int n) {
        ArrayList<Integer> primes = specialSieve(n);
        //we have a list of possible cyclic primes
        //now we keep rotating a number and checking if the rotated version
        //is still on the list.
        for(int i = 0; i < primes.size(); i++)
        {
            int tempNum = primes.get(i);
            int rotate = rotateNumber(tempNum);

            while(rotate != tempNum) //keeps rotating the number
            {
                if(!primes.contains(rotate)) //the rotated prime does not exist
                {
                    primes.remove(i);
                    i--; //keeps the loop working
                    break;
                }
                rotate = rotateNumber(rotate);
            }
        }
        return primes.size();
    }

    public static ArrayList<Integer> specialSieve(int n) {
        //finds all possible cyclic primes
        boolean[] notPrimes = new boolean[n + 1];
        //sieve of Eratosthenes to find all primes
        for (int i = 2; i * i <= n; i++) {

            if (notPrimes[i] == false) {
                for (int j = i * i; j <= n; j += i) {
                    notPrimes[j] = true;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<Integer>();
        //any number that has 0,2,4,5,6,8 in its digits is not a cyclic prime
        primes.add(2);
        primes.add(3);
        primes.add(5);
        for (int p = 5; p <= n; p++) {
            if (notPrimes[p] == false) {
                String str = "" + p;
                if (str.indexOf('0') == -1 &&
                    str.indexOf('2') == -1 &&
                    str.indexOf('4') == -1 &&
                    str.indexOf('5') == -1 &&
                    str.indexOf('6') == -1 &&
                    str.indexOf('8') == -1)
                {
                    primes.add(p);
                }
            }
        }
        return primes;

    }

    public static int rotateNumber(int n) {
        //takes an int abc and returns bca
        if (n < 10)
            return n;

        String str = "" + n;
        str = str.substring(1, str.length()) + str.charAt(0);
        return Integer.parseInt(str);
    }
}
