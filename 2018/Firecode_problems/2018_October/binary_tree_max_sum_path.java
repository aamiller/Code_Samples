// Tree path with largest sum

import java.util.*;
import java.util.steams.*;

public static int maxSumPath(TreeNode root) {
    int[] holder = new int[1];
    maxSumPath(root, holder);
    return holder[0];
}

public static int maxSumPath(TreeNode root, int[] holder) {
    if (root == null) { return 0; }
    
    // Calculate sum of left and right path vals
    int leftPathSum = maxSumPath(root.left, holder);
    int rightPathSum = maxSumPath(root.right, holder);
    
    // Get the path sum for below this node 
    int sum = Math.max(root.data + leftPathSum, root.data + rightPathSum);
    
    // Update overall max
    holder[0] = Math.max(holder[0], leftPathSum + rightPathSum + root.data);
    
    return sum;
}