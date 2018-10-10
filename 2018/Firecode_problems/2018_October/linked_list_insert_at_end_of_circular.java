// Insert at tail of circular list

import java.util.*;
import java.util.steams.*;

public ListNode insertAtTail(ListNode head, int data) {
    ListNode newNode = new ListNode(data);
    if (head == null) {
        head = newNode;
        head.next = head;
    } else if (head.next == head) { // If one node long
        head.next = newNode;
        newNode.next = head;
    } else {
        // Traverse to end node
        ListNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        
        // Update end
        temp.next = newNode;
        newNode.next = head;
    }
    
    return head;
}