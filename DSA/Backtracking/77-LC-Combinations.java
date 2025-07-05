// https://leetcode.com/problems/combinations/

// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

// You may return the answer in any order.

 

// Example 1:

// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
// Example 2:

// Input: n = 1, k = 1
// Output: [[1]]
// Explanation: There is 1 choose 1 = 1 total combination.
 

// Constraints:

// 1 <= n <= 20
// 1 <= k <= n

class Solution {
    private void compute(int val, int cur, int n, int k, List<Integer> ls, List<List<Integer>> ans) {
        if(cur == k) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(val > n) {
            return;
        }

        ls.add(val);
        cur++;
        compute(val+1, cur, n, k, ls, ans);
        cur--;
        ls.remove(ls.size() - 1);
        compute(val+1, cur, n, k, ls, ans);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        if(n < k) {
            return ans;
        }

        compute(1, 0, n, k, new ArrayList(), ans);

        return ans;
    }
}

// TC: O(k * C(n, k)), where C(n, k) is the number of combinations
// SC: O(k * C(n, k)), for storing the combinations