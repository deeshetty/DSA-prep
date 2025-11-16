/**
 * Problem: 643-LC-Maximum Average Subarray (LeetCode 643)
 * Link: https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * Given nums and k, find the contiguous subarray of length k with the maximum average value.
 *
 * Examples:
 *   Input: nums = [1,12,-5,-6,50,3], k = 4 -> 12.75
 *  Explanation: [12,-5,-6,50] has the maximum average 12.75
 *   Input: nums = [5], k = 1 -> 5.0
 *
 * Constraints:
 *   n == nums.length
 *   1 <= k <= n <= 10^5
 *   -10^4 <= nums[i] <= 10^4
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Integer.MIN_VALUE;
        int left = 0;
        double sum = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            if(right - left + 1 > k) {
                sum-=nums[left];
                left++;
            }

            if(right-left+1 == k) {
                ans = Math.max(ans, sum/k);
            }
        }

        return ans;
    }
}

// TC: O(N)
// SC: O(1)

/*
 * Approach:
 *   Sliding window of fixed size k: maintain running sum and update answer when window size == k.
 *
 * Complexity:
 *   Time: O(n)
 *   Space: O(1)
 */