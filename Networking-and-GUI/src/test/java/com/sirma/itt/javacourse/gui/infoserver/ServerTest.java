package com.sirma.itt.javacourse.gui.infoserver;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

/**
 * @author Sinan
 */
public class ServerTest {

	@Spy
	private Server server;

	@Mock
	private View view;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		view = Mockito.mock(View.class);
		Mockito.when(view.getButton()).thenReturn(new JButton());

		server = Mockito.spy(new Server(view));
	}

	/**
	 * Tests {@link Server#startServer()} for calling at most once.
	 */
	@Test
	public void testStartServer() {
		server.startServer();
		Mockito.verify(server, Mockito.atMost(1)).startServer();

		server.stopServer();
	}

	/**
	 * Tests {@link Server#stopServer()} for calling at most once.
	 */
	@Test
	public void testStopServer() {
		server.startServer();
		server.stopServer();

		Mockito.verify(server, Mockito.atMost(1)).stopServer();
	}

}
