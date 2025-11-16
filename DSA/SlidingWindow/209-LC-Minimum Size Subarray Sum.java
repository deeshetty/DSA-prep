/**
 * Problem: 209-LC-Minimum Size Subarray Sum (LeetCode 209)
 * Link: https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal
 * length of a subarray whose sum is >= target. Return 0 if no such subarray exists.
 *
 * Examples:
 *   Input: target = 7, nums = [2,3,1,2,4,3] -> Output: 2 ([4,3])
 *   Input: target = 4, nums = [1,4,4] -> Output: 1
 *   Input: target = 11, nums = [1,1,1,1,1,1,1,1] -> Output: 0
 *
 * Constraints:
 *   1 <= target <= 10^9
 *   1 <= nums.length <= 10^5
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int i = 0;

        for(int j=0; j<nums.length; j++) {
            sum+=nums[j];

            while(sum>=target && i<=j) {
                ans = Math.min(ans, j-i+1);
                sum-=nums[i];
                i++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

// TC: O(N)
// SC: 0(1)

/*
 * Approach:
 *   Sliding window / two pointers. Expand right pointer, accumulate sum, then shrink left while >= target to
 *   track minimal window size.
 *
 * Complexity:
 *   Time: O(n)
 *   Space: O(1)
 */