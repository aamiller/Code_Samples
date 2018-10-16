// Find the nth node from the end of a linked list

import java.util.*;
import java.util.streams.*;

public ListNode findNthNodeFromEnd(ListNode head, int n) {
    if (head == null || n < 1) { return null; }
    
    // Get length of list
    int len = 1;
    ListNode temp = head;
    while (temp.next != null) {
        temp = temp.next;
        len++;
    }

    // Special cases where we don't need to traverse
    if (n == len) { return head; } // First node
    if (n > len)  { return null; } // n is invalid, too large
    
    // Traverse to the node at n
    int toTraverse = len - n;
    temp = head;
    for (int i = 0; i < toTraverse; i++) { temp = temp.next; }

    return temp;
}