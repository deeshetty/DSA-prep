# Interview Prep Problem Index

A quick reference for all problems solved, including patterns and links.

---

## Syntax
## HashMap
- HashMap<Integer, Integer> hm = new HashMap<>();
- hm.put(1, 1);
- hm.get(1);

## Strings
- s.charAt(i)
- Character.isLetterOrDigit(s.charAt(i));
- Character.toLowerCase(s.charAt(i))
- Character.toUpperCase(s.charAt(i))
---

## Tips

- Use class to store pairs or tuples when needed
  static class Pair {
          int val;
          int idx;
          Pair(int val, int idx) {
              this.val = val;
              this.idx = idx;
          }
      }

## Sliding Window Technique
// General template for solving sliding window problems

```java
int left = 0, right = 0;
while (right < s.length()) {
  // Expand the window by moving 'right'
  // Update data structures (e.g., HashMap, count variables)

  while (/* condition: window is invalid or needs to shrink */) {
    // Shrink the window by moving 'left'
    // Update data structures accordingly
    left++;
  }

  // Optionally update result if needed
  right++;
}
```

- Use array of size 26 when the problem constraint says the values can be of only english uppercase | lowercase characters
  int[] arr = new int[26];

## Prefix Sum + HashMap Pattern 
- refer PrefixSum/GFG problem for reference
- When to Use
  Finding subarrays with a specific sum, difference, or condition
  Problems involving "subarray with sum equals K" or similar
  When you need to track running totals and check if you've seen a value before
  - Use a HashMap to store prefix sums (or running values) and their first occurrence index
  For each new element, check if (currentSum - target) exists in the map
  If it exists, you've found a valid subarray
  - If prefixSum[j] - prefixSum[i] = target, then subarray from i+1 to j has sum target
  So we look for prefixSum[i] = currentSum - target

## Binary Search template
```
  int left = minPossible, right = maxPossible;
  while (left < right) {
      int mid = left + (right - left) / 2;
      if (isPossible(mid)) {
          right = mid; // try smaller; its like we might ahve found the solution, but search in left half; there might be a smaller value which might be a valid solution
      } else {
          left = mid + 1; // need bigger
      }
  }
  return left; // or check if left is valid
```