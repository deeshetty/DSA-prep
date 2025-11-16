/**
 * Problem: 283-LC-Move Zeroes (LeetCode 283)
 * Link: https://leetcode.com/problems/move-zeroes/
 *
 * Given an integer array nums, move all 0's to the end while maintaining relative order of non-zero elements.
 * Do this in-place.
 *
 * Examples:
 *   Input: nums = [0,1,0,3,12] -> Output: [1,3,12,0,0]
 *   Input: nums = [0] -> Output: [0]
 *
 * Constraints:
 *   1 <= nums.length <= 10^4
 */

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

/*
 * Approach:
 *   Two-pointer: track position to place next non-zero and swap/assign while scanning.
 *
 * Complexity:
 *   Time: O(n)
 *   Space: O(1)
 */