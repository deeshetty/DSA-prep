// https://leetcode.com/problems/merge-intervals/description/

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// Example 3:

// Input: intervals = [[4,7],[1,4]]
// Output: [[1,7]]
// Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        if(n == 1) {
            return intervals;
        }

        List<int[]> ls = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); //O(NlogN)

        int[] cur = intervals[0];

        for(int i=1; i<n; i++) { //O(N)
            int[] next = intervals[i];
            if(next[0] <= cur[1]) {
                cur[1] = Math.max(next[1], cur[1]);
            } else {
                ls.add(cur);
                cur = next;
            }
        }

        ls.add(cur);

        return ls.toArray(new int[ls.size()][]); //SC: O(N); TC: O(NlogN);
    }
}

//TC: O(NlogN) due to sorting
//SC: O(N) for the list to store the merged intervals