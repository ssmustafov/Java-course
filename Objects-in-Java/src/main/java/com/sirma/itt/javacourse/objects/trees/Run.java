package com.sirma.itt.javacourse.objects.trees;

/**
 * Shows how the tree classes can be used.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - args
	 */
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
		System.out
				.println("Does 25 exists in the binary tree: " + binaryTree.doesElementExists(25));

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

		System.out.println();
		System.out.println("Hetero tree:");
		HeterogeneousTreeNode<Object> childA = new HeterogeneousTreeNode<Object>(22);
		HeterogeneousTreeNode<Object> childB = new HeterogeneousTreeNode<Object>("Text");
		HeterogeneousTreeNode<Object> childC = new HeterogeneousTreeNode<Object>(5.43f);
		HeterogeneousTreeNode<Object> childD = new HeterogeneousTreeNode<Object>('D');
		HeterogeneousTreeNode<Object> childE = new HeterogeneousTreeNode<Object>(8489573523L);
		HeterogeneousTreeNode<Object> childF = new HeterogeneousTreeNode<Object>(77);
		HeterogeneousTreeNode<Object> root = new HeterogeneousTreeNode<Object>("The root");
		childA.addChild(childE);
		childB.addChild(childC);
		childB.addChild(childD);
		root.addChild(childA);
		root.addChild(childB);
		root.addChild(childF);
		HeterogeneousTree<Object> heteroTree = new HeterogeneousTree<Object>();
		heteroTree.setRoot(root);
		// heteroTree.insert(229457843975L);
		// heteroTree.insert(23.123f);
		// heteroTree.insert(80);
		// heteroTree.insert(4, 0);
		// heteroTree.insert(9, 0);
		// heteroTree.insert('C', 2);
		// heteroTree.insert(23, 2);
		// heteroTree.insert(3, 0);
		// heteroTree.insert("Text", 1);

		System.out.println(heteroTree.getDFS());

	}
}
