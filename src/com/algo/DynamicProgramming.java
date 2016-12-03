package com.algo;

/**
 * Created by Subramanyam on 02-Dec-2016.
 */
public class DynamicProgramming {

    /**
     * (1, 1, 2, 3, 5, 8, 13...)
     * @param N
     * @return
     */
    public long fibonacci(int N) {

        int[] F = new int[N];

        F[0] = 1; F[1] = 1;

        for (int i = 2 ; i < N ; i++) {
            F[i] = F[i-1] + F[i-2];
        }

        return F[N-1];
    }
}
