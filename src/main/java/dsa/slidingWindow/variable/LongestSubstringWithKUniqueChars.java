package dsa.slidingWindow.variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChars {

//    Given a string s and an integer k,
//    return the length of the longest substring such that
//    the substring has all unique characters i.e. no repeating characters.
    public static String solve(String str, int k){
        if (str.isEmpty() || k > str.length()) return "";
        int left=0;
        int right=0;

        Map<Character, Integer> m = new HashMap<>();
        int i=0;
        int j=0;

        while(right < str.length()){
            char cr = str.charAt(right);
            m.put(cr, m.getOrDefault(cr, 0)+1);

            if(m.size() == k){
                if(right - left > j - i){
                    i=left;
                    j=right;
                }
            } else {
                while(m.size() > k && left <= right){
                    char cl = str.charAt(left);
                    m.put(cl, m.get(cl)-1);
                    if(m.get(cl)==0) m.remove(cl);
                    left++;
                }
                //Check possibility of answer if currSum equals sum
                if(m.size() == k && (right - left) > (j - i) ){
                    i=left;
                    j=right;
                }
            }
            //Otherwise increasing window size (also in case of m.size() < k)
            right++;
        }

        return str.substring(i, j+1);
    }

    public static void main(String[] args) {
        String str = "dxaaabcayz";
        ArrayList<String> strList = new ArrayList<>(Arrays.asList( "dxaaabcayz" ,"cxadabbc"));
        int k=3;
        strList.stream()
                .map( s -> solve(s, k))
                .forEach( ans -> System.out.println("Longest substring with k unique characters is " + ans));

    }


}
