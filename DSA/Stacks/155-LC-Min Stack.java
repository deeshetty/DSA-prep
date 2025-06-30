// https://leetcode.com/problems/min-stack/description/

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

 

// Example 1:

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2
 

// Constraints:

// -231 <= val <= 231 - 1
// Methods pop, top and getMin operations will always be called on non-empty stacks.
// At most 3 * 104 calls will be made to push, pop, top, and getMin.

class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || minSt.peek() >= val) {
            minSt.push(val);
        }
    }
    
    public void pop() {
        if(!minSt.isEmpty()) {
            int minStTop = minSt.peek();
            int stTop = st.peek();
            if(minStTop == stTop) {
                minSt.pop();
            }
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return !minSt.isEmpty() ? minSt.peek() : Integer.MAX_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

Note: 
// This solution uses two stacks:

// The main stack (st) stores all values as in a normal stack.
// The auxiliary stack (minSt) keeps track of the minimum value at each level of the stack.
// Whenever a new value is pushed, if it is less than or equal to the current minimum, it is also pushed onto minSt.
// When popping, if the popped value is equal to the current minimum, it is also popped from minSt.
// This allows getMin() to always return the current minimum in O(1) time, unlike using a single variable which would require scanning the stack after a pop.