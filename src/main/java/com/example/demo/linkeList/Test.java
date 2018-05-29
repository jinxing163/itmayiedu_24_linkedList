package com.example.demo.linkeList;

import java.util.LinkedList;

/**
 * @author JinXing
 * @date 2018/5/29 14:44
 */
public class Test {

    public static void test1(){

        LinkedList<Integer> list=new LinkedList<>();

        for (int i = 0; i <10 ; i++) {
            list.add(i);
        }

        list.add(2,10);
        list.remove(2);
        list.remove();
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println("first:"+list.getFirst());
        System.out.println("last:"+list.getLast());

    }

    public static void test2(){

        ExtLinkedList list=new ExtLinkedList();
        for (int i = 0; i <10 ; i++) {
            list.add(i);
        }

        list.remove(1);
        list.removeObject(8);
        list.add(1,20);
        System.out.println("list.size:"+list.size());
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i)+",");
        }

    }

    public static void main(String[] args) {

//        test1();

        test2();
    }

}
