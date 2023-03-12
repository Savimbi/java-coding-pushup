package com.dudosa.strings.numbers;

public class BSTDeapthSum {
    public static int nodeDepths(BinaryTree root) {
        return nodeDepths(root, 0);



    }
    static  int nodeDepths(BinaryTree root, int depth){
        if(root == null){
            return 0;
        }
        return depth + nodeDepths(root.left, depth + 1 ) + nodeDepths(root.right, depth +1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
