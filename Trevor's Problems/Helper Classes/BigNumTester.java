
/**
 * A class for testing the BigNum class
 * Simple and uses printing to the terminal
 */
public class BigNumTester{

    public static void main(String[] args){
        System.out.println("*****TESTING ADDITION*****");
        System.out.println("---Adding BigNum objects together---");
        System.out.println("999999 + 999999 = 1999998");
        BigNum num1 = new BigNum("999999");
        BigNum num2 = new BigNum("999999");
        System.out.println(num1.add(num2));
        System.out.println("500 + 500 = 1000");
        BigNum num3 = new BigNum(500);
        BigNum num4 = new BigNum(500);
        System.out.println("num3 = " + num3 + ", num4 = " + num4);
        System.out.println("num3 + num4 = " + num3.add(num4));
        System.out.println("333 + 669 = 1002");
        BigNum num5 = new BigNum(333);
        BigNum num6 = new BigNum(669);
        System.out.println("num5 = " + num5 + ", num6 = " + num6);
        System.out.println("num5 + num6 = " + num5.add(num6));
        System.out.println("9999 + 26 = 10025");
        BigNum num7 = new BigNum(9999);
        BigNum num8 = new BigNum(26);
        System.out.println("num7 = " + num7 + ", num8 = " + num8);
        System.out.println("num7 + num8 = " + num7.add(num8));
        System.out.println("---Adding BigNum with a natural number---");
        System.out.println("420 + 23 = 443");
        BigNum num9 = new BigNum(420);
        System.out.println("num9 = " + num9);
        System.out.println("num9 + 23 = " + num9.add(23));
        System.out.println();

        System.out.println("---Testing the isZero() method---");
        BigNum zeroTest = new BigNum(0);
        BigNum zeroTest2 = new BigNum("0000000");
        System.out.println("First num is " + zeroTest);
        System.out.println("Is the first one zero? " + zeroTest.isZero());
        System.out.println("Second num is " + zeroTest2);
        System.out.println("Is the second one zero? " + zeroTest2.isZero());
        System.out.println();
        
        System.out.println("---Testing BigNum comparison---");
        BigNum numTest1 = new BigNum(123456789);
        BigNum numTest2 = new BigNum(987654321);
        System.out.println("First num is " + numTest1);
        System.out.println("Second num is " + numTest2);
        System.out.println("first.compareTo(second) should yield -1");
        System.out.println("Comparison result: " + numTest1.compareTo(numTest2));
        BigNum numTest3 = new BigNum(4);
        BigNum numTest4 = new BigNum(4);
        System.out.println("First num is " + numTest3);
        System.out.println("Second num is " + numTest4);
        System.out.println("first.compareTo(second) should yield 0");
        System.out.println("Also, first.equals(second) should yield true");
        System.out.println("Comparison result: " + numTest3.compareTo(numTest4));
        System.out.println("Equality result: " + numTest3.equals(numTest4));
        System.out.println();
        

        System.out.println("***TESTING MULTIPLICATION***");
        System.out.println("---Multiplying BigNum objects together---");
        System.out.println("10 * 10 = 100");
        BigNum num10 = new BigNum(10);
        BigNum num11 = new BigNum(10);
        System.out.println("num10 = " + num10 + ", num11 = " + num11);
        System.out.println("num10 * num11 = " + num10.multiply(num11));
        System.out.println("15 * 3 = 45");
        BigNum num12 = new BigNum(15);
        BigNum num13 = new BigNum(3);
        System.out.println("num12 = " + num12 + ", num13 = " + num13);
        System.out.println("num12 * num13 = " + num12.multiply(num13));
        System.out.println("2 * 2 = 4");
        BigNum num17 = new BigNum(2);
        BigNum num18 = new BigNum(2);
        System.out.println("num17 = " + num17 + ", num18 = " + num18);
        System.out.println("num17 * num18 = " + num17.multiply(num18));
        System.out.println("---Multiplying BigNum with natural numbers---");
        System.out.println("15 * 15 = 225");
        BigNum num14 = new BigNum(15);
        System.out.println("num14 = " + num14);
        System.out.println("num14 * 15 = " + num14.multiply(15));
        System.out.println("456 * 789 = 359784");
        BigNum num15 = new BigNum(456);
        System.out.println("num15 = " + num15);
        System.out.println("num15 * 789 = " + num15.multiply(789));
        System.out.println();
        
        System.out.println("***TESTING EXPONENTIATION***");
        System.out.println("2^5 = 32");
        BigNum num16 = new BigNum(2);
        System.out.println("num16 = " + num16);
        System.out.println("num16 ^ 5 = " + num16.power(5));
        System.out.println("2^40 = 1099511627776");
        BigNum num19 = new BigNum(2);
        System.out.println("num19 = " + num19);
        System.out.println("num19 ^ 40 = " + num19.power(40));
        System.out.println("50 ^ 10 = 97656250000000000");
        BigNum num20 = new BigNum(50);
        System.out.println("num20 = " + num20);
        System.out.println("num20 ^ 10 = " + num20.power(10));
    }
}
