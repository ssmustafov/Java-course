package com.sirma.itt.javacourse.objects.quadrilaterals;

/**
 * Represents quadrangle figure.
 * 
 * @author smustafov
 */
public class Quadrangle extends Parallelogram {

	private int angle;
	private int sideC;
	private int sideD;

	/**
	 * Creates a new Quadrangle.
	 * 
	 * @param x
	 *            - the starting point X coordinate
	 * @param y
	 *            - the starting point Y coordinate
	 * @param sideA
	 *            - the length of side A
	 * @param sideB
	 *            - the length of side B
	 * @param sideC
	 *            - the length of side C
	 * @param sideD
	 *            - the length of side D
	 * @param angle
	 *            - the angle of the quadrangle
	 */
	public Quadrangle(int x, int y, int sideA, int sideB, int sideC, int sideD, int angle) {
		super(x, y, sideA, sideB);
		this.angle = angle;
		this.sideC = sideC;
		this.sideD = sideD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		System.out.println();
		System.out.println("Quadrangle:");
		System.out.printf("\tStarting point : (%d,%d)" + System.lineSeparator(), getPoint().getX(),
				getPoint().getY());
		System.out.printf("\tAngle : %d" + System.lineSeparator(), angle);
		System.out.printf("\tLength of side A : %d" + System.lineSeparator(), super.getWidth());
		System.out.printf("\tLength of side B : %d" + System.lineSeparator(), super.getHeight());
		System.out.printf("\tLength of side C : %d" + System.lineSeparator(), sideC);
		System.out.printf("\tLength of side D : %d" + System.lineSeparator(), sideD);
	}
}
