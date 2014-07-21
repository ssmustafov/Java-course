package com.sirma.itt.javacourse.objects.quadrilaterals;

/**
 * Represents quadrilateral figure.
 * 
 * @author smustafov
 */
public class Quadrilateral extends Parallelogram {

	private int angleA;
	private int angleB;
	private int angleC;
	private int angleD;
	private int sideC;
	private int sideD;

	/**
	 * Creates a new Quadrilateral.
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
	 * @param angleA
	 *            - the angle of A side
	 * @param angleB
	 *            - the angle of B side
	 * @param angleC
	 *            - the angle of C side
	 * @param angleD
	 *            - the angle of D side
	 */
	public Quadrilateral(int x, int y, int sideA, int sideB, int sideC, int sideD, int angleA,
			int angleB, int angleC, int angleD) {
		super(x, y, sideA, sideB);
		this.angleA = angleA;
		this.angleB = angleB;
		this.angleC = angleC;
		this.angleD = angleD;
		this.sideC = sideC;
		this.sideD = sideD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		System.out.println();
		System.out.println("Quadrilateral:");
		System.out.printf("\tStarting point : (%d,%d)" + System.lineSeparator(), getPoint().getX(),
				getPoint().getY());
		System.out.printf("\tAngle of A : %d" + System.lineSeparator(), angleA);
		System.out.printf("\tAngle of B : %d" + System.lineSeparator(), angleB);
		System.out.printf("\tAngle of C : %d" + System.lineSeparator(), angleC);
		System.out.printf("\tAngle of D : %d" + System.lineSeparator(), angleD);
		System.out.printf("\tLength of side A : %d" + System.lineSeparator(), super.getWidth());
		System.out.printf("\tLength of side B : %d" + System.lineSeparator(), super.getHeight());
		System.out.printf("\tLength of side C : %d" + System.lineSeparator(), sideC);
		System.out.printf("\tLength of side D : %d" + System.lineSeparator(), sideD);
	}
}
