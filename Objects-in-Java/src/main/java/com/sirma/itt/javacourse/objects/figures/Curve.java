package com.sirma.itt.javacourse.objects.figures;

/**
 * Represents a curve figure.
 * 
 * @author smustafov
 */
public class Curve extends Ellipse {

	private int startAngle;
	private int stopAngle;

	/**
	 * Creates new Curve.
	 * 
	 * @param x
	 *            - the X coordinate
	 * @param y
	 *            - the Y coordinate
	 * @param width
	 *            - the width of the curve
	 * @param height
	 *            - the height of the curve
	 * @param startAngle
	 *            - the starting angle of the curve
	 * @param stopAngle
	 *            - the ending angle of the curve
	 */
	public Curve(int x, int y, int width, int height, int startAngle, int stopAngle) {
		super(x, y, width, height);
		this.startAngle = startAngle;
		this.stopAngle = stopAngle;
	}

	@Override
	public void draw() {
		System.out.println();
		System.out.println("Curve:");
		System.out.printf("\tStart point : (%d,%d)" + System.lineSeparator(), getPoint().getX(),
				getPoint().getY());
		System.out.printf("\tWidth : %d" + System.lineSeparator(), super.getFirstRadius());
		System.out.printf("\tWidth : %d" + System.lineSeparator(), super.getSecondRadius());
		System.out.printf("\tStart angle : %d" + System.lineSeparator(), startAngle);
		System.out.printf("\tEnd angle : %d" + System.lineSeparator(), stopAngle);
	}
}
