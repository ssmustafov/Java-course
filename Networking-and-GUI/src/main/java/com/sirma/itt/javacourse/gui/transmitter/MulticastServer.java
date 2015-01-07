package com.sirma.itt.javacourse.gui.transmitter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents the multicasting server.
 * 
 * @author Sinan
 */
public class MulticastServer extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(MulticastServer.class);
	private static final int ONE_SECOND_IN_MILLISECONDS = 1000;
	private DatagramSocket socket;
	private MessageGenerator messageGenerator;
	private ChannelMediator channelMediator;
	private ServerView view;
	private boolean isStopped = false;

	/**
	 * Creates a new multicast server with given user interface for the server.
	 * 
	 * @param view
	 *            - the user interface of the server
	 */
	public MulticastServer(ServerView view) {
		createSocket();
		messageGenerator = new MessageGenerator();
		channelMediator = new ChannelMediator();
		this.view = view;
	}

	/**
	 * Instantiates the {@code DatagramSocket}.
	 */
	private void createSocket() {
		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Stops the server.
	 */
	public synchronized void stopTransmitting() {
		isStopped = true;
	}

	/**
	 * Returns a message depending on the channel.
	 * 
	 * @param channel
	 *            - the channel
	 * @return - a message for the channel
	 */
	private String getMessage(String channel) {
		if (channel.equals(MulticastingConstants.STRING_CHANNEL_IP)) {
			return messageGenerator.generateString();
		} else {
			return messageGenerator.generateInt();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (!isStopped) {
			try {
				String channel = channelMediator.getChannel();
				String message = getMessage(channel) + " -> send by " + channel;

				view.appendMessageToConsole(">> Sent message on channel: " + channel);

				byte[] buffer = message.getBytes();
				InetAddress group = InetAddress.getByName(channel);

				DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group,
						MulticastingConstants.MULTICAST_PORT);
				socket.send(packet);

				sleep(ONE_SECOND_IN_MILLISECONDS);
			} catch (IOException e) {
				isStopped = true;
				LOGGER.error(e.getMessage(), e);
			} catch (InterruptedException e) {
				isStopped = true;
				LOGGER.error(e.getMessage(), e);
			}
		}
		socket.close();
	}

}
