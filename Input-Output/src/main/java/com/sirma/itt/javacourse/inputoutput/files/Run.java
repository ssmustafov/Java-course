package com.sirma.itt.javacourse.inputoutput.files;


/**
 * Shows how the file classes can be used.
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
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		// FileWriter w = new FileWriter("src\\main\\resources\\test.txt");
		// w.write();

		// FileReverser r = new FileReverser();
		// r.reverseTextFile("src\\main\\resources\\reverse.txt");

		DirectoryBrowser d = new DirectoryBrowser();
		String str = d.listContent("C:\\");
		System.out.println(str);
	}
}
