package com.sirma.itt.javacourse.gui.helloserver;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sinan
 */
public class ClientServerTest {

	private ServerListener server;
	private Client client;

	/**
	 * @throws java.lang.Exception
	 *             - thrown if the server is closed
	 */
	@Before
	public void setUp() throws Exception {
		server = new ServerListener();
		server.start();

		client = new Client();
		client.connectToServer();
	}

	/**
	 * 
	 */
	@After
	public void tearDown() {
		server.stopServer();
	}

	/**
	 * Tests if the received message in the client contains the word "Hello".
	 */
	@Test
	public void testGetReceivedMessage() {
		String actual = client.getReceivedMessage();
		String expected = "Hello";

		assertTrue(actual.contains(expected));
	}

}
