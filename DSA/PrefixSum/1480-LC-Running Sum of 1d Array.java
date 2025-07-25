// https://leetcode.com/problems/running-sum-of-1d-array/description/?envType=problem-list-v2&envId=prefix-sum

// Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

// Return the running sum of nums.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [1,3,6,10]
// Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
// Example 2:

// Input: nums = [1,1,1,1,1]
// Output: [1,2,3,4,5]
// Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
// Example 3:

// Input: nums = [3,1,2,10,1]
// Output: [3,4,6,16,17]
 

// Constraints:

// 1 <= nums.length <= 1000
// -10^6 <= nums[i] <= 10^6

class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int latestSum = 0;
        for(int i=0; i<n; i++) {
            latestSum += nums[i];
            arr[i] = latestSum;
        }

        return arr;
    }
}
TC: O(N)
SC: O(N)

// If we are allowed to modify the input array, we can do it in O(1) space:
// class Solution {
//     public int[] runningSum(int[] nums) {
//         for (int i = 1; i < nums.length; i++) {
//             nums[i] += nums[i - 1];
//         }
//         return nums;
//     }
// }

// TC: O(N)
// SC: O(1)