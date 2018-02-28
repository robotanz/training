package com.robotanz.flood;

import java.util.Stack;

/**
 * 
 * @author jgenti
 *
 */
public class FloodFill {

	/**
	 * Implémentation du parcours tel que présenté au tableau
	 * @param image
	 * @param startPoint
	 * @param color
	 */
	public void floodFill(Image image, Point startPoint, Color color) {
		
		// add the starting point to the stack of seeds
		// A Queue could be used as well
		final Stack<Point> seeds = new Stack<>();
		seeds.push(startPoint);
		
		final Color colorToReplace = image.getColor(startPoint);
		
		while(!seeds.isEmpty()) {
			
			Point p = seeds.pop();
			
			// propagate horizontally
			boolean borderBelow = false;
			boolean borderAbove = false;
			
			// first try the right direction:
			int x = p.x;

			/*
			 * J'avais écrit une boucle for au tableau, mais un while est plus
			 * pratique ici
			 */
			while(x < image.width && image.getColor(p).equals(colorToReplace)) {

				image.setColor(new Point(x, p.y), colorToReplace);

				// check tangent vertical borders
				// check border below
				if(!isBorderPoint(image, new Point(x, p.y+1), colorToReplace)) {
					// border
					borderBelow = true;
				}
				else if(borderBelow) {
					// corner
					borderBelow = false;
					seeds.push(new Point(x, p.y+1));
				}

				// check border above
				if(!isBorderPoint(image, new Point(x, p.y-1), colorToReplace)) {
					// border
					borderAbove = true;
				}
				else if(borderAbove) {
					// corner
					borderAbove = false;
					seeds.push(new Point(x, p.y-1));
				}
				
				++x;
			}

			/*
			 * La partie que je n'ai pas eu le temps de développer au tableau.
			 * Il s'agit de la poursuite ou non du parcours
			 */
			
			// on continue en-dessous?
			Point seed = new Point(x-1, p.y + 1);
			if(!isBorderPoint(image, seed, colorToReplace)) {
				seeds.push(seed);
			}
			
			// au-dessus?
			seed = new Point(x-1, p.y - 1);
			if(!isBorderPoint(image, seed, colorToReplace)) {
				seeds.push(seed);
			}
			
			/*
			 * Parcours vers la gauche
			 * Il faut, bien entendu, éviter cette duplication de code
			 * et en extraire une méthode pour l'intérieur de la boucle
			 */
			x = p.x - 1;
			
			while(x >= 0 && image.getColor(p).equals(colorToReplace)) {

				image.setColor(new Point(x, p.y), colorToReplace);

				// check tangent vertical borders
				// check border below
				if(!isBorderPoint(image, new Point(x, p.y+1), colorToReplace)) {
					// border
					borderBelow = true;
				}
				else if(borderBelow) {
					// corner
					borderBelow = false;
					seeds.push(new Point(x, p.y+1));
				}

				// check border above
				if(!isBorderPoint(image, new Point(x, p.y-1), colorToReplace)) {
					// border
					borderAbove = true;
				}
				else if(borderAbove) {
					// corner
					borderAbove = false;
					seeds.push(new Point(x, p.y-1));
				}
				
				--x;
			}
			
			/*
			 * De même cette partie est redondante, on peut faire autrement
			 */
			
			// on continue en-dessous?
			seed = new Point(x+1, p.y + 1);
			if(!isBorderPoint(image, seed, colorToReplace)) {
				seeds.push(seed);
			}
			
			// au-dessus?
			seed = new Point(x+1, p.y - 1);
			if(!isBorderPoint(image, seed, colorToReplace)) {
				seeds.push(seed);
			}
		}
	}
	
	private boolean isBorderPoint(Image img, Point p, Color c) {
		return p.x >= img.width || p.x < 0 || p.y < 0 || p.y >= img.height || 
				!img.getColor(p).equals(c);
	}
	
	private static final int[] XOFFSET = {0, 1, 1, 1, 0, -1, -1, -1};
	private static final int[] YOFFSET = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public void floodFill2(Image image, Point startPoint, Color color) {
		
		// add the starting point to the stack of seeds
		// A Queue could be used as well
		final Stack<Point> seeds = new Stack<>();
		seeds.push(startPoint);
		
		final Color colorToReplace = image.getColor(startPoint);
		
		while(!seeds.isEmpty()) {
			Point p = seeds.pop();
			image.setColor(p, color);

			// Add valid seeds around current point (in 8 directions)
			for(int i=0; i<8; ++i) {
				Point seed = new Point(p.x + XOFFSET[i], p.y + YOFFSET[i]);
				if(!isBorderPoint(image, seed, colorToReplace)) {
					seeds.push(seed);
				}
			}
		}
	}
}
