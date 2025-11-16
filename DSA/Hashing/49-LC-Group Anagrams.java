/**
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 * Constraints:
 *
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String s : strs) { // O(N)
            addToGroup(hm, s); // O(K) -> K is max length of string
        }

        return new ArrayList<>(hm.values());
    }

    private void addToGroup(Map<String, List<String>> hm, String s) {
        int[] arr = new int[26]; //O(1)
        for (char c : s.toCharArray()) { //O(K)
            arr[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder(); 
        for(int count : arr) {
            sb.append(count).append("#");
        }

        String key = sb.toString();

        hm.computeIfAbsent(key, k -> new ArrayList<>()).add(s); //O(1)
    }

     // private static void compute(HashMap<String, List<String>> hm, String s) {
    //     int[] arr = new int[26];
    //     for(char c : s.toCharArray()){
    //         arr[c-'a']++;
    //     }

    //     String arrS = Arrays.toString(arr);

    //     List<String> ls = hm.getOrDefault(arrS, new ArrayList<>());
    //     ls.add(s);
    //     hm.put(arrS, ls);
    // }
}

// TC: O(n*k) -> N: number of strings, k: max length of string
// SC: O(n) -> for hashmap storage