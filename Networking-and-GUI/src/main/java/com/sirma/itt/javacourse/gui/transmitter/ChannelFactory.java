package com.sirma.itt.javacourse.gui.transmitter;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Sinan
 */
public final class ChannelFactory {

	/**
	 * Protects from instantiation.
	 */
	private ChannelFactory() {

	}

	/**
	 * Creates a new {@code InetAddress} with given channel name.
	 * 
	 * @param channelName
	 *            - the channel name which IP address will be extracted
	 * @return - the {@code InetAddress} of the channel
	 * @throws UnknownHostException
	 *             - thrown when there is no running server
	 */
	public static InetAddress createChannelInetAddress(String channelName)
			throws UnknownHostException {
		InetAddress address;

		switch (channelName) {
			case MulticastingConstants.STRING_CHANNEL_NAME:
				address = InetAddress.getByName(MulticastingConstants.STRING_CHANNEL_IP);
				break;
			case MulticastingConstants.INTEGER_CHANNEL_NAME:
				address = InetAddress.getByName(MulticastingConstants.INTEGER_CHANNEL_IP);
				break;
			default:
				address = InetAddress.getByName(MulticastingConstants.STRING_CHANNEL_IP);
				break;
		}

		return address;
	}

}