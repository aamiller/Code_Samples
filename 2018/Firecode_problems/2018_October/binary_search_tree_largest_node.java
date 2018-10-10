// Largest node in BST

import java.util.*;
import java.util.steams.*;

public TreeNode findMax(TreeNode root) {
    TreeNode temp = root;
    // Since BST, rightmost node will always be findMax
    // Checking temp != null catches root null case
    while (temp != null && temp.right != null) {
        temp = temp.right;
    }
    
    return temp;
}