package com.sirma.itt.javacourse.objects.figures;

/**
 * @author smustafov
 */
public class Circle extends Figure {

	private int radius;

	/**
	 * Creates new Circle.
	 * 
	 * @param centerX
	 *            - the center point X coordinate
	 * @param centerY
	 *            - the center point Y coordinate
	 * @param radius
	 *            - the radius of the circle
	 */
	public Circle(int centerX, int centerY, int radius) {
		super(centerX, centerY);
		this.radius = radius;
	}

	/**
	 * @return - the radius of the circle
	 */
	public int getRadius() {
		return radius;
	}

	@Override
	public void draw() {
		System.out.println();
		System.out.println("Circle:");
		System.out.printf("\tCenter : (%d,%d)" + System.lineSeparator(), getPoint().getX(),
				getPoint().getY());
		System.out.printf("\tRadius : %d" + System.lineSeparator(), radius);
	}

}
