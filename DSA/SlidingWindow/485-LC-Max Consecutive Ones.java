/**
 * Problem: 485-LC-Max Consecutive Ones (LeetCode 485)
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Examples:
 *   nums = [1,1,0,1,1,1] -> 3
 *  Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 *   nums = [1,0,1,1,0,1] -> 2
 *
 * Constraints:
 *   1 <= nums.length <= 10^5
 *  nums[i] is either 0 or 1.
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int i = 0;

        for(int j = 0; j<nums.length; j++) {
            if(nums[j] == 0) {
                i = j+1;
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
 *   Single-pass count reset when encountering zero; keep track of max length.
 *
 * Complexity:
 *   Time: O(n)
 *   Space: O(1)
 */