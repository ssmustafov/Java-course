package com.sirma.itt.javacourse.gui.transmitter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents the client.
 * 
 * @author Sinan
 */
public class MulticastClient extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(MulticastClient.class);
	private MulticastSocket socket;
	private ClientView view;
	private String channelName;

	/**
	 * Creates a new client with given channel name and user interface of the client.
	 * 
	 * @param channelName
	 *            - the name of the channel on which to listen
	 * @param view
	 *            - the user interface of the client
	 */
	public MulticastClient(String channelName, ClientView view) {
		createSocket();
		this.channelName = channelName;
		this.view = view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		InetAddress group = null;
		try {
			group = ChannelFactory.createChannelInetAddress(channelName);
			socket.joinGroup(group);

			DatagramPacket packet;

			while (true) {
				byte[] buffer = new byte[MulticastingConstants.MIDDLE_SIZE_BUFFER];
				packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);

				String receivedMessage = new String(packet.getData(), 0, packet.getLength());
				view.appendMessageToConsole(receivedMessage);
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				socket.leaveGroup(group);
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
			socket.close();
		}
	}

	/**
	 * Instantiates the {@code MulticastSocket}.
	 */
	private void createSocket() {
		try {
			this.socket = new MulticastSocket(MulticastingConstants.MULTICAST_PORT);
		} catch (IOException e) {
			view.showErrorDialog("There is no running channels");
			LOGGER.error(e.getMessage(), e);
		}
	}

}
