package com.sirma.itt.javacourse.gui.downloadagent;

import javax.swing.SwingUtilities;

/**
 * Shows how to use the Download agent.
 * 
 * @author Sinan
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
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new DownloadView();
			}
		});
	}
}
