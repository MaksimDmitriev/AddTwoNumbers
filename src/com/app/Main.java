package com.app;

public class Main {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);

        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode curr = new ListNode(l1.val + l2.val);
        int overflow = (sum >= 10) ? 1 : 0;
        ListNode first = curr;
        l1 = l1.next;
        l2 = l2.next;

        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }
            if (l1 == null) {
                sum = l2.val + overflow;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + overflow;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + overflow;
                l1 = l1.next;
                l2 = l2.next;
            }
            overflow = (sum >= 10) ? 1 : 0;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if (overflow == 1) {
            curr.next = new ListNode(1);
        }
        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

}
