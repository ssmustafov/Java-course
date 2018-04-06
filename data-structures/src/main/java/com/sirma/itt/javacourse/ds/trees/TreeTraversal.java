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

    public static <E> List<E> traverseDFS(TreeNode<E> node) {
        List<E> nodes = new ArrayList<>();
        traverseDFSInternal(node, nodes);
        return nodes;
    }

    private static <E> void traverseDFSInternal(TreeNode<E> node, List<E> nodes) {
        if (node == null) {
            return;
        }

        nodes.add(node.getValue());

        for (TreeNode<E> child : node.getChildren()) {
            traverseDFSInternal(child, nodes);
        }
    }

    public static <E> List<E> traverseBFS(TreeNode<E> node) {
        List<E> nodes = new ArrayList<>();

        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode<E> currentNode = queue.poll();
            nodes.add(currentNode.getValue());

            for (TreeNode<E> child : currentNode.getChildren()) {
                queue.offer(child);
            }
        }

        return nodes;
    }

    public static <E> List<E> traverseInOrder(BinaryTreeNode<E> node) {
        List<E> nodes = new ArrayList<>();
        traverseInOrderInternal(node, nodes);
        return nodes;
    }

    private static <E> void traverseInOrderInternal(BinaryTreeNode<E> node, List<E> nodes) {
        if (node == null) {
            return;
        }

        traverseInOrderInternal(node.getLeft(), nodes);
        nodes.add(node.getValue());
        traverseInOrderInternal(node.getRight(), nodes);
    }

    public static <E> List<E> traversePreOrder(BinaryTreeNode<E> node) {
        List<E> nodes = new ArrayList<>();
        traversePreOrderInternal(node, nodes);
        return nodes;
    }

    private static <E> void traversePreOrderInternal(BinaryTreeNode<E> node, List<E> nodes) {
        if (node == null) {
            return;
        }

        nodes.add(node.getValue());
        traversePreOrderInternal(node.getLeft(), nodes);
        traversePreOrderInternal(node.getRight(), nodes);
    }

    public static <E> List<E> traversePostOrder(BinaryTreeNode<E> node) {
        List<E> nodes = new ArrayList<>();
        traversePostOrderInternal(node, nodes);
        return nodes;
    }

    private static <E> void traversePostOrderInternal(BinaryTreeNode<E> node, List<E> nodes) {
        if (node == null) {
            return;
        }

        traversePostOrderInternal(node.getLeft(), nodes);
        traversePostOrderInternal(node.getRight(), nodes);
        nodes.add(node.getValue());
    }

}
