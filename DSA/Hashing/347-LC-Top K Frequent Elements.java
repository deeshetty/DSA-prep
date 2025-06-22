// https://leetcode.com/problems/top-k-frequent-elements/description/

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1 && k == 1) {
            return new int[]{nums[0]};
        }

        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        List<Map.Entry<Integer, Integer>> ls = new ArrayList<>(hm.entrySet());
        ls.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        int[] ans = new int[k];

        for(int i= 0; i<k; i++) {
            ans[i]= ls.get(i).getKey();
        }

        return ans;
    }
}

TC: O(N log N) -> the sorting step dominates
SC: O(N)