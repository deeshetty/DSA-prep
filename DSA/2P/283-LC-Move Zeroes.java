// https://leetcode.com/problems/move-zeroes/description/

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
 

// Follow up: Could you minimize the total number of operations done?

class Solution {
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int zeroIdx = 0;

        int i=0;
        while(i < n) {
            if(nums[i] != 0) {
                swap(nums, zeroIdx, i);
                zeroIdx++;
            }
            i++;
        }
    }
}

//TC: O(N)
//SC: O(1)