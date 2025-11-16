/**
 * House Robber
 * https://neetcode.io/problems/house-robber
 *
 * You are given an integer array nums where nums[i] represents the amount of money the ith house has. The houses are arranged in a straight line, i.e. the ith house is the neighbor of the (i-1)th and (i+1)th house.
 *
 * You are planning to rob money from the houses, but you cannot rob two adjacent houses because the security system will automatically alert the police if two adjacent houses were both broken into.
 *
 * Return the maximum amount of money you can rob without alerting the police.
 *
 * Example 1:
 * Input: nums = [1,1,3,3]
 * Output: 4
 * Explanation: nums[0] + nums[2] = 1 + 3 = 4.
 * Example 2:
 * Input: nums = [2,9,8,3,6]
 * Output: 16
 * Explanation: nums[0] + nums[2] + nums[4] = 2 + 8 + 6 = 16.
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return nums[0];
        }

        int prevMax = nums[0];
        int curMax = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++) {
            int val = Math.max(
                curMax,
                prevMax + nums[i]
            );

            prevMax = curMax;
            curMax = val;
        }

        return curMax;
    }
}

// TC: O(N)
// SC: O(1)

class Solution0 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return nums[0];
        }

        if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++) {
            dp[i] = Math.max(
                dp[i-1],
                dp[i-2] + nums[i]
            );
        }

        return dp[n-1];
    }
}
