// https://leetcode.com/problems/binary-search/description/

// Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4
// Example 2:

// Input: nums = [-1,0,3,5,9,12], target = 2
// Output: -1
// Explanation: 2 does not exist in nums so return -1
 

// Constraints:

// 1 <= nums.length <= 104
// -104 < nums[i], target < 104
// All the integers in nums are unique.
// nums is sorted in ascending order.

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left < right) {
            int mid = (left + (right - left) / 2);
            if(nums[mid] >= target) { //this handles duplicates as well, helping us find the leftmost index
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return nums[left] == target ? left : -1;
    }
}
//TC: O(log n)
//SC: O(1)

//Intuition:
// The array is sorted, so we can use binary search to find the target.
// if if(nums[mid] >= target) passes, it means we might have found the target or it might be to the left of mid, so we move right to mid.
// this handles duplicates as well, helping us find the leftmost index.