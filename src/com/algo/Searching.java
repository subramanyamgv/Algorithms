package com.algo;

/**
 * Created by Subramanyam on 23-Nov-2016.
 */
public class Searching {

    public boolean binarySearch(int []a, int key) {

        int i = 0, j = a.length;

        while (i <= j) {

            int m = (i + j) / 2;

            if (a[m] == key)
                return true;

            if (a[m] < key) { //move to right
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return false;
    }

    /**
     * Problem: Check if the given element exists in the cyclic sequence of elements
     * Solution: Similar to binary search, check middle element with end element
     * @param a
     * @return
     */
    public int findMinInCyclicSortedSequence(int []a) {

        int i = 0, j = a.length - 1;

        while (i <= j) {

            int m = (i + j) / 2;

            if (i == j) break;

            if (a[m] < a[j]) { // min is on left
                j = m;
            } else { //min is on right
                i = m + 1;
            }
        }

        return a[i];
    }


    /**
     * Problem: Given a sorted sequence of numbers, find whether there exists a number i at index i.
        E.g. In [-8, -5, -3, 3, 5, 10, 15, 22, 25, 27, 28], number 3 occurs at index 3
     * @param a
     * @return
     */
    public int checkIndexAndNumberAreSameInSortedSequence(int []a) {

        int i = 0, j = a.length;

        while (i <= j) {

            int m = (i + j) / 2;

            if (a[m] == m)
                return m;

            if (a[m] < m) { //Required element is at right
                i = m + 1;
            } else { //Required element is at left
                j = m - 1;
            }
        }

        return -1;
    }

    /**
     * Interpolation Search:
     * Variation of Binary Search, instead of using middle key, estimate the position of the key using values
     *  arr[low] and arr[high]. i.e., mid = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low])
     * @param a
     * @return boolean
     */
    public boolean interpolationSearch(int[] a, int key) {

        int i = 0, j = a.length;

        while (i <= j) {

            int m = i + ((key - a[i]) * (j - i)) / (a[j] - a[i]);

            if (a[m] == key)
                return true;

            if (a[m] < key) { //move to right
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return false;
    }

}
