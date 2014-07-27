package com.sirma.itt.javacourse.objects.quadrilaterals;

/**
 * Represents a rhombus figure.
 * 
 * @author smustafov
 */
public class Rhombus extends Square {

	private int angle;

	/**
	 * Creates a new rhombus figure.
	 * 
	 * @param x
	 *            - the top left start X coordinate
	 * @param y
	 *            - the top left start Y coordinate
	 * @param size
	 *            - the width of the all sides in the rhombus
	 * @param angle
	 *            - the angle of the rhombus
	 */
	public Rhombus(int x, int y, int size, int angle) {
		super(x, y, size);
		this.angle = angle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		System.out.println();
		System.out.println("Rhombus:");
		System.out.printf("\tTop left starting point : (%d,%d)" + System.lineSeparator(),
				getPoint().getX(), getPoint().getY());
		System.out.printf("\tAngle : %d" + System.lineSeparator(), angle);
		System.out.printf("\tSize : %d" + System.lineSeparator(), super.getSize());
	}

}
