package dsa.linkedList;

import java.util.LinkedList;

public class RemoveDuplicatesFromSortedList2 {
//    Given the head of a sorted linked list,
//    delete all nodes that have duplicate numbers,
//    leaving only distinct numbers from the original list.
//    Return the linked list sorted as well.

//    Input: head = [1,2,3,3,4,4,5]
//    Output: [1,2,5]

//    Input: head = [1,1,1,2,3]
//    Output: [2,3]

    private static ListNode removeDuplicates(ListNode head) {
        ListNode preHead = new ListNode(-1, head), prev = preHead;

        ListNode start = head, end = head;
        while (end != null) {
            if (end.next != null && end.val == end.next.val) {
//                Check if current value has duplicates next to it
                end = end.next;
            } else {
                // If next node has a different value or is null
                if (start != end) {
//                    start and end range contains duplicates, remove them with help of prev
                    prev.next = end.next;
                } else {
//                    start == end i.e. No duplicates, update prev to end
                    prev = end;
                }
//                Check for new val if it has duplicates
                start = end.next;
                end = end.next;
            }
        }
        return preHead.next;
    }

    private static void solve(int[] values) {
//        Create input linked list and print
        ListNode head = ListNode.createLinkedList(values);
        System.out.println("Input:");
        ListNode.printLinkedList(head);
//        Remove duplicates from linked list and print output
        head = removeDuplicates(head);
        System.out.println("Output:");
        ListNode.printLinkedList(head);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 1, 2, 3, 3, 4, 5, 5};
        solve(input);
    }
}
