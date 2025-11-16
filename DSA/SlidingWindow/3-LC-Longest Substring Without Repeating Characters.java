/**
 * Problem: Longest Substring Without Repeating Characters (LeetCode 3)
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Summary:
 *   Given a string s, find the length of the longest substring without duplicate characters.
 *
 * Examples:
 *   s = "abcabcbb" -> 3 ("abc")
 *   s = "bbbbb"     -> 1 ("b")
 *   s = "pwwkew"    -> 3 ("wke")
 *
 * Note: the answer must be a contiguous substring, not a subsequence.
 *
 * Constraints:
 *   0 <= s.length <= 5 * 10^4
 *   s consists of English letters, digits, symbols and spaces
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0;

        Set<Character> hs = new HashSet<>();

        for(int j=0; j<s.length(); j++) {
            if(!hs.add(s.charAt(j))) {
                while(s.charAt(i) != s.charAt(j) && i<=j) {
                    hs.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            ans = Math.max(ans, j-i+1);
        }

        return ans;
    }
}

// TC: O(N)
// SC: O(N)

//with spaces
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0;

        Set<Character> hs = new HashSet<>();

        for(int j=0; j<s.length(); j++) {
            if(Character.isLetterOrDigit(s.charAt(j))) {
                if(!hs.add(s.charAt(j))) {
                    while(s.charAt(i) != s.charAt(j) && i<=j) {
                        if(hs.contains(s.charAt(i))) {
                            hs.remove(s.charAt(i));
                        }
                        i++;
                    }
                    i++;
                }
            }
            ans = Math.max(ans, j-i+1);
        }

        return ans;
    }
}

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s.length() == 0) {
//             return 0;
//         }
//         if(s.length() == 1) {
//             return 1;
//         }

//         int curL = 0;
//         int maxL = 0;
//         int start =0;
//         HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

//         for(int end = 0; end < s.length(); end++) {
    
//             if(hm.containsKey(s.charAt(end))) {
//                 int found = hm.get(s.charAt(end));
//                 int prevStart = start;
//                 start = found + 1;

//                 for(int begin = prevStart; begin < start; begin++) {
//                     hm.remove(s.charAt(begin));
//                 }
//             }
    
//             hm.put(s.charAt(end), end);
//             curL = end - start + 1;
//             maxL = Math.max(curL, maxL); 
//         }

//         return maxL;
//     }
// }

/*
 * Approach:
 *   Sliding window (two pointers) with a HashSet or HashMap to track seen characters/indices.
 *   Move the right pointer to expand and adjust the left pointer to remove duplicates.
 *
 * Complexity:
 *   Time: O(n)  Space: O(min(n, charset_size))
 */