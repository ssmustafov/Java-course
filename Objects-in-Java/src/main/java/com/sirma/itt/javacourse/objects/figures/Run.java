package com.sirma.itt.javacourse.objects.figures;

import java.util.ArrayList;

/**
 * Shows how the figure classes can be used.
 * 
 * @author smustafov
 */
public class Run {

	public static void main(String[] args) {
		ArrayList<Figure> f = new ArrayList<>();
		f.add(new Ellipse(2, 4, 12, 29));
		f.add(new Circle(122, 344, 72));
		f.add(new Curve(78, 66, 234));

		for (Figure figure : f) {
			figure.draw();
		}
	}
}
