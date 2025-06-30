// https://leetcode.com/problems/next-greater-element-i/description/

// The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

// Example 1:

// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// Example 2:

// Input: nums1 = [2,4], nums2 = [1,2,3,4]
// Output: [3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
// - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 

// Constraints:

// 1 <= nums1.length <= nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 104
// All integers in nums1 and nums2 are unique.
// All the integers of nums1 also appear in nums2.

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums1.length; i++) {
            hm.put(nums1[i], i);
        }

        Stack<Integer> st = new Stack<>();

        int n = nums2.length;
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if(hm.containsKey(nums2[i])) {
                int val = hm.get(nums2[i]);
                res[val] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums2[i]);
        }

        return res;
    }
}

// Time Complexity: O(n + m), where n is the length of nums1 and m is the length of nums2.
// Space Complexity: O(n + m) for the HashMap and Stack.

// Use Deque<Integer> (ArrayDeque) instead of Stack for better performance, but Stack is fine

//Note:
// I use a stack to keep track of the "next greater" elements as I scan nums2 from right to left.
// For each number in nums2, I pop from the stack until I find something bigger (or the stack is empty).
// If the current number is in nums1, I record the top of the stack as its next greater (or -1 if the stack is empty).
// I use a HashMap to quickly map each value in nums1 to its index in the result array.
// This way, I can answer all queries in one pass, and everything runs fast!