package com.seagmetTree;

/**
 * @Author xuwei
 * @Date 2019-10-20
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8,9};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(array, Integer::sum);

        System.out.println(segmentTree);
        segmentTree.set(4,8);

        System.out.println(segmentTree.get(3,6));
    }
}
