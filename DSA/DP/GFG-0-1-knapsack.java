//https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

// 0 - 1 Knapsack Problem
// Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 

// Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.

// Examples :

// Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
// Output: 3
// Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
// Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
// Output: 0
// Explanation: Every item has a weight exceeding the knapsack's capacity (3).
// Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
// Output: 80
// Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.
// Constraints:
// 2 ≤ val.size() = wt.size() ≤ 103
// 1 ≤ W ≤ 103
// 1 ≤ val[i] ≤ 103
// 1 ≤ wt[i] ≤ 103

//Recursion
//TC: O(2^N)
//SC: O(N) recursion stack space
class Solution {
    private static int compute(int i, int weight, int[] val, int[] wt) {
        if(i == -1 || weight == 0) {
            return 0;
        }
        
        int pick = 0;
        if(wt[i] <= weight) {
            pick = compute(i-1, weight - wt[i], val, wt) + val[i];
        }
        
        int notPick = compute(i-1, weight, val, wt);
        
        return Math.max(pick, notPick);
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        
        if(n == 0 || W == 0) {
            return 0;
        }
        
        return compute(n-1, W, val, wt);
    }
}

//Tabulation
//TC: O(N*W)
//SC: O(N*W) space for dp array
class Solution {
    private static int compute(int i, int weight, int[] val, int[] wt) {
        if(i == -1 || weight == 0) {
            return 0;
        }
        
        int pick = 0;
        if(wt[i] <= weight) {
            pick = compute(i-1, weight - wt[i], val, wt) + val[i];
        }
        
        int notPick = compute(i-1, weight, val, wt);
        
        return Math.max(pick, notPick);
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        
        if(n == 0 || W == 0) {
            return 0;
        }
        
        int[][] dp = new int[n+1][W+1];
        
        for(int i=0; i<=W; i++) {
            dp[0][i] = 0;
        }
        
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=W; j++) {
                int pick = 0;
                
                if(wt[i-1] <= j) {
                    pick = dp[i-1][j - wt[i-1]] + val[i-1];
                }
                
                int notPick = dp[i-1][j];
                
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        
        return dp[n][W];
    }
}


//Tabulation optimized
//TC: O(N*W)
//SC: O(W) space for prev and cur arrays
class Solution {
    private static int compute(int i, int weight, int[] val, int[] wt) {
        if(i == -1 || weight == 0) {
            return 0;
        }
        
        int pick = 0;
        if(wt[i] <= weight) {
            pick = compute(i-1, weight - wt[i], val, wt) + val[i];
        }
        
        int notPick = compute(i-1, weight, val, wt);
        
        return Math.max(pick, notPick);
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        
        if(n == 0 || W == 0) {
            return 0;
        }
        
        // return compute(n-1, W, val, wt);
        
        // int[][] dp = new int[n+1][W+1];
        int prev[] = new int[W+1];
        int cur[] = new int[W+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=W; j++) {
                int pick = 0;
                
                if(wt[i-1] <= j) {
                    pick = prev[j - wt[i-1]] + val[i-1];
                }
                
                int notPick = prev[j];
                
                cur[j] = Math.max(pick, notPick);
            }
            
                
            System.arraycopy(cur, 0, prev, 0, W+1);
        }
        
        return prev[W];
    }
}
