package dsa.slidingWindow.variable;

import java.util.HashMap;
import java.util.Map;

public class PickToys {
//    Each char in string represent a type of toy
//     Max two type of toys can be selected
//     Choose toys in a continuous manner
//     aabcabbacc  -> abba
//     How many max toys can you pick considering above conditions

    public static String pickToys(String toys) {
        if (toys.length() <= 2) return toys;
        int left = 0;
        int right = 0;

        Map<Character, Integer> m = new HashMap<>();
        int i = -1;
        int j = -1;

        while (right < toys.length()) {
            char cr = toys.charAt(right);
            m.put(cr, m.getOrDefault(cr, 0) + 1);

            if (m.size() == 2) {
                if (right - left + 1 > (j - i)) {
                    i = left;
                    j = right;
                }
            } else {
                while (m.size() > 2 && left <= right) {
                    char cl = toys.charAt(left);
                    m.put(cl, m.get(cl) - 1);
                    if (m.get(cl) == 0) m.remove(cl);
                    left++;
                }
//                Check possibility of answer if currSum equals sum
                if (m.size() == 2 && (right - left) > (j - i)) {
                    i = left;
                    j = right;
                }
            }
//            Otherwise increasing window size (also in case of m.size() < k)
            right++;
        }

        if( i == -1 && j == -1) return "";
        return toys.substring(i, j + 1);
    }

    private static void solve(String toys) {
        System.out.println("Input: \"" + toys + "\"");
        String output = pickToys(toys);
        System.out.println("Output: \"" + output + "\"  count = " + output.length() + " \n");
    }

    public static void main(String[] args) {
        String toys = "daabcabbaccd";
        solve(toys);

        toys = "aaaaaa";
        solve(toys);
    }
}
