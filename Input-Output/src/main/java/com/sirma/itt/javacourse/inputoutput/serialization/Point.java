package com.sirma.itt.javacourse.inputoutput.serialization;

import java.io.Serializable;

/**
 * Represents a 2D point.
 * 
 * @author smustafov
 */
public class Point implements Serializable {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -3071063781850454696L;
	private double x;
	private double y;

	/**
	 * Creates a new point.
	 * 
	 * @param x
	 *            - the x coordinate of the point
	 * @param y
	 *            - the y coordinate of the point
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter method for x.
	 * 
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Setter method for x.
	 * 
	 * @param x
	 *            the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Getter method for y.
	 * 
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Setter method for y.
	 * 
	 * @param y
	 *            the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
