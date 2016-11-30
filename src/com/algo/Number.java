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
    public int getNumber(int num, int pos1, int pos2) {

        int nDigits = (int) Math.log10(num) + 1;

        int divisor = (int) Math.pow(10, nDigits - pos2);

        num = num / divisor;

        int divisor2 = (int) Math.pow(10, pos2 - pos1 + 1);

        num = num % divisor2;

        return num;
    }
}
