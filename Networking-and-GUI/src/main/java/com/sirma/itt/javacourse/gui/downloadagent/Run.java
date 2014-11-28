package com.sirma.itt.javacourse.gui.downloadagent;

import java.io.IOException;

/**
 * Shows how to use the Download agent.
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
	 * @throws IOException
	 *             - exception
	 */
	public static void main(String[] args) throws IOException {
		// DownloadAgent.downloadFile("http://zetcode.com/img/ebk/javalayout/migrep.png");
		// DownloadAgent
		// .downloadFile("http://www.nakov.com/books/inetjava/Internet-Programming-with-Java-Book-Svetlin-Nakov-v1.1.pdf");

		DownloadAgent
				.downloadFile(
						"https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TopLevelDemoProject/src/components/TopLevelDemo.java",
						"swing.java");
	}
}
