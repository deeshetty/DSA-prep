// https://leetcode.com/problems/koko-eating-bananas/description/

// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

// Return the minimum integer k such that she can eat all the bananas within h hours.

 

// Example 1:

// Input: piles = [3,6,7,11], h = 8
// Output: 4
// Example 2:

// Input: piles = [30,11,23,4,20], h = 5
// Output: 30
// Example 3:

// Input: piles = [30,11,23,4,20], h = 6
// Output: 23
 

// Constraints:

// 1 <= piles.length <= 104
// piles.length <= h <= 109
// 1 <= piles[i] <= 109


class Solution {
    private boolean isFeasible(int[] piles, int h, int cur) {
        int total = 0;
        // for(int pile : piles) {
        //    total += pile / cur;
        //    if(pile % cur != 0) {
        //     total++;
        //    }
        // }
        for(int pile : piles) {
           total += (pile + cur - 1) / cur;
        }

        return total <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(isFeasible(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

//TC: O(N log M)
//SC: O(1)
// where N is the number of piles and M is the maximum number of bananas in a pile

// Why O(n log M)?

// The binary search runs in O(log M) iterations (since the search space is from 1 to M).
// For each iteration, you check if Koko can eat all bananas at speed mid in h hours, which takes O(n) time (one pass through piles).
// So, total time is O(n log M).
// Summary:

// O(n) for finding the max is a one-time cost.
// The main loop is O(n log M)