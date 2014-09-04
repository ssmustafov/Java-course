package com.sirma.itt.javacourse.inputoutput.files;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Holds methods for displaying folder's content.
 * 
 * @author smustafov
 */
public class DirectoryBrowser {

	private final StringBuilder dirContent = new StringBuilder();

	/**
	 * Returns given folder's content including what files are in it and other folders. If the given
	 * path is not a folder or doesn't exists throws <code>IllegalArgumentException</code>. It
	 * traverses all levels of the given path.
	 * 
	 * @param path
	 *            - the full path to the folder
	 * @return - the given folder's content as string
	 */
	public String listContent(String path) {
		File dir = new File(path);
		if (dir.isFile()) {
			throw new IllegalArgumentException(
					"It is given a path to file instead of to directory: '" + path + "'");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(
					"It is given a path to something else instead of to directory: '" + path + "'");
		}

		dirContent.setLength(0);
		Queue<File> visitedDirsQueue = new LinkedList<>();
		visitedDirsQueue.add(dir);

		while (visitedDirsQueue.size() > 0) {
			File currentDir = visitedDirsQueue.remove();
			dirContent.append(currentDir.getAbsolutePath());
			dirContent.append(System.lineSeparator());
			File[] children = currentDir.listFiles();

			if (children != null) {
				for (File child : children) {
					visitedDirsQueue.add(child);
				}
			}
		}

		return dirContent.toString();
	}
}
