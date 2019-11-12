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
public class OneThousandDigitFibNum {

public static void main(String[] args)
{
    fibDigits(1000);
}

 //@returns x: where the xth fib# is the first that has more than n digits;
 //Each number is represented in Scientific Notation.
  public static int fibDigits(int n)
  {
      double aBase = 0.0, bBase = 1.0, cBase = 0.0;
      int aExp = 0, bExp = 0, cExp = 0;
      int count = 0;
      //A == aBase * Math.pow(10,aExp);

      while(aExp < n-1 || bExp < n-1 || cExp < n-1) // 1 * 10^999 has 1000 digits
      {
          //c = a + b
          //a = b
          //b = c
          if(aExp == bExp)
          {
             cBase = aBase + bBase;

                if(cBase >= 10 && cBase < 100) // 11 * 10^n --> 1.1 * 10^(n+1)
                {
                  cBase = cBase/10;
                  cExp++;
                }
             aBase = bBase;
             aExp = bExp;
             bBase = cBase;
             bExp = cExp;
             count++;
          }
          if(bExp - 1 == aExp) // if B is one digit longer then A
          {   aExp++;
              cBase = aBase/10 + bBase;  //8e10 + 1e11 --> 0.8e11 + 1e11

                if(cBase >= 10 && cBase < 100)
                {
                  cBase = cBase/10;
                  cExp++;
                }
             aBase = bBase;
             aExp = bExp;
             bBase = cBase;
             bExp = cExp;
             count++;
          }
      }
      System.out.println("A = " + aBase + "e" + aExp);
      System.out.println("B = " + bBase + "e" + bExp);
      System.out.println("C = " + cBase + "e" + cExp);
      System.out.println(count);
      return count;
  }

}
