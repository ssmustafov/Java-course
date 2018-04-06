package com.sirma.itt.javacourse.ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Utility methods for tree traversal.
 *
 * @author Sinan Mustafov
 */
public class TreeTraversal {

    public static <E> List<E> traverseDFS(TreeNode<E> root) {
        List<E> nodes = new ArrayList<>();
        traverseDFSInternal(root, nodes);
        return nodes;
    }

    private static <E> void traverseDFSInternal(TreeNode<E> root, List<E> nodes) {
        if (root == null) {
            return;
        }

        nodes.add(root.getValue());

        for (TreeNode<E> child : root.getChildren()) {
            traverseDFSInternal(child, nodes);
        }
    }

    public static <E> List<E> traverseBFS(TreeNode<E> root) {
        List<E> nodes = new ArrayList<>();

        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<E> node = queue.poll();
            nodes.add(node.getValue());

            for (TreeNode<E> child : node.getChildren()) {
                queue.offer(child);
            }
        }

        return nodes;
    }

    public static <E> List<E> traversePreOrder(BinaryTreeNode<E> root) {
        List<E> nodes = new ArrayList<>();
        return nodes;
    }

    public static <E> List<E> traversePostOrder(BinaryTreeNode<E> root) {
        List<E> nodes = new ArrayList<>();
        return nodes;
    }

    public static <E> List<E> traverseInOrder(BinaryTreeNode<E> root) {
        List<E> nodes = new ArrayList<>();
        return nodes;
    }

}
