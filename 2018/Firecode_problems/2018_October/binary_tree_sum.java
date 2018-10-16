// Iterative sum of a binary tree

import java.util.*;
import java.util.streams.*;

public int sumItr(TreeNode root) { 
    if (root == null) { return 0; }
    int sum = 0;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    TreeNode temp;
    while (!queue.isEmpty()) { 
        temp = queue.poll();
        if (temp != null) {
            sum += temp.data;
            queue.add(temp.right);
            queue.add(temp.left);
        }
        
    }
    
    return sum;
}