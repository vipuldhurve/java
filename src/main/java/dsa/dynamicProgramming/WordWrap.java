package dsa.dynamicProgramming;

import java.util.Arrays;

public class WordWrap {
//    Given an array words[] of size n,
//    where words[i] denotes the number of characters in one word.

//    Let K be the limit on the number of characters that can be put in one line (line width).

//    Put line breaks in the given sequence such that the lines are printed neatly.
//    Assume that the length of each word is smaller than the line width.

//    When line breaks are inserted there is a possibility that extra spaces are present in each line.
//    The extra spaces include spaces put at the end of every line except the last one.

//    The task is to minimize the following total cost
//    where total cost = Sum of cost of all lines,
//    where the cost of the line is = (Number of extra spaces in the line)^2.

    static int dp[][];

    private static int wordWrap(int[] words, int index, int spaces, int remainingSpaces) {
        // BASE CASE: If only one word left
        if (index == words.length - 1) {
            // CASE 1: If word can fit in same line
            // CASE 2: If word should be placed in next line add cost of current line
            return words[index] < remainingSpaces ? 0 : square(remainingSpaces);
        }

        if (dp[index][remainingSpaces] != Integer.MAX_VALUE) return dp[index][remainingSpaces];

        int currWord = words[index];
        // 2 options -> add in same line or next line
        if (currWord < remainingSpaces) {
            return dp[index][remainingSpaces] = Math.min(
                    // if word is kept on same line
                    // CASE 1: remainingSpaces == spaces i.e. currWord is first word in line -> [currWord]
                    // CASE 2: remainingSpaces < spaces i.e. current line has words -> [abc + " " + currWord]
                    wordWrap(words, index + 1, spaces, remainingSpaces == spaces ? spaces - currWord : remainingSpaces - currWord - 1),
                    // if word is kept in next line
                    // add current line cost
                    square(remainingSpaces) + wordWrap(words, index + 1, spaces, spaces - currWord)
            );
        } else
            return dp[index][remainingSpaces] = square(remainingSpaces) + wordWrap(words, index + 1, spaces, spaces - currWord);
    }

    private static int square(int num) {
        return num * num;
    }

    private static void solve(int[] words, int lineLength) {
        System.out.println("INPUT:   words = " + Arrays.toString(words) + "    Line length = " + lineLength);
        dp = new int[words.length + 1][lineLength + 1];
        for (int[] ints : dp) Arrays.fill(ints, Integer.MAX_VALUE);
        System.out.println("OUTPUT: " + wordWrap(words, 0, lineLength, lineLength) + "\n");
    }

    public static void main(String[] args) {
        int[] words = new int[]{3, 2, 2, 5};
        int lineLength = 6;
        solve(words, lineLength);

        words = new int[]{3, 2, 2};
        lineLength = 4;
        solve(words, lineLength);
    }
}

