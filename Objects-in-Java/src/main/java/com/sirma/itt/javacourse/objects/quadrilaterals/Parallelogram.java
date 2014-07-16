package com.sirma.itt.javacourse.objects.quadrilaterals;

import com.sirma.itt.javacourse.objects.figures.Figure;

/**
 * Represents parallelogram figure.
 * 
 * @author smustafov
 */
public class Parallelogram extends Figure {

	private int width;
	private int height;

	/**
	 * Creates new parallelogram.
	 * 
	 * @param x
	 *            - the top left start X coordinate
	 * @param y
	 *            - the top left start Y coordinate
	 * @param width
	 *            - the width of the parallelogram
	 * @param height
	 *            - the height of the parallelogram
	 */
	public Parallelogram(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	/**
	 * @return - the width of the parallelogram
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return - the height of the parallelogram
	 */
	public int getHeight() {
		return height;
	}

	@Override
	public void draw() {
		System.out.println();
		System.out.println("Parallelogram:");
		System.out.printf("\tTop left starting point : (%d,%d)" + System.lineSeparator(),
				getPoint().getX(), getPoint().getY());
		System.out.printf("\tWidth : %d" + System.lineSeparator(), width);
		System.out.printf("\tHeight : %d" + System.lineSeparator(), height);
	}

}
