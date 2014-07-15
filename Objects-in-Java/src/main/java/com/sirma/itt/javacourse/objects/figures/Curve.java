package com.sirma.itt.javacourse.objects.figures;

/**
 * @author smustafov
 */
public class Curve extends Figure {

	private int length;

	/**
	 * Creates new Curve.
	 * 
	 * @param x
	 *            - the X coordinate
	 * @param y
	 *            - the Y coordinate
	 * @param length
	 *            - the length of the curve
	 */
	public Curve(int x, int y, int length) {
		super(x, y);
		this.length = length;
	}

	@Override
	public void draw() {
		System.out.println();
		System.out.println("Curve:");
		System.out.printf("\tStart point : (%d,%d)" + System.lineSeparator(), getPoint().getX(),
				getPoint().getY());
		System.out.printf("\tLength : %d" + System.lineSeparator(), length);
	}

}
