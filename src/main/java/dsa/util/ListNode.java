package dsa.util;

public class ListNode<T> {
    public T val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static <T> ListNode<T> createLinkedList(T[] values) {
//        if array is empty simply return null;
        ListNode head = null, temp = head;
        for (T v : values) {
            if (head == null) {
                head = new ListNode(v);
                temp = head;
            } else {
                temp.next = new ListNode(v, null);
                temp = temp.next;
            }
        }
        return head;
    }

    public static ListNode<Integer> createLinkedList(int[] values) {
//        if array is empty simply return null;
        Integer[] boxedValues = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            boxedValues[i] = values[i];
        }
        return createLinkedList(boxedValues);
    }

    public static ListNode<Double> createLinkedList(double[] values) {
//        if array is empty simply return null;
        Double[] boxedValues = new Double[values.length];
        for (int i = 0; i < values.length; i++) {
            boxedValues[i] = values[i];
        }
        return createLinkedList(boxedValues);
    }

    public static <T> ListNode<Long> createLinkedList(long[] values) {
//        if array is empty simply return null;
        Long[] boxedValues = new Long[values.length];
        for (int i = 0; i < values.length; i++) {
            boxedValues[i] = values[i];
        }
        return createLinkedList(boxedValues);
    }

    public static <T> ListNode<Character> createLinkedList(char[] values) {
//        if array is empty simply return null;
        Character[] boxedValues = new Character[values.length];
        for (int i = 0; i < values.length; i++) {
            boxedValues[i] = values[i];
        }
        return createLinkedList(boxedValues);
    }

    public static <T> ListNode<Float> createLinkedList(float[] values) {
//        if array is empty simply return null;
        Float[] boxedValues = new Float[values.length];
        for (int i = 0; i < values.length; i++) {
            boxedValues[i] = values[i];
        }
        return createLinkedList(boxedValues);
    }
}
