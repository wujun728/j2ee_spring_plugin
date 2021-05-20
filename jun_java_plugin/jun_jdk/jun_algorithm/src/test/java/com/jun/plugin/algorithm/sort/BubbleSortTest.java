package com.jun.plugin.algorithm.sort;

import org.junit.Test;

import com.jun.plugin.algorithm.sort.BubbleSort;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        int[] a = {28, 16, 32, 12, 60, 2, 5, 72};
        new BubbleSort().bubbleSort(a);
        System.out.println("======冒泡排序测试======");
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
    }
}
