package dsa.slidingWindow.fixed;

import java.util.HashMap;
import java.util.Map;

public class AtmostKUniqueCharacters {


    //    TIME COMPLEXITY: O(N*N)   |   SPACE COMPLEXITY: O(N)
    private static int kUniqueCharacters(String s, int k) {
        int ans = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (!areAllKSizedSubstringValid(s, i, k)) break;
            ans = i;
        }
        return ans;
    }

    private static boolean areAllKSizedSubstringValid(String s, int windowSize, int k) {
//        window pointers
        int left = 0, right = 0;
//
        Map<Character, Integer> charFreqMap = new HashMap<>();
        while (right < s.length()) {
//            Calculation for char at right index
            Character cr = s.charAt(right);
            charFreqMap.put(cr, charFreqMap.getOrDefault(cr, 0) + 1);
//            Check if valid substring
            if (charFreqMap.size() > k) return false;
//            Move window
            if (right - left + 1 < windowSize) {
                right++;
            } else if (right - left + 1 == windowSize) {
//                Remove calculations for char at left index
                Character cl = s.charAt(left);
                charFreqMap.put(cl, charFreqMap.get(cl) - 1);
                if (charFreqMap.get(cl) == 0) charFreqMap.remove(cl);
                left++;
                right++;
            }
        }
        return true;
    }

    private static void solve(String input, int k) {
        System.out.println("INPUT: \"" + input + "\"   k = " + k);
        System.out.println("OUTPUT: " + kUniqueCharacters(input, k));
    }

    public static void main(String[] args) {
        String input = "bbaaabbaac";
        int k = 2;
        solve(input, k);
    }
}
