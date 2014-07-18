package com.sirma.itt.javacourse.objects.figures;

/**
 * Represents figure.
 * 
 * @author smustafov
 */
public abstract class Figure {

	private Point point;

	/**
	 * Initializes the X and Y coordinate of the figure.
	 * 
	 * @param x
	 *            - the X coordinate to be set
	 * @param y
	 *            - the Y coordinate to be set
	 */
	public Figure(int x, int y) {
		setPoint(new Point(x, y));
	}

	/**
	 * Draws a figure.
	 */
	public abstract void draw();

	/**
	 * Gets the point.
	 *
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * Sets the point.
	 *
	 * @param point
	 *            the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

}
