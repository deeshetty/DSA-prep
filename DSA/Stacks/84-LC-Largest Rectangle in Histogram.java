// https://leetcode.com/problems/largest-rectangle-in-histogram/description/

// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

// Example 1:


// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.
// Example 2:


// Input: heights = [2,4]
// Output: 4
 

// Constraints:

// 1 <= heights.length <= 105
// 0 <= heights[i] <= 104

class Solution {
    private int[] NSR(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        ans[n-1] = n;
        st.push(n-1);

        for(int i=n-2; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return ans;
    }

    private int[] NSL(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        ans[0] = -1;

        for(int i=1; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        if(heights.length == 1) {
            return heights[0];
        }

        int n = heights.length;

        int[] nsr = NSR(heights);
        int[] nsl = NSL(heights);

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int curAns = width * heights[i];
            ans = Math.max(ans, curAns);
        }

        return ans;
    }
}

class SolutionOptimizedWithOneStack {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 1) {
            return heights[0];
        }

        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);

        int anss = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int topIdx = st.pop();
                int leftIdx = st.isEmpty() ? -1 : st.peek();
                int curAns = heights[topIdx] * (i - leftIdx - 1);
                anss = Math.max(anss, curAns);
            }

            st.push(i);
        }

        int i = n;

        while(!st.isEmpty()) {
            int topIdx = st.pop();
            int leftIdx = st.isEmpty() ? -1 : st.peek();
            int curAns = heights[topIdx] * (i - leftIdx - 1);
            anss = Math.max(anss, curAns);
        }

        return anss;
    }
}

TC: O(N) - Each element is pushed and popped from the stack at most once.
SC: O(N) - Stack space for storing indices.

// The intuition is:

// Imagine each bar in the histogram as a possible rectangle height.
// For each bar, you want to find out how far you can extend to the left and right before hitting a bar shorter than it.
// The largest rectangle for that bar is its height times the width between those two boundaries.
// By using a stack, you efficiently keep track of bars that are taller than the current one, and when you find a shorter bar, you know you’ve found the right boundary for all taller bars in the stack.
// This lets you calculate the largest possible rectangle for every bar in one pass, without needing to precompute left/right boundaries for all bars.

// Here, everytime a smaller is found (NSR), when we pop current element from stack, we will be left with smaller element of current to its left (NSL).
// This way in a single pass itself, we finf NSR, NSL and calculate the area for each element.