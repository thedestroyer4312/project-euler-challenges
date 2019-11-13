/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;
import java.util.*;
/**
 *
 * @author twojineric
 */
public class NumberLetterCounts {

 /**
 * The numbers 1 - 1000 are written out in words and in British English.
 * Excluding hyphens and spaces, what is the total length of this string?
 *
 */

    public static void main(String[] args)
    {
       int answer = 0;
        for(int i = 0; i <= 1000; i++)
        {
            answer = answer + countOfNum(i);
        }
        System.out.println(answer);
    }

  //given int n, returns length if n was written out in words, excluding spaces. n < 1e5
  public static int countOfNum(int n)
  {
      Map<Integer,String> wordCount = new HashMap<>();
      wordCount.put(1,"one");
      wordCount.put(2,"two");
      wordCount.put(3,"three");
      wordCount.put(4,"four");
      wordCount.put(5,"five");
      wordCount.put(6,"six");
      wordCount.put(7,"seven");
      wordCount.put(8,"eight");
      wordCount.put(9,"nine");
      wordCount.put(10,"ten");
      wordCount.put(11,"eleven");
      wordCount.put(12,"twelve");
      wordCount.put(13,"thirteen");
      wordCount.put(14,"fourteen");
      wordCount.put(15,"fifteen");
      wordCount.put(16,"sixteen");
      wordCount.put(17,"seventeen");
      wordCount.put(18,"eighteen");
      wordCount.put(19,"nineteen");
      wordCount.put(20,"twenty");
      wordCount.put(30,"thirty");
      wordCount.put(40,"forty");
      wordCount.put(50,"fifty");
      wordCount.put(60,"sixty");
      wordCount.put(70,"seventy");
      wordCount.put(80,"eighty");
      wordCount.put(90,"ninety");

      String name = "";

         if(wordCount.containsKey(n))
            return (name + wordCount.get(n)).length();

      int thousands = n / 1000;
      if(thousands != 0)
          name = name + wordCount.get(thousands) + "thousand";
      if(n == 0)
          return name.length();

      n = n - (thousands * 1000);

      int hundreds = n / 100;
      if(hundreds != 0)
        name = name + wordCount.get(hundreds) + "hundred";

      n = n - (hundreds * 100);
      if(n == 0)
          return name.length();

     if(wordCount.containsKey(n))
         return (name + "and" + wordCount.get(n)).length();

     int tens = n / 10;
     if(hundreds != 0)
         name = name + "and";
        name = name + wordCount.get(tens*10);

     int ones = n - (tens * 10);
      if(n == 0)
          return name.length();
        name = name + wordCount.get(ones);

        return name.length();

  }
}
