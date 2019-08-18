package com.recursion;


public class Solution1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum(array));
    }


    public static int sum(int array[]) {
        return sum(array, 0);
    }
    /**
     * 计算数组从l到末尾的元素和
     * @param array
     * @param l
     * @return
     */
    public static int sum(int array[], int l) {
        if (l == array.length) {
            return 0;
        }
        //把l到末尾的元素和分解成：l位置的元素  和 （l + 1）位置到末尾的元素之和
        return array[l] + sum(array, l + 1);
    }
}
