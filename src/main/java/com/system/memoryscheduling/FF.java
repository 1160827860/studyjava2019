package com.system.memoryscheduling;

import javafx.concurrent.Worker;

/**
 * @author 李正阳  17060208112
 * 首次适应算法
 */
public class FF {
    public static void start(){
        Util.initMemory();
        finish();
        Memory.print();
    }
    private static void sortByStart(){
        for (int i = 0; i < Memory.table.size(); i++) {
            for(int j = i + 1;j < Memory.table.size() ; j++){
                Partition temp;
                Partition pre = Memory.table.get(i);
                Partition next = Memory.table.get(j);
                if(pre.getStart() > next.getStart() ){
                    temp = pre;
                    Memory.table.set(i ,  next);
                    Memory.table.set(j , temp);
                }
            }
        }

    }
    public static void finish(){
        /**
         * 调取用户输出的命令，一条一条的执行
         */
        for(Order i : Memory.orders){
            boolean f = false;
            /**
             * 检查命令是释放还是申请1为申请，2为释放
             */
            if(i.type == 1){
                /**
                 * 检查空闲区表中是否有满足的空闲分区
                 */
                for(int j = 0;j <Memory.table.size() ; j++){
                    Partition temp = Memory.table.get(j);
//                for(Partition j: Memory.table) {
                    /**
                     * 若碰见空闲分区，分为刚好满足和还剩下有空间
                     */
                    if (temp.getSize() >= i.getSize()) {
                        /**
                         * 刚好满足和内存有剩余
                         */
                        if(temp.getSize() == i.getSize()){
                            /**
                             * 将空闲分区的内存块移动到作业分区中
                             */
                            temp.setName(i.getId());
                            Memory.work.add(temp);
                            Memory.table.remove(temp);
                            break;
                        }else {
                            /**
                             * 将内存分区中的内存块大小改变、然后将分配出去的放入
                             * work作业分区中
                             */
                            temp.setName(i.getId());
                            Memory.work.add(new Partition(i.getId(),i.getSize(),temp.getStart()));
                            temp.setSize(temp.getSize() - i.getSize());
                            temp.setStart(temp.getStart() + i.getSize());
                            break;

                        }
                    }

                }
                if(!f){
                    System.out.println("内存空间不够无法申请");
                }
                /**
                 * 释放内存、先判断是哪一种情况
                 */
                }else {
                    Util.recoverMemory(i);
                }
                sortByStart();
            }

    }
}
