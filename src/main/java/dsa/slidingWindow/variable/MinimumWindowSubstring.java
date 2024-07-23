package dsa.slidingWindow.variable;

import java.util.Map;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {

//    Given two strings s and t of lengths m and n respectively,
//    return the minimum window substring of s such that every character in t(including duplicates) is included in the window.
//    If there is no such substring, return the empty string "".

//    Example 1:
//    Input: s = "ADOBECODEBANC", t = "ABC"
//    Output: "BANC"
//    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

//    Example 2:
//    Input: s = "a", t = "a"
//    Output: "a"
//    Explanation: The entire string s is the minimum window.

//    Example 3:
//    Input: s = "a", t = "aa"
//    Output: ""
//    Explanation: Both 'a's from t must be included in the window.
//    Since the largest window of s only has one 'a', return empty string.

    // Time Complexity: O(m+n)
    public static String solve(String s, String t) {
        if (t.isEmpty() || t.length() > s.length()) return "";

        int left = 0;
        int right = 0;
        Map<Character, Integer> m = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        c -> c,
                        c -> 1,
                        Integer::sum));
        int count = m.size();

        //ans
        int i=0;
        int j=0;
        int minLen = Integer.MAX_VALUE;

        while(right < s.length()){
            char cr = s.charAt(right);
            // If map does not contain letter right++
            // else If map contains do calcultaion
            if(m.containsKey(cr)){
                m.put(cr, m.get(cr)-1);
                if(m.get(cr) == 0) count--;
            }
            // Check value of count
            if(count == 0){
                while(count == 0){
                    char cl = s.charAt(left);

                    if(m.containsKey(cl)){
                        m.put(cl, m.get(cl)+1);
                        if(m.get(cl)==1) count++;

                        if(right - left + 1 < minLen){
                            minLen = right - left + 1;
                            i = left;
                            j = right;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        // If no valid window is found
        if(minLen==Integer.MAX_VALUE) return "";
        return s.substring(i, j+1);
    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        String ans = solve(s1, t1);
        System.out.println("The minimum window substring of s such that every character in t(including duplicates) is included in the window is => " + ans.length() + "  \"" + ans +"\"");
    }

}

