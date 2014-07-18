package com.sirma.itt.javacourse.objects.figures;

/**
 * Represents Ellipse figure.
 * 
 * @author smustafov
 */
public class Ellipse extends Circle {

	private int secondRadius;

	/**
	 * Creates new Ellipse.
	 * 
	 * @param centerX
	 *            - the center point X coordinate
	 * @param centerY
	 *            - the center point Y coordinate
	 * @param firstRadius
	 *            - the first radius
	 * @param secondRadius
	 *            - the second radius
	 */
	public Ellipse(int centerX, int centerY, int firstRadius, int secondRadius) {
		super(centerX, centerY, firstRadius);
		this.secondRadius = secondRadius;
	}

	/**
	 * @return - the first radius of the ellipse
	 */
	public int getFirstRadius() {
		return super.getRadius();
	}

	/**
	 * @return - the second radius of the ellipse
	 */
	public int getSecondRadius() {
		return secondRadius;
	}

	@Override
	public void draw() {
		System.out.println();
		System.out.println("Elipse:");
		System.out.printf("\tCenter : (%d,%d)" + System.lineSeparator(), getPoint().getX(),
				getPoint().getY());
		System.out.printf("\tRadius1 : %d" + System.lineSeparator(), super.getRadius());
		System.out.printf("\tRadius2 : %d" + System.lineSeparator(), secondRadius);
	}
}
