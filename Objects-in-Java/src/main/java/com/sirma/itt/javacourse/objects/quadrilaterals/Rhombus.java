package com.sirma.itt.javacourse.objects.quadrilaterals;

import com.sirma.itt.javacourse.objects.figures.Figure;

/**
 * Represents rhombus figure.
 * 
 * @author smustafov
 */
public class Rhombus extends Figure {

	private int size;
	private int width;

	/**
	 * Creates new rhombus figure.
	 * 
	 * @param x
	 *            - the top left start X coordinate
	 * @param y
	 *            - the top left start Y coordinate
	 * @param size
	 *            - the size of the rhombus
	 * @param width
	 *            - the width of the rhombus
	 */
	public Rhombus(int x, int y, int size, int width) {
		super(x, y);
		this.size = size;
		this.width = width;
	}

	@Override
	public void draw() {
		System.out.println();
		System.out.println("Rhombus:");
		System.out.printf("\tTop left starting point : (%d,%d)" + System.lineSeparator(),
				getPoint().getX(), getPoint().getY());
		System.out.printf("\tSize : %d" + System.lineSeparator(), size);
		System.out.printf("\tWidth : %d" + System.lineSeparator(), width);
	}

}
