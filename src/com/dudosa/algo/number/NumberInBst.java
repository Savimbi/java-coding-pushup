package com.dudosa.strings.numbers;
public class NumberInBst {

    public  static int findClosestNumberInBst(BST tree, int target){
        return findClosestNumberInBst(tree, target, tree.value);
    }

    public static int findClosestNumberInBst(BST tree, int target, int closest){
        if (Math.abs(target - tree.value) > Math.abs(target - closest)){
            closest = tree.value;
        }
        if (target < tree.value && tree.left != null){
            return findClosestNumberInBst(tree.left, target,closest);
        } else if(target > tree.value && tree.right != null){
            return findClosestNumberInBst(tree.right, target, closest);
        } else {
            return  closest;
        }
    }
    public static class BST{
        public int value;
        public BST left;
        public BST right;

        public BST(int value){
            this.value = value;
        }
    }

}

