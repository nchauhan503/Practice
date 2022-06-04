package com.nitin.linkedList;

public class ReorderList {

    public static class ListNodeO {
        int val;
        ListNodeO next;
        ListNodeO(int val) { this.val = val; }
        ListNodeO(int val, ReorderList.ListNodeO next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        //Create the listNode
        ListNodeO first = new ListNodeO(1);
        ListNodeO second = new ListNodeO(2);
        ListNodeO third = new ListNodeO(3);
        ListNodeO fourth = new ListNodeO(4);
        ListNodeO fifth = new ListNodeO(5);
        ListNodeO sixth = new ListNodeO(6);

        //Set the connection
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        reorderList(first);
    }

    public static void reorderList(ListNodeO head) {

        ListNodeO l1 = head;
        ListNodeO slow = head;
        ListNodeO fast = head;
        ListNodeO prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // After the while loop is done: l1 is the first half | slow is the second half
        ListNodeO l2 = reverseList(slow);

        mergeList(l1,l2,head);
    }

    private static ListNodeO reverseList(ListNodeO head) {
        ListNodeO prev = null;
        ListNodeO curr = head;
        ListNodeO next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void mergeList(ListNodeO l1, ListNodeO l2,ListNodeO head) {
        while ( l1 != null) {
            ListNodeO l1_next = l1.next;
            ListNodeO l2_next = l2.next;

            l1.next = l2;

            if ( l1_next == null){ break; }

            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }

    private static ListNodeO mergeListSpace(ListNodeO l1, ListNodeO l2) {

        ListNodeO dummy = new ListNodeO(0);
        ListNodeO f = dummy;

        while (l1 != null && l2 != null){
            f.next = new ListNodeO(l1.val);
            f = f.next;

            f.next = new ListNodeO(l2.val);
            f = f.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            f.next = new ListNodeO(l1.val);
            l1 = l1.next;
            f = f.next;
        }


        while (l2 != null){
            f.next = new ListNodeO(l2.val);
            l2 = l2.next;
            f = f.next;
        }

        return dummy.next;
    }
}
