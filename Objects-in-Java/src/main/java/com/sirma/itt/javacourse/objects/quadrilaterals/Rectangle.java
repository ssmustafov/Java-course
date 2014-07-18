package com.sirma.itt.javacourse.objects.quadrilaterals;

import com.sirma.itt.javacourse.objects.figures.Figure;

/**
 * Represents rectangle figure.
 * 
 * @author smustafov
 */
public class Rectangle extends Figure {

	private int width;
	private int height;

	/**
	 * Creates new rectangle.
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
		super(x, y);
		if (width == height) {
			throw new IllegalArgumentException("The rectangle's width and height must not be equal");
		}
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println();
		System.out.println("Rectangle:");
		System.out.printf("\tTop left starting point : (%d,%d)" + System.lineSeparator(),
				getPoint().getX(), getPoint().getY());
		System.out.printf("\tWidth : %d" + System.lineSeparator(), width);
		System.out.printf("\tHeight : %d" + System.lineSeparator(), height);
	}

}
