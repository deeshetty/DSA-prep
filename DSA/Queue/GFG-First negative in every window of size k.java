// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

// Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

// Note: If a window does not contain a negative integer, then return 0 for that window.

// Examples:

// Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
// Output: [-8, 0, -6, -6]
// Explanation:
// Window [-8, 2] First negative integer is -8.
// Window [2, 3] No negative integers, output is 0.
// Window [3, -6] First negative integer is -6.
// Window [-6, 10] First negative integer is -6.
// Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28] , k = 3
// Output: [-1, -1, -7, -15, -15, 0] 
// Explanation:
// Window [12, -1, -7] First negative integer is -1.
// Window [-1, -7, 8] First negative integer is -1.
// Window [-7, 8, -15] First negative integer is -7.
// Window [8, -15, 30] First negative integer is -15.
// Window [-15, 30, 16] First negative integer is -15.
// Window [30, 16, 28] No negative integers, output is 0.
// Input: arr[] = [12, 1, 3, 5] , k = 3
// Output: [0, 0] 
// Explanation:
// Window [12, 1, 3] No negative integers, output is 0.
// Window [1, 3, 5] No negative integers, output is 0.

// Constraints:
// 1 <= arr.size() <= 106
// -105 <= arr[i] <= 105
// 1 <= k <= arr.size()

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        
        Deque<Integer> q = new ArrayDeque<>();
        
        int l = 0;
        int r = 0;
        
        while(r < n) {
            
            if(arr[r] < 0) {
                q.addLast(r);
            }
            
            if(!q.isEmpty() && q.peekFirst() < l) {
                q.pollFirst();
            }
            
            if(r-l+1 == k) {
                ans.add(q.isEmpty() ? 0 : arr[q.peekFirst()]);
                l++;
            }
            
            r++;
        }
        
        return ans;
    }
}
//TC: O(N)
//SC: O(K) as deque stores indices of negative numbers in the current window, at max k indices

// As I slide a window of size k across the array, I keep a queue of indices of negative numbers that are inside the current window.
// Whenever the window moves forward, I remove indices from the front of the queue if they’re no longer in the window.
// For each window, if the queue isn’t empty, the first index in the queue points to the first negative number in that window—otherwise, there’s no negative, so I add 0.
// This way, I always know the first negative number for every window in one pass!