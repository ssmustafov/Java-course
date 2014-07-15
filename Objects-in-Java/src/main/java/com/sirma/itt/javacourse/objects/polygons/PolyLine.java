package com.sirma.itt.javacourse.objects.polygons;

import java.util.ArrayList;

import com.sirma.itt.javacourse.objects.figures.Curve;
import com.sirma.itt.javacourse.objects.figures.Figure;

/**
 * Represents poly line figure.
 * 
 * @author smustafov
 */
public class PolyLine extends Figure {

	private ArrayList<Curve> segments;

	/**
	 * Creates new poly line figure.
	 * 
	 * @param x
	 *            - the X coordinate of the starting point
	 * @param y
	 *            - the Y coordinate of the starting point
	 */
	public PolyLine(int x, int y) {
		super(x, y);
		segments = new ArrayList<Curve>();
	}

	/**
	 * Adds new segment (line) to the poly line.
	 * 
	 * @param x
	 *            - the X coordinate
	 * @param y
	 *            - the Y coordinate
	 * @param length
	 *            - the length of the line
	 */
	public void addSegment(int x, int y, int length) {
		segments.add(new Curve(x, y, length));
	}

	@Override
	public void draw() {
		System.out.println();
		System.out.println("Poly line:");
		System.out.printf("\tStarting point : (%d,%d)" + System.lineSeparator(), getPoint().getX(),
				getPoint().getY());
		System.out.println("\tSegments:");
		for (Curve curve : segments) {
			curve.draw();
		}
	}

}
