// Add each level of tree to arraylist

import java.util.*;
import java.util.streams.*;

public ArrayList<Integer> levelorder(TreeNode root) {
    ArrayList<Integer> output = new ArrayList<>();
    if (root == null) { return output; }
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    TreeNode temp;
    while (!queue.isEmpty()) {
        temp = queue.poll();
        if (temp != null) {
            output.add(temp.data);

            // Add subsequent elements to queue
            queue.add(temp.left);
            queue.add(temp.right);
        }
    }

    return output;
}