/**
 * Problem: Two Sum (LeetCode 1)
 * Link: https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that
 * they add up to target. You may assume exactly one solution exists and you may not use the same
 * element twice. The returned order does not matter.
 *
 * Examples:
 *  Example 1:
 *   Input: nums = [2,7,11,15], target = 9
 *   Output: [0,1]
 *   Explanation: nums[0] + nums[1] == 9
 *
 *  Example 2:
 *   Input: nums = [3,2,4], target = 6
 *   Output: [1,2]
 *
 *  Example 3:
 *   Input: nums = [3,3], target = 6
 *   Output: [0,1]
 *
 * Constraints:
 *  - 2 <= nums.length <= 10^4
 *  - -10^9 <= nums[i] <= 10^9
 *  - -10^9 <= target <= 10^9
 *  - Exactly one valid answer exists.
 */

//For sorted arrays - use 2 pointer approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[] {};
        }

        int n = nums.length;

        int left = 0;
        int right = n-1;

        while(left < right) {
            int curSum = nums[left] + nums[right];
            if(curSum == target) {
                return new int[]{
                    left,
                    right
                };
            } else if (curSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {-1, -1};
    }
}
//TC: O(N) as array is already sorted
//SC: O(1) as no extra space is used

//for handling unsorted array - without any extra space (without the use of hashmap)
class Solution {
    static class Pair {
        int val;
        int idx;
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[] {};
        }

        int n = nums.length;

        Pair[] arr = new Pair[n];

        for(int i=0; i<n; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        Arrays.sort(
            arr,
            Comparator.comparingInt(p -> p.val)
        );

        int left = 0;
        int right = n-1;

        while(left < right) {
            int curSum = arr[left].val + arr[right].val;
            if(curSum == target) {
                return new int[]{
                    arr[left].idx,
                    arr[right].idx
                };
            } else if (curSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {-1, -1};
    }
}
//TC: O(NlogN) + O(N) = O(NlogN) as we are sorting the array
//SC: O(N) as we are using extra space to store the pairs

//with extra space
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         if(nums.length == 0) {
//             return new int[] {};
//         }

//         HashMap<Integer, Integer> hm = new HashMap<>();

//         for(int i=0; i<nums.length; i++) {
//             if(hm.containsKey(nums[i])) {
//                 return new int[] {hm.get(nums[i]), i};
//             }

//             hm.put(target-nums[i], i);
//         }

//         return new int[] {};
//     }
// }

//TC: O(N) as we are traversing the array once
//SC: O(N) as we are using extra space to store the hashmap

/*
 * Approach & Complexity (revealed):
 *
 * 1) Two-pointer (sorted array): sort / or if already sorted use two pointers left/right to find sum.
 *    Time: O(N) if already sorted, O(N log N) if you sort first. Space: O(1) / O(N) if sorting requires extra.
 *
 * 2) Sorting with tracking indices: create pairs (value, index), sort by value, then use two pointers.
 *    Time: O(N log N), Space: O(N).
 *
 * 3) Hashmap (fastest for unsorted): store complement -> index while scanning; if current value exists
 *    in map, you found the pair. Time: O(N), Space: O(N).
 */