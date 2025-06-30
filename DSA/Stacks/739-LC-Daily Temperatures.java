// https://leetcode.com/problems/daily-temperatures/description/

// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

// Example 1:

// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]
// Example 2:

// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]
// Example 3:

// Input: temperatures = [30,60,90]
// Output: [1,1,0]
 

// Constraints:

// 1 <= temperatures.length <= 105
// 30 <= temperatures[i] <= 100

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(n-1);

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            if(!st.isEmpty() && temperatures[st.peek()] > temperatures[i]) {
                ans[i] = st.peek() - i;
            }

            st.push(i);
        }

        return ans;
    }
}

// TC: O(N)
// SC: O(N) for the stack

// Note: 
// I go through the temperatures from right to left, keeping a stack of indices.
// For each day, I pop from the stack until I find a day with a higher temperature than the current one.
// If I find such a day, I record how many days I had to wait by taking the difference in indices.
// Then, I push the current day's index onto the stack for future comparisons.
// This way, I always know how many days to wait for a warmer temperature, and I never need to reverse the answer!