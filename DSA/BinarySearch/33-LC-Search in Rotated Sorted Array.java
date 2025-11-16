/**
 * Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
 * (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * Constraints:
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        if(n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = n-1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[left] <= nums[mid]) { //left half is sorted
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {                      //right half is sorted
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return nums[left] == target ? left : -1;
    }
}

//TC: O(log n)
//SC: O(1)

// At every step, you look at the middle of your current search range.
// One half (left or right) will always be sorted (in order).
// You check: is the target in this sorted half?
// If yes, you search there (shrink your range to that half).
// If not, you search in the other half (the rotated/unsorted part).
// You keep repeating this, shrinking your search space, until you find the target or run out of options.
// Why does this work?
// Because even though the array is rotated, at least one half is always sorted, so you can use that to decide where to search next.

// In short:

// Find which half is sorted.
// If the target is in the sorted half, search there.
// Otherwise, search the other half.
// Repeat until you find the target or finish searching.
// This lets you find the target in O(log n) time, just like regular binary search!