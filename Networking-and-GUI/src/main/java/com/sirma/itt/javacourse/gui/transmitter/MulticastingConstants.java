package com.sirma.itt.javacourse.gui.transmitter;

/**
 * Holds constants for the multicast server-client application.
 * 
 * @author Sinan
 */
public final class MulticastingConstants {

	/**
	 * Protects from instantiation.
	 */
	private MulticastingConstants() {

	}

	public static final int MULTICAST_PORT = 7000;
	public static final int SMALL_SIZE_BUFFER = 256;
	public static final int MIDDLE_SIZE_BUFFER = 1024;
	public static final int BIG_SIZE_BUFFER = 4096;
	public static final String STRING_CHANNEL_IP = "230.0.0.1";
	public static final String INTEGER_CHANNEL_IP = "229.0.0.1";
	public static final String INTEGER_CHANNEL_NAME = "Integer";
	public static final String STRING_CHANNEL_NAME = "String";

}
