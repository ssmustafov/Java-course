package com.sirma.itt.javacourse.gui.downloadagent;

import java.io.IOException;

import javax.swing.SwingUtilities;

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
		// DownloadAgent
		// .downloadFile("http://www.nakov.com/books/inetjava/Internet-Programming-with-Java-Book-Svetlin-Nakov-v1.1.pdf");

		// DownloadAgent.downloadFile("http://zetcode.com/img/gui/javaswing/simplemenu.png",
		// "1.png");
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new DownloadUI();
			}
		});
	}
}
