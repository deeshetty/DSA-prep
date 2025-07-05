# Queue Cheatsheet (Java) 🚦

---

## What is a Queue?

- Think of a queue like a line at a ticket counter: **First-In-First-Out (FIFO)**
- You add to the back, remove from the front.

---

## Basic Queue Patterns

- **BFS (Breadth-First Search):**  
  Use a queue to process nodes/layers level by level (like in trees or grids).
- **Sliding Window:**  
  Use a queue (often a deque) to keep track of elements in the current window.
- **Monotonic Queue:**  
  Special deque that keeps elements in increasing or decreasing order for fast min/max in a window.

---

## Java Queue Syntax

```java
// Regular queue (FIFO)
Queue<Integer> q = new LinkedList<>();
q.offer(10);      // add to back
q.poll();         // remove from front
q.peek();         // look at front

// Double-ended queue (Deque)
Deque<Integer> dq = new ArrayDeque<>();
dq.addLast(10);   // add to back
dq.addFirst(5);   // add to front
dq.pollFirst();   // remove from front
dq.pollLast();    // remove from back
dq.peekFirst();   // look at front
dq.peekLast();    // look at back
```

---

## Monotonic Queue Pattern (for Sliding Window Max/Min)

- **Keep only useful elements in the deque (remove from back if not useful).**
- **Always check if the front is out of the window and remove it.**

```java
Deque<Integer> dq = new ArrayDeque<>();
for (int r = 0; r < n; r++) {
    // Remove from back if current is bigger (for max)
    while (!dq.isEmpty() && nums[r] > nums[dq.peekLast()]) {
        dq.pollLast();
    }
    dq.addLast(r);

    // Remove from front if out of window
    if (dq.peekFirst() < r - k + 1) {
        dq.pollFirst();
    }

    // The max in window is nums[dq.peekFirst()]
}
```

---

## Common Queue Methods in Java

| Method         | What it does                |
| -------------- | -------------------------- |
| `offer(e)`     | Add to back                |
| `poll()`       | Remove from front          |
| `peek()`       | Look at front              |
| `addFirst(e)`  | Add to front (Deque only)  |
| `addLast(e)`   | Add to back (Deque only)   |
| `pollFirst()`  | Remove from front (Deque)  |
| `pollLast()`   | Remove from back (Deque)   |
| `peekFirst()`  | Look at front (Deque)      |
| `peekLast()`   | Look at back (Deque)       |

---

## Tips

- Use `ArrayDeque` for most queue/deque needs (faster than `LinkedList`).
- For BFS, always process all elements at the current "level" before moving to the next.
- For sliding window problems, monotonic queues help you get min/max in O(1) per window.
- Remember: `Queue` is for FIFO, `Deque` is for double-ended operations.

---

## In short

Queues are your go-to for BFS, level-order, and sliding window tricks.  
Monotonic queues are a secret weapon for window min/max problems!