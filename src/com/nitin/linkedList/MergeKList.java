package com.nitin.linkedList;

public class MergeKList {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {

        //Create the listNode 1
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(8);

        //Set the connection
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;


        //Create the listNode 2
        ListNode lfirst = new ListNode(2);
        ListNode lsecond = new ListNode(6);

        //Set the connection
        lfirst.next = lsecond;


        //Create the listNode 3
        ListNode jfirst = new ListNode(1);
        ListNode jsecond = new ListNode(7);

        //Set the connection
        jfirst.next = jsecond;


        ListNode lists[] = new ListNode[3];
        lists[0] = first;
        lists[1] = lfirst;
        lists[2] = jfirst;

        /*ListNode n = mergeTwoLists(first,lfirst);

        while (n != null) {

            System.out.println("Test: " + n.val);
            n = n.next;
        }*/

        for (ListNode n : lists) {
            System.out.println("");
            while (n != null) {

                System.out.println("Test: " + n.val);
                n = n.next;
            }
        }


        ListNode output = mergeKLists(lists);

        while (output != null) {

            System.out.println("mergeListResult: " + output.val);
            output = output.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {


        ListNode d = new ListNode(0);
        ListNode dummy = d;

        for (ListNode l : lists){
            ListNode result = mergeTwoLists(dummy.next,l);
            //dummy = dummy.next;
            dummy = new ListNode(0);
            dummy.next = result;
        }

        return dummy.next;

    }

    private static ListNode mergeTwoLists(ListNode a, ListNode b) {

        // 1->2->5
        // 2->3->6

        if (a == null && b != null) {
            return b;
        }else if (a == null && b != null) {
            return a;
        }

        ListNode d = new ListNode(0);
        ListNode dummy = d;

        while ( a != null && b!= null){
            if (a.val <= b.val){
                dummy.next = a;
                a = a.next;
            }else{
                dummy.next = b;
                b = b.next;
            }
            dummy = dummy.next;
        }
        if ( a != null){
            dummy.next = a;
        }
        if ( b != null){
            dummy.next = b;

        }
        return d.next;
    }


}
