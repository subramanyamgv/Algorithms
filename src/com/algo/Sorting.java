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

    public int quickSortPartitioning(int []a, int l, int r) {

        int pivot = a[l];
        int i = l, j = r;
        while(true) {

            while (a[++i] < pivot) if (i == r) break;
            while (a[--j] > pivot) if (j == l) break;
            if (i >= j) break;

            //Swap
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        //Swap
        a[l] = a[j];
        a[j] = pivot;

        return j;
    }

    public void quicksort(int []a, int l, int r) {

        if (l >= r)
            return;

        int j = quickSortPartitioning(a, l, r);
        quicksort(a, l, j - 1);
        quicksort(a, l + 1, j);
    }

    public int kthSmallest(int[]a, int l, int r, int k) {

        while (l < r) {

            int j = quickSortPartitioning(a, l, r);

            if (j == k)
                break;

            if (j < k) //kth smallest on right
                l = j + 1;
            else
                r = j - 1;
        }

        return a[k];
    }


}
