package com.sirma.itt.javacourse.inputoutput.console;

/**
 * Interface for reading string from stream and writing it to a resource.
 * 
 * @author smustafov
 */
public interface WriterReader {

	/**
	 * Reads input which will be stored in some resource.
	 * 
	 * @return - the text as string to be stored
	 */
	String read();

	/**
	 * Writes given input to a resource.
	 */
	void write();

}
