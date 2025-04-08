package dsa.array;

import dsa.util.Printer;

import java.util.*;

public class GroupAnagrams {

//    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

//    Input: strs = [""]
//    Output: [[""]]

//    Input: strs = ["a"]
//    Output: [["a"]]

//    Constraints:
//    1 <= strs.length <= 10^4
//    0 <= strs[i].length <= 100
//    strs[i] consists of lowercase English letters.

    //    TIME COMPLEXITY: O(M*NlogN)   |   SPACE COMPLEXITY: O(M*N)
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] carr = s.toCharArray();
            Arrays.sort(carr);
            String key = new String(carr);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> strArr = new ArrayList<>();
                strArr.add(s);
                map.put(key, strArr);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[][] input = new String[][]{
                {"eat","tea","tan","ate","nat","bat"},
                {""},
                {"a"}
        };

        Arrays.stream(input)
                .peek(i -> {
                    System.out.println("INPUT: ");
                    Printer.printStringArray(i);
                })
                .map(GroupAnagrams::groupAnagrams)
                .forEach(output -> {
                    System.out.println("OUTPUT: ");
                    output.stream().forEach(o -> {
                        System.out.print("[ ");
                        o.forEach( s -> System.out.print(s + " "));
                        System.out.println("]");
                    });
                    System.out.println();
                });
    }
}
