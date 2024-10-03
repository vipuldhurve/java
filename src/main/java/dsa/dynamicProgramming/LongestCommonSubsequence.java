package dsa.dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
//    Given two strings text1 and text2,
//    return the length of their longest common subsequence.
//    If there is no common subsequence, return 0.

//    A subsequence of a string is a new string generated from the original string
//    with some characters (can be none) deleted without changing the relative order of the remaining characters.

//    For example, "ace" is a subsequence of "abcde".
//    A common subsequence of two strings is a subsequence that is common to both strings.

    static int[][] dp;

    private static int longestCommonSubsequence(String s1, String s2, int m, int n) {
        // BASE CASE: If either of string has 0 characters then lcs will be 0
        if (m == 0 || n == 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];
        // If character match
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) return dp[m][n] = 1 + longestCommonSubsequence(s1, s2, m - 1, n - 1);
        // Check for other combinations if character doesn't match
        return dp[m][n] = Math.max(longestCommonSubsequence(s1, s2, m - 1, n), longestCommonSubsequence(s1, s2, m, n - 1));
    }

    private static void solve(String s1, String s2) {
        System.out.println("INPUT:  \"" + s1 + "\" and \"" + s2 + "\"");
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        System.out.println("OUTPUT: " + longestCommonSubsequence(s1, s2, s1.length(), s2.length()) + "\n");
    }

    public static void main(String[] args) {
        String[][] input = new String[][]{
                {"abcde", "ace"},
                {"abc", "abc"},
                {"abc", "def"}
        };

        Arrays.stream(input).forEach(i -> solve(i[0], i[1]));
    }
}
