package dsa.binarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
//    Koko loves to eat bananas.
//    There are n piles of bananas, the ith pile has piles[i] bananas.
//    The guards have gone and will come back in h hours.

//    1. Koko can decide her bananas-per-hour eating speed of k.
//    2. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
//    3. If the pile has less than k bananas, she eats all of them instead
//    and will not eat any more bananas during this hour.

//    Koko likes to eat slowly but still wants to finish eating all the bananas
//    before the guards return.

//    Return the minimum integer k such that she can eat all the bananas
//    within h hours.

//    Input: piles = [1,4,3,2], h = 9
//    Output: 2

//    Input: piles = [25,10,23,4], h = 4
//    Output: 25


    private static int findMax(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) maxPile = Math.max(maxPile, pile);
        return maxPile;
    }

    private static int calculateTotalHours(int[] piles, int speed) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += Math.ceil((double) pile / (double) speed);
        }
        return totalHours;
    }

    private static int minEatingSpeed(int[] piles, int hours) {
        int n = piles.length;
//        if there are 4 piles koko will need at least 4 i.e. piles.length hours
//        according to banana eating strategy
//        if h hours is less than no. of piles
//        it is not possible to finish in h hours
        if (n == 0 || hours <= 0 || hours < n) return -1;
        int low = 1;
        int high = findMax(piles);
//        if we have hours equal no. of piles
//        we can get min eating speed of max-pile value
        if (hours == n) return high;
        System.out.println(high);
        while (low <= high) {
//            Calculate mid-speed and optimize to find min
            int mid = low + (high - low) / 2;
            System.out.println("low: " + low + "  high: " + high + "  mid: " + mid);
//            Calculate totalHours taken with speed = mid
            int totalHours = calculateTotalHours(piles, mid);
//            Find minimum speed if a valid speed found
            if (totalHours <= hours) high = mid - 1;
            else low = mid + 1;
        }
//        We can also use an ans variable to store valid speed
//        and then optimize to minimum valid speed
//        But if we observe min speed will always be in low
        return low;
    }

    private static void solve(int[] piles, int hours) {
        System.out.println("Banana Piles: [" + Arrays.toString(piles) + "]  hours = " + hours);
        System.out.println("Minimum Speed: "
                + minEatingSpeed(piles, hours) + "\n");
    }

    public static void main(String[] args) {
        int[] piles = new int[]{1, 4, 3, 2};
        int hours = 9;
        solve(piles, hours);

//        piles = new int[]{25, 10, 23, 4};
//        hours = 25;
//        solve(piles, hours);
//
//        piles = new int[]{3, 6, 7, 11};
//        hours = 8;
//        solve(piles, hours);
//
//        piles = new int[]{30, 11, 23, 4, 20};
//        hours = 5;
//        solve(piles, hours);
//
////        piles = {30,11,23,4,20};
//        hours = 6;
//        solve(piles, hours);
    }
}
