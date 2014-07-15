package com.sirma.itt.javacourse.objects.figures;

/**
 * Represents Ellipse figure.
 * 
 * @author smustafov
 */
public class Ellipse extends Figure {

	private int radius1;
	private int radius2;

	/**
	 * Creates new Ellipse.
	 * 
	 * @param centerX
	 *            - the center point X coordinate
	 * @param centerY
	 *            - the center point Y coordinate
	 * @param radius1
	 *            - the first radius
	 * @param radius2
	 *            - the second radius
	 */
	public Ellipse(int centerX, int centerY, int radius1, int radius2) {
		super(centerX, centerY);
		this.radius1 = radius1;
		this.radius2 = radius2;
	}

	@Override
	public void draw() {
		System.out.println();
		System.out.println("Elipse:");
		System.out.printf("\tCenter : (%d,%d)" + System.lineSeparator(), getPoint().getX(),
				getPoint().getY());
		System.out.printf("\tRadius1 : %d" + System.lineSeparator(), radius1);
		System.out.printf("\tRadius2 : %d" + System.lineSeparator(), radius2);
	}

}
