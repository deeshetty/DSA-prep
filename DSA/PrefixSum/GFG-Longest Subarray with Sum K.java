/**
 * Longest Subarray with Sum K (GFG)
 * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
 *
 * Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.
 *
 * Examples:
 * Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
 * Output: 6
 * Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
 * Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
 * Output: 5
 * Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
 * Input: arr[] = [10, -10, 20, 30], k = 5
 * Output: 0
 * Explanation: No subarray with sum = 5 is present in arr[].
 *
 * Constraints:
 * 1 <= arr.size() <= 105
 * -104 <= arr[i] <= 104
 * -109 <= k <= 109
 */

class Solution {
    public int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>(); //storing the prefix sum and the first index where it occurs
        // we use a map to store the prefix sum and its first occurrence index
        hm.put(0, -1);
        
        int n = arr.length;
        int ans = 0;
        
        int prefSum = 0;
        for(int i=0; i<n; i++) {
            prefSum += arr[i];
            
            if(hm.containsKey(prefSum - k)) {
                int curAns = i - hm.get(prefSum - k);
                ans = Math.max(ans, curAns);
            }
            
            hm.putIfAbsent(prefSum, i); //otherwise, it will update the index each time the same prefix sum if found, thereby losing the previous index which is needed to calculate the length of the subarray
        }
        
        return ans;
    }
}

// TC: O(N)
// SC: O(N) for the hashmap
