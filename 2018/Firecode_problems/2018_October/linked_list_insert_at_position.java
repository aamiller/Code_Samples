// Insert a Node at a specified position in a Linked List
// java.util.* and java.util.streams.* have been imported for this problem.

import java.util.*;
import java.util.steams.*;

public ListNode insertAtPosition(ListNode head, int data, int pos) {
    // Node to return
    ListNode newNode = new ListNode(data);

    // Single in list node case
    // Works if head is null
    if (pos <= 1) { 
        newNode.next = head;
        return newNode; 
    }

    ListNode prev = head;
    ListNode curr = head.next;
    int currPos = 2; // head.next is the 2nd element
    
    // Traverse, update pointers and count, set prev right before
    // position
    while (curr != null && currPos < pos) {
        currPos++;
        prev = curr;
        curr = curr.next;
    }
    
    // If we were able to reach position, list was long enough
    if (currPos == pos) {
        prev.next = newNode;
        newNode.next = curr;
    }

    return head;
}