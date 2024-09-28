package dsa.linkedList;

public class RemoveDuplicatesFromSortedList {
//    Given the head of a sorted linked list,
//    delete all duplicate numbers,
//    leaving only distinct numbers in the list.
//    Return the linked list sorted as well.

//    Input: head = [1,2,3,3,4,4,5]
//    Output: [1,2,3,4,5]

//    Input: head = [1,1,1,2,3]
//    Output: [1,2,3]

    private static ListNode removeDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
//        prev will store last node of unique values i.e. first unique will be head
        ListNode prev = head;
//        temp will iterate to skip duplicates of prev
        ListNode temp = head.next;
        while (temp != null) {
            if (prev.val != temp.val) {
//                If different value than prev is found
//                point prev.next to temp i.e. next unique
//                move prev to prev.next
                prev.next = temp;
                prev = prev.next;
            }
            temp = temp.next;
        }
        prev.next = null;
        return preHead.next;
    }

    private static void solve(int[] values) {
//        Create input linked list and print
        ListNode head = ListNode.createLinkedList(values);
        System.out.println("INPUT:");
        ListNode.printLinkedList(head);
//        Remove duplicates from linked list and print output
        head = removeDuplicates1(head);
        System.out.println("OUTPUT:");
        ListNode.printLinkedList(head);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 1, 2, 3, 3, 4, 5, 5};
        solve(input);

        input = new int[]{1, 1, 1, 2, 3};
        solve(input);
    }
}
