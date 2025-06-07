package dsa.slidingWindow.variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChars {

//    Given a string you need to print longest possible substring
//    that has exactly M unique characters.
//    If there is more than one substring of longest possible length,
//    then print any one of them

//    Input: Str = “aabbcc”, k = 1
//    Output: 2
//    Explanation: Max substring can be any one from {“aa” , “bb” , “cc”}.

//    Input: Str = “aabbcc”, k = 2
//    Output: 4
//    Explanation: Max substring can be any one from {“aabb” , “bbcc”}.

//    Input: Str = “aabbcc”, k = 3
//    Output: 6

//    Input: Str = “aaabbb”, k = 3
//    Output: Not enough unique characters

    public static String longestSubstringWithKUniqueChars(String str, int k) {
        if (str.isEmpty() || k > str.length()) return "";
        int left = 0;
        int right = 0;

        Map<Character, Integer> m = new HashMap<>();
        int i = -1;
        int j = -1;

        while (right < str.length()) {
            char cr = str.charAt(right);
            m.put(cr, m.getOrDefault(cr, 0) + 1);

            if (m.size() == k) {
                if (right - left > j - i) {
                    i = left;
                    j = right;
                }
            } else {
                while (m.size() > k && left <= right) {
                    char cl = str.charAt(left);
                    m.put(cl, m.get(cl) - 1);
                    if (m.get(cl) == 0) m.remove(cl);
                    left++;
                }
//                Check possibility of answer if currSum equals sum
                if (m.size() == k && (right - left) > (j - i)) {
                    i = left;
                    j = right;
                }
            }
//            Otherwise increasing window size (also in case of m.size() < k)
            right++;
        }
        if (i == -1 && j == -1) return "";
        return str.substring(i, j + 1);
    }

    private static void solve(String str, int k) {
        System.out.println("Input: \"" + str + "\"  k = " + k);
        System.out.println("Output: " + longestSubstringWithKUniqueChars(str, k) + "\n");
    }

    public static void main(String[] args) {
        String str = "dxaaabcayz";
        int k = 3;
        solve(str, k);

        str = "cxadabbc";
        k = 3;
        solve(str, k);

        str = "aabbcc";
        k = 1;
        solve(str, k);

        k = 2;
        solve(str, k);

        k = 3;
        solve(str, k);

        str = "aaabbb";
        k = 3;
        solve(str, k);
    }


}
