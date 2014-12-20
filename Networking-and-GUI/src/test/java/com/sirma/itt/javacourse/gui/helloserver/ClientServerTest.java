package com.sirma.itt.javacourse.gui.helloserver;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.ConnectException;

import org.junit.Test;

/**
 * Tests the Hello client-server.
 * 
 * @author Sinan
 */
public class ClientServerTest {

	/**
	 * Tests if the received message in the client contains the word "Hello".
	 * 
	 * @throws IOException
	 *             - not expected exception
	 */
	@Test
	public void testIfTheMessageContainsHello() throws IOException {
		ServerListener server = new ServerListener();
		server.start();
		Client client = new Client();
		client.connectToServer();
		server.stopServer();

		String actual = client.getReceivedMessage();
		String expected = "Hello!";

		assertTrue(actual.contains(expected));
	}

	/**
	 * Tests the client with not running server socket.
	 * 
	 * @throws IOException
	 *             - expected exception
	 */
	@Test(expected = ConnectException.class)
	public void testWithNoRunningServerSocket() throws IOException {
		Client client = new Client();
		client.connectToServer();
	}

}
