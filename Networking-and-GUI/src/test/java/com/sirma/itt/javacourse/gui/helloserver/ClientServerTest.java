package com.sirma.itt.javacourse.gui.helloserver;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Hello client-server.
 * 
 * @author Sinan
 */
public class ClientServerTest {
	private Server server;
	private Client client;

	/**
	 * Opens a server socket and connects one client to it, before the execution of the tests.
	 * 
	 * @throws IOException
	 *             - thrown when I/O exception occurs
	 */
	@Before
	public void setUp() throws IOException {
		server = new Server();
		server.startServer();

		client = new Client();
		client.connectToServer();
	}

	/**
	 * Stops the server socket after execution of the tests.
	 */
	@After
	public void tearDown() {
		server.stopServer();
	}

	/**
	 * Tests if the received message in the client contains the word "Hello".
	 * 
	 * @throws IOException
	 *             - not expected exception
	 */
	@Test
	public void testIfTheMessageContainsHello() throws IOException {
		String actual = client.getReceivedMessage();
		String expected = "Hello!";

		assertTrue(actual.contains(expected));
	}

}
