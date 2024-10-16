package dsa.linkedList;

import dsa.util.ListNode;
import dsa.util.Printer;

public class PartitionList {

//    Given the head of a linked list and a value x,
//    partition it such that all nodes less than x come before nodes greater than or equal to x.

//    You should preserve the original relative order of the nodes in each of the two partitions.

//    Example 1:
//    Input: head = [1,4,3,2,5,2], x = 3
//    Output: [1,2,2,4,3,5]

//    Example 2:
//    Input: head = [2,1], x = 2
//    Output: [1,2]

    // TIME COMPLEXITY: O(N)
    private static ListNode partition(ListNode head, int x) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode temp = preHead;
        // List to store elements values than x
        ListNode smallerElementPreHead = new ListNode(-1);
        ListNode smallerElementTemp = smallerElementPreHead;

        while (temp.next != null) {
            // 1. Remove smaller elements from original list
            // 2. Skip if element is greater
            if ((int) temp.next.val < x) {
                // Add in smaller elements list
                smallerElementTemp.next = temp.next;
                smallerElementTemp = smallerElementTemp.next;
                // remove from original list
                temp.next = temp.next.next;
            } else temp = temp.next;
        }

        // If no smaller element is found return original list
        if (smallerElementTemp == smallerElementPreHead) return head;

        // point smaller element tail's next to original list head
        // As original list now contains elements greater than x
        smallerElementTemp.next = preHead.next;
        return smallerElementPreHead.next;
    }

    private static void solve(int[] input, int x) {
//        Create input linked list and print
        ListNode<Integer> list = ListNode.createLinkedList(input);
        System.out.println("INPUT:");
        Printer.printLinkedList(list);
        System.out.println("x = " + x);
//        Add to linked list and print output
        list = partition(list, x);
        System.out.println("OUTPUT:");
        Printer.printLinkedList(list);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 4, 3, 2, 5, 2};
        int x = 3;
        solve(input, x);

        input = new int[]{2, 1};
        x = 2;
        solve(input, x);

        input = new int[]{2, 3, 4, 5};
        x = 1;
        solve(input, x);

        input = new int[]{2, 3, 4, 5};
        x = 6;
        solve(input, x);
    }
}
