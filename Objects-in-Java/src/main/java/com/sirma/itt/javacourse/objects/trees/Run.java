package com.sirma.itt.javacourse.objects.trees;

/**
 * Shows how the BinaryTree class can be used.
 * 
 * @author smustafov
 */
public class Run {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		System.out.println("Binary tree:");
		// insert new number in the tree, only if there is not already a number with same value
		binaryTree.insert(40);
		binaryTree.insert(78);
		binaryTree.insert(25);
		binaryTree.insert(10);
		binaryTree.insert(32);

		// print all elements in a sorted way
		System.out.println("In-order sort: " + binaryTree.getInOrderSort());
		System.out.println("Pre-order sort: " + binaryTree.getPreOrderSort());
		System.out.println("Post-order sort: " + binaryTree.getPostOrderSort());

		// search for element in the tree
		System.out.println("Does 25 exists in the tree: " + binaryTree.doesElementExists(25));

		System.out.println();
		System.out.println("Homo tree:");
		HomogeneousTree<Integer> homoTree = new HomogeneousTree<>(22);
		homoTree.insert(30);
		homoTree.insert(45);
		homoTree.insert(4);
		homoTree.insert(-234);
		homoTree.insert(54);
		homoTree.insert(new HomogeneousTreeNode<Integer>(12), 1);
		homoTree.insert(new HomogeneousTreeNode<Integer>(42), 14);

		System.out.println(homoTree.getDFS());

	}
}
