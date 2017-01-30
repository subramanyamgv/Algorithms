package com.algo;

/**
 * Created by Subramanyam on 23-Nov-2016.
 */
public class BitsAndBytes {

    /**
     * Number of bits required to represent a number
     * @param num
     * @return
     */
    public int nBits(int num) {
        return (int) Math.log(num) + 1;
    }

    /**
     * Ref: http://www.exploringbinary.com/number-of-bits-in-a-decimal-integer/
     *
     * Min bits required to represent D digit number
     *
     *      10^(D-1) <= n <= 10^D - 1
     *
     * I/P 4 digits
     * O/P
     */
    public int minBits(int digits) {
        return (int)((digits - 1) * Math.log(10)) + 1;
    }

    /**
     * Max bits required to represent D digit number
     * I/P 4 digits
     * O/P
     */
    public int maxBits(int digits) {
        return (int)(digits * Math.log(10) - 1) + 1;
    }

    public int reverseBits(int num) {

        int reverse = 0;
        for (int i = 0 ; i < 8 ; i++) {
            reverse = reverse * 2 | (num & 1);
            num >>= 1;
        }

        return reverse;
    }
}
