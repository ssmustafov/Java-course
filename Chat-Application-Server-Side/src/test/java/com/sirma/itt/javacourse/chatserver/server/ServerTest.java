package com.sirma.itt.javacourse.chatserver.server;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.chatserver.view.MockView;
import com.sirma.itt.javacourse.chatserver.view.View;

/**
 * Tests {@link com.sirma.itt.javacourse.chatserver.server.Server} class.
 * 
 * @author smustafov
 */
public class ServerTest {

	private final String host = "localhost";
	private final int testPort = 7000;
	private Server server;
	private View view = new MockView();

	private Socket testClient;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		server = new Server(view, testPort);
		server.startServer();

		try {
			testClient = new Socket(host, testPort);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@After
	public void tearDown() {
		server.stopServer();
	}

	/**
	 * Tests .
	 */
	@Test
	public void testStartServer() {

	}

}
