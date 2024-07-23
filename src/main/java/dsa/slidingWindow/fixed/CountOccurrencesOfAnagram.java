package dsa.slidingWindow.fixed;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurrencesOfAnagram {

    public static int solve(String str, String pattern){
        int k = pattern.length();
        int left=0;
        int right=0;
        int ans=0;
        //Creating map of pattern
        Map<Character, Integer> m = new HashMap<>();
        m = pattern.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        c -> c,
                        c -> 1,
                        Integer::sum));
//        for(int i=0; i<pattern.length(); i++){
//            m.put(pattern.charAt(i) ,m.getOrDefault(pattern.charAt(i), 0) + 1);
//        }

        // Creating a variable which stores number of unique characters in pattern so that we don't have to iterate through map again and again
        int count = m.size();


        while(right < str.length()){
            //Adding calculations of right pointer
            Character cr = str.charAt(right);
            if(m.containsKey(cr)){
                m.put(cr , m.get(cr) - 1);
                if(m.get(cr) == 0) count--;
            }

            //Slide window
            if(right - left + 1 < k){
                right++;
            } else if(right - left + 1 == k){
                //Calculating ans
                if(count==0) ans++;
                //Removing calculations of left pointer
                Character cl = str.charAt(left);
                if(m.containsKey(cl)){
                    m.put(cl , m.get(cl) + 1);
                    if(m.get(cl) == 1) count++;
                }
                left++;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabaabaa";
        String pattern = "aaba";
        System.out.println("Number of Anagrams of " + pattern + " in " + str + " is " + solve(str, pattern));
    }

}
