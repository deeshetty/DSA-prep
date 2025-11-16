/**
 * Problem: Top K Frequent Elements (LeetCode 347)
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Summary:
 *   Given an integer array nums and an integer k, return the k most frequent elements.
 *   The order of the returned elements does not matter.
 *
 * Examples:
 *   nums = [1,1,1,2,2,3], k = 2 -> [1,2]
 *   nums = [1], k = 1 -> [1]
 *
 * Constraints:
 *   1 <= nums.length <= 10^5
 *   -10^4 <= nums[i] <= 10^4
 *   1 <= k <= number of unique elements
 * 
 * Complexity:
 *   Bucket sort: Time O(n), Space O(n)
 *   Heap: Time O(n log k), Space O(n)
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> frequencyMap = new HashMap<>(); //SC: O(N)

        for(int i=0; i<n; i++) { //TC: O(N)
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1); //TC: O(1)
        }

        List<Integer>[] ls = new List[n];

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) { //TC: O(N)
            if(ls[entry.getValue()-1] == null) {
                ls[entry.getValue()-1] = new ArrayList();
            }

            ls[entry.getValue()-1].add(entry.getKey());
        }

        int[] ans = new int[k];
        int j = 0;
        for(int i=n-1; i>=0; i--) { //O(N)
            if(ls[i] != null && ls[i].size() > 0) {
                for(int e : ls[i]) {
                    ans[j++] = e;

                    if(j == k) { //O(K)
                        return ans;
                    }
                }
            }
        }

        return ans;
    }
}

//TC: O(N) + O(N) + O(N+K) ~ O(N)
//SC: O(N)
//Note: Bucket sort approach

// Alternative approach using Min-Heap
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> frequencyMap = new HashMap<>(); //SC: O(N)

        for(int i=0; i<n; i++) { //TC: O(N)
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1); //TC: O(1)
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue()); //SC: O(K)

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) { //TC: O(N)
            pq.offer(entry); //TC: O(logK)

            if(pq.size() > k) {
                pq.poll(); //TC: O(logK)
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()) { //TC: O(K)
            ans[i++] = pq.poll().getKey(); //O(logK)
        }

        return ans;
    }
}

//TC: O(N) + O(NlogK) + O(KlogK) ~ O(NlogK)
//SC: O(N+K) ~ O(N)

/*
 * Approaches:
 *   - Bucket sort by frequency (O(n) time, O(n) space): build frequency map, then buckets of lists by
 *     frequency and collect from highest frequency down.
 *   - Min-heap (O(n log k) time): maintain a size-k heap of entries by frequency.
 *
 * Complexity:
 *   Bucket sort: Time O(n), Space O(n)
 *   Heap: Time O(n log k), Space O(n)
 */