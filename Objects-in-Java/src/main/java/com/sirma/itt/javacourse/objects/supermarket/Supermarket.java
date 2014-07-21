package com.sirma.itt.javacourse.objects.supermarket;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Represents a supermarket.
 * 
 * @author smustafov
 */
public class Supermarket extends AbstractSupermarket {

	private final HashMap<Integer, Employee> employees;
	private final HashMap<Integer, Product> products;
	private final HashMap<Integer, Client> clients;
	private final String name;
	private final BigDecimal profit;

	/**
	 * Creates a new supermarket.
	 * 
	 * @param name
	 *            - the supermarket's name
	 */
	public Supermarket(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("The supermarket's name cannot be empty");
		}

		this.name = name;
		this.employees = new HashMap<>();
		this.clients = new HashMap<>();
		this.products = new HashMap<>();
		this.profit = new BigDecimal("0");
	}

	/**
	 * @return - the supermarket's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return - the supermarket's profit
	 */
	public BigDecimal getProfit() {
		return profit;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addEmployee(Employee employee) {
		employees.put(employee.getEmployeeID(), employee);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addProduct(Product product) {
		products.put(product.getProductID(), product);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addClient(Client client) {
		clients.put(client.getClientID(), client);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void buy(int clientID, int productID) {
		if (!products.containsKey(productID)) {
			throw new IllegalArgumentException("No such product with ID : " + productID);
		}
		if (!clients.containsKey(clientID)) {
			throw new IllegalArgumentException("No such client with ID : " + clientID);
		}

		Product product = products.get(productID);
		product.setAmount(product.getAmount() - 1);

		BigDecimal price = product.getPrice();
		profit.add(price);
	}

}
