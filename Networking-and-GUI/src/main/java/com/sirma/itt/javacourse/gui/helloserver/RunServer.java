package com.sirma.itt.javacourse.gui.helloserver;

import java.io.IOException;

import javax.swing.SwingUtilities;

/**
 * Shows how to use the server.
 * 
 * @author Sinan
 */
public final class RunServer {

	/**
	 * Protects from instantiation.
	 */
	private RunServer() {

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
				try {
					new ServerView();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
