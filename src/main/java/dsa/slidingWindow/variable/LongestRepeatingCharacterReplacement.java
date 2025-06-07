package dsa.slidingWindow.variable;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {

//    You are given a string s and an integer k.
//    You can choose any character of the string
//    and change it to any other uppercase English character.
//    You can perform this operation at most k times.

//    Return the length of the longest substring containing the same letter
//    you can get after performing the above operations.

//    Example 1:
//    Input: s = "ABAB", k = 2
//    Output: 4
//    Explanation: Replace the two 'A's with two 'B's or vice versa.

//    Example 2:
//    Input: s = "AABABBA", k = 1
//    Output: 4
//    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//    The substring "BBBB" has the longest repeating letters, which is 4.
//    There may exists other ways to achieve this answer too.


    public static int characterReplacement(String s, int k) {
        int start=0, end=0, maxFreq=0, maxLen=0;
        int[] m = new int[26];

        while(end < s.length()){
            Character c = s.charAt(end);
            m[c - 'A']++;
            maxFreq = Math.max(maxFreq, m[c - 'A']);
            // changesRequired = (end-start+1) - maxFreq
            if((end-start+1) - maxFreq > k){
                m[s.charAt(start) - 'A']--;
                start++;
            }

            // changesRequired <= k
            maxLen = Math.max(maxLen, end-start+1);
            end++;
        }
        return maxLen;
    }



    private static void solve(String str, int k) {
        System.out.println("Input: \"" + str + "\"  k = " + k);
        System.out.println("Output: " + characterReplacement(str, k) + "\n");
    }

    public static void main(String[] args) {
        String str = "ABAB";
        int k = 2;
        solve(str, k);

        str = "AAABABBA";
        k = 1;
        solve(str, k);
    }
}
