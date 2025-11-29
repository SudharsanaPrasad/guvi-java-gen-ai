package com.guvi.custom.list;

// ListNode node = new ListNode(50);
// System.out.println(node.getVal() + " " + node.getNext())
//System.out.println(node.toString())
public class ListNode {
    private int val;
    // how do I store the address to the next node?
    private ListNode next;
    // private ListNode prev;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }
}
