package com.algo.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Subramanyam on 20-Dec-2016.
 */
public class Permutations {


    public void printPermutations(String str) {
        _printPermutations("", str);
    }

    private void _printPermutations(String prefix, String str) {

        int n = str.length();

        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                _printPermutations(prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

    public void powerSet(String str) {
        Set<Character> set = new TreeSet<Character>();
        set.add('a');
        set.add('b');
        set.add('c');
        _powerSet(str, str.length()-1, set);
    }

    private void _powerSet(String str, int n, Set<Character> set) {

        if (n < 0) {
            for (Character a : set)
                System.out.print(a);
            System.out.println();
            return;
        }

        set.remove(str.charAt(n));
        _powerSet(str, n-1, set);
        set.add(str.charAt(n));
        _powerSet(str, n-1, set);
    }


}
