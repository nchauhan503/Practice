package com.nitin.LinkedList;

public class RemoveNFromEnd {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        //Create the listNode
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        //ListNode third = new ListNode(3);
        //ListNode fourth = new ListNode(4);
        //ListNode fifth = new ListNode(5);

        //Set the connection
        first.next = second;
        //second.next = third;
        //third.next = fourth;
        //fourth.next = fifth;


        ListNode output = removeNthFromEnd(first,2);

        while (output != null) {

            System.out.println("Output: " + output.val);
            output = output.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null){ return head; }

        if (head.next == null && n == 1){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;


        //move the fast one n times
        for ( int i = 0; i < n ; i++){
            fast = fast.next;
        }

        if (fast == null){
            return head.next;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNthFromEndBrute(ListNode head, int n) {

        if (head == null){
            return head;
        }

        // total count tracker
        int count = 0;

        ListNode c = head;
        // get the total count
        while (c != null){
            count++;
            c = c.next;
        }

        int targetElement = count - n;


        if (targetElement == 0 && count == 1){
            return null;
        }

        if (targetElement == 0){
            return head.next;
        }

        ListNode update = head;
        while (targetElement > 0){


            // we hit the desired spot where we need to do the deletion
            if (targetElement == 1){

                ListNode temp = null;

                // this checks for making sure we do not go beyond the end of the list
                if (update.next != null){
                    temp = update.next.next;
                }else{
                    temp = update.next;
                }

                //removing the node in question
                update.next = null;
                update.next = temp;
            }

            //if not the intended node, go to the next node
            update = update.next;

            //decrement the counter
            targetElement--;

        }

        return head;
    }
}
