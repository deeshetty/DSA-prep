/*
https://leetcode.com/problems/sort-characters-by-frequency/description/

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.

*/

class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        if(n <= 2) {
            return s;
        }

        Map<Character, Integer> freqMap = new HashMap<>(); //SC: O(N)
        for(char ch : s.toCharArray()) { //TC: O(N)
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1); //TC: O(1)
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(Collections.reverseOrder(Map.Entry.comparingByValue()));

        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) { //TC: O(N)
            pq.offer(entry); //TC: O(logN)
        }

        StringBuilder sb = new StringBuilder(); //SC: O(N)
        while(!pq.isEmpty()) { //O(N)
            Map.Entry<Character, Integer> entry = pq.poll(); //O(logN)

            char ch = entry.getKey();
            int freq = entry.getValue();

            for(int i=0; i<freq; i++) { //Tc: O(N)
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

//TC: O(N) + O(NlogN) + O(NlogN) + O(N) ~ O(NlogN)
//SC: O(N) for hashmap + O(N) priority queue + O(N) stringBuilder

// Alternative approach using Bucket Sort
class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        if(n <= 2) {
            return s;
        }

        Map<Character, Integer> freqMap = new HashMap<>(); //SC: O(N)
        for(char ch : s.toCharArray()) { //TC: O(N)
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1); //TC: O(1)
        }

        List<Character>[] ls = new List[n]; //SC: O(N)

        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) { //TC: O(N)
            int frequency = entry.getValue();
            if(ls[frequency-1] == null) {
                ls[frequency - 1] = new ArrayList<>();
            }

            ls[frequency-1].add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder(); //SC: O(N)

        for(int i=n-1; i>=0; i--) { //O(N)
            if(ls[i] != null) {
                for(char ch : ls[i]) { //TC: O(N)
                    sb.append(String.valueOf(ch).repeat(i+1));
                }
            }
        }

        return sb.toString();
    }
}

//TC: O(N) + O(N) + O(N) ~ O(N)
//SC: O(N) for hashmap + O(N) array list + O(N) stringBuilder