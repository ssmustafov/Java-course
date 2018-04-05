package com.sirma.itt.javacourse.ds.trees;

import java.util.List;

/**
 * Represents abstract unmodifiable node in a tree structure. A node can contain an element value.
 *
 * @param <E> type of the element value in the tree node
 * @author Sinan Mustafov
 */
public interface TreeNode<E> {

    /**
     * Returns the value stored at this node.
     *
     * @return the value stored at this node
     */
    E getValue();

    /**
     * Returns the number of children for the node.
     *
     * @return the number of children for the node
     */
    int getChildrenCount();

    /**
     * Returns unmodifiable list containing the children of the node, or empty if no children.
     *
     * @return unmodifiable list containing the children of the node, or empty if no children
     */
    List<TreeNode<E>> getChildren();

    /**
     * Checks whether the node does not have any children. Also referred as leaf node.
     *
     * @return true if the node does not have any children; false otherwise
     */
    default boolean isExternal() {
        return getChildrenCount() == 0;
    }

    /**
     * Checks whether the node has at least one child.
     *
     * @return true if the node has at least one child; false otherwise
     */
    default boolean isInternal() {
        return getChildrenCount() > 0;
    }

}
