package com.sirma.itt.javacourse.chatserver.server;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.chatserver.server.ServerDispatcher} class.
 * 
 * @author smustafov
 */
public class ServerDispatcherTest {

	/**
	 * Tests.
	 */
	@Test
	public void testAddClient() {
		ServerDispatcher dispatcher = new ServerDispatcher();
		dispatcher.addClient(new Client(null));

	}

}
