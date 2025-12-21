package com.guvi.custom;

public class LinkedList {
    private ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(ListNode head) {
        this.head = head;
    }

    // Insert a node to the beginning
    public void addFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.setNext(head);
        head = newNode;
    }

    public void addLast(int value) {
        ListNode newNode = new ListNode(value);
        // what if head is null?
        if(head == null) {
            head = newNode;
        } else {
            // walk to the last node
            ListNode temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            // update the next to the newNode
            temp.setNext(newNode);
        }
        // what if head isnt' null?
    }

    // remove first
    // if head == null -> removeFirst will be unsuccessful
    // if head != null -> removeFirst will be successful
    public boolean removeFirst() {
        if(head == null) return false;
        head = head.getNext();
        return true;
    }

    // remove the first node whose data == value
    public boolean remove(int value) {
        if(head == null) return false;

        // If the head itself holds the value
        if(head.getVal() == value) {
            head = head.getNext();
            return true;
        }

        ListNode current = head;
        ListNode previous = null;

        // walk through the linked list until
        // the current.getVal() doesn't equal the value
        while(current != null && current.getVal() != value) {
            previous = current;
            current = current.getNext();
        }

        if(current == null) {
            return false;
        }

        // previous.setNext(previous.getNext().getNext());
        previous.setNext(current.getNext());
        return true;

    }

    // contains: return true if the linked list contains the element
    /*
    public int contains(int value) {
        ListNode temp = head;
        int index = -1;
        while(temp != null) {
            if(temp.getVal() == value) {
                return index + 1;
            }
            index++;
            temp = temp.getNext();
        }
        return index;
    }
     */
    public boolean contains(int value) {
        ListNode temp = head;
        while(temp != null) {
            if(temp.getVal() == value) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    @Override
    public String toString() {
        ListNode temp = head;
        StringBuilder result = new StringBuilder();
        while(temp != null) {
            result.append(temp.getVal());
            if(temp.getNext() != null) {
                result.append(" -> ");
            }
            temp = temp.getNext();
        }
        System.out.println();
        return result.toString();
    }
}
