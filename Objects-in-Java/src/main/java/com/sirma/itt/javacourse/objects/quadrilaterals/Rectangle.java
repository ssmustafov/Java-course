package com.sirma.itt.javacourse.objects.quadrilaterals;

/**
 * Represents a rectangle figure.
 * 
 * @author smustafov
 */
public class Rectangle extends Parallelogram {

	/**
	 * Creates a new rectangle.
	 * 
	 * @param x
	 *            - the top left start X coordinate
	 * @param y
	 *            - the top left start Y coordinate
	 * @param width
	 *            - the width of the rectangle
	 * @param height
	 *            - the height of the rectangle
	 */
	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height, 0);
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
		System.out.printf("\tWidth : %d" + System.lineSeparator(), super.getWidth());
		System.out.printf("\tHeight : %d" + System.lineSeparator(), super.getHeight());
	}

}
