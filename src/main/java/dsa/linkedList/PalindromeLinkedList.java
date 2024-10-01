package dsa.linkedList;

import dsa.util.ListNode;
import dsa.util.Printer;

import java.util.Arrays;

public class PalindromeLinkedList {
//    Given the head of a singly linked list,
//    return true if it is a palindrome or false otherwise.

//    Input: head = [1,2,2,1]
//    Output: true

//    Input: head = [1,2]
//    Output: false

//    Input: head = [1,2,3,2,1]
//    Output: true

//    Input: head = [1,2,3,3,1]
//    Output: false

    private static ListNode<Integer> reverseLinkedList(ListNode<Integer> head) {
        ListNode<Integer> curr = head, nodeNext = null, prev = null;
        while (curr != null) {
            // Get a hold on current next
            nodeNext = curr.next;
            // Point current node to prev
            curr.next = prev;
            // Move prev to current node
            prev = curr;
            // Move current node next
            curr = nodeNext;
        }
        return prev;
    }

    private static ListNode<Integer> splitLinkedList(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;
        ListNode<Integer> slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode<Integer> mid = slow.next;
        slow.next = null;
        return mid;
    }

    private static boolean isPalindrome(ListNode<Integer> head) {
        ListNode<Integer> firstHalf, secondHalf;
        firstHalf = head;
        // Split the linked list in two equal halves
        secondHalf = splitLinkedList(head);
        // Reverse second half
        secondHalf = reverseLinkedList(secondHalf);
        // Check if all nodes of first and second halves are equal
        while (firstHalf != null && secondHalf != null) {
            if (!firstHalf.val.equals(secondHalf.val)) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 2, 1},
                {1, 2},
                {1, 2, 3, 2, 1},
                {1, 2, 3, 3, 1},
                {1},
                {}
        };
        Arrays.stream(input)
                .map(ListNode::createLinkedList)
                .peek(Printer::printLinkedList)
                .map(PalindromeLinkedList::isPalindrome)
                .forEach(o -> System.out.println("OUTPUT: " + o.toString().toUpperCase() + "\n"));
    }
}
