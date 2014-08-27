package com.sirma.itt.javacourse.collections.page;

import java.util.Scanner;

/**
 * Holds methods for executing commands for <code>PageBean</code> class.
 * 
 * @author smustafov
 */
public class CommandExecutor {

	private PageBean pageBean;

	/**
	 * Creates a new command executor to work with PageBean.
	 * 
	 * @param pageBean
	 *            - the page bean
	 */
	public CommandExecutor(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	/**
	 * Reads and returns a line read from standard input.
	 * 
	 * @return - the read line
	 */
	public static String readLine() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	/**
	 * Works with console to execute commands for getting next and previous page.
	 */
	public void execute() {
		System.out.print(pageBean.next());
		System.out.println(" - Page #" + pageBean.getCurrentPageNumber());
		while (true) {
			String line = CommandExecutor.readLine();
			line = line.trim();
			line = line.toLowerCase();

			if ("exit".equals(line)) {
				break;
			}
			if ("next".equals(line) || "next()".equals(line)) {
				String page = pageBean.next();
				if (!page.isEmpty()) {
					System.out.print(page);
					System.out.println(" - Page #" + pageBean.getCurrentPageNumber());
				}
			}
			if ("previous".equals(line) || "previous()".equals(line)) {
				System.out.print(pageBean.previous());
				System.out.println(" - Page #" + pageBean.getCurrentPageNumber());
			}
		}
	}

}
