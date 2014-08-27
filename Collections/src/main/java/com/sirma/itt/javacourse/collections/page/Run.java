package com.sirma.itt.javacourse.collections.page;

import java.util.ArrayList;
import java.util.List;

/**
 * Shows how the PageBean class can be used.
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
	 *            - arguments
	 */
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(20);
		list.add(1);
		list.add(7);
		list.add(2);
		list.add(33);
		list.add(47);
		list.add(-1);
		list.add(55);
		list.add(55);

		PageBean p = new PageBean(list, 4);
		System.out.println(p.next());
		System.out.println(p.hasNext());
		System.out.println(p.next());
		System.out.println(p.next());
		System.out.println(p.next());
		System.out.println(p.next());
		System.out.println(p.previous());
		System.out.println(p.getCurrentPageNumber());
	}
}
