package com.sirma.itt.javacourse.collections.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Shows how the PageBean class can be used.
 * 
 * @author smustafov
 */
public final class Run {

	private static final Logger LOGGER = LogManager.getLogger(Run.class);

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

		PageBean p = new PageBean(list, 2);

		CommandExecutor e = new CommandExecutor(p);
		try {
			e.execute();
		} catch (IllegalArgumentException ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
	}
}
