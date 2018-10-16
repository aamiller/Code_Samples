// Check for cycles in a Linked List using O(n) memory

import java.util.*;
import java.util.streams.*;

public Boolean isCyclic(ListNode head) {
    if (head == null) { return false; }
    HashSet<ListNode> seenNodes = new HashSet<>();
    
    ListNode temp = head;
    while (temp != null) {
        if (seenNodes.contains(temp)) { return true; }
        seenNodes.add(temp);
        temp = temp.next;
    }
    return false;
}