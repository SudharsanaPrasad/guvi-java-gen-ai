package com.guvi.custom.list;

public class Main {
    public static void main(String[] args) {
        ListNode node = new ListNode(50);
        ListNode newNode = new ListNode(60);
        //System.out.println("val" + node.getVal() + " next " + node.getNext());
        //System.out.println(node);

        // true -> first node
        LinkedList list = new LinkedList(node);
        System.out.println(list);
        list.addFirst(80);
        System.out.println(list);
        list.addLast(90);
        //list.getTail()?
        System.out.println(list);
//        list.removeFirst();
//        System.out.println(list);
        list.addLast(60);
        System.out.println(list);

        System.out.println(list.contains(50));
        System.out.println(list.contains(90));
    }
}
