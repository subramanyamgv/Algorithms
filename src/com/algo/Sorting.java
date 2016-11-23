package com.algo;

/**
 * Created by Subramanyam on 23-Nov-2016.
 */
public class Sorting {

    public boolean isSorted(int[] a) {

        for (int i = 1 ; i < a.length ; i++) {
            if (a[i] < a[i-1]) {
                return false;
            }
        }

        return true;
    }

    public int[] insertion(int[] a) {

        for (int j = 1 ; j < a.length ; j++) {
            int key = a[j];
            int i = j - 1;
            while(i >=0 && a[i] > key) {
                a[i+1] = a[i];
                i = i - 1;
            }
            a[i+1] = key;
        }

        return a;
    }

    public int[] merge(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];
        int i = a.length - 1, j = b.length - 1, k = answer.length;

        while (k > 0)
            answer[--k] =
                    (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];

        return answer;
    }

}
