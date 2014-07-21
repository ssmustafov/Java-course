package com.sirma.itt.javacourse.objects.quadrilaterals;

import com.sirma.itt.javacourse.objects.figures.Figure;

/**
 * Represents rectangle figure.
 * 
 * @author smustafov
 */
public class Rectangle extends Figure {

	private int size;

	/**
	 * Creates a new rectangle.
	 * 
	 * @param x
	 *            - the top left start X coordinate
	 * @param y
	 *            - the top left start Y coordinate
	 * @param size
	 *            - the length of the all four sides
	 */
	public Rectangle(int x, int y, int size) {
		super(x, y);
		this.size = size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		System.out.println();
		System.out.println("Rectangle:");
		System.out.printf("\tTop left starting point : (%d,%d)" + System.lineSeparator(),
				getPoint().getX(), getPoint().getY());
		System.out.printf("\tSize : %d" + System.lineSeparator(), size);
	}

}
