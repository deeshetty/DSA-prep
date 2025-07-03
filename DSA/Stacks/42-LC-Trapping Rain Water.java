// https://leetcode.com/problems/trapping-rain-water/description/

// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n < 3) {
            return 0;
        }

        int[] prefMax = new int[n];
        int[] sufMax = new int[n];
        int ans = 0;

        prefMax[0] = height[0];
        sufMax[n-1] = height[n-1];

        for(int i=1; i<n; i++) {
            prefMax[i] = Math.max(prefMax[i-1], height[i]);
        }

        for(int i=n-2; i>=0; i--) {
            sufMax[i] = Math.max(sufMax[i+1], height[i]);
        }

        for(int i=0; i<n; i++) {
            ans += Math.min(prefMax[i], sufMax[i]) - height[i];
        }

        return ans;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
// Note: This solution uses two auxiliary arrays to store the maximum heights to the left and right of each index.

class Solution1 {
    public int trap(int[] height) {
        int n = height.length;

        if(n < 3) {
            return 0;
        }

        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        int ans = 0;

        for(int i=1; i<n; i++) {
            while(!st.isEmpty() && height[st.peek()] < height[i]) {
                int poppedIdx = st.pop();
                if(!st.isEmpty()) {
                    int width = i - st.peek() - 1;
                    int minBarrier = Math.min(height[i], height[st.peek()]);

                    ans += width * (minBarrier - height[poppedIdx]);
                }
            }
            st.push(i);
        }

        return ans;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for the stack
// Note: This solution uses a stack to keep track of the indices of the bars, allowing us to calculate the trapped water efficiently as we iterate through the heights.

// I use a stack to keep track of the bars’ indices as I move through the array.
// Whenever I find a bar that’s taller than the one on top of the stack, I know I’ve found a right boundary for a “valley.”
// I pop the valley bottom from the stack, and now the new top of the stack is the left boundary.
// The water trapped above this valley is determined by the distance between the left and right boundaries, and the height is limited by the shorter of those two boundaries (minus the valley’s height).
// I keep doing this for every bar, so I end up calculating all the water that can be trapped in every pit as I go!