package com.darksouls.datastructures.list;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList  {
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.add(null);
        LinkedList b = new LinkedList();
        b.add("1");
        System.out.println(a.contains(null));
    }
}
