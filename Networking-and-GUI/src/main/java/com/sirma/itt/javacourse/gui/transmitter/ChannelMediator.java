package com.sirma.itt.javacourse.gui.transmitter;

import java.util.Random;

/**
 * Holds method which decides on what channel to send data.
 * 
 * @author Sinan
 */
public class ChannelMediator {

	private Random randomGenerator = new Random();

	/**
	 * Returns one of the channel's IP address.
	 * 
	 * @return - IP address of randomly chosen channel
	 */
	public String getChannel() {
		String channel;
		int channelNumber = randomGenerator.nextInt(2);

		if (channelNumber == 0) {
			channel = MulticastingConstants.STRING_CHANNEL_IP;
		} else {
			channel = MulticastingConstants.INTEGER_CHANNEL_IP;
		}

		return channel;
	}

}
