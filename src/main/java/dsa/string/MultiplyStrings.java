package dsa.string;

import java.util.Arrays;

public class MultiplyStrings {
//    You are given two strings num1 and num2 that represent non-negative integers.

//    Return the product of num1 and num2 in the form of a string.

//    Assume that neither num1 nor num2 contain any leading zero,
//    unless they are the number 0 itself.

//    Note: You can not use any built-in library to convert the inputs directly into integers.

//    Example 1:
//    Input: num1 = "3", num2 = "4"
//    Output: "12"

//    Example 2:
//    Input: num1 = "111", num2 = "222"
//    Output: "24642"

    //    TIME COMPLEXITY :  O(M*N)   |   SPACE COMPLEXITY: O(M+N)
    private static String multiplyStrings(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] result = new int[num1.length() + num2.length()];

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int digit = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
//                Add digit to index i+j value
                result[i + j] += digit;
//                Add carry to next index i+j+1
                result[i + j + 1] += result[i + j] / 10;
//                Store once place in i+j index
                result[i + j] %= 10;
            }
        }

        StringBuilder multiple = new StringBuilder();
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) i--;

        while (i >= 0) multiple.append(result[i--]);
        return multiple.toString();
    }

    public static void main(String[] args) {
        String[][] input = new String[][]{
                {"123", "456"},
                {"3", "4"},
                {"10", "100"}
        };

        Arrays.stream(input)
                .peek(i -> System.out.println("Input: \"" + i[0] + "\" and \"" + i[1] + "\""))
                .map(i -> multiplyStrings(i[0], i[1]))
                .forEach(o -> System.out.println("Output: \"" + o + "\"\n"));
    }
}
