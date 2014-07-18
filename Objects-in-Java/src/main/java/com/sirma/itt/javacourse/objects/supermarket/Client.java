package com.sirma.itt.javacourse.objects.supermarket;

/**
 * Represents client.
 * 
 * @author smustafov
 */
public class Client extends Person {

	private static int clientID = 0;

	/**
	 * Creates a new client.
	 * 
	 * @param name
	 *            - the client's name to be set
	 * @param age
	 *            - the client's age to be set
	 */
	public Client(String name, int age) {
		super(name, age);
		Client.clientID++;
	}

	/**
	 * @return - the client's ID
	 */
	public int getClientID() {
		return clientID;
	}

}
