// https://leetcode.com/problems/find-pivot-index/description/?envType=problem-list-v2&envId=prefix-sum

// Given an array of integers nums, calculate the pivot index of this array.

// The pivot index is the index where the sum of all the numbers strictly to the left of the index 
// is equal to the sum of all the numbers strictly to the index's right.

// If the index is on the left edge of the array, then the left sum is 0 
// because there are no elements to the left. This also applies to the right edge of the array.

// Return the leftmost pivot index. If no such index exists, return -1.

 

// Example 1:

// Input: nums = [1,7,3,6,5,6]
// Output: 3
// Explanation:
// The pivot index is 3.
// Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
// Right sum = nums[4] + nums[5] = 5 + 6 = 11
// Example 2:

// Input: nums = [1,2,3]
// Output: -1
// Explanation:
// There is no index that satisfies the conditions in the problem statement.
// Example 3:

// Input: nums = [2,1,-1]
// Output: 0
// Explanation:
// The pivot index is 0.
// Left sum = 0 (no elements to the left of index 0)
// Right sum = nums[1] + nums[2] = 1 + -1 = 0
 
// Constraints:

// 1 <= nums.length <= 104
// -1000 <= nums[i] <= 1000

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = 0;

        for(int num : nums) {
            total += num;
        }

        int prev = 0;
        int prefixSum = 0;

        for(int i=0; i<n; i++) {
            prefixSum += nums[i];
            if(prev == total - prefixSum) {
                return i;
            }

            prev = prefixSum;
        }
        return -1;
    }
}

// TC: O(N)
// SC: O(1)

//Here we maintain a prefix array, but the above solution is an optimized version of it with just a variable to maintain the prefix sum and total sum.
// class Solution {
//     public int pivotIndex(int[] nums) {
//         int n = nums.length;
//         int[] ps = new int[n+2];

//         ps[0] = 0;

//         int latestSum = 0;
//         for(int i=0; i<n; i++) {
//             latestSum += nums[i];
//             ps[i+1] = latestSum;
//         }

//         ps[n+1] = latestSum;

//         for(int i=0; i<n; i++) {
//             int leftSum = ps[i];
//             int rightSum = latestSum - ps[i+1];

//             if(leftSum == rightSum) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }

// TC: O(N)
// SC: O(N)