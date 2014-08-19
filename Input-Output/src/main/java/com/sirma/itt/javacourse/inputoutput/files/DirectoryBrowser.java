package com.sirma.itt.javacourse.inputoutput.files;

import java.io.File;

/**
 * Holds methods for displaying folder's content.
 * 
 * @author smustafov
 */
public class DirectoryBrowser {

	/**
	 * Returns given folder's content including what files are in it and other folders. If the given
	 * path is not a folder or doesn't exists throws <code>IllegalArgumentException</code>. It
	 * traverses only one level.
	 * 
	 * @param path
	 *            - the full path to the folder
	 * @return - the given folder's content as string
	 */
	public String listContent(String path) {
		File dir = new File(path);
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + " is not a directory");
		}

		StringBuilder dirContent = new StringBuilder();
		File[] children = dir.listFiles();
		for (File child : children) {
			dirContent.append(child.getAbsolutePath());
			dirContent.append(System.lineSeparator());
		}

		return dirContent.toString();
	}
}
