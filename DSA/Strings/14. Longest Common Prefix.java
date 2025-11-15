// https://leetcode.com/problems/longest-common-prefix/description/

// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
 

// Constraints:

// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters if it is non-empty.

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        int n = strs.length;
        String first = strs[0];

        if(n == 0 || first.isEmpty()) {
            return "";
        }
        
        int m = first.length();

        for(int i=0; i<m; i++) {
            char ch = first.charAt(i);

            for(int j=1; j<n; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return sb.toString();
                }
            }

            sb.append(ch);
        }

        return sb.toString();
    }
}

//TC: O(N*M) where N is number of strings and M is length of smallest string (we stop as soon as we find a mismatch)
//SC: O(1)