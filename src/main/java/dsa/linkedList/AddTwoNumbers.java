package dsa.linkedList;

import dsa.util.ListNode;
import dsa.util.Printer;

public class AddTwoNumbers {
//    You are given two non-empty linked lists, l1 and l2,
//    where each represents a non-negative integer.

//    The digits are stored in reverse order,
//    e.g. the number 123 is represented as 3 -> 2 -> 1 -> in the linked list.

//    Each of the nodes contains a single digit.
//    You may assume the two numbers do not contain any leading zero,
//    except the number 0 itself.

//    Return the sum of the two numbers as a linked list.

//    Input: l1 = [1,2,3], l2 = [4,5,6]
//    Output: [5,7,9]
//    Explanation: 321 + 654 = 975.

//    Input: l1 = [9], l2 = [9]
//    Output: [8,1]

    // TIME COMPLEXITY: O(M + N) , where M and N are size of list1 and list2
    private static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> preHead = new ListNode<>(-1);
        ListNode<Integer> temp = preHead;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            // If list l1 has some value, add it to carry and move to next l1 item
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            // If list l2 has some value, add it to carry and move to next l2 item
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            // Create new node with calculated value
            temp.next = new ListNode<>(carry % 10);
            temp = temp.next;
            // Update carry
            carry = carry / 10;
        }
        return preHead.next;
    }

    private static void solve(int[] list1, int[] list2) {
//        Create input linked list and print
        ListNode<Integer> l1 = ListNode.createLinkedList(list1);
        ListNode<Integer> l2 = ListNode.createLinkedList(list2);
        System.out.println("INPUT:");
        Printer.printLinkedList(l1);
        Printer.printLinkedList(l2);
//        Add to linked list and print output
        l1 = addTwoNumbers(l1, l2);
        System.out.println("OUTPUT:");
        Printer.printLinkedList(l1);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{1, 2, 3};
        int[] list2 = new int[]{4, 5, 6};
        solve(list1, list2);

        list1 = new int[]{9};
        list2 = new int[]{9};
        solve(list1, list2);

        list1 = new int[]{7, 7};
        list2 = new int[]{9, 4, 1};
        solve(list1, list2);
    }

}
