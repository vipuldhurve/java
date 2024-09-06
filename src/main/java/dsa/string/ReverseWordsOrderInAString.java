package dsa.string;

public class ReverseWordsOrderInAString {
//    Given an input string s, reverse the order of the words.

//    A word is defined as a sequence of non-space characters.
//    The words in s will be separated by at least one space.

//    Return a string of the words in reverse order
//    concatenated by a single space.

//    Note that s may contain leading or trailing spaces
//    or multiple spaces between two words.
//    The returned string should only have a single space separating the words.
//    Do not include any extra spaces.

//    Example 1:
//    Input: s = "the sky is blue"
//    Output: "blue is sky the"

//    Example 2:
//    Input: s = "  hello world  "
//    Output: "world hello"
//    Explanation: Your reversed string should not contain leading or trailing spaces.

//    Example 3:
//    Input: s = "a good   example"
//    Output: "example good a"
//    Explanation: You need to reduce multiple spaces between two words to a single space

//    Time Complexity: O{N}
    private static String reverseWordsOrder(String s) {
        int start = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (start >= 0) {
//            Make start point to last character in word
            while (start >= 0 && s.charAt(start) == ' ') start--;
//            If we have all spaces start will be less than 0
            if (start < 0) break;
//            Mark end of the word
            int end = start;
//            Find start of the word
            while (start >= 0 && s.charAt(start) != ' ') start--;
            if (sb.length() == 0) {
                sb.append(s.substring(start + 1, end + 1));
            } else {
                sb.append(" ").append(s.substring(start + 1, end + 1));
            }
        }
        return sb.toString();
    }

    private static void solve(String input) {
        System.out.print("Input: \"");
        System.out.println(input + "\"");
        System.out.print("Output: \"");
        System.out.println(reverseWordsOrder(input) + "\"" + "\n");
    }

    public static void main(String[] args) {
        String input1 = "the sky is blue";
        solve(input1);

        String input2 = "  hello world  ";
        solve(input2);

        String input3 = "  a good   example  ";
        solve(input3);
    }
}
