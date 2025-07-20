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