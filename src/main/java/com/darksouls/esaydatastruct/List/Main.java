package com.darksouls.esaydatastruct.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> a = new MyLinkedList<>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.addFirst(5);
        System.out.println(a.getFirst());
        System.out.println(a.toString());
        List<Integer> b= new LinkedList();
        b.add(1);
        System.out.println(b.toString());
    }
}
