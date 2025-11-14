// https://leetcode.com/problems/maximum-subarray/description/

// Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
 

// Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

class Solution {

    // private int compute(int[] arr, int idx, int sum) {
    //     if(idx == -1) {
    //         return sum;
    //     }

    //     max = Math.max(max, sum+arr[idx]);

    //     int pick = compute(arr, idx-1, sum+arr[idx]);
    //     int notPick = compute(arr, idx-1, sum);

    //     int curMax = Math.max(pick, notPick);
    //     max = Math.max(max, curMax);

    //     return curMax;
    // }

    private int compute(int[] arr, int idx, int[] dp) {
        if(idx == 0) {
            return dp[0] = arr[0];
        }

        if(dp[idx] == -1) {
            int prev = compute(arr, idx-1, dp);

            int curMax = Math.max(prev + arr[idx], arr[idx]);

            dp[idx] = curMax;

            return curMax;
        } else {
            return dp[idx];
        }
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return nums[0];
        }

        int max = nums[0];

        int prev = nums[0];
        int cur;

        for(int i=1; i<n; i++) {
            cur = Math.max(
                nums[i],
                nums[i] + prev
            );

            max = Math.max(max, cur);

            prev = cur;            
        }

        return max;
    }
}