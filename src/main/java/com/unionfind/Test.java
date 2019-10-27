package com.unionfind;

import java.util.Random;

/**
 * @Author xuwei
 * @Date 2019-10-27
 * @Version V1.0
 **/
public class Test {
    private static double testUF(UF uf, int m) {

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void  ab(UF uf){
        uf.unionElements(0, 1);
        System.out.println(uf.isConnected(0, 1));
        System.out.println(uf.isConnected(0, 2));
        uf.unionElements(1, 2);
        System.out.println(uf.isConnected(0,2));
    }


    public static void main(String[] args) {

//         UnionFind1 慢于 UnionFind2
        int size = 100000;
        int m = 10000;

//        // UnionFind2 慢于 UnionFind1, 但UnionFind3最快
        //原因：1.unionFind需要寻址 2.m次union导致树高非常高，然后判断isConnected耗时相应就很高
//        int size = 100000;
//        int m = 100000;

//        UnionFind1 uf1 = new UnionFind1(size);
//
//        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");

        UnionFind2 uf2 = new UnionFind2(size);
        System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");
//
        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + " s");

        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + " s");

        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5 : " + testUF(uf5, m) + " s");
    }
}
