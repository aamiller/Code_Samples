// Validate a binary search tree

import java.util.*;
import java.util.streams.*;

public static boolean validateBST(TreeNode root) {
	// Custom class to track what the limits are of
	// the node's data that will not invalidate 
	// the binary search tree property. 
     class TreeBoundaryData {
         int min;
         int max;
         TreeNode node;
         TreeBoundaryData(int min, int max, TreeNode node) {
             this.min = min;
             this.max = max;
             this.node = node;
         }
     }
     
    // Initialize first node with maximum and minimum values
    // that we may find in the tree.
    // LinkedList implementation for queue because we don't have a concurrency concern.
    Queue<TreeBoundaryData> queue = new LinkedList<>();
    queue.add(new TreeBoundaryData(Integer.MIN_VALUE, Integer.MAX_VALUE, root));
    
    TreeBoundaryData temp;
    while (!queue.isEmpty()) {
        temp = queue.poll();
        if (temp.node != null) {
            if (temp.node.data >= temp.max || temp.node.data <= temp.min) {
                return false;
            }
            queue.add(new TreeBoundaryData(temp.node.data, temp.max, temp.node.right));
            queue.add(new TreeBoundaryData(temp.min, temp.node.data, temp.node.left));
        }
    }
    
    return true;
}