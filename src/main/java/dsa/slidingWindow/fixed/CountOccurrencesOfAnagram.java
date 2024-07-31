package dsa.slidingWindow.fixed;

import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurrencesOfAnagram {

//    Given a word and a text,
//    return the count of the occurrences of anagrams of the word in the text
//    For eg: anagrams of word for are for, ofr, rof etc.

//    Input : forxxorfxdofr & for
//    Output : 3

//    Input : aabaabaa & aaba
//    Output : 4

    public static int countAnagrams(String str, String pattern) {
        int k = pattern.length();
        int left = 0;
        int right = 0;
        int ans = 0;
//        Creating map of pattern
        Map<Character, Integer> m = pattern.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        c -> c,
                        c -> 1,
                        Integer::sum));

//        Creating a variable which stores number of unique characters in pattern so that we don't have to iterate through map again and again
        int count = m.size();


        while (right < str.length()) {
//            Adding calculations of right pointer
            Character cr = str.charAt(right);
            if (m.containsKey(cr)) {
                m.put(cr, m.get(cr) - 1);
                if (m.get(cr) == 0) count--;
            }

//            Slide window
            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                //Calculating ans
                if (count == 0) ans++;
                //Removing calculations of left pointer
                Character cl = str.charAt(left);
                if (m.containsKey(cl)) {
                    m.put(cl, m.get(cl) + 1);
                    if (m.get(cl) == 1) count++;
                }
                left++;
                right++;
            }
        }
        return ans;
    }

    private static void solve(String word, String pattern){
        System.out.println("Count of Anagrams of \"" + pattern + "\" in \"" + word
                + "\" : " + countAnagrams(word, pattern));
    }

    public static void main(String[] args) {
        String word = "aabaabaa";
        String pattern = "aaba";
        solve(word, pattern);

        word = "forxxorfxdofr";
        pattern = "for";
        solve(word, pattern);
    }

}
