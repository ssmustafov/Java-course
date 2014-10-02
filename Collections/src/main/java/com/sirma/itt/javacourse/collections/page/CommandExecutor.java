package com.sirma.itt.javacourse.collections.page;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Holds methods for executing commands for <code>PageBean</code> class.
 * 
 * @author smustafov
 */
public class CommandExecutor {

	// TODO: Add rest of the pagebean's commands
	private static final Logger LOGGER = LogManager.getLogger(CommandExecutor.class);
	private static final String EXIT_PROGRAM_STRING = "exit";
	private static final String NEXT_PAGE_STRING = "next";
	private static final String PREVIOUS_PAGE_STRING = "previous";
	private BufferedReader reader;
	private PageBean pageBean;

	/**
	 * Creates a new command executor to work with <code>PageBean</code>.
	 * 
	 * @param pageBean
	 *            - the page bean
	 * @param reader
	 *            - input stream to be set
	 */
	public CommandExecutor(PageBean pageBean, InputStreamReader reader) {
		this.pageBean = pageBean;
		this.reader = new BufferedReader(reader);
	}

	/**
	 * Creates a new command executor to work with <code>PageBean</code>. The input stream will be
	 * set to standard input stream.
	 * 
	 * @param pageBean
	 *            - the page bean
	 */
	public CommandExecutor(PageBean pageBean) {
		this.pageBean = pageBean;
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Reads and returns a line read from standard input.
	 * 
	 * @return - the read line
	 */
	public String readLine() {
		String line = "";
		try {
			line = reader.readLine();
		} catch (IOException e) {
			LOGGER.error(e);
		}

		return line;
	}

	/**
	 * Works with console to execute commands for getting next and previous page.
	 */
	public void execute() {
		System.out.print(pageBean.next());
		System.out.println(" - Page #" + pageBean.getCurrentPageNumber());
		while (true) {
			String line = readLine();
			line = line.trim();
			line = line.toLowerCase();

			if (EXIT_PROGRAM_STRING.equals(line)) {
				if (reader != null) {
					// TODO: possible not closing in every case?
					try {
						reader.close();
					} catch (IOException e) {
						LOGGER.error(e);
					}
				}
				break;
			}
			if (NEXT_PAGE_STRING.equals(line)) {
				if (pageBean.hasNext()) {
					String page = pageBean.next();
					System.out.print(page);
					System.out.println(" - Page #" + pageBean.getCurrentPageNumber());
				}
			}
			if (PREVIOUS_PAGE_STRING.equals(line)) {
				System.out.print(pageBean.previous());
				System.out.println(" - Page #" + pageBean.getCurrentPageNumber());
			}
		}
	}
}
