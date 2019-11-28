package com.system;

import java.util.LinkedList;

/**
 * 定义cpu的规格
 * 默认cpu为双道同时只能运行一个进程并且采用基础的抢占式的cpu
 */
public class cpu {
    /**
     * @param free_num 定义了cpu可以同时运行的进程数量
     *  默认值为1。
     *
     *@param free_statue 判断cpu是否被占用 true 被占用
     *
     * @parm queue_length  表示系统是几道作业的操作系统
     * 默认为双道作业系统
     *
     * external 为外存中的等待队列
     * queue 为内存中的队列
     */
    static int free_num = 1;
    static boolean[] free_statue;
    static int queue_length = 2;
    static LinkedList<pcb> external = new LinkedList<pcb>();
    static LinkedList<pcb> queue  = new LinkedList<pcb>();
    static {
        /**
         * 初始化cpu的是否被占用的标志数组
         */
        free_statue = new boolean[free_num];
        /**
         * 等待队列的实体初始化
         */
    }
    public cpu() {

    }

    /**
     * 指定cpu的规格
     * @param user_free_num cpu可以同时运行进程的个数
     * @param user_queue_length 等待队列的长度和几道系统一致
     */
    public static void initcpu(int user_free_num,int user_queue_length) {
        free_num = user_free_num;
        queue_length = user_queue_length;
    }



}
