package com.algorithm.mystudy;

import java.util.Scanner;

public class EasyFullPermutation {
    static  StringBuilder builder = new StringBuilder();
    public static int permutation(int index,int[] arrs1,boolean[] arrsb2){
        int[] arrs = arrs1;
        boolean[] arrsb = arrsb2;
        builder.append(arrs[index]);
        arrsb[index] = true;

        if (builder.length() == arrs.length) {
            System.out.println(builder.toString());
            builder.deleteCharAt(builder.length() - 1);
            return index;
        }
        for (int i = 0; i < arrsb.length; i++) {
            if (arrsb[i] == false) {
                permutation(i, arrs, arrsb);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] arrs = new  int[t];
        for(int i = 1;i <= t;i++){
            arrs[i - 1] = i;
        }
        boolean[] arrsb = new boolean[t];
        permutation(0,arrs,arrsb);
    }
}
