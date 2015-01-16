package com.sirma.itt.javacourse.gui.infoserver;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * @author Sinan
 */
public class ServerTest {

	private Server server;
	private Client client;

	@Mock
	private View view;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		view = Mockito.mock(View.class);
		Mockito.when(view.getButton()).thenReturn(new JButton());

		server = new Server(view);
		server.startServer();

		client = new Client(view);
		client.connectToServer();
		client.start();
	}

	/**
	 * 
	 */
	@Test
	public void test() {
		server.stopServer();
	}

}
