package com.sirma.itt.javacourse.objects.supermarket;

/**
 * @author smustafov
 */
public class Client extends Supermarket {

	@SuppressWarnings("unused")
	private Person client;

	/**
	 * Creates a new client.
	 * 
	 * @param client
	 *            - the client to be created
	 */
	public Client(Person client) {
		this.client = client;
	}

}
