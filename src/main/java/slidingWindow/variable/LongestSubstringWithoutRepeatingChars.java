package slidingWindow.variable;

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

    public static String solve(String str){
        if (str.isEmpty()) return "";
        int left=0;
        int right=0; 

        Map<Character, Integer> m = new HashMap<>();
        int i=0;
        int j=0;

        while(right < str.length()){
            char cr = str.charAt(right);
            m.put(cr, m.getOrDefault(cr, 0)+1);

            if(m.size() == (right - left + 1) ){
                if(right - left > j - i){
                    i=left;
                    j=right;
                }
            } else {
                while(m.size() < (right - left + 1) && left <= right){
                    char cl = str.charAt(left);
                    m.put(cl, m.get(cl)-1);
                    if(m.get(cl)==0) m.remove(cl);
                    left++;
                }
                //Check possibility of answer if currSum equals sum
                if(m.size() == (right - left + 1)){
                    if(right - left > j - i){
                        i=left;
                        j=right;
                    }
                }
            }
            //Otherwise increasing window size (also in case of m.size() < k)
            right++;
        }

        return str.substring(i, j+1);
    }

    public static void main(String[] args) {
        String[] inputArr = new String[]{"dxaaabcayz", "abcabcbb", "bbbbb", "pwwkew"};
        Arrays.stream(inputArr)
                .map(LongestSubstringWithoutRepeatingChars::solve)
                .forEach( ans -> System.out.println("Longest substring size with all unique characters is \"" + ans +"\" with length = "+ ans.length()));
    }


}
