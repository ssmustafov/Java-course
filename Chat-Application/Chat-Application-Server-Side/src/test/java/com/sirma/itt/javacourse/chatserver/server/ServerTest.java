package com.sirma.itt.javacourse.chatserver.server;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.chathelper.utils.Query;
import com.sirma.itt.javacourse.chathelper.utils.QueryHandler;
import com.sirma.itt.javacourse.chathelper.utils.QueryTypes;
import com.sirma.itt.javacourse.chatserver.view.MockView;
import com.sirma.itt.javacourse.chatserver.view.View;

/**
 * Tests {@link com.sirma.itt.javacourse.chatserver.server.Server} class.
 * 
 * @author smustafov
 */
public class ServerTest {

	private static final Logger LOGGER = LogManager.getLogger(ServerTest.class);
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
	}

	/**
	 * 
	 */
	@After
	public void tearDown() {
		server.stopServer();
	}

	/**
	 * Tests login into server.
	 */
	@Test
	public void testServerLogin() {
		try {
			testClient = new Socket(host, testPort);
		} catch (UnknownHostException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error("Closed", e);
		}

		QueryHandler q = new QueryHandler(testClient);
		q.sendQuery(new Query(QueryTypes.Login, "Test"));
		Query a = q.readQuery();
		assertEquals(QueryTypes.Success, a.getQueryType());
		q.sendQuery(new Query(QueryTypes.Logout, "Test"));
	}

}
