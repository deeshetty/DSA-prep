// https://leetcode.com/problems/two-sum/description/

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]
 

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.

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