package dsa.twoPointers;

public class isPalindrome {
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
        String s = "Was it a car or a cat I saw?";
        System.out.println("\"" + s + "\" " + isPalindromeSolve(s));

        s = "tab a cat";
        System.out.println("\"" + s + "\" " + isPalindromeSolve(s));

        s = "";
        System.out.println("\"" + s + "\" " + isPalindromeSolve(s));

        s = null;
        System.out.println("\"" + s + "\" " + isPalindromeSolve(s));
    }
}
