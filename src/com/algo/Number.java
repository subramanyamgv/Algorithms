package com.algo;

/**
 * Created by Subramanyam on 30-Nov-2016.
 */
public class Number {

    /**
     * Reverse a number
     * I/p: 146
     * o/p: 641
     * @param num
     * @return
     */
    public int reverse(int num) {
        int revNum = 0;
        while (num > 0) {
            revNum = (revNum * 10) + num % 10;
            num = num / 10;
        }
        return revNum;
    }

    public boolean isPalindrome (int m, int n) {
        return m == reverse(n);
    }

    /**
     * Find number of digits in a number
     * @param n
     * @return
     */
    public int nDigits (int n) {
      return (int)Math.log10(n) + 1;
    }

    /**
     * Find number of digits in n^power
     * @param n
     * @param power
     * @return
     */
    public int nDigits(int n, int power) {
        return 1 + (int)(power * Math.log10(n));
    }

    /**
     * Get Kth digit from a number
     * I/p: k = 5th digit, num = 36492827
     * O/P: 2
     */
    public int getKthDigit(int num, int k) {

        int nDigits = (int)Math.log10(num) + 1;

        if (k > nDigits)
            return -1;

        int divisor = (int)Math.pow(10, nDigits - k);

        num = num / divisor;

        return num % 10;
    }

    /**
     * Get number between pos1 & pos2 in number num
     *  I/p: pos1 = 3, pos2 = 6, num = 36492827
     *  O/P: 4928
     *
     * @param num
     * @param pos1
     * @param pos2
     * @return
     */
    public int getSubNumber(int num, int pos1, int pos2) {

        int nDigits = (int) Math.log10(num) + 1;

        int divisor = (int) Math.pow(10, nDigits - pos2);

        num = num / divisor;

        int divisor2 = (int) Math.pow(10, pos2 - pos1 + 1);

        num = num % divisor2;

        return num;
    }

    /**
     * Problem: Return number of ways a number can be expressed as double squares
     * e.g., 10 = 3^2 + 1^2; 25 = 5^2 + 0^2 or 4^2 + 3^2
     *
     * Solution: N = x^2 + y^2;  y = sqrt(N - x^2).
     * Therefore, find all numbers for which (N - x^2) is a perfect square
     *
     * @param num
     * @return
     */
    public int doubleSquares(int num) {
        int p = (int)Math.sqrt((double)num / 2.0);
        int total = 0;
        for (int i = 0 ; i < p ; i++) {
            double j = (int)Math.sqrt((double)num - i*i);
            if (j - (int)j == 0.0) {
                total += 1;
            }
        }
        return total;
    }

    /**
     * Computes log N!
     * @param N
     * @return
     */
    public double logNfactorial(int N) {
        if (N == 0) return 0.0;
        return Math.log(N) + logNfactorial(N - 1);
    }

    public int gcd(int p, int q) {
        return (q == 0) ? p : gcd(q, p%q);
    }


}
