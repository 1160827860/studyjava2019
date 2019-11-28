package com.system;

import com.sun.deploy.panel.ITreeNode;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 李正阳  17060208112
 */
public class ProcessScheduling {


    static int time = 0;
    public static void main(String[] args) {
        LinkedList<pcb> external = initProcess();
        start(external);
        for(pcb temp : external){
            System.out.println(temp.toString());
        }
    }

    /**
     * 初始化需要运行的进程
     */
    public static LinkedList<pcb> initProcess(){
        Scanner in  = new Scanner(System.in);
        System.out.println("是否自定义cpu:(1为自定义的cpu，0为默认) ");
        if(in.nextInt() == 1 ){
            System.out.println("请输入cpu能同时运行几个进程,以及等待队列（进入内存能有多少个进程）");
            cpu.initcpu(in.nextInt(),in.nextInt());
        }
        System.out.println("请输入一共几个进程：");
        int n = in.nextInt();
        LinkedList<pcb>external = new LinkedList<pcb>();
        for(int i = 0;i < n; i++){
            System.out.println("输入进程的名字、到达时间、" +
                    "任务完成需要的时间、" +
                    "优先级");
            pcb temp = new pcb(in.next(),in.nextInt(),in.nextInt(),in.nextInt());
            external.add(temp);
        }
        return external;
    }

    /**
     *
     * @param p 作业未到达时候用
     */
    public static void start( LinkedList<pcb> p){
        /**
         * 作业还没有完全到达、作业没有全部做完、
         */
        while (p.size() != 0 || cpu.external.size() != 0 ||  cpu.queue.size() != 0) {
            for (int i = 0; i < p.size(); i++) {
                pcb temp = p.get(i);
                /**
                 *模拟作业到达，进入等待队列
                 */
                if (temp.getArrive_time() == time) {
                    cpu.external.add(temp);
                }
            }
            pcb prv = null;
            if(prv != null){
                cpu.external.add(prv);
            }
            for (pcb temp : cpu.external) {
                /**
                 * 模拟作业进入内存（只有两个道）
                 */
                if (cpu.queue.size() < cpu.queue_length) {
                    /**
                     * 记录进入内存的时间
                     */
                    if (temp.getFinish_level() == 0) {
                        temp.setInto_time(time);
                    }
                    /**
                     * 进入内存的过程，并且删除外存中的进程
                     */
                    cpu.queue.add(temp);
                    cpu.external.remove(temp);
                    /**
                     * 分配时间片
                     */
                    pcb head = cpu.queue.getFirst();
                    head.finish_time++;
                    /**
                     * 任务完成，从内存中删除任务记录，完成时间，并且计算周转
                     * 时间和带权周转时间
                     */
                    if (head.getTotal_time() == head.getFinish_level()) {
                        cpu.queue.remove(head);
                        head.setFinish_time(time);
                        head.setCycling_time(head.getFinish_time() - head.arrive_time);
                        head.setAuthorized_turnaround_time(head.getCycling_time() / head.getTotal_time());
                    }
                    /**
                     * 时间片结束，将内存中的进程删除
                     */
                     prv = cpu.queue.removeFirst();
                }

            }
            time ++;
        }
    }
}

