// https://leetcode.com/problems/reorder-list/

// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

// Example 1:


// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
// Example 2:


// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
 

// Constraints:

// The number of nodes in the list is in the range [1, 5 * 104].
// 1 <= Node.val <= 1000

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode cur = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode reversedMid = reverseList(mid);

        while(cur != null && reversedMid != null) {
            ListNode next = cur.next;
            cur.next = reversedMid;
            ListNode midNext = reversedMid.next;
            reversedMid.next = next;

            cur = next;
            reversedMid = midNext;
        }
    }
}

//Tc: O(N)
//SC: O(1) - In-place reversal of the second half of the list

// Pattern:

// Find the middle of the list (slow & fast pointers)
// Reverse the second half
// Merge the two halves alternately
// How it works:

// Use slow/fast pointers to find the middle.
// Split the list into two halves.
// Reverse the second half.
// Merge the first half and the reversed second half node by node.