package com.maxcriser.algoritmsarray;

import java.util.List;

final class Solutions {

    private static final String NOT_FOUNT = "NOT-FOUNT";

    static String LinearSearch(final List<Integer> pList, final int x, final int n) {
        String answer = NOT_FOUNT;
        for (int i = 0; i < n; i++) {
            if (pList.get(i) == x) {
                answer = i + "";
            }
        }
        return answer;
    } // n

    static String BetterLinearSearch(final List<Integer> pList, final int x, final int n) {
        for (int i = 0; i < n; i++) {
            if (pList.get(i) == x) {
                return i + "";
            }
        }
        return NOT_FOUNT;
    } // 1 - > n

    static String SentineLinearSearch(final List<Integer> pList, final int x, final int n) {
        final int last = pList.get(n - 1);
        pList.set(n - 1, x);
        int i = 0;
        while (pList.get(i) != x) {
            i++;
        }
        pList.set(n - 1, last);
        if (i < n - 1 || pList.get(n - 1) == x) {
            return i + "";
        } else {
            return NOT_FOUNT;
        }
    } // 1 - n

    static String RecursiveLinearSearch(final List<Integer> pList, final int x, final int n, final int i) {
        if (i > n - 1) {
            return NOT_FOUNT;
        } else if (pList.get(i) == x) {
            return i + "";
        } else {
            return RecursiveLinearSearch(pList, x, n, i + 1);
        }
    } // 1 - n
}