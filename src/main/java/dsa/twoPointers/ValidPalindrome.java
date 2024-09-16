package dsa.twoPointers;

import java.util.Arrays;

public class ValidPalindrome {
//    Given a string s, return true if it is a palindrome, otherwise return false.
//    It is also case-insensitive and ignores all non-alphanumeric characters.

//    Input: s = "Was it a car or a cat I saw?"
//    Output: true

//    Input: s = "tab a cat"
//    Output: false

    public static boolean isPalindromeSolve(String s) {
        if (s == null) return false;

        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] input = new String[]{
                "Was it a car or a cat I saw?",
                "tab a cat",
                "ta#b *a #bat",
                "",
                null
        };
        Arrays.stream(input)
                .peek(i -> System.out.println("INPUT: " + i))
                .map(ValidPalindrome::isPalindromeSolve)
                .forEach(o -> System.out.println("OUTPUT: " + o.toString().toUpperCase() + "\n"));
    }
}
