// https://leetcode.com/problems/valid-parentheses/description/

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"

// Output: true

// Example 2:

// Input: s = "()[]{}"

// Output: true

// Example 3:

// Input: s = "(]"

// Output: false

// Example 4:

// Input: s = "([])"

// Output: true

 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }
        
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(brackets.containsKey(c)) {
                if(stack.isEmpty()) {
                    return false;
                }
                char poppedChar = stack.pop();
                if(poppedChar != brackets.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

// TC: O(N)
// SC: O(N) for the stack

//This is an alternative solution using a stack implemented with an array:
// class Solution {
//     public boolean isValid(String s) {
//         char[] stack = new char[s.length()];
//         int top = -1;
//         for (char c : s.toCharArray()) {
//             switch (c) {
//                 case '(': case '{': case '[':
//                     stack[++top] = c;
//                     break;
//                 case ')':
//                     if (top < 0 || stack[top--] != '(') return false;
//                     break;
//                 case '}':
//                     if (top < 0 || stack[top--] != '{') return false;
//                     break;
//                 case ']':
//                     if (top < 0 || stack[top--] != '[') return false;
//                     break;
//                 default:
//                     return false; // Invalid character
//             }
//         }
//         return top == -1; // Stack should be empty if all brackets are matched
//     }
// }

class MinStack {
    private List<Integer> st;
    private int curMin = Integer.MAX_VALUE;

    public MinStack() {
        this.st = new ArrayList<>();
        this.curMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        this.st.add(val);
        this.curMin = Math.min(this.curMin, val);
    }
    
    public void pop() {
        int topEle = st.get(st.size() - 1);
        this.st.remove(st.size() - 1);
        if(topEle == this.curMin) {
            int newMin = Integer.MAX_VALUE;
            for(int i : st) {
                newMin = Math.min(newMin, i);
            }
            this.curMin = newMin;
        }
    }
    
    public int top() {
        return this.st.get(st.size() - 1);
    }
    
    public int getMin() {
        return this.curMin;
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