//https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Given a string s, find the length of the longest substring without duplicate characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.

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
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int ans = 0;
//         int i = 0;

//         Set<Character> hs = new HashSet<>();

//         for(int j=0; j<s.length(); j++) {
//             if(Character.isLetterOrDigit(s.charAt(j))) {
//                 if(!hs.add(s.charAt(j))) {
//                     while(s.charAt(i) != s.charAt(j) && i<=j) {
//                         if(hs.contains(s.charAt(i))) {
//                             hs.remove(s.charAt(i));
//                         }
//                         i++;
//                     }
//                     i++;
//                 }
//             }
//             ans = Math.max(ans, j-i+1);
//         }

//         return ans;
//     }
// }

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s.length() <= 1) {
//             return s.length();
//         }

//         int l = 0;
//         int r = 0;
//         int ans = 0;
//         HashSet<Character> hs = new HashSet<>();

//         while(r < s.length()) {
//             if(!hs.add(s.charAt(r))) {
//                 while(l <= r && s.charAt(l) != s.charAt(r)) {
//                     hs.remove(s.charAt(l));
//                     l++;
//                 }
//                 l++;
//             }
//             ans = Math.max(ans, r-l+1);
//             r++;
//         }

//         return ans;
//     }
// }

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