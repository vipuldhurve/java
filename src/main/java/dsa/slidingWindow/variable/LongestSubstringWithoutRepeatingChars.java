package dsa.slidingWindow.variable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

//    Given a string s, find the length of the longest substring without repeating characters.

//     Example 1:
//    Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.

//    Example 2:
//    Input: s = "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.

//    Example 3:
//    Input: s = "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    // In this code we check window size and map size
    // So in this solution we need to check for valid window while shrinking
    public static String solve(String str) {
        if (str.isEmpty()) return "";
        int left = 0;
        int right = 0;

        Map<Character, Integer> m = new HashMap<>();
        int i = 0;
        int j = 0;

        while (right < str.length()) {
            char cr = str.charAt(right);
            m.put(cr, m.getOrDefault(cr, 0) + 1);

            if (m.size() == (right - left + 1)) {
                if (right - left > j - i) {
                    i = left;
                    j = right;
                }
            } else {
                while (m.size() < (right - left + 1) && left <= right) {
                    char cl = str.charAt(left);
                    m.put(cl, m.get(cl) - 1);
                    if (m.get(cl) == 0) m.remove(cl);
                    left++;
                }
//                Check possibility of answer if currSum equals sum
                if (m.size() == (right - left + 1)) {
                    if (right - left > j - i) {
                        i = left;
                        j = right;
                    }
                }
            }
//            Otherwise increasing window size (also in case of m.size() < k)
            right++;
        }
        return str.substring(i, j + 1);
    }

    // In this solution we don't update ans when shrinking window
    // because it is taken care in else block in next iteration
    public int solve2(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int start = 0, end = 0;
        int maxLen = 0;
        while(end < s.length()){
            Character key = s.charAt(end);
            count.put(key, count.getOrDefault(key, 0) + 1);
            if(count.get(key) > 1){
                while(count.get(key)>1){
                    Character startKey = s.charAt(start);
                    count.put(startKey, count.get(startKey) - 1);
                    if(count.get(startKey) == 0) count.remove(startKey);
                    start++;
                }
            } else {
                maxLen = Math.max(count.size(), maxLen);
            }
            end++;
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String[] inputArr = new String[]{
                "dxaaabcayz",
                "abcabcbb",
                "bbbbb",
                "pwwkew"};

        Arrays.stream(inputArr)
                .peek(s -> System.out.println("Input: \"" + s + "\""))
                .map(LongestSubstringWithoutRepeatingChars::solve)
                .forEach(ans -> System.out.println("Output: \"" + ans + "\" length = " + ans.length() + "\n"));
    }


}
