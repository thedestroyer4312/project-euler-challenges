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
public class DoubleBasePalindrome {

    //sum of all numbers less than 10^6 that are palindromes in base 2 and 10.
    public static void main(String[] args) {
        System.out.println(DBP(1000000));
    }

    public static int DBP(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i = i + 2)
        //binary numbers must be odd to be a palindrome
        {
            if (isPalindrome("" + i)) {
                
                String bin = Integer.toString(i, 2);
                if (isPalindrome(bin)) {
                    sum = sum + i;
                }
            }
        }
        
        return sum;
    }

    public static boolean isPalindrome(String num) {
        while (num.length() > 1) {
            char firstChar = num.charAt(0);
            char lastChar = num.charAt(num.length() - 1);

            if (lastChar == firstChar) {
                num = num.substring(1, num.length() - 1);
            }
            else {
                return false;
            }

        }
        return true;
    }
}
