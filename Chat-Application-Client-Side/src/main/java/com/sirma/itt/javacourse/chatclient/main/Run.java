package com.sirma.itt.javacourse.chatclient.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.sirma.itt.javacourse.chatclient.utils.ServerFinder;
import com.sirma.itt.javacourse.chathelper.utils.Query;
import com.sirma.itt.javacourse.chathelper.utils.QueryTypes;

/**
 * Starts a new client for the chat application.
 * 
 * @author Sinan
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Socket socket = ServerFinder.openSocket();
		ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
		OutputStream s = socket.getOutputStream();
		s.flush();
		ObjectOutputStream writer = new ObjectOutputStream(s);

		Scanner scanner = new Scanner(System.in);
		//
		// while (true) {
		// String line = scanner.nextLine();
		// if (line.isEmpty()) {
		// break;
		// }
		Query q = new Query(QueryTypes.Login, "nomercy");
		writer.writeObject(q);
		writer.flush();

		Query r = (Query) reader.readObject();
		System.out.println(r);

		scanner.nextLine();

		q = new Query(QueryTypes.Logout, "nomercy");
		writer.writeObject(q);
		writer.flush();

		r = (Query) reader.readObject();
		System.out.println(r);
		// }

		// Query r = new Query(Queries.Login, "Test");
		// writer.writeObject(r);
		// writer.flush();

		reader.close();
		writer.close();
		socket.close();
	}
}
