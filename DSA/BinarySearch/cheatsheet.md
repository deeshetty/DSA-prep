# Binary Search: Quick Recap & Template

---

## When to use binary search?

- The answer space is sorted or monotonic (increasing/decreasing, or “yes/no” boundary).
- You’re looking for a number, index, or minimum/maximum value that satisfies a condition.

---

## Classic Binary Search Template (for index in sorted array)

```java
int left = 0, right = n - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (condition(mid)) {
        // move left or right depending on what you want
    } else {
        // move the other way
    }
}
```

---

## Lower Bound / First True / Min Satisfying Value (searching answer space)

```java
int left = minPossible, right = maxPossible;
while (left < right) {
    int mid = left + (right - left) / 2;
    if (isPossible(mid)) {
        right = mid; // try smaller
    } else {
        left = mid + 1; // need bigger
    }
}
return left; // or check if left is valid
```

---

## Key Points

- For problems like “Koko Eating Bananas” or “Ship Within Days,” you’re not searching the array, but the **answer space** (possible speeds, capacities, etc.).
- Always set your left bound to the **minimum valid value** (often `max(array)` for capacity problems).
- Set your right bound to the **maximum possible value** (often `sum(array)`).
- Write a helper like `isPossible()` to check if a guess works.
- Use integer math tricks like `(pile + speed - 1) / speed` for ceiling division.

---

## Tips

- If you’re stuck, ask: “Can I rephrase this as: for a given X, is it possible?”
- If yes, try binary search on X!
- Be careful with off-by-one errors (`left < right` vs `left <= right`).
- For classic search, use `while (left <= right)`. For answer space, use `while (left < right)`.

---

## In short

If you can guess an answer and check it in O(N), you can probably binary search it in O(N log M)!