// Delete the Node at a Particular Position in a Linked List
// java.util.* and java.util.streams.* have been imported for this problem.

import java.util.*;
import java.util.steams.*;

public ListNode deletedLinkedListNode(ListNode head, int position) {
    // Invalid input cases
    if (head == null || position <= 0) { return head; }
    
    // Front case
    if (position == 1) { return head.next; }
    
    ListNode prev = head;
    ListNode curr = prev.next;
    
    // Current node pointer is at 2nd node
    int currPos = 2;
    while (currPos < position && curr != null) {
        currPos++;
        prev = curr;
        curr = curr.next;
    }
    
    if (position == currPos) {
        // End case
        if (curr.next == null) {
            prev.next = null;
        } else {
        // Middle case
         prev.next = prev.next.next;
         curr.next = null;
        }
    }
    
    return head;
}