package com.algorithm.MyStudy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 全排列问题
 */
public class permute {

        static LinkedList<Integer> builder = new LinkedList<Integer>();
        public static void sort(int index ,int[] arrs,boolean[] arrsb){
                builder.addLast(arrs[index]);
                arrsb[index] = true;
                for(int j = 0; j < arrs.length ;j++){
                    if(arrsb[j] == false){
                        sort(j,arrs,arrsb);
                    }
                }
                if(builder.size() == arrs.length){
                    System.out.println( builder.toString());
                    builder.remove(builder.size() - 1);
                    arrsb[index] = false;
                    return;
                }
            builder.remove(builder.size() - 1);
            arrsb[index] = false;
            return;



        }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] arrs = new int[t];
        for(int i = 0;i < arrs.length;i++){
            arrs[i] = i + 1;
        }
        boolean[] arrsb = new boolean[t];
        for(int i = 0;i < arrs.length;i++){
            sort(i,arrs,arrsb);
        }

    }
}
