/**
 * Problem: 1004-LC-Max Consecutive Ones III (LeetCode 1004)
 * Link: https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * Given a binary array nums and integer k, return the maximum consecutive 1's if you can flip at most k zeros.
 *
 * Examples:
 *   Example 1:
 *     Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 *     Output: 6
 *     Explanation: By flipping two zeros (shown below), we can form [1,1,1,0,0,1,1,1,1,1,1]; the longest window of 1's has length 6.
 *
 *   Example 2:
 *     Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 *     Output: 10
 *
 * Constraints:
 *   1 <= nums.length <= 10^5
 */

// User function Template for Java

class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int cnt = 0;
        int i = 0;

        for(int j=0; j<nums.length; j++) {
            if(nums[j] == 0) {
                cnt++;
            }

            while(cnt > k && i<=j) {
                if(nums[i] == 0) {
                    cnt--;
                }
                i++;
            }

            ans = Math.max(ans, j-i+1);
        }

        return ans;
    }
}

// TC: O(N)
// SC: O(1)

/*
 * Approach:
 *   Sliding window maintaining count of zeros in the window; shrink left when zero_count > k.
 *
 * Complexity:
 *   Time: O(n)
 *   Space: O(1)
 */