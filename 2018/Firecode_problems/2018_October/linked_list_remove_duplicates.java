// Remove duplicates in a singly linked linked list

import java.util.*;
import java.util.streams.*;

public ListNode removeDuplicates(ListNode head) {
    // If empty or no vals, no possible duplicates
    if (head == null || head.next == null) { return head; }
    
    // Set to hold previously seen node vals
    HashSet<Integer> set = new HashSet<Integer>();
    ListNode prev = head;
    ListNode curr = head.next;
    
    // Fence post, add our first value
    set.add(prev.data);
    
    ListNode temp; // For cutting removed node's pointer
    while (curr != null) {
        // If already seen this value, remove it
        if (set.contains(curr.data)) {
            // Remove the node, set curr pointer on ListNode
            // right after the deleted node.
            temp = curr;
            curr = curr.next;
            temp.next = null;
            prev.next = curr;
        } else { // Otherwise, add to set
            set.add(curr.data);
            prev = curr;
            curr = curr.next;
        }
    }
    return head;
}