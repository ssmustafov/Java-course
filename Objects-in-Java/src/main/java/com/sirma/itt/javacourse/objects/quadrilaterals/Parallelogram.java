package com.sirma.itt.javacourse.objects.quadrilaterals;

import com.sirma.itt.javacourse.objects.figures.Figure;

/**
 * Represents parallelogram figure.
 * 
 * @author smustafov
 */
public class Parallelogram extends Figure {

	private int angle;
	private int width;
	private int height;

	/**
	 * Creates a new parallelogram.
	 * 
	 * @param x
	 *            - the top left start X coordinate
	 * @param y
	 *            - the top left start Y coordinate
	 * @param width
	 *            - the width of the parallelogram
	 * @param height
	 *            - the height of the parallelogram
	 * @param angle
	 *            - the angle of the parallelogram
	 */
	public Parallelogram(int x, int y, int width, int height, int angle) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.angle = angle;
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

	/**
	 * @return - the angle of parallelogram
	 */
	public int getAngle() {
		return angle;
	}

	@Override
	public void draw() {
		System.out.println();
		System.out.println("Parallelogram:");
		System.out.printf("\tTop left starting point : (%d,%d)" + System.lineSeparator(),
				getPoint().getX(), getPoint().getY());
		System.out.printf("\tAngle : %d" + System.lineSeparator(), angle);
		System.out.printf("\tWidth : %d" + System.lineSeparator(), width);
		System.out.printf("\tHeight : %d" + System.lineSeparator(), height);
	}

}
