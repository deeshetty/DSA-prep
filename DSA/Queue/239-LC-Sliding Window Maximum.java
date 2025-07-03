// https://leetcode.com/problems/sliding-window-maximum/description/

// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

 

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if(n < k) {
            return new int[] {};
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] ans = new int[n-k+1];
        int i = 0;

        for(int j=0; j<n; j++) {
            pq.offer(nums[j]);

            if(pq.size() > k) {
                pq.remove(nums[j-k]);
            }

            if(pq.size() == k) {
                ans[i++] = pq.peek();
            }
        }

        return ans;
    }
}

//This solution uses a max-heap (priority queue) to keep track of the maximum elements in the current sliding window of size k. The time complexity is O(N log k) due to the heap operations, where N is the length of the input array nums. The space complexity is O(k) for storing the elements in the heap.
//This approach is efficient for the sliding window maximum problem, especially when k is small relative to n. However, if k is large or if the input array is very large, this solution may not be optimal due to the overhead of maintaining the heap.
//An alternative approach using a deque (double-ended queue) can achieve O(N) time complexity, which is more efficient for larger inputs. Here's how that would look:

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();

        int l = 0;
        int r = 0;
        int n = nums.length;

        int[] ans = new int[n-k+1];

        while(r < n) {
            while(!q.isEmpty() && nums[r] > q.peekLast()) {
                q.pollLast();
            }

            q.addLast(nums[r]);

            if(r-l+1 == k) {
                ans[l] = q.peekFirst();

                if(nums[l] == q.peekFirst()) {
                    q.pollFirst();
                }

                l++;
            }
            r++;
        }

        return ans;
    }
}

//Here we store array elements in deque

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();

        int l = 0;
        int r = 0;
        int n = nums.length;

        int[] ans = new int[n-k+1];

        while(r < n) {
            while(!q.isEmpty() && nums[r] > nums[q.peekLast()]) {
                q.pollLast();
            }

            q.addLast(r);

            if (q.peekFirst() < l) {
                q.pollFirst();
            }

            if(r-l+1 == k) {
                ans[l] = nums[q.peekFirst()];

                l++;
            }
            r++;
        }

        return ans;
    }
}

//here we store indexes in deque to handle duplicates