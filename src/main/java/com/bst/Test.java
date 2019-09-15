package com.bst;

/**
 *
 * ///////////////////
 * //	   5        //
 * //	/	\       //
 * //   3	  6     //
 * //  / \     \    //
 * // 2   4     8   //
 * ///////////////////
 * 前序遍历：5 3 2 4 6 8
 * 中序遍历：2 3 4 5 6 8
 * 后序遍历：2 4 3 8 6 5
 * @Author xuwei
 * @Date 2019-09-14
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 2, 4, 8, 9, 13,7};
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }

//        bst.postOrder();
//        System.out.println(bst.contains(9));
//        bst.levelOrder();

        bst.preOrder();
        bst.remove(8);
        System.out.println("-------");
        bst.preOrder();
    }
}
