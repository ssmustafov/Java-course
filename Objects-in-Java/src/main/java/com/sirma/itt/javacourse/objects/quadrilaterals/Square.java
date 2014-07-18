package com.sirma.itt.javacourse.objects.quadrilaterals;

import com.sirma.itt.javacourse.objects.figures.Figure;

/**
 * Represents a square figure.
 * 
 * @author smustafov
 */
public class Square extends Figure {

	private int size;

	/**
	 * Creates new square figure.
	 * 
	 * @param x
	 *            - the top left start X coordinate
	 * @param y
	 *            - the top left start Y coordinate
	 * @param size
	 *            - the size of the square
	 */
	public Square(int x, int y, int size) {
		super(x, y);
		this.size = size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		System.out.println();
		System.out.println("Square:");
		System.out.printf("\tTop left starting point : (%d,%d)" + System.lineSeparator(),
				getPoint().getX(), getPoint().getY());
		System.out.printf("\tSize : %d" + System.lineSeparator(), size);
	}

}
