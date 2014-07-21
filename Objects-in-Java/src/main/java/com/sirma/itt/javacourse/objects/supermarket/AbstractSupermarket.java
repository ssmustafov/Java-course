package com.sirma.itt.javacourse.objects.supermarket;

/**
 * Represents an abstraction for Supermarket. It contains methods for adding employee, product,
 * client and buying a product.
 * 
 * @author smustafov
 */
public abstract class AbstractSupermarket {

	/**
	 * Adds new employee to the supermarket.
	 * 
	 * @param employee
	 *            - the new employee to be added
	 */
	public abstract void addEmployee(Employee employee);

	/**
	 * Adds new product to the supermarket.
	 * 
	 * @param product
	 *            - the new product to be added
	 */
	public abstract void addProduct(Product product);

	/**
	 * Adds new client to the market.
	 * 
	 * @param client
	 *            - the new client to be added
	 */
	public abstract void addClient(Client client);

	/**
	 * Buys product.
	 * 
	 * @param clientID
	 *            - the client's ID
	 * @param productID
	 *            - the product's ID which the client buys
	 */
	public abstract void buy(int clientID, int productID);

}
